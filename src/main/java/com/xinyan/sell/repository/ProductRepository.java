package com.xinyan.sell.repository;

import com.xinyan.sell.po.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Administrator
 * 2018/11/14 0014
 *
 * ProductRepository商品表的Repository接口
 */
public interface ProductRepository extends JpaRepository<ProductInfo, String> {
    /**
     * 根据商品状态查询
     * @param productStatus
     * @return
     */
    public List<ProductInfo> findByProductStatus(Integer productStatus);
}
