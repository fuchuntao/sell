package com.xinyan.sell.repository;

import com.xinyan.sell.po.OrderDetail;
import com.xinyan.sell.po.OrderMaster;
import com.xinyan.sell.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * OrderMasterRepository接口单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    /**
     * 订单保存测试
     */
    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        String orderId = KeyUtil.generateUniqueKey();
        //订单信息
        orderMaster.setOrderId(orderId);
        orderMaster.setBuyerName("李四");
        orderMaster.setBuyerPhone("15775972860");
        orderMaster.setBuyerAddress("深圳龙岗");
        orderMaster.setBuyerOpenid("qwer456");
        orderMaster.setOrderAmount(new BigDecimal("40"));
        //订单详情
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setDetailId(KeyUtil.generateUniqueKey());
        orderDetail1.setOrderId(orderId);
        orderDetail1.setProductId("e366cd06d920495aa6e4f61f429c9f1b");
        orderDetail1.setProductName("陕西肉夹馍");
        orderDetail1.setProductPrice(new BigDecimal("20"));
        orderDetail1.setProductQuantity(1);
        orderDetail1.setProductIcon("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=4226804373,4128326637&fm=26&gp=0.jpg");
        orderDetailList.add(orderDetail1);

        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setDetailId(KeyUtil.generateUniqueKey());
        orderDetail2.setOrderId(orderId);
        orderDetail2.setProductId("bc11a39ece114865aba6465cb6b3ae38");
        orderDetail2.setProductName("重庆酸辣粉");
        orderDetail2.setProductPrice(new BigDecimal("10"));
        orderDetail2.setProductQuantity(2);
        orderDetail2.setProductIcon("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=249319268,490411311&fm=26&gp=0.jpg");
        orderDetailList.add(orderDetail2);

        //订单详情保存
        orderDetailRepository.save(orderDetailList);

        //订单信息保存
        OrderMaster master = orderMasterRepository.save(orderMaster);
        Assert.assertNotNull(master);


    }

    /**
     * 订单查询
     */
    @Test
    public void findByBuyerOpenid() {
        PageRequest pageRequest = new PageRequest(0, 2);
        Page<OrderMaster> page = orderMasterRepository.findByBuyerOpenid("qwer456", pageRequest);
        Assert.assertNotNull(page);
    }
}