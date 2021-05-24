<%--
Created by IntelliJ IDEA.
User: xiongyinwei
Date: 2021/5/24
Time: 10:13
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() +
            ":" + request.getServerPort() + path + "/";
%>
<head>
    <base href="<%=basePath%>"/>
    <meta name="viewport" content="width=device-width, initial-scale=1,
maximum-scale=1">
    <title>Title</title>
    <link rel="stylesheet" href="static/layui/css/layui.css">
    <style type="text/css">
        .layui-table td{
            height: 60px;
        }
        .layui-table td img{
            width:60px;
            height: 60px;
        }
    </style>
</head>
<body>
<%--显示标题--%>
<div>
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>销售信息查询</legend>
    </fieldset>
    <%--数据表格--%>
    <table id="demo" lay-filter="test"></table>
</div>

<!--引入layui的js文件-->
<script src="static/layui/layui.js"></script>
<script src="static/js/showSale.js"></script>

</body>
</html>