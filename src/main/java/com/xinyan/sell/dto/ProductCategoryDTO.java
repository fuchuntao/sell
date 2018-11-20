package com.xinyan.sell.dto;

import lombok.Data;

/**
 * 2018/11/14 0014.
 * .@Data 自动生成set, get
 *
 * @author 莫言
 */
@Data
public class ProductCategoryDTO {

    /**
     * 类目ID Category id.
     */
    private Integer categoryId;

    /**
     * 类目名称
     */
    private String categoryName;

    /**
     * 类目编号
     */
    private Integer categoryType;

}
