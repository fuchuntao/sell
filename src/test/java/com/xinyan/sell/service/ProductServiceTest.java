package com.xinyan.sell.service;

import com.xinyan.sell.po.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    /**
     * 单个商品查询测试
     */
    @Test
    public void findOne() {
        ProductInfo productInfo = productService.findOne("05ab5a9f6c184238ac476098b6fa338d");
        Assert.assertNotNull(productInfo);

    }

    /**
     * 商品列表测试
     */
    @Test
    public void findAll() {
        List<ProductInfo> productInfoList = productService.findAll();
        Assert.assertNotEquals(0, productInfoList.size());
    }

    /**
     * 分页查询测试
     */
    @Test
    public void findAll1() {
        PageRequest pageRequest = new PageRequest(0, 2);
        Page<ProductInfo> page = productService.findAll(pageRequest);
        Assert.assertNotEquals(0, page.getTotalElements());

    }

    /**
     * 商品查询：商品状态
     */
    @Test
    public void findByProductStatus() {
        List<ProductInfo> productInfos = productService.findByProductStatus(0);
        Assert.assertNotEquals(0, productInfos.size());


    }

}