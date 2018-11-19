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

    @Test
    public void findList() {


    }

    @Test
    public void findOne() {


    }

    @Test
    public void cancel() {


    }

    @Test
    public void paid() {


    }

    //==================================卖家订单测试=====================

    @Test
    public void listTest(){
        PageRequest pageRequest = new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage = orderService.list(pageRequest);
        Assert.assertNotNull(orderDTOPage);
    }
}
