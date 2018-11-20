package com.xinyan.sell.controller;


import com.xinyan.sell.dto.ProductCategoryDTO;
import com.xinyan.sell.converter.ProductInfoToProductInfoDTO;
import com.xinyan.sell.dto.ProductInfoDTO;
import com.xinyan.sell.enums.ProductStatus;
import com.xinyan.sell.po.ProductCategory;
import com.xinyan.sell.po.ProductInfo;
import com.xinyan.sell.service.ProductCategoryService;
import com.xinyan.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


/**
 * Administrator
 * 2018/11/16 0016
 * 卖家商品Controller
 */
@RequestMapping("/seller/product")
@Controller
public class SellerProductController  {


    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 分页查询商品列表
     * @param map
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public String list(Map<String, Object> map,
                       @RequestParam(value = "page",required = false,defaultValue = "1") Integer page,
                       @RequestParam(value = "size",required = false,defaultValue = "5") Integer size){

        PageRequest pageRequest=new PageRequest(page-1, size);
        Page<ProductInfoDTO> productInfoDTOPage=productService.findAll(pageRequest);

        map.put("productInfoDTOPage",productInfoDTOPage);

        return "product/list";
    }

    /**
     *商品下架
     * @param productId
     * @return
     */

    @RequestMapping("/updateStatusDown")
    public String updateStatusDown(@RequestParam("productId") String productId){
        //通过商品id找到商品对象
        ProductInfo productInfo=productService.findOne(productId);
        //更改商品为下架
        productInfo.setProductStatus(ProductStatus.DOWN.getCode());
        //保存商品信息
        productService.save(productInfo);

        return  "redirect:list";
    }

    /**
     *商品上架
     * @param productId
     * @return
     */
    @RequestMapping("/updateStatusUp")
    public String updateStatusUp(@RequestParam("productId") String productId){
        //通过商品id找到商品对象
        ProductInfo productInfo=productService.findOne(productId);
        //更改商品为上架
        productInfo.setProductStatus(ProductStatus.UP.getCode());
        //保存商品信息
        productService.save(productInfo);

        return "redirect:list";
    }

    /**
     *删除商品
     * @param productId
     * @return
     */
    @RequestMapping("/delete")
    public String delete(@RequestParam("productId") String productId){
        //根据商品id找到商品对象
        ProductInfo productInfo=productService.findOne(productId);
        //删除商品
        productService.delete(productInfo);

        return "redirect:list";
    }

    /**
     * 更新商品信息
     * @param productId
     * @param map
     * @return
     */
    @RequestMapping("/update")
    public String update(@RequestParam("productId") String productId,Map<String, Object> map){
        //根据商品id找到商品对象
        ProductInfo productInfo=productService.findOne(productId);
        //将商品对象转化为DTO对象
        ProductInfoDTO productInfoDTO=ProductInfoToProductInfoDTO.converter(productInfo);
        //获取商品的类目名称
        ProductCategory productCategory=productCategoryService.findByCategoryType(productInfo.getCategoryType());
       //将查询到的商品类目设置到DTO对象中
        productInfoDTO.setCategoryName(productCategory.getCategoryName());
        //将获取的对象放到请求域中
        map.put("productInfoDTO",productInfoDTO);
        //获取所有的类目
        List<ProductCategoryDTO> productCategoryDTOList=productService.findAllProductCategory();
        map.put("productCategoryDTOList",productCategoryDTOList);
        return "product/update";
    }

    /**
     * 去添加商品页面
     * @param model
     * @return
     */
    @RequestMapping("/toAdd")
    public String toAdd(Model model){
        List<ProductCategoryDTO> productCategoryDTOList=productService.findAllProductCategory();

        model.addAttribute("productCategoryDTOList",productCategoryDTOList);

        return "product/add";
    }

    /**
     * 添加商品
     * @param productId
     * @param productInfoDTO
     * @return
     */
    @GetMapping("/save/{id}")
    public String save(@PathVariable("productId") String productId,
                       ProductInfoDTO productInfoDTO){


        //根据商品Id查询商品是否存在
        ProductInfo pro=productService.findOne(productInfoDTO.getProductId());
        if (!productInfoDTO.getProductId().isEmpty()){
            pro.setProductName(productInfoDTO.getProductName());
            pro.setProductPrice(productInfoDTO.getProductPrice());
            pro.setProductStock(productInfoDTO.getProductStock());
            pro.setProductDescription(productInfoDTO.getProductDescription());
            pro.setProductIcon(productInfoDTO.getProductIcon());
            pro.setProductStatus(productInfoDTO.getProductStatus());

            //通过获取DTO对象的CategoryName查找CategoryType
            ProductCategory productCategory=productCategoryService.findByCategoryName(productInfoDTO.getCategoryName());

            pro.setCategoryType(productCategory.getCategoryType());
        }
        productService.save(pro);
        return "redirect:/seller/product/list";
    }
}
