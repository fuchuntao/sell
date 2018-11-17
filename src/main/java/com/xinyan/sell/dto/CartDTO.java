package com.xinyan.sell.dto;

import lombok.Getter;

/**
 * Administrator
 * 2018/11/17 0017
 * 购物车
 */
@Getter
public class CartDTO {

    /** 商品id */
    private String productId;

    /** 商品数量 */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
