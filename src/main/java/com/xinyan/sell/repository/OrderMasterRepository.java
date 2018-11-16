package com.xinyan.sell.repository;

import com.xinyan.sell.po.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Administrator
 * 2018/11/16 0016
 *
 * OrderMasterRepository买家订单Repository接口
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {


}
