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
<title>index</title>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/json2.js"></script>

</head>
<body>
	<h3>index</h3>
	<table>
		<tr>
			<td>${teacher.tid}</td>
			<td>${teacher.tname}</td>
			<td>${teacher.taddress}</td>
		</tr>
	</table>

	<table border="1">
		<tr>
			<td>编号</td>
			<td>姓名</td>
			<td>地址</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${tlist}" var="teacher">
			<tr>
				<td>${teacher.tid}</td>
				<td>${teacher.tname}</td>
				<td>${teacher.taddress}</td>
				<td><a href="teacher/doadd">添加</a> <a href="teacher/dodel/${teacher.tid}">删除</a> <a href="teacher/doedit/${teacher.tid}">修改</a> 
				<a href="javascript:void(0)" onclick="show1(${teacher.tid})">详细</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<br />
	<br />
	<br />
	<table id="showdetails" border="1"></table>
	<script type="text/javascript">
		function show1(tid){
		//  ${pageContext.request.contextPath}  ===> http://localhost:8087/ssm
			$.ajax("${pageContext.request.contextPath}/teacher/testRequestBody",// 发送请求的URL字符串。
					{
						dataType : "json", // 预期服务器返回的数据类型。
						type : "post", //  请求方式 POST或GET
						contentType : "application/json", //  发送信息至服务器时的内容编码类型
						// 发送到服务器的数据。
						data : JSON.stringify({
							tid : tid,
							tname : "Spring MVC企业应用实战"
						}),
						async : true, // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
						// 请求成功后的回调函数。
						success : function(data) {
							  console.log(data);
							  $("#showdetails").html(""); //清空数据
								var tr = $("<tr align='center'/>");
								$("<td/>").html(data.tid).appendTo(tr);
								$("<td/>").html(data.tname).appendTo(tr);
								$("<td/>").html(data.taddress).appendTo(tr);
								$("#showdetails").append(tr);
						},
						// 请求出错时调用的函数
						error : function() {
							alert("数据发送失败");
						}
					});
		}
</script>
</body>
</html>