package com.xinyan.sell.po;

import com.xinyan.sell.enums.PayStatus;
import com.xinyan.sell.enums.ProductStatus;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Administrator
 * 2018/11/16 0014
 * 商品列表实体类
 */
@Data //自动生成set,get
@Entity //和数据库表映射
@DynamicUpdate //动态更新
public class ProductInfo {

    @Id
    /** 商品id */
    private String productId;

    /** 商品名 */
    private String productName;


    /** 商品价格 */
    private BigDecimal productPrice;


    /** 商品库存 */
    private Integer productStock;


    /** 商品描述 */
    private String productDescription;


    /** 图片 */
    private String productIcon;


    /** 商品状态，0正常，1下架 */
    private Integer productStatus = ProductStatus.UP.getCode();


    /** 类目编号 */
    private Integer categoryType;

    /** 创建时间 */
    private Date createTime;
}
