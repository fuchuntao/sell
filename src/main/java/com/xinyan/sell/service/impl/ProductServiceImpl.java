package com.xinyan.sell.service.impl;

import com.sun.xml.internal.fastinfoset.stax.events.ReadIterator;
import com.xinyan.sell.DTO.ProductCategoryDTO;
import com.xinyan.sell.DTO.ProductInfoDTO;
import com.xinyan.sell.converter.ProductCategoryToProductCategoryDTO;
import com.xinyan.sell.converter.ProductInfoToProductInfoDTO;
import com.xinyan.sell.po.ProductCategory;
import com.xinyan.sell.po.ProductInfo;
import com.xinyan.sell.repository.ProductCategoryRepository;
import com.xinyan.sell.repository.ProductRepository;
import com.xinyan.sell.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Administrator
 * 2018/11/15 0015
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    //============================卖家端===========================

    @Override
    public ProductInfo findOne(String productId) {
       //根据id找到productInfo对象
        ProductInfo productInfo=productRepository.findOne(productId);

        return productInfo;
    }

    @Override
    public List<ProductInfo> findAll() {
        return null;
    }

    @Override
    public Page<ProductInfoDTO> findAll(Pageable pageable) {
        //创建商品信息分页对象
     Page<ProductInfo> productInfoPage=productRepository.findAll(pageable);

     //获取所有的商品类目
//        List<ProductCategory> productRepositoryList=productCategoryRepository.findAll();


        //将商品信息分页对象转换为商品信息DTO对象（list）
     List<ProductInfoDTO> productInfoDTOList=ProductInfoToProductInfoDTO.converter(productInfoPage.getContent());
        for (ProductInfoDTO productInfoDTO:productInfoDTOList){
                for (ProductInfo productInfo:productInfoPage){
                    ProductCategory productCategory1=productCategoryRepository.findOneByCategoryType(productInfo.getCategoryType());
                    productInfoDTO.setCategoryName(productCategory1.getCategoryName());
            }

        }


        //将list的DTO对象封装为分页DTO对象
     Page<ProductInfoDTO> productInfoDTOPage = new PageImpl<>(productInfoDTOList, pageable, productInfoPage.getTotalElements());

        return productInfoDTOPage;
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
        List<ProductCategoryDTO> converter = ProductCategoryToProductCategoryDTO.converter(productCategoryRepositoryAll);
        return converter;
    }


}