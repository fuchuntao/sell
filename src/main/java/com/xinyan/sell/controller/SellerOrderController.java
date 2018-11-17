package com.xinyan.sell.controller;

import com.xinyan.sell.dto.OrderDTO;
import com.xinyan.sell.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Pageable;
import java.util.Map;

/**
 * Administrator
 * 2018/11/17 0017
 */
@RequestMapping("/seller/order")
@Controller
public class SellerOrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/list")
    public String list(@RequestParam(value = "page",required = false,defaultValue = "1") Integer page,
                       @RequestParam(value = "size",required = false,defaultValue = "5") Integer size,
                       Map<String ,Object> map){
        PageRequest pageRequest = new PageRequest(page-1,size);
        Page<OrderDTO> orderDTOPage = orderService.list(pageRequest);
        map.put("orderDTOPage",orderDTOPage);
        return "order/list";
    }


}
