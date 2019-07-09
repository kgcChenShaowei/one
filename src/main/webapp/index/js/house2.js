$(function () {
    $('#dg2').datagrid({
        title: "未审核房屋信息",
        url: 'getHouseNoPass',  //服务器地址
        pagination: true,  //启用分页
        //toolbar: '#ToolBar',  //工具栏
        //rownumbers: true,  //显示行号
        //singleSelect:true,  //实现单行选择
        pageList: [3, 6, 9, 15, 20], //设置每页大小
        pageSize: 3, //每页三条
        fitColumns: true,
        fit: true,
        singleSelect: true,
        columns: [[
            {field: 'cb', checkbox: "true", align: 'right'},
            {field: 'id', title: '编号', width: 100, align: 'right'},
            {
                field: 'type', title: '类型', width: 100, align: 'right',
                formatter: function (value, row, index) {
                    var data = value.name;
                    return data;
                }
            },
            {field: 'title', title: '标题', width: 100, align: 'right'},
            {field: 'description', title: '描述', width: 100, align: 'right'},
            {field: 'price', title: '价格', width: 100, align: 'right'},
            {
                field: 'pubdate', title: '日期', width: 100, align: 'right',
                formatter: function (value, row, index) {
                    var data = new Date(value);
                    var year = data.getFullYear();
                    var month = data.getMonth() + 1;
                    var day = data.getDay();
                    return year + "年" + month + "月" + day + "日";
                }
            },
            {field: 'floorage', title: '面积', width: 100, align: 'right'},
            {field: 'contact', title: '联系', width: 100, align: 'right'},
            {
                field: 'street', title: '街道', width: 100, align: 'right',
                formatter: function (value, row, index) {
                    var data = value.name;
                    return data;
                }
            },
            {field: 'path', title: '道路', width: 100, align: 'right'},
            {
                field: 'opt', title: '操作', width: 100, align: 'left',
                formatter: function (value, row, index) {
                    //发送同步请求
                    // return "<a href=\"delDistrict?id="+row.id+"\" class=\"easyui-linkbutton\" iconCls=\"icon-ok\">删除</a>";
                    //发送异步请求Ajax
                    return "<a href=\"javascript:passHouse(" + row.id + ")\" class=\"easyui-linkbutton\" iconCls=\"icon-ok\">审核</a>";

                }
            }
        ]]
    });
})
/*审核出租房*/
function passHouse(id){
    //发送异步请求到服务器
    $.post("houseYes",{"id":id},function(data){
        if(data.result>0) {
            $("#dg2").datagrid("reload"); //刷新
        }else{
            $.messager.alert('提示框','审核失败！^_^','info');
        }
    },"json");
}