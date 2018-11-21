package com.xinyan.sell.service.impl;

import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundRequest;
import com.lly835.bestpay.model.RefundResponse;
import com.lly835.bestpay.service.BestPayService;
import com.xinyan.sell.dto.OrderDTO;
import com.xinyan.sell.enums.ResultStatus;
import com.xinyan.sell.exception.SellException;
import com.xinyan.sell.service.OrderService;
import com.xinyan.sell.service.PayService;
import com.xinyan.sell.utils.JsonUtil;
import com.xinyan.sell.utils.MathUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Administrator
 * 2018/11/20 0020
 * 微信支付订单
 */
@Slf4j
@Service
public class PayServiceImpl implements PayService {
    private static final String ORDER_NAME = "微信点餐订单";
    @Autowired
    private BestPayService bestPayService;
    @Autowired
    private OrderService orderService;


    /**
     * 微信支付
     * @param orderDTO
     * @return
     */

    @Override
    public PayResponse create(OrderDTO orderDTO) {
        //设置payrequest支付请求
        PayRequest payRequest=new PayRequest();
        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        payRequest.setOrderId(orderDTO.getOrderId());
        payRequest.setOrderName(ORDER_NAME);
        payRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("【微信支付】发起支付, request : {}", JsonUtil.toJson(payRequest));
        //相应请求支付
        PayResponse payResponse = bestPayService.pay(payRequest);
        log.info("【微信支付】发起支付, response : {}", JsonUtil.toJson(payResponse));

        return payResponse;
    }

    /**
     *  微信支付异步通知
     * @param notifyData
     * @return
     */
    @Override
    public PayResponse notify(String notifyData) {
        //返回一个xml格式的字符串
        PayResponse payResponse = bestPayService.asyncNotify(notifyData);
        log.info("【微信支付】异步通知,payResponse : {}",JsonUtil.toJson(payResponse));
        //查询订单
        OrderDTO orderDTO = orderService.findOne(payResponse.getOrderId());
        if(orderDTO==null){
            log.error("【微信支付】异步通知,订单不存在,orderId :{}",payResponse.getOrderId());
            throw new SellException(ResultStatus.ORDER_NOT_EXIST);
        }
        if(MathUtil.compareTo(payResponse.getOrderAmount(),orderDTO.getOrderAmount().doubleValue())){
            log.error("【微信支付】异步通知,订单金额不一致,orderId={},微信通知金额={},订单金额={}",
                    payResponse.getOrderId(),payResponse.getOrderAmount(),orderDTO.getOrderAmount());
            throw new SellException(ResultStatus.WECHAT_MP_PAY_NOTIFY_MONEY_ERROR);
        }
        //修改订单支付状态
        orderService.paid(orderDTO);

        return payResponse;
    }

    /**
     * 退款
     * @param orderDTO
     * @return
     */
    @Override
    public RefundResponse refund(OrderDTO orderDTO) {
        //设置退款请求要求
        RefundRequest refundRequest=new RefundRequest();
        refundRequest.setOrderId(orderDTO.getOrderId());
        refundRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        refundRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("【微信退款】request:{}",JsonUtil.toJson(refundRequest));
        //响应请求
        RefundResponse refundResponse = bestPayService.refund(refundRequest);
        log.info("【微信退款】response:{}",JsonUtil.toJson(refundResponse));

        return refundResponse;
    }
}
