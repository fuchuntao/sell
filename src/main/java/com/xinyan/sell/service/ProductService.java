package com.xinyan.sell.service;

import com.xinyan.sell.dto.CartDTO;
import com.xinyan.sell.po.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Administrator
 * 2018/11/14 0014
 * 商品列表业务接口
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
    public Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 商品查询：商品状态
     * @param productStatus
     * @return
     */
    public List<ProductInfo> findByProductStatus(Integer productStatus);

    /**
     * 减少商品库存
     * @param cartDTOList
     */
    public void decreaseStock(List<CartDTO> cartDTOList);

    /**
     * 取消订单增加商品库存
     * @param cartDTOList
     */
    public void increaseStock(List<CartDTO> cartDTOList);

}
