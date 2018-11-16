package com.xinyan.sell.service.impl;

import com.xinyan.sell.po.ProductInfo;
import com.xinyan.sell.repository.ProductRepository;
import com.xinyan.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Administrator
 * 2018/11/15 0015
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    //============================卖家端===========================
    
    /**
     * 商品列表查询
     * @return
     */
    @Override
    public List<ProductInfo> findAll() {
        return productRepository.findAll();
    }

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        PageRequest pageRequest =new PageRequest(pageable.getPageNumber(),pageable.getPageSize());
        Page<ProductInfo> page = productRepository.findAll(pageRequest);
        return page;
    }

    /**
     * 商品查询：商品状态
     * @param productStatus
     * @return
     */
    @Override
    public List<ProductInfo> findByProductStatus(Integer productStatus) {
        return productRepository.findByProductStatus(productStatus);
    }
    //=========================买家端======================

    /**
     *单个商品查询
     * @param productId
     * @return
     */
    @Override
    public ProductInfo findOne(String productId) {
        return productRepository.findOne(productId);
    }
}
