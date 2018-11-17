<!DOCTYPE html>
<html lang="zh">
<#include "../common/header.ftl">
<body>

<div id="main-wrapper">
    <#include "../common/sidebar.ftl">

    <#include "../common/topbar.ftl">

    <!-- 页面主体内容 -->
    <!-- Page wrapper  -->
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

        <!-- 页面主体信息 -->
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">商品列表</h4>
                            <div class="table-responsive">
                                <table id="zero_config" class="table table-striped table-bordered">
                                    <thead>
                                    <tr>
                                        <th class="text-center">商品ID</th>
                                        <th class="text-center">商品名称</th>
                                        <th class="text-center">价格</th>
                                        <th class="text-center">地址库存</th>
                                        <th class="text-center">商品状态</th>
                                        <th class="text-center">商品类别</th>
                                        <th class="text-center">操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                        <#--<#list productInfos content as productInfo >-->
                                        <#--<tr>-->
                                            <#--<td>${productInfo.productId}</td>-->
                                            <#--<td>${productInfo.productName}</td>-->
                                            <#--<td>${productInfo.productPrice}</td>-->
                                            <#--<td>${productInfo.productStock}</td>-->
                                            <#--<td>${productInfo.productStatus}</td>-->
                                            <#--<td>${productInfo.categoryType}</td>-->
                                            <#--<td>delete/update</td>-->
                                        <#--</tr>-->
                                        <#--</#list>-->

                                    </tbody>
                                </table>
                                <#--<!-- 分页 &ndash;&gt;-->
                                <#--<ul class="pagination float-right">-->
                                        <#--<#if productDTOPage.first>-->
                                        <#--<li class="page-item disabled">-->
                                            <#--<a class="page-link" href="${basePath}/seller/product/list?page=${productDTOPage.pageNumber}">-->
                                                <#--上一页-->
                                            <#--</a>-->
                                        <#--</li>-->
                                        <#--<#else>-->
                                        <#--<li class="page-item">-->
                                            <#--<a class="page-link" href="${basePath}/seller/product/list?page=${productDTOPage.pageNumber}" aria-label="Previous">-->
                                                <#--上一页-->
                                            <#--</a>-->
                                        <#--</li>-->
                                        <#--</#if>-->
                                        <#--<#list 1..productDTOPage.totalPages as index>-->
                                            <#--<#if productDTOPage.pageNumber == (index - 1)>-->
                                        <#--<li class="page-item active">-->
                                            <#--<a class="page-link" href="${basePath}/seller/product/list?page=${index}">${index}</a>-->
                                        <#--</li>-->
                                            <#--<#else>-->
                                        <#--<li class="page-item">-->
                                            <#--<a class="page-link" href="${basePath}/seller/product/list?page=${index}">${index}</a>-->
                                        <#--</li>-->
                                            <#--</#if>-->
                                        <#--</#list>-->
                                        <#--<#if productDTOPage.last>-->
                                        <#--<li class="page-item disabled">-->
                                            <#--<a class="page-link" href="${basePath}/seller/product/list?page=${productDTOPage.pageNumber+1}" aria-label="Next">-->
                                                <#--下一页-->
                                            <#--</a>-->
                                        <#--</li>-->
                                        <#--<#else>-->
                                        <#--<li class="page-item">-->
                                            <#--<a class="page-link" href="${basePath}/seller/product/list?page=${productDTOPage.pageNumber+2}" aria-label="Next">-->
                                                <#--下一页-->
                                            <#--</a>-->
                                        <#--</li>-->
                                        <#--</#if>-->
                                <#--</ul>-->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<#include "../common/layout.ftl">

<#include "../common/js.ftl">
</body>
</html>