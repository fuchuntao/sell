package com.xinyan.sell.service;

import com.xinyan.sell.dto.OrderDTO;
import com.xinyan.sell.po.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Administrator
 * 2018/11/17 0017
 * 订单业务接口
 */
public interface OrderService {

    /**
     * 订单列表
     * @return
     */
    Page<OrderDTO> list(Pageable pageable);




}
