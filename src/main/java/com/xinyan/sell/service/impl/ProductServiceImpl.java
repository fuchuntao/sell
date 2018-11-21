package com.xinyan.sell.service.impl;

import com.xinyan.sell.dto.ProductCategoryDTO;
import com.xinyan.sell.converter.ProductCategoryToProductCategoryDTO;
import com.xinyan.sell.converter.ProductInfoToProductInfoDTO;
import com.xinyan.sell.dto.CartDTO;
import com.xinyan.sell.dto.ProductInfoDTO;
import com.xinyan.sell.enums.ResultStatus;
import com.xinyan.sell.exception.SellException;
import com.xinyan.sell.po.ProductCategory;
import com.xinyan.sell.po.ProductInfo;
import com.xinyan.sell.repository.ProductCategoryRepository;
import com.xinyan.sell.repository.ProductRepository;
import com.xinyan.sell.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Administrator
 * 2018/11/15 0015
 * 商品列表业务接口实现类
 */
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Autowired
    private ProductCategoryRepository productCategoryRepository;

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
    public Page<ProductInfoDTO> findAll(Pageable pageable) {
        //创建商品信息分页对象
        Page<ProductInfo> productInfoPage = productRepository.findAll(pageable);
        //将商品信息分页对象转换为商品信息DTO对象（list）
        List<ProductInfoDTO> productInfoDTOList = ProductInfoToProductInfoDTO.converter(productInfoPage.getContent());
        //将list的DTO对象封装为分页DTO对象
        Page<ProductInfoDTO> productInfoDTOPage = new PageImpl<>(productInfoDTOList, pageable, productInfoPage.getTotalElements());

        return productInfoDTOPage;
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
     * 减少库存
     * @param cartDTOList
     */
    @Override
    public void decreaseStock(List<CartDTO> cartDTOList) {

        for(CartDTO cartDTO : cartDTOList) {

            //判断商品是否存在
            ProductInfo productInfo = productRepository.findOne(cartDTO.getProductId());
            if(productInfo == null) {
                log.info("【减少库存】商品不存在，ProductId : {}", cartDTO.getProductId());
                throw new SellException(ResultStatus.PRODUCT_NOT__EXIST);
            }

            //判断库存是否足够
            Integer quantity = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if(quantity == null) {
                log.info("【减少库存】商品库存不足, ProductStock : {}", productInfo.getProductStock());
                throw new SellException(ResultStatus.PRODUCT_STOCK_ERROR);
            }
            //设置productInfo对象的库存
            productInfo.setProductStock(quantity);
            //保存到数据库中
            productRepository.save(productInfo);

        }

    }

    /**
     * 取消订单增加库存
     * @param cartDTOList
     */
    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO : cartDTOList) {
            //判断上商品是否存在
            ProductInfo productInfo = productRepository.findOne(cartDTO.getProductId());
            if(productInfo == null) {
                log.info("【增加库存】商品不存在, productInfo: {}", cartDTO.getProductId());
                throw new SellException(ResultStatus.PRODUCT_NOT__EXIST);
            }
            //库存的修改
            Integer productStock = productInfo.getProductStock() + cartDTO.getProductQuantity();
            //设置库存
            productInfo.setProductStock(productStock);
            //保存到数据库中
            productRepository.save(productInfo);
        }
    }


    /**
     * @param productInfo
     * 保存或更新商品信息
     */
    @Override
    public void save(ProductInfo productInfo) {
        productRepository.save(productInfo);
    }

    /**
     * @param productInfo
     * 删除商品信息
     */
    @Override
    public void delete(ProductInfo productInfo) {
        productRepository.delete(productInfo);
    }

    /**
     * @return
     * 查询所有的类目
     */
    @Override
    public List<ProductCategoryDTO> findAllProductCategory() {
        List<ProductCategory> productCategoryRepositoryAll = productCategoryRepository.findAll();
        List<ProductCategoryDTO> productCategoryDTOList = ProductCategoryToProductCategoryDTO.converter(productCategoryRepositoryAll);
        return productCategoryDTOList;
    }



}