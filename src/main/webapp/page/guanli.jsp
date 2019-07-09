﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0050)http://localhost:8080/HouseRent/manage!list.action -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD>
<TITLE>青鸟租房 - 用户管理</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="../css/style.css">
  <script src="../index/js/jquery-1.8.3.js"></script>
  <script type="application/javascript">
      function do_delete(id){
          if(confirm("确认删除吗？")){
              location.href = "deleteHouse?id="+id;
          }
      }
  </script>
<META name=GENERATOR ></HEAD>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV>
<DIV class=search> 欢迎:${sessionScope.loginInfo.name}  <LABEL class="ui-green searchs"><a href="gofabu">发布房屋信息</a></LABEL>
<LABEL class=ui-green><INPUT onclick='location.href="index.jsp"' value="退       出" type=button name=search></LABEL>
</DIV></DIV>
<DIV class="main wrap">
<DIV id=houseArea>
<TABLE class=house-list>
  <TBODY>


       <c:forEach items="${pageInfo.list}" var="list">
         <TR>
           <TD class=house-thumb><SPAN><A href="details.jsp" target="_blank"><img src="http://localhost:80/${list.path}"
                                                                                  width="100" height="75"
                                                                                  alt=""></A></SPAN></TD>
           <TD>
             <DL>
               <DT><A href="details.jsp" target="_blank">${list.title}</A></DT>
               <DD>${list.street.district.name}区域的${list.street.name}<BR>联系方式：${list.contact} </DD>
             </DL>
           </TD>
           <TD class=house-type><LABEL class=ui-green><INPUT onclick="location.href='updateHouse?id=${list.id}'" value="修    改" type=button name=search></LABEL>
           </TD>
           <TD class=house-price><LABEL class=ui-green><INPUT onclick="do_delete(${list.id})" value="删    除" type=button name=search></LABEL></TD>
         </TR>
       </c:forEach>


    </TBODY>
</TABLE></DIV>
<DIV class=pager>
<UL>
  <c:forEach begin="1" end="${pageInfo.pages}" step="1" var="i">
    <LI class=current><A id=widget_338868862
                         href="zhuye?page=${i}"
                         parseContent="true" showError="true" targets="houseArea"
                         ajaxAfterValidation="false" validate="false"
                         dojoType="struts:BindAnchor">${i}</A>
    </LI>
  </c:forEach></UL><SPAN class=total>${pageInfo.pageNum}/${pageInfo.pages}页</SPAN> </DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
