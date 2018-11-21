package com.xinyan.sell.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Administrator
 * 2018/11/16 0016
 * 返回客户端的ResultVO对象
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVO<T> {

    /** 错误码 */
    private Integer code;

    /** 消息 */
    private String msg;

    /** 页面数据 */
    private T data;
}
