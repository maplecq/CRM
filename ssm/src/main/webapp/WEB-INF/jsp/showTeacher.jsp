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
<title>showTeacher</title>
</head>
<body>
	<h3>showTeacher</h3>
	<table border="1">
		<tr>
			<td>${teacher.tname}</td>
			<td>${teacher.tid}</td>
			<td>${teacher.taddress}</td>
		</tr>
	</table>
</body>
</html>