package com.xinyan.sell.controller;

import com.xinyan.sell.converter.ProductCategoryFormToProductCategoryDto;
import com.xinyan.sell.dto.ProductCategoryDTO;
import com.xinyan.sell.form.ProductCategoryForm;
import com.xinyan.sell.po.ProductCategory;
import com.xinyan.sell.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 用户 : 莫言
 * 时间 : 2018/11/19 9:32
 * 类名 : productCategoryController
 * 包名 : com.xinyan.sell.controller
 *
 * @author 莫言
 */
@RequestMapping("/product/productcategory")
@Controller
public class ProductCategoryController {


    /**
     * The Product category service.
     */
    @Autowired
    private ProductCategoryService productCategoryService;


    /**
     * Update 更新.
     *
     * @param categoryId the category id
     * @param map        the map
     * @return the string
     */
    @GetMapping("/update/{categoryId}")
    public String update(@PathVariable("categoryId") Integer categoryId, Map<String, Object> map){
        ProductCategory productCategory = productCategoryService.findOne(categoryId);
        map.put("productCategory" , productCategory);
        return "productcategory/detail";
    }

    /**
     * Add 添加跳转页面.
     *
     * @return the string
     */
    @GetMapping("/add")
    public String add(){
        return "productcategory/add";
    }

    /**
     * Save 添加保存.
     *
     * @param productCategoryForm the product category form
     * @return the string
     */
    @PostMapping("/save")
    public String save(ProductCategoryForm productCategoryForm){
        ProductCategoryDTO productCategoryDTO = ProductCategoryFormToProductCategoryDto.converter(productCategoryForm);
        productCategoryService.save(productCategoryDTO);

        return "redirect:/product/productcategory/list";
    }


    /**
     * Update 更新.
     *
     * @param categoryId          the category id
     * @param productCategoryForm the product category form
     * @return the string
     */
    @PostMapping("/save/{categoryId}")
    public String update(@PathVariable("categoryId") Integer categoryId, ProductCategoryForm productCategoryForm) {
        ProductCategoryDTO productCategoryDTO = ProductCategoryFormToProductCategoryDto.converter(productCategoryForm);
        productCategoryDTO.setCategoryId(categoryId);
        productCategoryService.save(productCategoryDTO);


        return "redirect:/product/productcategory/list";
    }


    /**
     * 类目列表.
     *
     * @return map集合
     */
    @GetMapping("/list")
    public String list(@RequestParam(value = "page",required = false,defaultValue = "1") Integer page,
                       @RequestParam(value = "size",required = false,defaultValue = "5") Integer size,
                       Map<String ,Object> map){

        PageRequest pageRequest = new PageRequest(page-1, size);
        Page<ProductCategoryDTO> productCategoryDTOS = productCategoryService.pageList(pageRequest);
        map.put("productCategoryDTOS",productCategoryDTOS);

        return "productcategory/list";
    }

    /**
     * 删除.
     *
     * @return the product category vo
     */
    @GetMapping("/delete/{categoryId}")
    public String findNo(@PathVariable("categoryId") Integer categoryId){
        productCategoryService.delete(categoryId);
        return "redirect:/product/productcategory/list";
    }


}
