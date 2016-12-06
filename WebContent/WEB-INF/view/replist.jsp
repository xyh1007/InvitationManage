<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>回复信息界面</title>
</head>
<body>
<center>
<h1>回复信息列表</h1>
<table border="1"> 
<tr><td colspan="3" align="right"><a href="addrep?id=${id}">添加回复</a>&nbsp;&nbsp;<a href="invlist">返回帖子列表</a></td></tr> 
<tr bgcolor="#00BFFF">
 <th>回复内容</th> 
 <th>回复昵称</th>  
 <th>发布时间</th>  
</tr>
<c:choose>
<c:when test="${replist.size()==0}">
<tr><td colspan="6" align="center">没有相关信息</td></tr>
</c:when>
<c:otherwise>
<c:forEach items="${replist}" var="item" varStatus="status">  
<tr 
   <c:if test="${status.count%2==0}">bgcolor="#87CEEB"</c:if>
  >
    <td >${item.content}</td>  
    <td>${item.author}</td>  
    <td>${item.createdate}</td> 
  </tr>  
</c:forEach> 
</c:otherwise>
</c:choose>
</table>
</center>
</body>
</html>