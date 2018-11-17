package com.xinyan.sell.controller;


import com.xinyan.sell.po.ProductInfo;
import com.xinyan.sell.service.ProductService;
import com.xinyan.sell.vo.SellerProductInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * Administrator
 * 2018/11/16 0016
 */
@RequestMapping("/seller/product")
@RestController
public class SellerProductController {


    @Autowired
    private ProductService productService;

    @RequestMapping("/list")
    public SellerProductInfoVO list(){
        SellerProductInfoVO sellerProductInfoVO=new SellerProductInfoVO();
        List<ProductInfo> productInfos=productService.findAll();
        for (ProductInfo productInfo:productInfos){
            BeanUtils.copyProperties(productInfo,sellerProductInfoVO);
        }

        return sellerProductInfoVO;
    }

}
