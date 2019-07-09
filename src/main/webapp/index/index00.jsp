<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<table id="dg" style="width:600px;height:300px">
</table>
<div id="tb">
    <a href="javascript:Add()" class="easyui-linkbutton"
       iconCls="icon-add" plain="true">添加</a> <a
        href="javascript:ModifyBySelect()" class="easyui-linkbutton"
        iconCls="icon-edit" plain="true">修改</a> <a
        href="javascript:DeleteByFruitName()" class="easyui-linkbutton"
        iconCls="icon-remove" plain="true">批量删除</a>
    <div>名称:<input type="text" name="name">
        电话:<input type="text" name="telephone">
        <a
                href="javascript:search()" class="easyui-linkbutton"
                iconCls="icon-search" plain="true">搜索</a>
    </div>
</div>
<div id="AddDialog" class="easyui-dialog" buttons="#AddDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form id="ModiyDialogForm" method="post">
        <table>
            <tr>
                <td>用户名称:</td>
                <td><input type="text" class="easyui-validatebox"
                           name="name" id="name"></td>
            </tr>
            <tr>
                <td>用户密码:</td>
                <td><input type="text" class="easyui-validatebox"
                           name="password" id="password"></td>
            </tr>
            <tr>
                <td>用户联系方式:</td>
                <td><input type="text" class="easyui-validatebox"
                           name="telephone" id="telephone"></td>
            </tr>
            <tr>
                <td>用户地址:</td>
                <td><input type="text" class="easyui-validatebox"
                           name="isadmin" id="isadmin"></td>
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

<div id="updateDialog" class="easyui-dialog" buttons="#updateDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form id="ModiyDialogForm1" method="post">
        <table>
            <tr>
                <td>用户编号:</td>
                <td><input type="text" class="easyui-validatebox" readonly
                           name="id" id="id"></td>
            </tr>
            <tr>
                <td>用户名称:</td>
                <td><input type="text" class="easyui-validatebox"
                           name="name" id="name"></td>
            </tr>
            <tr>
                <td>用户密码:</td>
                <td><input type="text" class="easyui-validatebox"
                           name="password" id="password"></td>
            </tr>
            <tr>
                <td>用户联系方式:</td>
                <td><input type="text" class="easyui-validatebox"
                           name="telephone" id="telephone"></td>
            </tr>
            <tr>
                <td>用户地址:</td>
                <td><input type="text" class="easyui-validatebox"
                           name="isadmin" id="isadmin"></td>
            </tr>
        </table>
        </table>
    </form>
</div>
<div id="updateDialogButtons">
    <a href="javascript:SaveDialog2()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a>
    <a href="javascript:CloseDialog()" class="easyui-linkbutton"
       iconCls="icon-cancel">取消</a>
</div>
</body>
<link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
<link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
<script src="js/jquery-1.8.3.js"></script>
<!--jquery.easyui.min.js包含了easyUI中的所有插件-->
<script src="js/jquery.easyui.min.js"></script>
<script type="application/javascript" src="js/index00.js">
</script>
</html>
