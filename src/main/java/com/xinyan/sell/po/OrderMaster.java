package com.xinyan.sell.po;

import com.xinyan.sell.enums.OrderStatus;
import com.xinyan.sell.enums.PayStatus;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * OrderMaster 数据表持久化类
 * (@DynamicUpdate) 动态更新
 * (@Entity) 和数据库表进行映射
 * (@Data) 自动生成 Getter,Setter,toString
 * @author 莫言
 * @date 2018/11/16
 */

@Data
@Entity
@DynamicUpdate
public class OrderMaster {

    @Id
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
