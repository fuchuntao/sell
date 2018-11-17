package com.xinyan.sell.controller;

import com.xinyan.sell.po.ProductInfo;
import com.xinyan.sell.service.ProductService;
import com.xinyan.sell.utils.KeyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerProductControllerTest {

    @Autowired
    private ProductService productService;

}