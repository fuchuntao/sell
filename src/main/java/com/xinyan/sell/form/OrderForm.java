package com.xinyan.sell.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Administrator
 * 2018/11/17 0017
 * OrderForm表单对象
 */
@Data
public class OrderForm {

    @NotEmpty(message = "姓名必填")
    private String name;

    @NotEmpty(message = "电话必填")
    private String phone;

    @NotEmpty(message = "地址必填")
    private String address;


    @NotEmpty(message = "微信openid必填")
    private String openid;

    @NotEmpty(message = "订单详情必填")
    private String items;

}
