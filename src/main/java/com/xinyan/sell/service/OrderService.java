package com.xinyan.sell.service;

import com.xinyan.sell.dto.OrderDTO;
import com.xinyan.sell.po.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 * Administrator
 * 2018/11/17 0017
 * 订单业务接口
 */
public interface OrderService {
    //===========================买家端===================================

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO createOrder(OrderDTO orderDTO);

    /**
     * 订单列表
     * @param buyOpenId
     * @param pageable
     * @return
     */
    Page<OrderDTO> findList(String buyOpenId, Pageable pageable);


    /**
     * 查询订单详情
     * @param orderId
     * @return
     */
    OrderDTO findOne(String orderId);

    /**
     * 取消订单
     * @param orderDTO
     * @return
     */
    OrderDTO cancel(OrderDTO orderDTO);


    /**
     * 支付订单
     * @param orderDTO
     * @return
     */
    OrderDTO paid(OrderDTO orderDTO);

    //===========================卖家端===================================

    /**
     * 卖家订单列表
     * @return
     */
    Page<OrderDTO> list(Pageable pageable);



}
