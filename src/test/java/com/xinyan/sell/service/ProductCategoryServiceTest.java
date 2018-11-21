package com.xinyan.sell.service;

import com.xinyan.sell.dto.ProductCategoryDTO;
import com.xinyan.sell.po.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * ProductCategoryService项目业务接口单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceTest {


    /**
     * The Product category service.
     */
    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 单个查询
     */
    @Test
    public void findOne() {
        ProductCategory productCategory = productCategoryService.findOne(3);
        Assert.assertNotNull(productCategory);

    }

    /**
     * 查询列表
     */
    @Test
    public void pageList() {
        PageRequest pageRequest = new PageRequest(0 ,5);
        Sort desc = new Sort(Sort.Direction.DESC, "updateTime");
        Page<ProductCategoryDTO> pageList = productCategoryService.pageList(pageRequest, desc);
        Assert.assertNotEquals("列表分页查询", pageList.getTotalElements());
    }

    /**
     * 查询多个
     */
    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> categoryTypeIn = productCategoryService.findByCategoryTypeIn(Arrays.asList(2, 3, 4));
        Assert.assertNotEquals(0, categoryTypeIn.size());
    }

    /**
     * Save.
     */
    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory();
        ProductCategoryDTO productCategoryDTO = new ProductCategoryDTO();
        productCategoryDTO.setCategoryName("女生最爱");
        productCategoryDTO.setCategoryType(60);
        //ProductCategoryFormToProductCategoryDto.converter(productCategory);
        ProductCategory save = productCategoryService.save(productCategoryDTO);
        Assert.assertNotEquals("添加测试", save);
    }

    /**
     * Delete.
     */
    @Test
    public void delete() {
        productCategoryService.delete(10);
    }
}
