package com.xinyan.sell.service;

import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;
import com.xinyan.sell.dto.OrderDTO;

/**
 * Administrator
 * 2018/11/20 0020
 */
public interface PayService {

    /**
     * 微信支付
     * @param orderDTO
     * @return
     */
    public PayResponse create(OrderDTO orderDTO);

    /**
     * 微信支付异步通知
     * @param notifyData
     * @return
     */
    public PayResponse notify(String notifyData);

    /**
     * 退款
     * @param orderDTO
     * @return
     */
    public RefundResponse refund(OrderDTO orderDTO);
}
