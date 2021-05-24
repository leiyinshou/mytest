layui.use(['jquery','layer', 'table','form','upload','element'], function() {
    var $ = layui.jquery    //引入jquery模块
        , layer = layui.layer  //引用layer弹出层模块
        , table = layui.table  //引用table数据表格模块
        , form = layui.form  //引用form表单模块
        , element=layui.element  //常用元素操作
        , upload = layui.upload;  //文件上传组件
    var currentPage = 1;

    loadSale()


    /*******自定义函数*********/

function loadSale() {
        table.render({
            elem: '#demo'  //表示跟表格容器的id进行绑定
            , height: 400 //表格容器的高度
            //  默认会自动传递两个参数：?page=1&limit=30  page 代表当前页码、limit 代表每页数据量
            , url: 'sale/loadPageByParams' //数据接口, 用来访问到后端控制器中，获取数据返回 （JSON数据）
            , page: true //开启分页
            , limits: [3, 5, 8, 10, 15] //自定义分页条数
            , limit: 3 //默认每页显示5条记录
            , even: true  //隔行变色效果
            //,where:JSONParams //传参
            , cols: [[ //表头
                /*
                      表示当前一列数据：
                 field : 字段， 跟返回的JSON对象的属性的名字完全一致！！！
                 title : 表示标题
                 width ： 列的宽度
                 sort ： 是否支持排序 true支持
                 fixed: 'left'  ： 向左悬浮
                 * */
                {type: 'checkbox'}
                , {field: 'id', title: 'ID', align: 'center', width: 100, sort: true}
                , {field: 'productname', title: '商品', align: 'center', width: 150, templet: '<div>{{d.product.productname}}</div>'}
                , {field: 'price', title: '单价', align: 'center', width: 100,sort: true}
                , {field: 'quantity', title: '数量', align: 'center', width: 100, sort: true}
                , {field: 'totalprice', title: '总价', align: 'center', width: 150, sort: true}
                , {field: 'saledate', title: '销售日期', align: 'center', width: 250, sort: true}
                , {field: 'realname', title: '销售员', align: 'center', width: 150, templet: '<div>{{d.users.realname}}</div>'}
            ]]
            , done: function (res, curr, count) {
                //得到当前页码
                console.log(curr);
                //给currentPage赋值
                currentPage = curr;
            }
        });
    }

});

