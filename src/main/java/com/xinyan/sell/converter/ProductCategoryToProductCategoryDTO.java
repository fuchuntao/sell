package com.xinyan.sell.converter;

import com.xinyan.sell.dto.ProductCategoryDTO;
import com.xinyan.sell.po.ProductCategory;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Administrator
 * 2018/11/19 0019
 */
public class ProductCategoryToProductCategoryDTO {

    public ProductCategoryToProductCategoryDTO() {
    }

    public static ProductCategoryDTO converter(ProductCategory productCategory){
        ProductCategoryDTO productCategoryDTO=new ProductCategoryDTO();
        BeanUtils.copyProperties(productCategory,productCategoryDTO);
        return productCategoryDTO;
    }

    public static List<ProductCategoryDTO> converter(List<ProductCategory> productCategoryList){
        List<ProductCategoryDTO> productCategory=productCategoryList.stream()
                .map(e -> converter(e)).collect(Collectors.toList());

        return productCategory;
    }
}
