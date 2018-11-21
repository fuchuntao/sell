package com.xinyan.sell.repository;

import com.xinyan.sell.po.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /**
     * @param categoryType
     * @return
     * 根据商品类目查询单个商品
     */
     ProductCategory findOneByCategoryType(Integer categoryType);

    /**
     * 根据商品类目名查询单个商品
     * @param categoryName
     * @return
     */
    ProductCategory findOneByCategoryName(String categoryName);

    //List<ProductCategory> findAll(Pageable pageable, Sort sort);

}
