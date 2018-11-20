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
        //带分页的查询列表
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

    /**
     * 取消订单
     * @param orderId
     * @param page
     * @param size
     * @param map
     * @return
     */
    @GetMapping("/cancel")
    public String cancel(@RequestParam("orderId") String orderId,
                         @RequestParam(value = "page",required = false,defaultValue = "1") Integer page,
                         @RequestParam(value = "size",required = false,defaultValue = "5") Integer size,
                         Map<String ,Object> map){
        //先根据orderId查出orderDTO对象
        OrderDTO orderDTO = orderService.findOne(orderId);
        //调用cancel方法取消订单
        orderService.cancel(orderDTO);
        //带分页的列表
        PageRequest pageRequest = new PageRequest(page-1,size);
        Page<OrderDTO> orderDTOPage = orderService.list(pageRequest);
        map.put("orderDTOPage",orderDTOPage);
        return "order/list";
    }

    /**
     * 完结订单
     * @param orderId
     * @param page
     * @param size
     * @param map
     * @return
     */
    @GetMapping("/finish")
    public String finish(@RequestParam("orderId") String orderId,
                         @RequestParam(value = "page",required = false,defaultValue = "1") Integer page,
                         @RequestParam(value = "size",required = false,defaultValue = "5") Integer size,
                         Map<String ,Object> map){
        //先根据orderId查出orderDTO对象
        OrderDTO orderDTO = orderService.findOne(orderId);
        orderService.finish(orderDTO);
        //带分页的列表
        PageRequest pageRequest = new PageRequest(page-1,size);
        Page<OrderDTO> orderDTOPage = orderService.list(pageRequest);
        map.put("orderDTOPage",orderDTOPage);
        return "order/list";
    }


}
