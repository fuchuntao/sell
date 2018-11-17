package com.xinyan.sell.dto;

import com.xinyan.sell.enums.OrderStatus;
import com.xinyan.sell.enums.PayStatus;
import com.xinyan.sell.po.OrderDetail;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Administrator
 * 2018/11/16 0016
 * 订单的数据传输对象
 */
@Data
public class OrderDTO {
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

    /**支付状态 默认支付状态*/
    private Integer payStatus = PayStatus.PAID.getCode();

    /**创建时间*/
    private Date createTime ;

    /**更新时间*/
    private  Date updateTime;

    /**订单详情*/
    private List<OrderDetail> orderDetailList;

}
