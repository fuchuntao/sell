package com.xinyan.sell.repository;

import com.xinyan.sell.po.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;


/**
 * ProductCategoryRepositoryTest接口单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;


    /**
     * 单个查询
     */
    @Test
    public void findOneTest() {
        ProductCategory repositoryOne = productCategoryRepository.findOne(3);
        Assert.assertNotNull("根据id查询类目", repositoryOne);
    }

    /**
     * 保存
     */
    @Test
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("女神最爱");
        productCategory.setCategoryType(4);
        ProductCategory result = productCategoryRepository.save(productCategory);
        Assert.assertNotEquals(null, result);


    }

    /**
     * 根据多个类目查询
     */
    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> categoryTypeIn = productCategoryRepository.findByCategoryTypeIn(Arrays.asList(10, 2, 3));
        Assert.assertNotNull("根据多个类目查询", categoryTypeIn);

    }

    /**
     * 修改测试
     */
    @Test
    public void updateTest() {

        //查询
        ProductCategory repositoryOne = productCategoryRepository.findOne(5);
        //修改
        repositoryOne.setCategoryName("女孩最爱");
        //保存
        ProductCategory productCategory = productCategoryRepository.save(repositoryOne);
        Assert.assertNotNull("null", productCategory);

    }

    /**
     * 排序分页查询.
     */
    @Test
    public void paglist() {
        Sort desc = new Sort(Sort.Direction.DESC, "updateTime");
        List<ProductCategory> list = productCategoryRepository.findAll(desc);
        for (ProductCategory u : list) {
            System.out.println(u);
        }
    }
}

