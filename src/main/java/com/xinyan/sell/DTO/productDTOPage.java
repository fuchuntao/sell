package com.xinyan.sell.DTO;

import com.xinyan.sell.po.ProductInfo;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;

/**
 * Administrator
 * 2018/11/17 0017
 */
@Data
public class productDTOPage {

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private Integer productStatus;

    private Integer categoryType;

    private int pageNumber;

    private int size;

}
