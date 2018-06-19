<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>添加页面</title>
</head>
<body>
	<h1>添加</h1>
	<form action="teacher/addPage" method="post">
		<table>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="tname"></td>
			</tr>
			<tr>
				<td>地址</td>
				<td><input type="text" name="taddress"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="添加" /></td>
			</tr>
		</table>
	</form>
</body>
</html>