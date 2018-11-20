package com.xinyan.sell.DTO;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
