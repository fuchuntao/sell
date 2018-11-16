package com.xinyan.sell.repository;

import com.xinyan.sell.po.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Administrator
 * 2018/11/14 0014
 *
 * ProductCategoryRepository商品类目Repository接口
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    /**
     * 类目类型查询
     * @param categoryTypeList
     * @return
     */
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
