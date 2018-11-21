package com.xinyan.sell.vo;

import com.xinyan.sell.enums.OrderStatus;
import com.xinyan.sell.enums.PayStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Administrator
 * 2018/11/18 0018
 * 订单主表OrderMasterVO
 */
@Data
public class OrderMasterVO {
    /**
     * 订单id
     */
    private String orderId;

    /**卖家名字*/
    private String buyerName;

    /**卖家电话*/
    private String buyerPhone;

    /**卖家地址*/
    private String buyerAddress;

    /**卖家微信openid*/
    private String buyerOpenid;

    /**订单总额*/
    private BigDecimal orderAmount;

    /**订单状态 默认为下单状态*/
    private Integer orderStatus = OrderStatus.NEW.getCode();

    /**支付状态 默认未支付状态*/
    private Integer payStatus = PayStatus.WAIT.getCode();

    /**创建时间*/
    private Date createTime;

    /**更新(修改时间)*/
    private Date updateTime;
}
