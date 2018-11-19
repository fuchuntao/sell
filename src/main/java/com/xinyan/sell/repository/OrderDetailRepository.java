package com.xinyan.sell.repository;

import com.xinyan.sell.po.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Administrator
 * 2018/11/16 0016
 * OrderDetailRepository买家订单详情Repository接口
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    /**
     * 查询订单详情
     * @param orderId
     * @return
     */
   List<OrderDetail> findByOrderId(String orderId);


}
