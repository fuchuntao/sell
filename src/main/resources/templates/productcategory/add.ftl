<!DOCTYPE html>
<html dir="ltr" lang="zh">
<!-- head -->
<#include "../common/header.ftl">
<body>

<div id="main-wrapper">
    <!-- Topbar header - style you can find in pages.scss -->
    <#include "../common/topbar.ftl">

    <!-- Left Sidebar - style you can find in sidebar.scss  -->
    <#include "../common/sidebar.ftl">

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
                                    <a href="${basePath}/product/productcategory/list">类目</a>
                                </li>
                                <li class="breadcrumb-item active" aria-current="page">
                                    详情
                                </li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
        </div>

        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">类目编辑</h4>
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-md-12">
                                        <!-- 类目编辑 -->
                                        <form action="${basePath}/product/productcategory/save" method="post">
                                            <table class="table table-striped table-bordered">
                                                <thead>
                                                    <tr>
                                                        <th>类目名称</th><br>
                                                        <th>类目编码</th><br>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>
                                                            <input type="text" name="categoryName" />
                                                        </td>
                                                        <td>
                                                            <input type="text" name="categoryType" />
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>

                                    </div>
                                    <div class="col-md-12">
                                        <div class="btn-group" role="group">
                                                <button type="submit" class="btn btn-success">提交</button>
                                        </div>
                                    </div>
                                    </form>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- customizer Panel -->
<#include "../common/layout.ftl">

<!-- All Jquery -->
<#include "../common/js.ftl">

</body>
</html>
