package com.xinyan.sell.dto;

import lombok.Data;

import java.math.BigDecimal;


/**
 * Administrator
 * 2018/11/17 0017
 * 商品信息DTO对象
 */
@Data
public class ProductInfoDTO {

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private  Integer productStock;

    private Integer productStatus;

    private Integer categoryType;

}
