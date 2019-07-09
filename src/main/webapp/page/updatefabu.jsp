<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0044)http://localhost:8080/HouseRent/page/add.jsp -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 -发布房屋信息</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<script src="../index/js/jquery-1.8.3.js"></script>
<script type="application/javascript">
  $(function () {
      $.post("goType",null,function (data) {
          for(var i=0;i<data.length;i++){
              var node=$("<OPTION  value="+data[i].id+">"+data[i].name+"</OPTION>");
              $("#typeId").append(node);
          }
          $("#typeId").val(${house.type.id});
      },"json");
      $.post("goDistrict",null,function (data) {
          for(var i=0;i<data.length;i++){
              var node=$("<OPTION  value="+data[i].id+">"+data[i].name+"</OPTION>");
              $("#districtId").append(node);
          }
          $("#districtId").val(${house.street.districtId});
          loadStreet( $("#districtId").val());
      },"json");

      $("#districtId").change(function(){
          loadStreet($(this).val());  //重新加载街道
      });
  })
      function loadStreet(did) {
              $.post("gostreet",{"id":did},function (data) {
                  $("#streetId>option:gt(0)").remove();
                  for(var i=0;i<data.length;i++){
                      //使用$()工厂函数创建标签
                      var node=$("<option value="+data[i].id+">"+data[i].name+"</option>");
                      //将创建的标签添加下拉列表
                      $("#streetId").append(node);
                  }
                  $("#streetId").val(${house.street.id});

              },"json")
      }
</script>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV></DIV>
<DIV id=regLogin class=wrap>
<DIV class=dialog>
<DL class=clearfix>
  <DT>新房屋信息发布</DT>
  <DD class=past>填写房屋信息</DD></DL>
<DIV class=box>

<FORM id=add_action method=post name=add.action enctype="multipart/form-data"
action=updateHouse2>
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>
    <TD class=field>标　　题：</TD>
    <TD><INPUT id=add_action_title class=text type=text name=title value="${house.title}">
        <INPUT class=text type=hidden name=id value="${house.id}"></TD></TR>
  <TR>
    <TD class=field>户　　型：</TD>
    <TD><SELECT id="typeId" class=text name=typeId>
      <OPTION selected="selected" value=0>-请选择-</OPTION>
    </SELECT></TD>
  </TR>
  <TR>
    <TD class=field>面　　积：</TD>
    <TD><INPUT id=add_action_floorage class=text type=text name=floorage value="${house.floorage}"></TD></TR>
  <TR>
    <TD class=field>价　　格：</TD>
    <TD><INPUT id=add_action_price class=text type=text name=price value="${house.price}"> </TD></TR>
  <TR>
    <TD class=field>发布日期：</TD>
    <TD><INPUT class=text type=date name=pubdate value="<fmt:formatDate value="${house.pubdate}" pattern="yyyy-MM-dd"></fmt:formatDate>" ></TD></TR>
  <TR>
    <TD class=field>位　　置：</TD>
    <TD>区：<SELECT class=text id="districtId" name=districtId>
      <OPTION selected="selected" value=0 >-请选择-</OPTION>
      </SELECT>
      街：<SELECT class=text id="streetId" name=streetId>
        <OPTION selected value=0>-请选择-</OPTION>
       </SELECT>
    </TD></TR><!--
						<tr>
							<td class="field">坐  标：</td>
							<td><input type="text" class="text" name="point" />
							</td>
						</tr>
						--><!--  <tr>
							<td class="field">Y 坐  标：</td>
							<td><input type="text" class="text" name="point.y" /></td>
						</tr>-->
  <TR>
    <TD class=field>联系方式：</TD>
    <TD><INPUT id=add_action_contact class=text type=text name=contact value="${house.contact}"> </TD></TR>
  <TR>
    <TD class=field>房间照片：</TD>
    <TD><INPUT id=ssss class=text type=file name=pfile>
      <input type="hidden" value="${house.path}" name="oldPath">
      <img src="http://localhost:80/${house.path}" width="100" height="75" alt=""></TD></TR>
  <TR>
    <TD class=field>详细信息：</TD>
    <TD><TEXTAREA name=description>${house.title}</TEXTAREA></TD></TR></TBODY></TABLE>
<DIV class=buttons><INPUT value=立即发布 type=submit>
</DIV></DIV></FORM></DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
