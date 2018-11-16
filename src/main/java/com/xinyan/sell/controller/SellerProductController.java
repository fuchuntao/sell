package com.xinyan.sell.controller;


import com.xinyan.sell.po.ProductInfo;
import com.xinyan.sell.service.ProductService;
import com.xinyan.sell.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


//    @RequestMapping("/list")
//    public ResultVO list(Pageable pageable){
//
////        Page<ProductInfo> productInfos=productService.findAll();
//
//        return "";
//    }

}
