<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date" isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${ path }/css/bootstrap.min.css">  
<script src="${ path }/js/jquery/2.1.1/jquery.min.js"></script>
<script src="${ path }/js/bootstrap.min.js"></script>
<title>住房历史信息</title>
</head>
<body>
<div class="container" style="margin-top:50px;">
	<form class="form-horizontal" action="${pageContext.request.contextPath}/zhuhistory/bycid">
		<div class="col-sm-2" style="display:inline-block;">
			<select class="form-control" name="cid">
				<c:forEach var="customer" items="${ requestScope.customers }">
					<option value="${ customer.cid }"> ${ customer.cname } </option>
				</c:forEach>
			</select>
		</div>
		<input class="btn btn-primary col-sm-2" type="submit" value="获取">
		<a class="btn btn-primary col-sm-2" href="${pageContext.request.contextPath}/room/info">返回</a>
	</form>
	<table class="table">
		
		<c:if test="${ customer != null }">
			<th colspan="4">
				${customer.cname}的住房历史信息
			</th>
		</c:if>
		<thread>
			<tr>
				<td>住房人姓名：</td>
				<td>房间号：</td>
				<td>入住时间：</td>
				<td>退房时间：</td>
				<td>住房费用：</td>
			</tr>
		</thread>
		<tbody>
			<c:forEach var="zhuhistory" items="${requestScope.zhuhistorys}">
				<tr>
					<td>${zhuhistory.customer.cname}</td>
					<td>${zhuhistory.room.rid}</td>
					<td>${zhuhistory.ldate}</td>
					<td>${zhuhistory.zdate}</td>
					<td>${zhuhistory.paymoney}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</center>
</body>
</html>