package com.xinyan.sell.controller;

import com.xinyan.sell.converter.ProductCategoryFormToProductCategoryDto;
import com.xinyan.sell.dto.ProductCategoryDTO;
import com.xinyan.sell.form.ProductCategoryForm;
import com.xinyan.sell.po.ProductCategory;
import com.xinyan.sell.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 卖家类目Controller
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


    @Autowired
    private ProductCategoryService productCategoryService;


    /**
     * 修改类目
     * @param categoryId
     * @param map
     * @return
     */
    @GetMapping("/update/{categoryId}")
    public String update(@PathVariable("categoryId") Integer categoryId, Map<String, Object> map){
        ProductCategory productCategory = productCategoryService.findOne(categoryId);
        map.put("productCategory" , productCategory);
        return "productcategory/detail";
    }

    /**
     * 去添加类目页面
     * @return
     */
    @GetMapping("/add")
    public String add(){
        return "productcategory/add";
    }

    /**
     * 添加类目
     * @param productCategoryForm
     * @return
     */
    @PostMapping("/save")
    public String save(ProductCategoryForm productCategoryForm){
        ProductCategoryDTO productCategoryDTO = ProductCategoryFormToProductCategoryDto.converter(productCategoryForm);
        productCategoryService.save(productCategoryDTO);
        return "redirect:/product/productcategory/list";
    }


    /**
     * 修改类目
     * @param categoryId
     * @param productCategoryForm
     * @return
     */
    @PostMapping("/save/{categoryId}")
    public String update(@PathVariable("categoryId") Integer categoryId, ProductCategoryForm productCategoryForm) {
        ProductCategoryDTO productCategoryDTO = ProductCategoryFormToProductCategoryDto.converter(productCategoryForm);
        productCategoryDTO.setCategoryId(categoryId);
        productCategoryService.save(productCategoryDTO);
        return "redirect:/product/productcategory/list";
    }


    /**
     * 类目列表
     * @param page
     * @param size
     * @param map
     * @return
     */
    @GetMapping("/list")
    public String list(@RequestParam(value = "page",required = false,defaultValue = "1") Integer page,
                       @RequestParam(value = "size",required = false,defaultValue = "5") Integer size,
                       Map<String ,Object> map){

        PageRequest pageRequest = new PageRequest(page-1, size);
        Sort desc = new Sort(Sort.Direction.DESC, "updateTime");
        Page<ProductCategoryDTO> productCategoryDTOS = productCategoryService.pageList(pageRequest, desc);
        map.put("productCategoryDTOS",productCategoryDTOS);
        return "productcategory/list";
    }

    /**
     * 删除类目
     * @param categoryId
     * @return
     */
    @GetMapping("/delete/{categoryId}")
    public String delete(@PathVariable("categoryId") Integer categoryId){
        productCategoryService.delete(categoryId);
        return "redirect:/product/productcategory/list";
    }


}
