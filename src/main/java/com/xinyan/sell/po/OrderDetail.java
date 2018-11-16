package com.xinyan.sell.po;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;


/**
 * OrderDetail 数据持久化对象
 *
 *
 * (@Entity)会根据类名跟数据库表（相同的表名）进行关联(自动清除下划线，进行类名拼接)，
 *          如果不相同则使用table(name = "OrderDetail(数据库表名)")进行关联
 *
 *
 *   (@DynamicUpdate) 动态更新
 *   (@Entity) 和数据库表进行映射
 *   (@Data) 自动生成 Getter,Setter,toString
 * @author 莫言
 */


@Data
@Entity
@DynamicUpdate
public class OrderDetail {

    @Id
    private String detailId;

    private String orderId;

    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 当前价格，单位分
     */
    private BigDecimal productPrice;

    /**
     * 数量
     */
    private Integer productQuantity;

    /**
     * 菜单小图标
     */
    private String productIcon;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新(修改时间)
     */
    private Date updateTime;
}
