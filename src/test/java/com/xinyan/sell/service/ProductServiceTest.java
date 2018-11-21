package com.xinyan.sell.service;

import com.xinyan.sell.dto.CartDTO;
import com.xinyan.sell.dto.ProductInfoDTO;
import com.xinyan.sell.po.ProductInfo;
import com.xinyan.sell.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * ProductService业务接口单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;
    @Autowired
    private  ProductCategoryService productCategoryService;

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
        Page<ProductInfoDTO> productInfoDTOPage = productService.findAll(pageRequest);

        Assert.assertNotEquals(0, productInfoDTOPage.getTotalElements());

    }


    @Test
    public void decreaseStock() {

    }

    /**
     * 商品查询：商品状态
     */
    @Test
    public void findByProductStatus() {
        List<ProductInfo> productInfos = productService.findByProductStatus(0);
        Assert.assertNotEquals(0, productInfos.size());
    }


    @Test
    public void increaseStock() {
    }

    @Test
    public void save() {
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId(KeyUtil.generateUniqueKey());
        productInfo.setProductName("上海青");
        productInfo.setProductIcon("www.oooo.pp");
        productInfo.setCategoryType(2);
        productInfo.setProductDescription("上海青不是上海特产");
        productInfo.setProductPrice(new BigDecimal("15"));
        productInfo.setProductStock(30);

        productService.save(productInfo);
        Assert.assertNotNull(productInfo);
    }

    @Test
    public void delete() {
        ProductInfo productInfo=productService.findOne("7eeac3864d8644b7aa513b81dab6e96a");
        productService.delete(productInfo);
    }

    @Test
    public void findAllProductCategory() {
        productCategoryService.findAll();
    }
}