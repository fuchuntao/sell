package com.xinyan.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Administrator
 * 2018/11/16 0016
 * 商品列表ProductVO对象
 */
@Data
public class ProductVO {

    /** 类目名称*/
    @JsonProperty("name")
    private String categoryName;

    /** 类目编号*/
    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;

}
