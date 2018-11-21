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
                    <h4 class="page-title">类目管理</h4>
                    <div class="d-flex align-items-center"></div>
                </div>
                <div class="col-7 align-self-center">
                    <div class="d-flex no-block justify-content-end align-items-center">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item">首页</li>
                                <li class="breadcrumb-item active" aria-current="page">
                                    订单
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
                <div class="col-8">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">类目列表</h4>
                            <div class="table-responsive">
                                <table id="zero_config" class="table table-striped table-bordered">
                                    <thead>
                                    <tr>
                                        <th class="text-center">类目ID</th>
                                        <th class="text-center">类目名称</th>
                                        <th class="text-center">类目编码</th>
                                        <th class="text-center">操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <#list productCategoryDTOS.content as productCategoryDTOS >
                                        <tr>
                                            <td>${productCategoryDTOS.categoryId}</td>
                                            <td>${productCategoryDTOS.categoryName}</td>
                                            <td>${productCategoryDTOS.categoryType}</td>
                                            <td>
                                                <a class="btn btn-sm btn-outline-info" href="${basePath}/product/productcategory/update/${productCategoryDTOS.categoryId}" ">修改</a>
                                                <a class="btn btn-sm btn-outline-danger" id="delete" onclick="deleteProduct(${productCategoryDTOS.categoryId})">删除</a>
                                                <a class="btn btn-sm btn-outline-danger" href="${basePath}/product/productcategory/add" ">添加</a>
                                            </td>
                                        </tr>
                                        </#list>
                                    </tbody>
                                </table>
                                <!-- 分页 -->
                                <ul class="pagination float-right">
                                        <#if productCategoryDTOS.first>
                                        <li class="page-item disabled">
                                            <a class="page-link" href="${basePath}/product/productcategory/list?page=${productCategoryDTOS.number}">
                                                上一页
                                            </a>
                                        </li>
                                        <#else>
                                        <li class="page-item">
                                            <a class="page-link" href="${basePath}/product/productcategory/list?page=${productCategoryDTOS.number}" aria-label="Previous">
                                                上一页
                                            </a>
                                        </li>
                                        </#if>
                                        <#list 1..productCategoryDTOS.totalPages as index>
                                            <#if productCategoryDTOS.number == (index - 1)>
                                        <li class="page-item active">
                                            <a class="page-link" href="${basePath}/product/productcategory/list?page=${index}">${index}</a>
                                        </li>
                                            <#else>
                                        <li class="page-item">
                                            <a class="page-link" href="${basePath}/product/productcategory/list?page=${index}">${index}</a>
                                        </li>
                                            </#if>
                                        </#list>
                                        <#if productCategoryDTOS.last>
                                        <li class="page-item disabled">
                                            <a class="page-link" href="${basePath}/product/productcategory/list?page=${productCategoryDTOS.number+1}" aria-label="Next">
                                                下一页
                                            </a>
                                        </li>
                                        <#else>
                                        <li class="page-item">
                                            <a class="page-link" href="${basePath}/product/productcategory/list?page=${productCategoryDTOS.number+2}" aria-label="Next">
                                                下一页
                                            </a>
                                        </li>
                                        </#if>
                                </ul>
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
<script>
    //删除
    function deleteProduct(id) {
        if(confirm("确定要删除吗？")) {
            window.location="${basePath}/product/productcategory/delete/" +id;
            <#--$("#delete").attr("href", "${basePath}/product/productcategory/delete/" +id);-->
            return true;
        }
        return false;
    }
</script>
</body>
</html>
