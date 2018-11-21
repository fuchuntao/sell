package com.xinyan.sell.DTO;
import com.xinyan.sell.enums.ProductStatus;
import lombok.Data;

import java.math.BigDecimal;


/**
 * Administrator
 * 2018/11/17 0017
 * 商品信息DTO对象
 */
@Data
public class ProductInfoDTO {

    /**
     * 商品ID
     */
    private String productId;

    /**
     * 商品名字
     */
    private String productName;

    /**
     * 商品价格
     */
    private BigDecimal productPrice;

    /**
     * 商品库存
     */
    private  Integer productStock;

    /**
     * 商品状态
     */
    private Integer productStatus;

    /**
     * 商品类目
     */
    private Integer categoryType;

    /**
     * 商品描述
     */
    private String productDescription;

    /**
     * 商品图片
     */
    private String productIcon;

}
