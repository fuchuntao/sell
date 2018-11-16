package com.xinyan.sell.service;

import com.xinyan.sell.po.ProductCategory;
import com.xinyan.sell.repository.ProductCategoryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * ProductCategoryService项目业务接口单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceTest {


    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 单个查询
     */
    @Test
    public void findOne() {
        ProductCategory productCategory = productCategoryService.findOne(3);
        Assert.assertNotNull(productCategory);

    }

    /**
     * 查询列表
     */
    @Test
    public void findAll() {
        List<ProductCategory> productCategoryList = productCategoryService.findAll();
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    /**
     * 查询多个
     */
    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> categoryTypeIn = productCategoryService.findByCategoryTypeIn(Arrays.asList(2, 3, 4));
        Assert.assertNotEquals(0, categoryTypeIn.size());
    }
}