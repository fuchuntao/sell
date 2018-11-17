package com.xinyan.sell.repository;

import com.xinyan.sell.po.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void findAllTest(){
        List<OrderMaster> orderMasterList = orderMasterRepository.findAll();
        Assert.assertNotEquals("订单列表",0,orderMasterList.size());
    }

}