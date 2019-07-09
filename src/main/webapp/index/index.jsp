<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<table id="dg" style="width:600px;height:300px">
    <div id="tb">
        <a href="javascript:Add()" class="easyui-linkbutton"
           iconCls="icon-add" plain="true">添加</a> <a
            href="javascript:ModifyBySelect()" class="easyui-linkbutton"
            iconCls="icon-edit" plain="true">修改</a> <a
            href="javascript:DeleteByFruitName()" class="easyui-linkbutton"
            iconCls="icon-remove" plain="true">删除</a>
    </div>
</table>
<div id="AddDialog" class="easyui-dialog" buttons="#AddDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form id="ModiyDialogForm" method="post">
        <table>
            <tr>
            <td>编号:</td>
            <td><input type="text" class="easyui-validatebox"
                       name="id" id="id" />
            </td>
        </tr>
            <tr>
                <td>用户:</td>
                <td><input id="c1" type="text" class="easyui-validatebox"
                           name="userId" id="userId" />
                </td>
            </tr>
            <tr>
                <td>类型:</td>
                <td><input id="c2" type="text" class="easyui-validatebox"
                           name="typeId" id="typeId"/></td>
            </tr>
            <tr>
                <td>标题:</td>
                <td><input type="text" class="easyui-validatebox"
                           name="title" id="title" /></td>
            </tr>
            <tr>
                <td>描述:</td>
                <td><input type="text" class="easyui-validatebox"
                           name="description" id="description" /></td>
            </tr>
            <tr>
                <td>价格:</td>
                <td><input type="text" class="easyui-validatebox"
                           name="price" id="price" /></td>
            </tr>
            <tr>
                <td>日期:</td>
                <td><input type="date" class="easyui-validatebox"
                           name="pubdate" id="pubdate" /></td>
            </tr>
            <tr>
                <td>面积:</td>
                <td><input type="text" class="easyui-validatebox"
                           name="floorage" id="floorage" /></td>
            </tr>
            <tr>
                <td>联系方式:</td>
                <td><input type="text" class="easyui-validatebox"
                           name="contact" id="contact"/>
                    </td>
            </tr>
            <tr>
                <td>是否审核通过:</td>
                <td><input type="radio" class="easyui-validatebox" readonly
                           name="ispass" id="ispass" value="0" aria-selected="true"/>否
                    <input type="radio" class="easyui-validatebox" readonly
                           name="ispass" id="ispass" value="1"/>是</td>
            </tr>
            <tr>
                <td>是否删除:</td>
                <td><input type="radio" class="easyui-validatebox" readonly
                           name="isdel" id="isdel" value="0"/>否
                    <input type="radio" class="easyui-validatebox" readonly
                           name="isdel" id="isdel" value="1"/>是</td>
            </tr>
            <tr>
                <td>街道:</td>
                <td><input id="c3" type="text" class="easyui-validatebox"
                           name="streetId" id="streetId"/></td>
            </tr>
            <tr>
                <td>图片:</td>
                <td><input type="text" class="easyui-validatebox"
                           name="path" id="path"/></td>
            </tr>
        </table>
    </form>
</div>
<div id="AddDialogButtons">
    <a href="javascript:SaveDialog1()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a>
    <a href="javascript:CloseDialog1()" class="easyui-linkbutton"
       iconCls="icon-cancel">取消</a>
</div>
<div id="upDialog" class="easyui-dialog" buttons="#AddDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form id="ModiyDialogForm1" method="post">
        <table>
            <tr>
                <td>编号:</td>
                <td><input type="text" class="easyui-validatebox"
                           name="id" id="id" />
                </td>
            </tr>
            <tr>
                <td>用户:</td>
                <td><input id="c1" type="text" class="easyui-validatebox"
                           name="userId" id="userId" />
                </td>
            </tr>
            <tr>
                <td>类型:</td>
                <td><input id="c2" type="text" class="easyui-validatebox"
                           name="typeId" id="typeId"/></td>
            </tr>
            <tr>
                <td>标题:</td>
                <td><input type="text" class="easyui-validatebox"
                           name="title" id="title" /></td>
            </tr>
            <tr>
                <td>描述:</td>
                <td><input type="text" class="easyui-validatebox"
                           name="description" id="description" /></td>
            </tr>
            <tr>
                <td>价格:</td>
                <td><input type="text" class="easyui-validatebox"
                           name="price" id="price" /></td>
            </tr>
            <tr>
                <td>日期:</td>
                <td><input type="date" class="easyui-validatebox"
                           name="pubdate" id="pubdate" /></td>
            </tr>
            <tr>
                <td>面积:</td>
                <td><input type="text" class="easyui-validatebox"
                           name="floorage" id="floorage" /></td>
            </tr>
            <tr>
                <td>联系方式:</td>
                <td><input type="text" class="easyui-validatebox"
                           name="contact" id="contact"/>
                </td>
            </tr>
            <tr>
                <td>是否审核通过:</td>
                <td><input type="radio" class="easyui-validatebox" readonly
                           name="ispass" id="ispass" value="0" aria-selected="true"/>否
                    <input type="radio" class="easyui-validatebox" readonly
                           name="ispass" id="ispass" value="1"/>是</td>
            </tr>
            <tr>
                <td>是否删除:</td>
                <td><input type="radio" class="easyui-validatebox" readonly
                           name="isdel" id="isdel" value="0"/>否
                    <input type="radio" class="easyui-validatebox" readonly
                           name="isdel" id="isdel" value="1"/>是</td>
            </tr>
            <tr>
                <td>街道:</td>
                <td><input id="c3" type="text" class="easyui-validatebox"
                           name="streetId" id="streetId"/></td>
            </tr>
            <tr>
                <td>图片:</td>
                <td><input type="text" class="easyui-validatebox"
                           name="path" id="path"/></td>
            </tr>
        </table>
    </form>
</div>
<div id="upDialogButtons">
    <a href="javascript:SaveDialog2()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a>
    <a href="javascript:CloseDialog2()" class="easyui-linkbutton"
       iconCls="icon-cancel">取消</a>
</div>

</body>
<link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
<link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
<script src="js/jquery-1.8.3.js"></script>
<!--jquery.easyui.min.js包含了easyUI中的所有插件-->
<script src="js/jquery.easyui.min.js"></script>
<script type="application/javascript" src="js/index.js">
</script>
</html>

