$(function () {
    //下拉列表
    $('#cc').combobox({
        url:'getDistrict2',
        valueField:'id',
        textField:'name'
    });
    $('#c2').combobox({
        url:'getDistrict2',
        valueField:'id',
        textField:'name'
    });
    //分页
    $('#dg').datagrid({
        toolbar: '#tb',
        title: "街道管理",
        url: 'getStreet',
        pagination: true,
        pageList: [3, 5, 8, 10, 15],
        pageSize: 10,
        fitColumns: true,
        fit: true,
        pagination: true,
        columns: [[
            {field: 'cb', checkbox:"true", align: 'right'},
            {field: 'id', title: '街道编号', width: 100, align: 'right'},
            {field: 'name', title: '街道名称', width: 100, align: 'right'},
            {field: 'district', title: '区域编号', width: 100, align: 'right',
                formatter: function (value, row, index) {
                    var data = value.name;
                    return data;
                }},
            {field: 'x', title: '操作', width: 100, align: 'right',
                formatter: function (value, row, index) {
                    var data = row.id;
                    return "<a href=\"javascript:DeleteById( "+data+" )\" class=\"easyui-linkbutton\"\n" +
                        "       iconCls=\"icon-ok\">删除</a>";
                }}
        ]]
    });
})
//添加页面
function Add() {
    $("#AddDialog").dialog("open").dialog("setTitle","添加区域")
}
//添加保存按钮
function SaveDialog(){
    $("#ModiyDialogForm").form("submit",{
        url:'addStreet',
        success:function (data) {
            //将字符串转换为JSON对象
            data=$.parseJSON(data);
            if(data.result==1){
                $("#AddDialog").dialog("close");
                $.messager.alert("系统提示","添加成功！","info");
                $("#dg").datagrid('reload');
            }else{
                $.messager.alert("系统提示","添加失败！","info");
            }
        }
    })
}
//添加取消按钮
function CloseDialog1(){
    $("#AddDialog").dialog("close");
    $("#dg").datagrid('reload');
}
//修改页面
function ModifyBySelect(){
    //获取datagrid选中行  返回的数组
    var SelectRows = $("#dg").datagrid('getSelections');
    if(SelectRows.length!=1){
        $.messager.alert('提示框','你还没有选中行，或者选择了多行.','info');
        return;
    }
    //打开窗口
    $("#updateDialog").dialog("open").dialog("setTitle","修改区域");

    //2.通过主键从数据库查询单条对象进行回显(当datagrid的行数据无法满足表单显示时)
    //发送异步请求获取对象进行回显
    var row=SelectRows[0];
    $.post("upStreet",{"id":row.id},function(data){
        //回显
        $('#ModiyDialogForm1').form('load',data);
    },"json");
}
//修改保存按钮
function SaveDialog2(){
    $("#ModiyDialogForm1").form("submit",{
        url:'updateStreet',
        success:function (data) {
            //将字符串转换为JSON对象
            data=$.parseJSON(data);
            if(data.result==1){
                $("#AddDialog").dialog("close");
                $.messager.alert("系统提示","修改成功！","info");
                $("#dg").datagrid('reload');
            }else{
                $.messager.alert("系统提示","修改失败！","info");
            }
        }
    })
}
//修改取消按钮
function CloseDialog2(){
    $("#updateDialog").dialog("close");
    $("#dg").datagrid('reload');
}
//单条删除
function DeleteById(obj){
    $.messager.confirm("系统提示","你要把我删掉吗！",
        function (r) {
            if(r){
                $.post("",{"id":obj},function (data) {
                    if(data.result==1){
                        $("#dg").datagrid('reload');
                    }else{
                        $.messager.alert("系统提示","删除失败！","info");
                    }
                },"json");
            }else{
                $.messager.alert('提示框','想好再点，可以吗！^_^','info');
            }
        })
}
//批量删除
function DeleteByFruitName(){
    //获取选中行
    var SelectRows = $("#dg").datagrid('getSelections');
    if(SelectRows.length==0){
        $.messager.alert('提示框','你还没有选中行^_^','info');
        return;
    }
    //确认删除
    $.messager.confirm('提示框', '你真的想把我删除掉吗？我不能离开你',function(flag){
        if(flag){  //为true实现删除
            // 调用服务器接口进行删除
            //获取选中项的值
            var value="";
            for(var i=0;i<SelectRows.length;i++){
                value=value+SelectRows[i].id+",";
            }
            value=value.substring(0,value.length-1);  //去除最后的逗号

            //发送异步请求到服务器
            $.post("",{"id":value},function(data){
                if(data.result>0){
                    //实现datagrid的刷新
                    $('#dg').datagrid('reload');
                }else{
                    $.messager.alert('提示框','删除失败！^_^','info');
                }
            },"json");
        }
    });
}