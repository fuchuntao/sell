<!DOCTYPE html>
<html lang="zh">
<#include "../common/header.ftl">

<body>
<div id="main-wrapper">
        <#include "../common/sidebar.ftl">

        <#include "../common/topbar.ftl">
    <div class="page-wrapper">

        <!-- 页面功能导航 -->
        <div class="page-breadcrumb">
            <div class="row">
                <div class="col-5 align-self-center">
                    <h4 class="page-title">商品管理</h4>
                    <div class="d-flex align-items-center"></div>
                </div>
                <div class="col-7 align-self-center">
                    <div class="d-flex no-block justify-content-end align-items-center">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item">首页</li>
                                <li class="breadcrumb-item active" aria-current="page">
                                    商品
                                </li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
        </div>

<!-- 页面主体内容 -->
<div class="container-fluid">
    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">添加商品</h4>
                </div>
            </div>
                <hr class="m-t-0">
                <form  action="${basePath}/seller/product/add" method="post">
                    <div class="card-body">
                        <h4 class="card-title">productInfo</h4>
                        <div class="form-group row align-items-center m-b-0">
                            <label for="inputEmail3" class="col-3 text-right control-label col-form-label">商品名称</label>
                            <div class="col-9 border-left p-b-10 p-t-10">
                                <input type="text"  name="productName" class="form-control" required  placeholder="商品名称">
                            </div>
                        </div>
                        <div class="form-group row align-items-center m-b-0">
                            <label for="inputEmail3" class="col-3 text-right control-label col-form-label">商品价格</label>
                            <div class="col-9 border-left p-b-10 p-t-10">
                                <input type="number" required  name="productPrice" class="form-control" id="inputEmail3" placeholder="商品价格">
                            </div>
                        </div>
                        <div class="form-group row align-items-center m-b-0">
                            <label for="inputEmail3" class="col-3 text-right control-label col-form-label">商品库存</label>
                            <div class="col-9 border-left p-b-10 p-t-10">
                                <input type="number" required  name="productStock" class="form-control" id="inputEmail3" placeholder="商品库存">
                            </div>
                        </div>
                        <div class="form-group row align-items-center m-b-0">
                            <label for="inputEmail3" class="col-3 text-right control-label col-form-label">商品描述</label>
                            <div class="col-9 border-left p-b-10 p-t-10">
                                <input type="text"  name="productDescription" class="form-control" required data-validation-required-message="此处必须填写，不能为空" placeholder="商品描述">
                            </div>
                        </div>

                        <div class="form-group row align-items-center m-b-0">
                            <label for="inputEmail3" class="col-3 text-right control-label col-form-label">商品状态</label>
                            <div class="col-9 border-left p-b-10 p-t-10">
                                <div class="custom-control custom-radio">
                                    <input type="radio" value="0" name="productStatus" checked required id="styled_radio1" class="custom-control-input">
                                    <label class="custom-control-label" for="styled_radio1">上架</label>
                                </div>
                                <div class="custom-control custom-radio">
                                    <input type="radio" value="1" name="productStatus" id="styled_radio2" class="custom-control-input">
                                    <label class="custom-control-label" for="styled_radio2">下架</label>
                                </div>
                            </div>
                        </div>

                        <div class="form-group row align-items-center m-b-0">
                            <label for="inputEmail3" class="col-3 text-right control-label col-form-label">商品类别</label>
                            <div class="col-9 border-left p-b-10 p-t-10">
                                <select class="form-control" name="categoryType" id="categoryType" >
                                    <#list productCategoryDTOList as productCategoryDTO >
                                        <option value="${productCategoryDTO.categoryType}" >
                                            ${productCategoryDTO.categoryName}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>

                        <div class="form-group row align-items-center m-b-0">
                            <label for="inputEmail3" class="col-3 text-right control-label col-form-label">商品照片</label>
                            <div class="col-9 border-left p-b-10 p-t-10">
                                <input type="url"  name="productIcon" class="form-control" required placeholder="输入照片URL"/>
                            </div>
                        </div>

                        </div>
                        <div class="card-body">
                        <div class="form-group m-b-0 text-right">
                            <button type="submit" class="btn btn-info waves-effect waves-light">保存</button>
                            <button type="submit" class="btn btn-dark waves-effect waves-light">取消</button>
                        </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    </div>
</div>
<#include "../common/layout.ftl">

<#include "../common/js.ftl">
</body>

</html>