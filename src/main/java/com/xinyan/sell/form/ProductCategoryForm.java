package com.xinyan.sell.form;

import lombok.Data;

import java.util.Date;

/**
  * .@Data //自动生成set,get.
 * 2018/11/14 0014.
 *  @author 莫言
 */
@Data
public class ProductCategoryForm {

    /** 类目名称.*/
    private String categoryName;

    /** 类目编号.*/
    private Integer categoryType;

    /**修改时间*/
    private Date updateTime;


}
