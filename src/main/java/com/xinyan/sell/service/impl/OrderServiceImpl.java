package com.xinyan.sell.service.impl;

import com.xinyan.sell.converter.OrderMasterToOrderDTOConverter;
import com.xinyan.sell.dto.OrderDTO;
import com.xinyan.sell.po.OrderDetail;
import com.xinyan.sell.po.OrderMaster;
import com.xinyan.sell.repository.OrderMasterRepository;
import com.xinyan.sell.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Administrator
 * 2018/11/17 0017
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;
    /**
     * 订单列表
     *
     * @param pageable
     * @return
     */
    @Override
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
