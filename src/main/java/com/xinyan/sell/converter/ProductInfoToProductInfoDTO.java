package com.xinyan.sell.converter;

import com.xinyan.sell.dto.ProductInfoDTO;
import com.xinyan.sell.po.ProductInfo;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Administrator
 * 2018/11/19 0019
 */
public class ProductInfoToProductInfoDTO {

    public ProductInfoToProductInfoDTO() {
    }

    public static ProductInfoDTO converter(ProductInfo productInfo){
        ProductInfoDTO productInfoDTO=new ProductInfoDTO();
        BeanUtils.copyProperties(productInfo,productInfoDTO);
        return productInfoDTO;
    }

    public static List<ProductInfoDTO> converter(List<ProductInfo> productInfoList){
        List<ProductInfoDTO> productInfoDTOList=productInfoList.stream()
                .map(e -> converter(e)).collect(Collectors.toList());

        return productInfoDTOList;
    }
}
