package com.xinyan.sell.controller;

import com.xinyan.sell.po.ProductInfo;
import com.xinyan.sell.service.ProductService;
import com.xinyan.sell.utils.KeyUtil;
import com.xinyan.sell.vo.SellerProductInfoVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerProductControllerTest {

    @Autowired
    private ProductService productService;
    @Test
    public void list() {
        SellerProductInfoVO sellerProductInfoVO=new SellerProductInfoVO();
        List<ProductInfo> productInfos=productService.findAll();
        if (!productInfos.equals(null)){
            for (ProductInfo productInfo:productInfos){
                BeanUtils.copyProperties(productInfo,sellerProductInfoVO);
                sellerProductInfoVO.setProductId(KeyUtil.generateUniqueKey());
                sellerProductInfoVO.setCategoryType(10);
                sellerProductInfoVO.setProductStatus(0);
                sellerProductInfoVO.setProductName("鱼香肉丝");
                sellerProductInfoVO.setProductPrice(new BigDecimal(30));
                sellerProductInfoVO.setProductStock(30);

            }
        }
    }
}