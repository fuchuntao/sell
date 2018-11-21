package com.xinyan.sell.converter;

import com.xinyan.sell.dto.ProductCategoryDTO;
import com.xinyan.sell.form.ProductCategoryForm;
import com.xinyan.sell.po.ProductCategory;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;


/**
 * 用户 : 莫言
 * 时间 : 2018/11/19 14:42
 * 类名 : ProductCategoryFormToProductCategoryDto
 * 包名 : com.xinyan.sell.converter
 *
 * @author 莫言
 */
public class ProductCategoryFormToProductCategoryDto {


    /**
     * Converter product ProductCategory 转 ProductCategoryDTO.
     *
     * @param productCategory the product category
     * @return the product category dto
     */
    public static ProductCategoryDTO converter(ProductCategory productCategory) {
        ProductCategoryDTO productCategoryDTO = new ProductCategoryDTO();
        BeanUtils.copyProperties(productCategory, productCategoryDTO);
        return productCategoryDTO;
    }


    /**
     * Converter List<ProductCategory> 转  List<ProductCategoryDTO> .
     *
     * @param productCategoryList the product category list
     * @return the list
     */
    public static List<ProductCategoryDTO> converter(List<ProductCategory> productCategoryList) {
        List<ProductCategoryDTO> productCategoryDTOList = productCategoryList.stream()
                .map(e -> converter(e)).collect(Collectors.toList());

        return productCategoryDTOList;
    }

    /**
     * Converter ProductCategoryForm 转 ProductCategoryDTO.
     *
     * @param productCategoryForm the product category form
     * @return the product category dto
     */
    public static ProductCategoryDTO converter(ProductCategoryForm productCategoryForm) {
        ProductCategoryDTO productCategoryDTO = new ProductCategoryDTO();
        BeanUtils.copyProperties(productCategoryForm, productCategoryDTO);
        return productCategoryDTO;
    }

    /**
     * Converter ProductCategoryDTO 转  ProductCategory.
     *
     * @param productCategoryDTO the product category dto
     * @return the product category
     */
    public static ProductCategory converter(ProductCategoryDTO productCategoryDTO) {
        ProductCategory productCategory = new ProductCategory();
        BeanUtils.copyProperties(productCategoryDTO, productCategory);
        return productCategory;
    }
}
