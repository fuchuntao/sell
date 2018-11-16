package com.xinyan.sell.enums;

import lombok.Getter;

/**
 * Administrator
 * 2018/11/16 0016
 * 订单状态枚举类
 */
@Getter
public enum OrderStatus {
    NEW(0, "新订单"),
    FINISH(1, "已完结订单"),
    CANCEL(2, "取消订单")
    ;


    private Integer code;
    private String message;

    OrderStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
