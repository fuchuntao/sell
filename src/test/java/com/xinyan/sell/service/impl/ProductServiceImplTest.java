package com.xinyan.sell.service.impl;

import com.xinyan.sell.po.ProductInfo;
import com.xinyan.sell.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {


    @Autowired
    private ProductRepository productRepository;
    @Test
    public void delete() {
        ProductInfo productInfo=productRepository.findOne("1");

        productRepository.delete(productInfo);

    }
}