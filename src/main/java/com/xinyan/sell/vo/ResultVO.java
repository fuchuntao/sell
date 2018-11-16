package com.xinyan.sell.vo;

import lombok.Data;

/**
 * Administrator
 * 2018/11/16 0016
 * 返回客户端的vo对象
 */
@Data
public class ResultVO<T> {

    /** 错误码 */
    private Integer code;

    /** 消息 */
    private String msg;

    /** 页面数据 */
    private T data;
}
