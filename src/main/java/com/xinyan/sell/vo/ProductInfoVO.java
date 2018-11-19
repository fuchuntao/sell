package com.xinyan.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Administrator
 * 2018/11/16 0016
 * 商品详情ProductInfoVO对象
 *
 */
@Data
public class ProductInfoVO {

    /** 商品id */
    @JsonProperty("id")
    private String productId;

    /** 商品名 */
    @JsonProperty("name")
    private String productName;


    /** 商品价格 */
    @JsonProperty("price")
    private BigDecimal productPrice;


    /** 商品描述 */
    @JsonProperty("description")
    private String productDescription;


    /** 图片 */
    @JsonProperty("icon")
    private String productIcon;

}
