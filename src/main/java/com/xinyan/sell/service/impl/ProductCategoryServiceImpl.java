package com.xinyan.sell.service.impl;

import com.xinyan.sell.converter.ProductCategoryFormToProductCategoryDto;
import com.xinyan.sell.dto.ProductCategoryDTO;
import com.xinyan.sell.dto.ProductInfoDTO;
import com.xinyan.sell.po.ProductCategory;
import com.xinyan.sell.repository.ProductCategoryRepository;
import com.xinyan.sell.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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
    public Page<ProductCategoryDTO> pageList(Pageable pageable) {

        Page<ProductCategory> productCategoryPage= repository.findAll(pageable);
        List<ProductCategoryDTO> page = ProductCategoryFormToProductCategoryDto.converter(productCategoryPage.getContent());

        Page<ProductCategoryDTO> pageList = new PageImpl<>(page, pageable, productCategoryPage.getTotalElements());
        return pageList;
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


    @Override
    public ProductCategory findByCategoryType(Integer categoryType) {
        return repository.findOneByCategoryType(categoryType);
    }

    @Override
    public ProductCategory findByCategoryName(String categoryName) {
        return repository.findOneByCategoryName(categoryName);
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
     * 添加
     * @param productCategoryDto the product category
     * @return productCategory 对象
     */
    @Override
    public ProductCategory save(ProductCategoryDTO productCategoryDto) {
        ProductCategory productCategory = ProductCategoryFormToProductCategoryDto.converter(productCategoryDto);
        return repository.save(productCategory);
    }

    /**
     *根据ID删除.
     * @param id the id
     */
    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }

}
