<%--
  Created by IntelliJ IDEA.
  User: 86158
  Date: 2019/6/25
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script src="js/jquery-1.8.3.js"></script>
    <!--jquery.easyui.min.js包含了easyUI中的所有插件-->
    <script src="js/jquery.easyui.min.js"></script>
</head>
<body>
<table id="data" title="信息" class="easyui-datagrid"
       url="gethouse" toolbar="#ToolBar" pagination="true"
       fitColumns="true" fit="true" rownumbers="true">
    <thead>
    <tr>
        <th field="cb" checkbox="true"></th>
        <th field="id" width="100px">编号</th>
        <th field="usersname" width="100px">用户</th>
        <th field="typename" width="100px">类型</th>
        <th field="title" width="100px">标题</th>
        <th field="description" width="100px">描述</th>
        <th field="price" width="100px">价格</th>
        <th field="pubdate" width="100px">日期</th>
        <th field="floorage" width="100px">面积</th>
        <th field="contact" width="100px">联系</th>
        <th field="streetname" width="100px">街道</th>
        <th field="ispass" width="100px">是否审核通过</th>
        <th field="isdel" width="100px">是否删除</th>
        <th field="path" width="100px">道路</th>
    </tr>
    </thead>
</table>

<div id="ToolBar">
    <div style="height: 40px;">
        <a href="javascript:Add()" class="easyui-linkbutton"
           iconCls="icon-add" plain="true">添加</a> <a
            href="javascript:ModifyBySelect()" class="easyui-linkbutton"
            iconCls="icon-edit" plain="true">修改</a> <a
            href="javascript:DeleteByFruitName()" class="easyui-linkbutton"
            iconCls="icon-remove" plain="true">删除</a>
    </div>
</div>

<div id="AddDialog" class="easyui-dialog" buttons="#AddDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form id="ModiyDialogForm" method="post">
        <table>
            <tr>
                <td>学号:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="xh" id="bname" /></td>
            </tr>
            <tr>
                <td>姓名:</td>
                <td><input type="text" name="name" id="author" /></td>
            </tr>
            <tr>
                <td>性别:</td>
                <td><input type="text" name="sex" id="buytime"></td>
            </tr>
            <tr>
                <td>类别:</td>
                <td>
                    <input id="cc" class="easyui-combobox" name="dept"
                           data-options="valueField:'id',textField:'text',url:'get_data.php'" />
                </td>
            </tr>
        </table>
    </form>
</div>

<div id="AddDialogButtons">
    <a href="javascript:SaveDialog()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a>
    <a href="javascript:CloseDialog()" class="easyui-linkbutton"
       iconCls="icon-cancel">取消</a>
</div>

<script type="text/javascript" src="./js/MyEasyUICRUD.js"></script>
</body>

</html>
