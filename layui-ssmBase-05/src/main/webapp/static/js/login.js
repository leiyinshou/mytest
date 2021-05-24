layui.use(['jquery','layer','form'], function() {
    var $ = layui.jquery    //引入jquery模块
        , layer = layui.layer  //引用layer弹出层模块
        , form = layui.form  ;//引用form表单模块

    var verifyCheckIf = false;    //验证码判断条件

    form.on('submit(login)',function (data) {
        var yzm = $("#yzm").val();
        if (yzm.length == 5){
            verifyCheck(yzm);
        } else {
            layer.tips('验证码格式错误！','#yzm', {tips: [2,'red'],time:2000,tipsMore: true});
        }
        if (verifyCheckIf){
            var loginJson = data.field;
            console.log(loginJson);
            loginUser(loginJson);
        }
        return false;
    });

    //判断是否被拦截转发到的登陆页面
    if($("#loginUIMsg").val()=="loginUIMsg"){  //是被拦截的
        layer.msg("对不起，请先登陆！！",{icon: 7,time:2000,anim: 6,shade:0.5});
    }



    //自定义函数

    //验证码验证
    function verifyCheck(yzm){
        $.ajaxSettings.async = false;
        $.post(
            "user/verifyCheck", //请求的url路径
            {"yzm":yzm}, //传递到后端的参数，格式JSON
            function (data){
                if(data === 'success'){
                    verifyCheckIf = true;
                    layer.tips('验证码验证正确。','#yzm', {tips: [2,'green'],time:2000,tipsMore: true});
                }else{
                    verifyCheckIf = false;
                    layer.tips('验证码验证错误！','#yzm', {tips: [2,'red'],time:2000,tipsMore: true});
                }
            },"text" //text : 表示后端响应的是文本
        ).error(function (){
            lay.msg("数据请求异常！",{icon: 6,time:2000,anim: 3,shade:0.5});
        })
    }

    function loginUser(loginJson){
        $.post(
            "user/loginUser", //请求的url路径
            loginJson, //传递到后端的参数，格式JSON
            function (data){
                if(data === 'success'){
                    setTimeout("window.location.href='model/toHome'",2000);
                    layer.msg("登陆成功！！",{icon: 1,time:2000,anim: 4,shade:0.5});
                }else{
                    layer.msg("登陆失败！！用户名或密码错误",{icon: 2,time:2000,anim: 3,shade:0.5});
                }
            },"text" //text : 表示后端响应的是文本
        ).error(function () {
            lay.msg("数据请求异常！", {icon: 6, time: 2000, anim: 3, shade: 0.5});
        })
    }


    //自定义表单验证
    form.verify({
        userName: function(value, item){ //value：表单的值、item：表单的DOM对象
            if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
                return '用户名不能有特殊字符';
            }
            if(/(^\_)|(\__)|(\_+$)/.test(value)){
                return '用户名首尾不能出现下划线\'_\'';
            }
            if(/^\d+\d+\d$/.test(value)){
                return '用户名不能全为数字';
            }
            if(value.length<3||value.length>12){
                return '用户名长度为3-12位';
            }
        }
        //我们既支持上述函数式的方式，也支持下述数组的形式
        //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
        ,pwd: [/^[\S]{3,12}$/,'密码必须6到12位，且不能出现空格']
    });


})