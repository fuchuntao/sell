package com.xinyan.sell.converter;

import com.xinyan.sell.dto.ProductInfoDTO;
import com.xinyan.sell.po.ProductInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
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

    public static List<ProductInfo> converter(List<ProductInfoDTO> productInfoDTOList){
        List<ProductInfo> productInfoList = productInfoDTOList.stream()
                .map(e -> converter(e)).collect(Collectors.toList());

        return productInfoList;
    }
}
