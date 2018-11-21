package com.xinyan.sell.service;

import com.xinyan.sell.dto.ProductCategoryDTO;
import com.xinyan.sell.dto.ProductInfoDTO;
import com.xinyan.sell.po.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 2018/11/14 0014.
 * 类目 业务接口
 * @author 莫言
 */
public interface ProductCategoryService {

    //=======================================买家端==============================

    /**
     * 查询单个.
     *
     * @param categoryId the category id
     * @return product category
     */
    ProductCategory findOne(Integer categoryId);


    /**
     * 查询列表.
     *
     * @return list
     */
    Page<ProductCategoryDTO> pageList(Pageable pageable);


    /**
     * 根据类目查询多个.
     *
     * @param categoryType the category type
     * @return list
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType);


    /**
     * 添加 Save.
     *
     * @param productCategoryDto the product category
     */
    ProductCategory save(ProductCategoryDTO productCategoryDto);

    /**
     * 删除 Delete.
     *
     * @param id the id
     */
    void delete(Integer id);

    //===================卖家端==========================
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

    /**
     * 查询列表
     * @return
     */
    List<ProductCategory> findAll();
}
