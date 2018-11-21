package com.xinyan.sell.service;

import com.xinyan.sell.dto.OrderDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * OrderService业务接口单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void createOrder() {

    }

    /**
     * 测试买家订单列表
     */
    @Test
    public void findList() {
        PageRequest pageRequest = new PageRequest(0, 5);
        String buyOpenId = "qwer456";
        Page<OrderDTO> orderDTOPage = orderService.findList(buyOpenId, pageRequest);
        Assert.assertNotEquals(0, orderDTOPage.getSize());


    }

    /**
     * 测试订单详情
     */
    @Test
    public void findOne() {
        OrderDTO orderDTO = orderService.findOne("1b08039906a54e699d43aaec8764bb2e");
        Assert.assertNotNull(orderDTO);

    }

    /**
<<<<<<< HEAD
     * 取消订单单元测试
=======
     * 测试取消订单
>>>>>>> df3207e2819df499edb4b11270bf7081a6c41b3a
     */
    @Test
    public void cancelTest() {
        OrderDTO orderDTO = orderService.findOne("123");
        OrderDTO cancel = orderService.cancel(orderDTO);
        Assert.assertNotNull(cancel);
    }

    /**
     * 测试支付订单
     */
    @Test
    public void paid() {

    }

    //==================================卖家订单测试=====================

    /**
     * 卖家订单列表单元测试
     */
    @Test
    public void listTest(){
        PageRequest pageRequest = new PageRequest(0,5);
        Page<OrderDTO> orderDTOPage = orderService.list(pageRequest);
        Assert.assertNotNull(orderDTOPage);
    }

    /**
     * 完结订单单元测试
     */
    @Test
    public void  finishTest(){
        OrderDTO orderDTO = orderService.findOne("123");
        OrderDTO cancel = orderService.finish(orderDTO);
        Assert.assertNotNull(cancel);
    }
}
