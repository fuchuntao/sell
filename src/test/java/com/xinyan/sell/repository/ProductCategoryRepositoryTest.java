package com.xinyan.sell.repository;

import com.xinyan.sell.po.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ProductCategoryRepositoryTest接口单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private  ProductCategoryRepository productCategoryRepository;


    /**
     * 单个查询
     */
    @Test
    public void findOneTest() {
        ProductCategory repositoryOne = productCategoryRepository.findOne(3);
        Assert.assertNotNull("根据id查询类目",repositoryOne);
    }

    /**
     * 保存
     */
    @Test
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("男生最爱");
        productCategory.setCategoryType(2);
        ProductCategory result = productCategoryRepository.save(productCategory);
        Assert.assertNotEquals(null, result);



    }



}