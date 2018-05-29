<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date" isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'login.jsp' starting page</title>
<link rel="stylesheet" href="${ path }/css/bootstrap.min.css">  
<script src="${ path }/js/jquery/2.1.1/jquery.min.js"></script>
<script src="${ path }/js/bootstrap.min.js"></script>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<div class="container" style="margin-top:50px;">
		<div class="col-sm-12" style="text-align:center;"><h2>登陆酒店住宿管理系统</h2></div>
		<form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/login" name="form1" method="post">
			<div class="form-group">
				<label class="col-sm-2 control-label">用户名：</label>
				<div class="col-sm-12">
					<input class="form-control" type="text" name="username">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">密码：</label>
				<div class="col-sm-12">
					<input class="form-control" type="password" name="password"></td>
				</div>
			</div>
			<input class="btn btn-primary col-sm-12" type="submit" value="登录">
		</form>
	</div>
</body>
</html>
