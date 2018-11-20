package com.xinyan.sell.service;

import com.xinyan.sell.DTO.ProductCategoryDTO;
import com.xinyan.sell.DTO.ProductInfoDTO;
import com.xinyan.sell.po.ProductCategory;
import com.xinyan.sell.po.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Administrator
 * 2018/11/14 0014
 */
public interface ProductService {

    /**
     * 单个商品查询
     * @param productId
     * @return
     */
    public ProductInfo findOne(String productId);
    /**
     * 商品列表
     * @return
     */
    public List<ProductInfo> findAll();

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    public Page<ProductInfoDTO> findAll(Pageable pageable);


    /**
     * @param productInfo
     * 保存或更新商品信息
     */
    void save(ProductInfo productInfo);

    /**
     * @param productInfo
     * 删除商品信息
     */
    void delete(ProductInfo productInfo);


    /**
     * @return
     * 查询所有的类目
     */
    public List<ProductCategoryDTO> findAllProductCategory();
}
