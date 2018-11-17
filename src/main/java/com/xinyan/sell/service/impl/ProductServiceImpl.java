package com.xinyan.sell.service.impl;

import com.xinyan.sell.dto.CartDTO;
import com.xinyan.sell.enums.ResultStatus;
import com.xinyan.sell.exception.SellException;
import com.xinyan.sell.po.ProductInfo;
import com.xinyan.sell.repository.ProductRepository;
import com.xinyan.sell.service.ProductService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     *单个商品查询
     * @param productId
     * @return
     */
    @Override
    public ProductInfo findOne(String productId) {
        return productRepository.findOne(productId);
    }

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

    /**
     * 更新库存
     * @param cartDTOList
     */
    @Override
    public void decreaseStock(List<CartDTO> cartDTOList) {

        for(CartDTO cartDTO : cartDTOList) {

            //判断商品是否存在
            ProductInfo productInfo = productRepository.findOne(cartDTO.getProductId());
            if(productInfo == null) {
                log.info("【更新库存】商品不存在，ProductId : {}", cartDTO.getProductId());
                throw new SellException(ResultStatus.PRODUCT_NOT__EXIST);
            }

            //判断库存是否足够
            Integer quantity = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if(quantity == null) {
                log.info("【更新库存】商品库存不足, ProductStock : {}", productInfo.getProductStock());
                throw new SellException(ResultStatus.PRODUCT_STOCK_ERROR);
            }
            //设置productInfo对象的库存
            productInfo.setProductStock(quantity);
            //保存到数据库中
            productRepository.save(productInfo);

        }

    }
}
