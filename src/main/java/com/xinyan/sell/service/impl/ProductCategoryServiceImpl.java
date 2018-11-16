package com.xinyan.sell.service.impl;

import com.xinyan.sell.po.ProductCategory;
import com.xinyan.sell.repository.ProductCategoryRepository;
import com.xinyan.sell.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Administrator
 * 2018/11/14 0014
 *类目 业务接口实现类
 *
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository repository;

    /**
     * 单个查询
     * @param categoryId
     * @return
     */
    @Override
    public ProductCategory findOne(Integer categoryId) {
        return repository.findOne(categoryId);
    }

    /**
     * 查询列表
     * @return
     */
    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }


    /**
     * 多个查询
     * @param categoryType
     * @return
     */
    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType) {
        return repository.findByCategoryTypeIn(categoryType);
    }
}
