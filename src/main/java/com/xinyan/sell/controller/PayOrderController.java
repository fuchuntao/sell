package com.xinyan.sell.controller;

import com.xinyan.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Administrator
 * 2018/11/18 0018
 * 支付订单Controller
 */
@Slf4j
@RequestMapping("/pay")
@Controller
public class PayOrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 支付订单
     * @param orderId
     * @param returnUrl
     * @return
     */
    @RequestMapping("/create")
    public String pay(@RequestParam("orderId") String orderId,
                      @RequestParam("returnUrl") String returnUrl) {


        return null;

    }


}
