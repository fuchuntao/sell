package com.xinyan.sell.service.impl;

import com.xinyan.sell.converter.OrderMasterToOrderDTOConverter;
import com.xinyan.sell.dto.CartDTO;
import com.xinyan.sell.dto.OrderDTO;
import com.xinyan.sell.enums.OrderStatus;
import com.xinyan.sell.enums.PayStatus;
import com.xinyan.sell.enums.ResultStatus;
import com.xinyan.sell.exception.SellException;
import com.xinyan.sell.po.OrderDetail;
import com.xinyan.sell.po.OrderMaster;
import com.xinyan.sell.po.ProductInfo;
import com.xinyan.sell.repository.OrderDetailRepository;
import com.xinyan.sell.repository.OrderMasterRepository;
import com.xinyan.sell.repository.ProductRepository;
import com.xinyan.sell.service.OrderService;
import com.xinyan.sell.service.ProductService;
import com.xinyan.sell.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Administrator
 * 2018/11/17 0017
 * 订单业务接口实现类
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private ProductService productService;

    //===========================买家端===================================
    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        //生成订单id orderId
        String orderId = KeyUtil.generateUniqueKey();
        orderDTO.setOrderId(orderId);
        //订单总金额
        BigDecimal orderAmount = new BigDecimal(0);


        //查询商品
        for(OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            ProductInfo productInfo = productRepository.findOne(orderDetail.getProductId());
            //判断订单是否存在
            if(productInfo == null) {
                log.info("【创建订单】商品不存在，productId :{}", orderDetail.getProductId());
                throw new SellException(ResultStatus.PRODUCT_NOT__EXIST);
            }
            //订单总金额=订单单价*订单数量
            orderAmount = (productInfo.getProductPrice().multiply(
                    new BigDecimal(orderDetail.getProductQuantity())))
                    .add(orderAmount);
            //订单详情保存
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetail.setDetailId(KeyUtil.generateUniqueKey());
            orderDetail.setOrderId(orderDTO.getOrderId());
            orderDetailRepository.save(orderDetail);
        }
        //订单主表列表
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        orderMasterRepository.save(orderMaster);

        //更新库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream()
                .map(e -> new CartDTO(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());

//        List<CartDTO> cartDTOS = new ArrayList<>();
//        for(OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
//            cartDTOS.add(new CartDTO(orderDetail.getDetailId(), orderDetail.getProductQuantity()))
//
//        }


        productService.decreaseStock(cartDTOList);
        return orderDTO;
    }

    /**
     * 订单列表
     * @param buyOpenId
     * @param pageable
     * @return
     */
    @Override
    public Page<OrderDTO> findList(String buyOpenId, Pageable pageable) {

        //根据buyOpenId拿到商品
        Page<OrderMaster> orderMasterPage = orderMasterRepository.findByBuyerOpenid(buyOpenId, pageable);
        List<OrderDTO> orderDTOS = OrderMasterToOrderDTOConverter.converter(orderMasterPage.getContent());
        Page<OrderDTO> orderDTOPage = new PageImpl<>(orderDTOS, pageable, orderMasterPage.getTotalElements());

        return orderDTOPage;
    }

    /**
     * 查询单个订单
     * @param orderId
     * @return
     */
    @Override
    public OrderDTO findOne(String orderId) {

        //先查询订单是否存在
        OrderMaster orderMaster = orderMasterRepository.findOne(orderId);
        if(orderMaster == null) {
            log.info("【订单详情】订单不存在, orderId:{}", orderId);
            throw new SellException(ResultStatus.ORDER_NOT_EXIST);
        }
        //查询订单详情
        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId(orderId);
        if(orderDetailList == null) {
            log.info("【订单详情】订单详情不存在，orderId : {}", orderId);
            throw new SellException(ResultStatus.ORDER_DETAIL_NOT_EXIST);
        }
        //拼接OrderDTO
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }

    /**
     * 取消订单
     * @param orderDTO
     * @return
     */
    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        //判断订单状态
        if(!orderDTO.getOrderStatus().equals(OrderStatus.NEW.getCode())) {
            log.info("【取消订单】订单状态不是新订单，orderId:{}, orderStatus:{}",
                    orderDTO.getOrderId(), orderDTO.getOrderStatus());
            throw new SellException(ResultStatus.ORDER_STATUS_ERROR);
        }
        //修改订单状态
        orderDTO.setOrderStatus(OrderStatus.CANCEL.getCode());
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        OrderMaster master = orderMasterRepository.save(orderMaster);
        if(master == null) {
            log.info("【取消订单】修改订单状态出错, orderMaster : {}", orderMaster);
            throw new SellException(ResultStatus.ORDER_UPDATE_FAIL);
        }


        //修改订单库存
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.info("【取消订单】订单详情为空, orderDTO :{}", orderDTO);
            throw new SellException(ResultStatus.ORDER_DETAIL_NOT_EXIST);
        }
        //获取订单购物车
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream()
                .map(e -> new CartDTO(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productService.increaseStock(cartDTOList);
        //是否支付退款

        return orderDTO;
    }


    /**
     * 支付订单
     * @param orderDTO
     * @return
     */
    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        //判断订单状态
        if(!orderDTO.getOrderStatus().equals(OrderStatus.NEW.getCode())) {
            log.info("【支付订单】 订单状态错误, orderId : {}, orderStatus:{}",
                    orderDTO.getOrderId(), orderDTO.getOrderStatus());
            throw new SellException(ResultStatus.ORDER_STATUS_ERROR);
        }
        //判断订单支付状态
        if(!orderDTO.getPayStatus().equals(PayStatus.WAIT.getCode())) {
            log.info("【支付订单】订单支付状态错误, orderId : {}, payStatus : {}",
                    orderDTO.getOrderId(), orderDTO.getPayStatus());
            throw new SellException(ResultStatus.ORDER_PAY_STATUS_ERROR);

        }
        //修改订单支付状态
        orderDTO.setPayStatus(PayStatus.PAID.getCode());
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        //保存到数据库中
        OrderMaster master = orderMasterRepository.save(orderMaster);
        if(master == null) {
            log.info("【支付订单】修改订单支付状态有误，orderMaster : {}", orderMaster);
            throw new SellException(ResultStatus.ORDER_UPDATE_FAIL);
        }
        return orderDTO;
    }




    //===========================卖家端===================================

    /**
     * 卖家订单列表
     * @param pageable
     * @return
     */
    public Page<OrderDTO> list(Pageable pageable) {
        Page<OrderMaster> orderMasterPage = orderMasterRepository.findAll(pageable);
        List<OrderDTO> orderDTOList = OrderMasterToOrderDTOConverter.converter(orderMasterPage.getContent());
        Page<OrderDTO> orderDTOPage = new PageImpl<>(orderDTOList,pageable,orderMasterPage.getTotalElements());

        return orderDTOPage;
    }

    @Override
    public OrderDetail getOrderDetail(String orderId) {
        return null;
    }


}
