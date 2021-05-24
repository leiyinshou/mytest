<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
    String path = request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
    <base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>tt</title>
    <link rel="stylesheet" href="static/layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="static/css/back/zhao-layui.css" />
    <link rel="shortcut icon" href="favicon.ico" />
</head>
<body>

<%--display:none ---不为被隐藏的对象保留其物理空间，即该对象在页面上彻底消失，通俗来说就是看不见也摸不到。--%>
<div id="saveDiv" >
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>销售</legend>
    </fieldset>
    <form class="layui-form" action="" id="saveForm">
        <input type="hidden" name =userid value="${pageContext.session.getAttribute("loginUser").id}" >
        <div class="layui-form-item">
            <label class="layui-form-label">商品名称</label>
            <div class="layui-input-inline">
                <select name="productid" id="saveType" lay-verify="required"></select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">销售单价</label>
            <div class="layui-input-inline">
                <input type="text" name="price" lay-verify="required|number" placeholder="请输入销售单价" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">销售数量</label>
            <div class="layui-input-inline">
                <input type="text" name="quantity" lay-verify="required|number" placeholder="请输入销售数量" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <%--lay-filter事件过滤器，主要用于事件的精确匹配，跟选择器是比较类似的。其实它并不私属于form模块，它在 layui 的很多基于事件的接口中都会应用到。
                    lay-submit绑定触发提交的元素，如button--%>
                <button class="layui-btn" lay-submit lay-filter="formDemo">添加</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>


    </form>
</div>

</body>
<script src="static/layui/layui.js"></script>
<script src="static/js/saveSale.js"></script>
</html>
