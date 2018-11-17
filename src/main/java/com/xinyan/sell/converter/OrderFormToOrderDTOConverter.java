package com.xinyan.sell.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.xinyan.sell.dto.OrderDTO;
import com.xinyan.sell.enums.ResultStatus;
import com.xinyan.sell.exception.SellException;
import com.xinyan.sell.form.OrderForm;
import com.xinyan.sell.po.OrderDetail;
import com.xinyan.sell.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Administrator
 * 2018/11/17 0017
 * 转换类
 */
@Slf4j
public class OrderFormToOrderDTOConverter {

    public static OrderDTO converter(OrderForm orderForm) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        try {
            List<OrderDetail> orderDetailList = JsonUtil.readValue(orderForm.getItems(),
                    new TypeReference<List<OrderDetail>>() {});

            orderDTO.setOrderDetailList(orderDetailList);
        } catch (Exception e) {
            log.error("【对象装换】错误， String :{}", orderForm.getItems());
            throw new SellException(ResultStatus.ORDER_PARAM_EEROR);
        }

        return orderDTO;
    }


}
