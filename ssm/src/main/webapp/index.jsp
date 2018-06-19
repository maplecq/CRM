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
<title>Insert title here</title>
</head>
<body>
	<a href="teacher/test?id=1">teacher/test?id=1</a>
	<br />
	<a href="teacher/showTeacher?id=69">teacher/showTeacher?id=69</a>
	<br />
	<a href="teacher/showTeacher2?id=69">teacher/showTeacher2?id=69</a>
	<br />
	<a href="teacher/showTeacher3/69">teacher/showTeacher3/69</a>
	<br />
	<a href="teacher/showAll">显示所有</a>
</body>
</html>