<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false" import="java.sql.Date,com.zjy.entity.*"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="now" value="<%= new Date(new java.util.Date().getTime()).getTime()%>"></c:set>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<c:set var="zhuroom" value="${requestScope.zhuroom}"></c:set>
<c:set var="dd" value="${ now - zhuroom.ldate.time}" scope="request"></c:set>
<fmt:setLocale value="zh_CN" /> 
<fmt:parseNumber var="price" integerOnly="true" value="${prices }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>住房信息</title>
<link rel="stylesheet" href="${ path }/css/bootstrap.min.css">  
<script src="${ path }/js/jquery/2.1.1/jquery.min.js"></script>
<script src="${ path }/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container" style="margin-top:50px;text-align:center;">
	<table class="table">
		<thead>
			<tr>
				<th>房间号</th>
				<th>住房人id</th>
				<th>住房人姓名</th>
				<th>住房人性别</th>
				<th>住房人电话</th>
				<th>定金(元)</th>
				<th>实际消费</th>
				<th>入住时间</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${zhuroom.room.rid}</td>
				<td>${zhuroom.customer.cid}</td>
				<td>${zhuroom.customer.cname}</td>
				<td>${zhuroom.customer.csex}</td>
				<td>${zhuroom.customer.ctel}</td>
				<td>${zhuroom.paymoney}</td>
				<td id="price">${ (now - zhuroom.ldate.time)/ (1000 * 60 * 60 * 24) * zhuroom.room.price}</td>
				<td>${ zhuroom.ldate }</td>
			</tr>
		</tbody>
	</table>
	<a class="btn btn-primary col-sm-5" href="${pageContext.request.contextPath}/zhuroom/del?id=${zhuroom.id}">退房</a>
	<a class="btn btn-primary col-sm-5" href="${pageContext.request.contextPath}/room/info">返回</a>
</div>
</body>
<script type="text/javascript">
	$("#price").text($("#price").text().substring(0,$("#price").text().indexOf(".") + 3));
</script>
</html>