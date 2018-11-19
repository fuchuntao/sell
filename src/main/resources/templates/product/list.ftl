
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
                    <h4 class="page-title">订单管理</h4>
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
                <div class="col-12">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">订单列表</h4>
                            <div class="table-responsive">
                                <table id="zero_config" class="table table-striped table-bordered">
                                    <thead>
                                    <tr>
                                        <th class="text-center">商品ID</th>
                                        <th class="text-center">商品名称</th>
                                        <th class="text-center">价格</th>
                                        <th class="text-center">商品库存</th>
                                        <th class="text-center">商品状态</th>
                                        <th class="text-center">商品类别</th>
                                        <th class="text-center">操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                         <#list productInfoDTOPage.content as productInfoDTO >
                                         <tr>
                                             <td>${productInfoDTO.productId}</td>
                                             <td>${productInfoDTO.productName}</td>
                                             <td>${productInfoDTO.productPrice}</td>
                                             <td>${productInfoDTO.productStock}</td>
                                             <td>
                                                 <#if productInfoDTO.productStatus == 0>上架
                                                 <#elseif productInfoDTO.productStatus == 1>下架
                                                 </#if>
                                             </td>
                                             <td>${productInfoDTO.categoryType}</td>
                                             <td>
                                                  <#if productInfoDTO.productStatus == 0>
                                                   <a class="btn btn-sm btn-outline-info" href="${basePath}/seller/product/updateStatusDown?productId=${productInfoDTO.productId}">下架</a>
                                                  <#elseif productInfoDTO.productStatus == 1>
                                                  <a class="btn btn-sm btn-outline-info" href="${basePath}/seller/product/updateStatusUp?productId=${productInfoDTO.productId}">上架</a>
                                                  </#if>
                                                  <a class="btn btn-sm btn-outline-info" href="${basePath}/seller/product/delete?productId=${productInfoDTO.productId}">删除</a>
                                                  <a class="btn btn-sm btn-outline-info" href="${basePath}/seller/product/update?productId=${productInfoDTO.productId}">更新</a>
                                             </td>
                                         </tr>
                                         </#list>
                                    </tbody>
                                </table>
                                <!-- 分页 -->
                                <ul class="pagination float-right">
                                        <#if productInfoDTOPage.first>
                                        <li class="page-item disabled">
                                            <a class="page-link" href="${basePath}/seller/product/list?page=${productInfoDTOPage.number}">
                                                上一页
                                            </a>
                                        </li>
                                        <#else>
                                        <li class="page-item">
                                            <a class="page-link" href="${basePath}/seller/product/list?page=${productInfoDTOPage.number}" aria-label="Previous">
                                                上一页
                                            </a>
                                        </li>
                                        </#if>
                                        <#list 1..productInfoDTOPage.totalPages as index>
                                            <#if productInfoDTOPage.number == (index - 1)>
                                        <li class="page-item active">
                                            <a class="page-link" href="${basePath}/seller/product/list?page=${index}">${index}</a>
                                        </li>
                                            <#else>
                                        <li class="page-item">
                                            <a class="page-link" href="${basePath}/seller/product/list?page=${index}">${index}</a>
                                        </li>
                                            </#if>
                                        </#list>
                                        <#if productInfoDTOPage.last>
                                        <li class="page-item disabled">
                                            <a class="page-link" href="${basePath}/seller/product/list?page=${productInfoDTOPage.number+1}" aria-label="Next">
                                                下一页
                                            </a>
                                        </li>
                                        <#else>
                                        <li class="page-item">
                                            <a class="page-link" href="${basePath}/seller/product/list?page=${productInfoDTOPage.number+2}" aria-label="Next">
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
</body>
</html>