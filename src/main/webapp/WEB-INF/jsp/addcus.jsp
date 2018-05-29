<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date" isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("utf-8");request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${ path }/css/bootstrap.min.css">  
<script src="${ path }/js/jquery/2.1.1/jquery.min.js"></script>
<script src="${ path }/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<style>
	.hide{display:none;}
</style>
<c:set var="date" value='<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%>'></c:set>
<c:set var="rid" value='${ requestScope.rid }'></c:set>
<form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/zhuroom/zhu" method="post" accept-charset="utf-8">
	<input type="text" name="rid" value="${requestScope.rid}" style="position: absolute;top:-100px;">
	<input type="text" name="ldate" value="${date}" style="position: absolute;top:-100px;">
	<div class="container" style="text-align=center;">
		<div class="col-sm-9" style="display:block;margin:0 auto;">
			<label class="col-sm-12 control-label" style="text-align:center;background:#d6f8fa;">顾客入住</label>
			<div class="form-group">
				<label class="col-sm-2 control-label">房间rid:</label>
				<div class="col-sm-12">
					<input type="text" disabled="disabled" id="disabledTextInput" class="form-control"  value="${requestScope.rid}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">选择已登记的顾客</label>
				<div class="col-sm-12">
					<select name="rrid" class="form-control" id="cc">
						<option value="false">false</option>
						<c:forEach var="customer" items="${ requestScope.customers }">
							<option value="${ customer.cid }">${customer.cname}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group gg">
				<label class="col-sm-2 control-label">用户身份证号：</label>
				<div class="col-sm-12">
					<input class="form-control" placeholder="用户身份证号" type="input" name="cid">
				</div>
			</div>
			<div class="form-group gg">
				<label class="col-sm-2 control-label">用户姓名：</label>
				<div class="col-sm-12">
					<input class="form-control" placeholder="用户姓名" type="input" name="cname">
				</div>
			</div>
			
			<div class="form-group gg">
				<label class="col-sm-2 control-label">用户性别：</label>
				<div class="col-sm-12">
					<select name="csex" class="form-control">
						<option value="男">男</option>
						<option value="女">女</option>
					</select>
				</div>
			</div>
			<div class="form-group gg">
				<label class="col-sm-2 control-label">用户电话：</label>
				<div class="col-sm-12">
					<input  class="form-control" placeholder="输入用户电话" type="input" name="ctel">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">时间:</label>
				<div class="col-sm-12">
					<input type="text" disabled="disabled" id="disabledTextInput" class="form-control" value="${date}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">付款(元)：</label>
				<div class="col-sm-12">
					<input  class="form-control" placeholder="付款" type="input" name="paymoney">
				</div>
			</div>
			<div class="form-group" style="text-align:center;">
				<input class="btn btn-primary col-sm-5" type="submit" value="提交" >
				<a class="btn btn-primary col-sm-5" href='${pageContext.request.contextPath}/room/info'>返回</a>
			</div>
		</div>
	</div>
</form>
<script type="text/javascript">
	$("#cc").change(function(){
		console.log(this.value);
		if(this.value != 'false'){
			$(".gg").addClass('hide');
		}else{
			$(".gg").removeClass('hide');
		}
	});
</script>
</body>
</html>