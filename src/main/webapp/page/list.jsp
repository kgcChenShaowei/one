<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0030)http://localhost:8080/House-2/ -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 - 首页</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<LINK rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<script src="../index/js/jquery-1.8.3.js"></script>
<script type="application/javascript">
    $(function () {
        $("#districtId").change(function () {
            var did=$(this).val();
            $.post("gostreet",{"id":did},function (data) {
                $("#streetId>option:gt(0)").remove();
                for(var i=0;i<data.length;i++){
                    //使用$()工厂函数创建标签
                    var node=$("<option value="+data[i].id+">"+data[i].name+"</option>");
                    //将创建的标签添加下拉列表
                    $("#streetId").append(node);
                }
            },"json")
        })
    })
    function do_page() {
        
    }
</script>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV></DIV>
<DIV id=navbar class=wrap>
<DL class="search clearfix">
  <FORM id=sform method=post action=  >
    <DT>
      <UL>
        <LI class=bold>房屋信息</LI>
        <LI>标题：<INPUT class=text type=text name=title>


          <LABEL class=ui-blue><INPUT onclick=doSearch() value=搜索房屋 type=button name=search></LABEL>
        </LI>
      </UL>
    </DT>

    <DD>
      <UL>
        <LI class=first>房屋位置</LI>
        <LI>区：<SELECT class=text id="districtId" name=districtId>
          <OPTION selected="selected" value=0>-请选择-</OPTION>
          <c:forEach items="${districtList}" var="district">
            <OPTION value=${district.id}>${district.name}</OPTION>
          </c:forEach>
        </SELECT>
          街：<SELECT class=text id="streetId" name=streetId>
                <OPTION selected value=0>-请选择-</OPTION>
              </SELECT></LI>
      </UL>
    </DD>
    <DD>
      <UL>
        <LI class=first>房屋类型</LI>
        <LI>
          <SELECT class=text name=typeId>
            <OPTION selected="selected" value=0>-请选择-</OPTION>
            <c:forEach items="${typeList}" var="type">
              <OPTION value=${type.id}>${type.name}</OPTION>
            </c:forEach>
          </SELECT></LI>
      </UL>
    </DD>
  </FORM>
</DL>
</DIV>
<DIV class="main wrap">
  <TABLE class=house-list>
    <TBODY>
    <c:if test="${allHouse!=null}">
      <c:forEach items="${allHouse}" var="list">
        <TR>
          <TD class=house-thumb><span><A href="details.jsp" target="_blank"><img src="http://localhost:80/${list.path}"
                                                                                 width="100" height="75"
                                                                                 alt=""></a></span></TD>
          <TD>
            <DL>
              <DT><A href="details.jsp" target="_blank">${list.title}</A></DT>
              <DD>${list.street.district.name}区域的${list.street.name}<BR>联系方式：${list.contact} </DD>
          <TD class=house-type>${list.type.name}</TD>
          <TD class=house-price><SPAN>${list.price}</SPAN>元/月</TD>
        </TR>

      </c:forEach>
    </c:if>

  <TR>无租房信息</TR></TBODY></TABLE>
<DIV class=pager>
<UL>
  <LI class=current><A href="#">首页</A></LI>
  <LI><A href="javascript:do_page()">上一页</A></LI>
  <LI><A href="#">下一页</A></LI>
  <LI><A href="#">末页</A></LI></UL><SPAN 
class=total>1/2页</SPAN> </DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
