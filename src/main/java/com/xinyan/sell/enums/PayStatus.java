package com.xinyan.sell.enums;

import lombok.Getter;

/**
 * Administrator
 * 2018/11/16 0016
 * 订单支付状态枚举类
 */
@Getter
public enum PayStatus {
    WAIT(0, "未支付"),
    PAID(1, "已支付")


    ;

    private Integer code;
    private String message;

    PayStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
