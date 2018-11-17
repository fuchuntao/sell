package com.xinyan.sell.controller;


import com.xinyan.sell.po.ProductCategory;
import com.xinyan.sell.po.ProductInfo;
import com.xinyan.sell.service.ProductCategoryService;
import com.xinyan.sell.service.ProductService;
import com.xinyan.sell.utils.ResultVoUtil;
import com.xinyan.sell.vo.ProductInfoVO;
import com.xinyan.sell.vo.ProductVO;
import com.xinyan.sell.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Administrator
 * 2018/11/16 0016
 * 买家商品Controller
 */

@RequestMapping("/buyer/product")
@RestController
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 买家商品列表
     * @return
     */
    @GetMapping("/list")
    public ResultVO list() {

        //所有上架商品
        List<ProductInfo> productInfoList = productService.findAll();

        //根据上架商品类目查询出所有类目
//        List<Integer> productCategoryList = new ArrayList<>();
//
//        for (ProductInfo productInfo : productInfoList) {
//            productCategoryList.add(productInfo.getCategoryType());
//        }
        List<Integer> productCategoryList = productInfoList.stream().
                map(e -> e.getCategoryType()).collect(Collectors.toList());

        List<ProductCategory> productCategories = productCategoryService.findByCategoryTypeIn(productCategoryList);
        //类目拼接
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory : productCategories) {
            ProductVO productVO = new ProductVO();
            //BeanUtils 复制对象属性
            BeanUtils.copyProperties(productCategory, productVO);

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();

            //商品拼接
            for(ProductInfo productInfo : productInfoList) {
                ProductInfoVO productInfoVO = new ProductInfoVO();
                if(productInfo.getCategoryType().equals(productVO.getCategoryType())) {
                    //BeanUtils 复制对象属性
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }

            }
            //将商品拼接到类目中
            productVO.setProductInfoVOList(productInfoVOList);
            //将类目放到类目集合中
            productVOList.add(productVO);
        }

        //将数据拼接到resultvo中返回前端
        return ResultVoUtil.success(productVOList);

    }


}
