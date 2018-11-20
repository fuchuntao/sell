package com.xinyan.sell.controller;


import com.xinyan.sell.DTO.ProductInfoDTO;
import com.xinyan.sell.enums.ProductStatus;
import com.xinyan.sell.po.ProductInfo;
import com.xinyan.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


/**
 * Administrator
 * 2018/11/16 0016
 */
@RequestMapping("/seller/product")
@Controller
public class SellerProductController  {


    @Autowired
    private ProductService productService;

    /**
     * 查询商品列表
     * @param map
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public String list(Map<String, Object> map,
                       @RequestParam(value = "page",required = false,defaultValue = "1") Integer page,
                       @RequestParam(value = "size",required = false,defaultValue = "5") Integer size){

        PageRequest pageRequest=new PageRequest(page-1, size);
        Page<ProductInfoDTO> productInfoDTOPage=productService.findAll(pageRequest);

        map.put("productInfoDTOPage",productInfoDTOPage);

        return "product/list";
    }

    /**商品下架
     *
     * @param productId
     * @return
     */
    @RequestMapping("/updateStatusDown")
    public String updateStatusDown(@RequestParam("productId") String productId){
        //通过商品id找到商品对象
        ProductInfo productInfo=productService.findOne(productId);
        //更改商品为下架
        productInfo.setProductStatus(ProductStatus.DOWN.getCode());
        //保存商品信息
        productService.save(productInfo);

        return  "redirect:list";
    }

    /**商品上架
     *
     * @param productId
     * @return
     */
    @RequestMapping("/updateStatusUp")
    public String updateStatusUp(@RequestParam("productId") String productId){
        //通过商品id找到商品对象
        ProductInfo productInfo=productService.findOne(productId);
        //更改商品为上架
        productInfo.setProductStatus(ProductStatus.UP.getCode());
        //保存商品信息
        productService.save(productInfo);

        return "redirect:list";
    }

    /**删除商品
     *
     * @param productId
     * @return
     */
    @RequestMapping("/delete")
    public String delete(@RequestParam("productId") String productId){
        //根据商品id找到商品对象
        ProductInfo productInfo=productService.findOne(productId);
        //删除商品
        productService.delete(productInfo);

        return "redirect:list";
    }
}
