package com.xinyan.sell.service;

import com.xinyan.sell.po.ProductCategory;

import java.util.List;

/**
 * Administrator
 * 2018/11/14 0014
 * 类目 业务接口
 */
public interface ProductCategoryService {

    //=======================================买家端==============================

    /**
     * 查询单个
     * @param categoryId
     * @return
     */
    public ProductCategory findOne(Integer categoryId);


    /**
     * 查询列表
     * @return
     */
    public List<ProductCategory> findAll();


    /**
     * 根据类目查询多个
     * @param categoryType
     * @return
     */
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType);

    //===================卖家端
    /**
     * @param categoryType
     * @return
     * 通过商品类型查找类目
     */
    ProductCategory findByCategoryType(Integer categoryType);


    /**
     * @param categoryName
     * @return
     * 根据商品类目找到商品类别编号
     */
    ProductCategory findByCategoryName(String categoryName);
}
