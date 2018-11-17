package com.xinyan.sell.controller;

import com.xinyan.sell.converter.OrderFormToOrderDTOConverter;
import com.xinyan.sell.dto.OrderDTO;
import com.xinyan.sell.enums.ResultStatus;
import com.xinyan.sell.exception.SellException;
import com.xinyan.sell.form.OrderForm;
import com.xinyan.sell.service.OrderService;
import com.xinyan.sell.utils.ResultVoUtil;
import com.xinyan.sell.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Administrator
 * 2018/11/17 0017
 * 买家订单 Controller
 */
@Slf4j
@RequestMapping("/buyer/order")
@RestController
public class BuyerOrderController {


    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     * @param orderForm
     * @param bindingResult
     * @return
     */
    @PostMapping("/create")
    public ResultVO create(@Valid OrderForm orderForm,
                           BindingResult bindingResult) {


        //验证订单是否有误
        if(bindingResult.hasErrors()) {
            log.error("【创建订单】订单参数有误, OrderForm :{}", orderForm);
            throw new SellException(ResultStatus.ORDER_PARAM_EEROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());

        }
        //将OrderForm转换为OrderDTO
        OrderDTO orderDTO = OrderFormToOrderDTOConverter.converter(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultStatus.CART_EMPIY);
        }
        //创建订单
        OrderDTO order = orderService.createOrder(orderDTO);

        //返回参数
        Map<String, String> map = new HashMap<>();
        map.put("orderId", order.getOrderId());

        return ResultVoUtil.success(map);

    }


}
