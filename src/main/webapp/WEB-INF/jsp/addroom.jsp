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
<title>Insert title here</title>
</head>
<body>
<div class="container" style="margin-top:25px;">
	<label class="col-sm-10 control-label" style="text-align:center;background:#d6f8fa;">添加客房</label>
	<form class="form-horizontal center-block" style="width:92%;display:inherit;" role="form" action="${pageContext.request.contextPath}/room/addroom" method="post">
		<div class="form-group">
  			<label for="firstname" class="col-sm-2 control-label">房间rid:</label>
  			<div class="col-sm-10">
				<input class="form-control" type="input" name="rid"></input>
			</div>
		</div>
		<div class="form-group">
  			<label for="firstname" class="col-sm-2 control-label">房间床的数量：</label>
  			<div class="col-sm-10">
				<input class="form-control" type="input" name="bednum"></input>
			</div>
		</div>
			<div class="form-group">
  			<label for="firstname" class="col-sm-2 control-label">价格：</label>
				<div class="col-sm-10">
					<input class="form-control" type="input" name="price"></input>
				</div>
			</div>
				<input class="btn btn-primary col-sm-5" type="submit" value="提交"></input>
				<a class="btn btn-primary col-sm-5" href="${pageContext.request.contextPath}/room/info">返回</a>
	</form>
</div>
</body>
</html>