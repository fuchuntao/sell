package com.xinyan.sell.controller;


import com.xinyan.sell.po.ProductInfo;
import com.xinyan.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Administrator
 * 2018/11/16 0016
 */
@RequestMapping("/seller/product")
@Controller
public class SellerProductController  {


    @Autowired
    private ProductService productService;

    @RequestMapping("/list")
    public String list(Model model) {

        //获取所有商品信息
        List<ProductInfo> productInfos = productService.findAll();

        //将商品信息发送到请求域中

        model.addAttribute("productInfos",productInfos);

        return "product/list";
    }

}
