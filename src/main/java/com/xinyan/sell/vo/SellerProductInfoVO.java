package com.xinyan.sell.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 卖家端商品信息视图
 * Administrator
 * 2018/11/16 0016
 */
@Data
public class SellerProductInfoVO {

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private Integer productStatus;

    private Integer categoryType;

//    private int pageNumber;
//
//    private int pageSize;
}
