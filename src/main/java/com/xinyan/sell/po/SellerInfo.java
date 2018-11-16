package com.xinyan.sell.po;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * SellerInfo 数据持久化类
 * ProductCategory 数据表持久化类
 * (@DynamicUpdate) 动态更新
 * (@Entity) 和数据库表进行映射
 * (@Data) 自动生成 Getter,Setter,toString
 * @author 莫言
 * @date 2018/11/16
 */

@Data
@Entity
@DynamicUpdate
public class SellerInfo {



    @Id
    private Integer Id;

    /**卖家账户(可能会通过微信登录)*/
    private String userName;

    /**卖家密码*/
    private String passWord;

    /**微信openid*/
    private String openId;

    /**创建时间*/
    private Date createTime;

    /**更新(修改时间)*/
    private Date updateTime;

}
