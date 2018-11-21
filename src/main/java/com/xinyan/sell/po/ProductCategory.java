package com.xinyan.sell.po;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Administrator
 * 2018/11/14 0014
 * 类目实体类
 */
@Data //自动生成set,get
@Entity //和数据库表映射
@DynamicUpdate //动态更新
public class ProductCategory {

    @GeneratedValue //主键自动生成
    @Id  //映射主键
    /** 类目id*/
    private Integer categoryId;

    /** 类目名称*/
    private String categoryName;

    /** 类目编号*/
    private Integer categoryType;

}
