package com.xinyan.sell.converter;

import com.xinyan.sell.DTO.ProductInfoDTO;
import com.xinyan.sell.po.ProductInfo;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Administrator
 * 2018/11/19 0019
 */
public class ProductInfoDTOToProductInfo {

    public ProductInfoDTOToProductInfo() {
    }

    public static ProductInfo converter(ProductInfoDTO productInfoDTO){
       ProductInfo productInfo=new ProductInfo();
        BeanUtils.copyProperties(productInfoDTO,productInfo);
        return productInfo;
    }

//    public static List<ProductInfoDTO> converter(List<ProductInfo> productInfoList){
//        List<ProductInfoDTO> productInfoDTOList=productInfoList.stream()
//                .map(e -> converter(e)).collect(Collectors.toList());
//
//        return productInfoDTOList;
//    }
}
