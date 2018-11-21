package com.xinyan.sell.dto;

import lombok.Data;

/**
 * Administrator
 * 2018/11/14 0014
 */
@Data //自动生成set,get
public class ProductCategoryDTO {


    /** 类目id*/
    private Integer categoryId;

    /** 类目名称*/
    private String categoryName;

    /** 类目编号*/
    private Integer categoryType;

}
