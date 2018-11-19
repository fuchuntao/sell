package com.xinyan.sell.controller;

import com.xinyan.sell.dto.OrderDTO;
import com.xinyan.sell.service.OrderService;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Administrator
 * 2018/11/17 0017
 * 卖家订单Controller
 */
@RequestMapping("/seller/order")
@Controller
public class SellerOrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 订单列表
     * @param page
     * @param size
     * @param map
     * @return
     */
    @GetMapping("/list")
    public String list(@RequestParam(value = "page",required = false,defaultValue = "1") Integer page,
                       @RequestParam(value = "size",required = false,defaultValue = "5") Integer size,
                       Map<String ,Object> map){
        PageRequest pageRequest = new PageRequest(page-1,size);
        Page<OrderDTO> orderDTOPage = orderService.list(pageRequest);
        map.put("orderDTOPage",orderDTOPage);
        return "order/list";
    }

    /**
     * 订单详情
     * @return
     */
    @GetMapping("/detail")
    public String detail(@RequestParam("orderId") String orderId , Map<String ,Object> map){
        OrderDTO orderDTO = orderService.findOne(orderId);
        map.put("orderDTO",orderDTO);
        return "order/detail";
    }

    @GetMapping("/cancel")
    public String cancel(@RequestParam("orderId") String orderId,
                         @RequestParam(value = "page",required = false,defaultValue = "1") Integer page,
                         @RequestParam(value = "size",required = false,defaultValue = "5") Integer size,
                         Map<String ,Object> map){
        //先根据orderId查出orderDTO对象
        OrderDTO orderDTO = orderService.findOne(orderId);
        orderService.cancel(orderDTO);
        PageRequest pageRequest = new PageRequest(page-1,size);
        Page<OrderDTO> orderDTOPage = orderService.list(pageRequest);
        map.put("orderDTOPage",orderDTOPage);
        return "order/list";
    }


}
