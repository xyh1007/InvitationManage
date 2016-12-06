<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加回复界面</title>
<script type="text/javascript">
function tijiao(){
	if(document.addrep.content.value==null||document.addrep.content.value==''){
		alert("添加回复失败");
		location.href="replist?id=${id}";
	}else{
		if(document.addrep.author.value==null||document.addrep.author.value==''){
			document.addrep.author.value='匿名用户';
		}
		alert("添加成功");
		document.addrep.submit();
	}
}
function back(){
	location.href="replist?id=${id}";
}
</script>
</head>
<body>
<form action="/InvitationManage/addrep" method="post" name="addrep">
<table border="1">
<tr><td bgcolor="#00BBFF">添加回复</td></tr> 
<tr><td>回复内容：<textarea rows="3" cols="20" name="content"></textarea></td></tr> 
<tr><td>回复昵称：<input type="text" name="author"/></td></tr> 
<tr><td><input type="button" value="提交" onclick="tijiao()"/>&nbsp;&nbsp;<input type="button" value="返回" onclick="back()"/></td></tr> 
</table>
<input type="hidden" name="id" value="${id}"/>
</form>
</body>
</html>