package com.xinyan.sell.repository;

import com.xinyan.sell.po.ProductInfo;
import com.xinyan.sell.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * ProductRepository接口单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {


    @Autowired
    private ProductRepository productRepository;

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        //生成主键值
        productInfo.setProductId(KeyUtil.generateUniqueKey());
        productInfo.setProductName("重庆酸辣粉");
        productInfo.setProductPrice(new BigDecimal("10"));
        productInfo.setProductStock(70);
        productInfo.setProductDescription("重庆特色小吃");
        productInfo.setProductIcon("http://xxxx.jsp");
//        productInfo.setProductStatus(ProductStatus.UP.getCode());
        productInfo.setCategoryType(5);

        ProductInfo productInfo1 = productRepository.save(productInfo);
        Assert.assertNotNull(productInfo1);
    }


    @Test
    public void findByProductStatus() {


    }
}