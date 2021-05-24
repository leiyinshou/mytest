layui.use(['jquery','layer', 'table','form','upload','element'], function() {
    var $ = layui.jquery    //引入jquery模块
        , layer = layui.layer  //引用layer弹出层模块
        , table = layui.table  //引用table数据表格模块
        , form = layui.form  //引用form表单模块
        , element=layui.element  //常用元素操作
        , upload = layui.upload;  //文件上传组件


    loadAllProduct();


    //添加提交监听
    form.on('submit(formDemo)',function (data) {
        var saveJson = data.field;
        console.log(saveJson);
        selProduct(saveJson);
        layer.closeAll();
        return false;
    })

//加载商品
    function loadAllProduct() {
        $.post(
            "product/loadAll",
            function (data) {
                console.log(data);
                var selectStr = `<option value="">-----请选择商品-----</option>`;
                $.each(data,function (i, product) {
                    selectStr += `<option value="${product.id}">${product.productname}</option>`
                })
                $("#saveType").html(selectStr);
                form.render("select") //渲染下拉框，不渲染显示不出来
            },"json"
        ).error(function (){
            layer.msg("服务器异常！！！",{icon: 3,time:2000,anim: 6,shade:0.5});
        })
    }

    function selProduct(saveJson) {
        $.post(
            "product/loadListTByParams", //请求的url路径
            saveJson, //传递到后端的参数，格式JSON
            function (data){
                var str = '';
                $.each(data,function (i,product) {
                    str+=product.productname+"的库存为："+product.quantity;
                })
                $("#sel").text(str)
            },"json" //text : 表示后端响应的是文本
        ).error(function (){
            lay.msg("数据异常！",{icon: 6,time:2000,anim: 3,shade:0.5});
        })
    }

});
