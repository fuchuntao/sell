package com.xinyan.sell.enums;

import lombok.Getter;

/**
 * Administrator
 * 2018/11/15 0015
 */
@Getter
public enum ProductStatus {
    UP(0,"上架"),
    DOWN(1, "下架")
    ;
    private Integer code;
    private String message;

    ProductStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
