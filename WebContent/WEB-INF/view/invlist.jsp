<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>帖子列表界面</title>
<script type="text/javascript">
var totalPage = ${totalPage};
var currentPage=${currentPage};
function first(){
	document.queryform.deldisplay.value = '0';
	if(currentPage==1){
		alert("当前已经是第一页了");
	}else{
		currentPage=1;
		document.queryform.currentPage.value = currentPage;
		document.queryform.submit();
	}
}
function pre(){
	document.queryform.deldisplay.value = '0';
	if(currentPage==1){
		alert("当前已经是第一页了");
	}else{
		currentPage--;
		document.queryform.currentPage.value = currentPage;
		document.queryform.submit();
	}
}
function next(){
	document.queryform.deldisplay.value = '0';
	if(currentPage==totalPage){
		alert("当前已经是最后页了");
	}else{
		currentPage++;
		document.queryform.currentPage.value = currentPage;
		document.queryform.submit();
	}
}
function last(){
	document.queryform.deldisplay.value = '0';
	if(currentPage==totalPage){
		alert("当前已经是最后页了");
	}else{
		currentPage = totalPage;
		document.queryform.currentPage.value = currentPage;
		document.queryform.submit();
	}
}
function delet(id){
	if(confirm("确认删除该条发帖及相关服务？")){
		document.queryform.delflag.value = '1';
		document.queryform.deldisplay.value = '1';
		document.queryform.id.value = id;
		document.queryform.submit();
	}
}
function search(){
	document.queryform.deldisplay.value = '0';
	document.queryform.submit();
}
</script>
</head>
<body>
<center>
<h1>帖子列表</h1>
<form action="invlist" name="queryform" method="post">
帖子标题：<input type="text" name="title" value="${title}"/>
<input type="button" value="搜索" onclick="search()"/>
<input type="hidden" name="currentPage" value="${currentPage}"/>
<input type="hidden" name="totalPage" value="${totalPage}"/>
<input type="hidden" name="delflag" value="${delflag}"/>
<input type="hidden" name="id" value="${id}"/>
<input type="hidden" name="deldisplay" value="${deldisplay}"/>
</form>
<table border="1"> 
<tr bgcolor="#00BBFF">
 <th>标题</th> 
 <th>内容摘要</th>  
 <th>作者</th>  
 <th>发布时间</th>  
 <th>操作</th> 
</tr>
<c:choose>
<c:when test="${invlist.size()==0}">
<tr><td colspan="6" align="center">没有相关信息</td></tr>
</c:when>
<c:otherwise>
<c:forEach items="${invlist}" var="item" varStatus="status">  
<tr 
   <c:if test="${status.count%2==0}">bgcolor="#33FFFF"</c:if>
  >
    <td >${item.title}</td>  
    <td>${item.summary}</td>  
    <td>${item.author}</td>  
    <td>${item.createdate}</td> 
    <td><a href="replist?id=${item.id}">查看回复</a>&nbsp;&nbsp;<a href="javascript:void(0)" onclick="delet(${item.id})">删除</a></td> 
</tr>  
</c:forEach> 
</c:otherwise>
</c:choose>
</table>
<c:if test="${deldisplay==1}">
<a>删除成功!</a>
</c:if>
<br>
第 ${currentPage}/${totalPage}页&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" value="首页" onclick="first()">&nbsp;&nbsp;
<input type="button" value="上一页" onclick="pre()">&nbsp;&nbsp;
<input type="button" value="下一页" onclick="next()">&nbsp;&nbsp;
<input type="button" value="末页" onclick="last()">&nbsp;&nbsp;
</center>
</body>
</html>