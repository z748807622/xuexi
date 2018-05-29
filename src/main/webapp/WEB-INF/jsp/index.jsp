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
<link rel="stylesheet" href="${ path }/css/index.css"> 
<script src="${ path }/js/jquery/2.1.1/jquery.min.js"></script>
<script src="${ path }/js/bootstrap.min.js"></script>
<title>住房信息</title>
</head>
<body>
	<div class="container" style="margin-top:25px;">
			<div class="col-sm-6 center-block" >
				<a class="btn btn-primary col-sm-5" href="${pageContext.request.contextPath}/room/addroompage">添加房间</a>
				<a class="btn btn-primary col-sm-5" href="${pageContext.request.contextPath}/zhuhistory">住房历史</a>
			</div>
			
			<table class="table table-condensed">
				<thead>
					<tr>
						<th>房号</th>
						<th>床位数量</th>
						<th>房间单价(元)</th>
						<th>可执行操作</th>
					</tr>
				</thead>
				<%-- <br /><span style="color:red;">${requestScope.result}</span>  <br /> --%>
				<tbody>
					<c:forEach var="room" items="${requestScope.allroom}">
						<tr class='<c:choose><c:when test="${room.rstate=='1'}">warning</c:when><c:when test="${room.rstate=='0'}">success</c:when></c:choose>'>
							<td>${room.rid}</td>
							<td>${room.bednum}</td>
							<td>${room.price}</td>
							<c:choose>
								<c:when test="${room.rstate=='1'}">
									<td><a href="${pageContext.request.contextPath}/zhuroom/info?rid=${room.rid}">入住客户信息</a></td>
								</c:when>
								<c:when test="${room.rstate=='0'}">
									<td><a href="${pageContext.request.contextPath}/zhuroom/zhupage?rid=${room.rid}">客户入住</a></td>
								</c:when>
							</c:choose>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
</body>
</html>