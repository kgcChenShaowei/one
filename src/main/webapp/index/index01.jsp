<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<table id="dg" style="width:600px;height:300px"></table>
<div id="tb">
    <a href="javascript:Add()" class="easyui-linkbutton"
       iconCls="icon-add" plain="true">添加</a> <a
        href="javascript:ModifyBySelect()" class="easyui-linkbutton"
        iconCls="icon-edit" plain="true">修改</a> <a
        href="javascript:DeleteByFruitName()" class="easyui-linkbutton"
        iconCls="icon-remove" plain="true">批量删除</a>
</div>

<div id="AddDialog" class="easyui-dialog" buttons="#AddDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form id="ModiyDialogForm" method="post">
        <table>
            <tr>
                <td>区域名称:</td>
                <td><input type="text" class="easyui-validatebox"
                           name="name" id="name"></td>
            </tr>
        </table>
    </form>
</div>
<div id="AddDialogButtons">
    <a href="javascript:SaveDialog()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a>
    <a href="javascript:CloseDialog1()" class="easyui-linkbutton"
       iconCls="icon-cancel">取消</a>
</div>

<div id="updateDialog" class="easyui-dialog" buttons="#updateDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form id="ModiyDialogForm1" method="post">
        <table>
            <tr>
                <td>区域编号:</td>
                <td><input type="text" class="easyui-validatebox" readonly
                           name="id" id="id"></td>
            </tr>
            <tr>
                <td>区域名称:</td>
                <td><input type="text" class="easyui-validatebox"
                           name="name" id="bname"></td>
            </tr>
        </table>
    </form>
</div>
<div id="updateDialogButtons">
    <a href="javascript:SaveDialog2()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a>
    <a href="javascript:CloseDialog2()" class="easyui-linkbutton"
       iconCls="icon-cancel">取消</a>
</div>

--------------------------------------------------

<div id="openShowSteetDialog" class="easyui-dialog" buttons="#upDialogButtons"
     style="width: 600px; height: 450px; padding: 10px 20px;" closed="true">
    <table id="dg2" style="width:600px;height:300px"></table>
    <div id="tb2">
        <a href="javascript:Add2()" class="easyui-linkbutton"
           iconCls="icon-add" plain="true">添加</a> <a
            href="javascript:ModifyBySelect2()" class="easyui-linkbutton"
            iconCls="icon-edit" plain="true">修改</a> <a
            href="javascript:DeleteByFruitName2()" class="easyui-linkbutton"
            iconCls="icon-remove" plain="true">批量删除</a>
    </div>

    <div id="AddDialog2" class="easyui-dialog" buttons="#AddDialogButtons2"
         style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
        <form id="ModiyDialogForm2" method="post">
            <table>
                    <tr>
                        <td>街道名称:</td>
                        <td><input type="text" class="easyui-validatebox"
                                   name="name" id="name"></td>
                    </tr>
            </table>
        </form>
    </div>
    <div id="AddDialogButtons2">
        <a href="javascript:S1()" class="easyui-linkbutton"
           iconCls="icon-ok">保存</a>
        <a href="javascript:C1()" class="easyui-linkbutton"
           iconCls="icon-cancel">取消</a>
    </div>

    <div id="updateDialog2" class="easyui-dialog" buttons="#updateDialogButtons2"
         style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
        <form id="ModiyDialogForm3" method="post">
            <table>
                <tr>
                    <td>街道编号:</td>
                    <td><input type="text" class="easyui-validatebox" readonly
                               name="id" id="id"></td>
                </tr>
                <tr>
                    <td>街道名称:</td>
                    <td><input type="text" class="easyui-validatebox"
                               name="name" id="name"></td>
                </tr>
            </table>
        </form>
    </div>
    <div id="updateDialogButtons2">
        <a href="javascript:SaveDialog2()" class="easyui-linkbutton"
           iconCls="icon-ok">保存</a>
        <a href="javascript:CloseDialog()" class="easyui-linkbutton"
           iconCls="icon-cancel">取消</a>
    </div>
</div>
<div id="upDialogButtons">
    <a href="javascript:S()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a>
    <a href="javascript:C()" class="easyui-linkbutton"
       iconCls="icon-cancel">取消</a>
</div>


</body>
<link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
<link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
<script src="js/jquery-1.8.3.js"></script>
<!--jquery.easyui.min.js包含了easyUI中的所有插件-->
<script src="js/jquery.easyui.min.js"></script>
<script type="application/javascript" src="js/index01.js">
</script>
</html>
