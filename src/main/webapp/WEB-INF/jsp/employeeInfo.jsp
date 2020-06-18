<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="baseUri" value="${pageContext.request.contextPath }"
	scope="request"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>智能考勤系统</title>
<link rel="stylesheet" href="${baseUri}/static/layui/css/layui.css">
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">

		<!-- 引入头部导航 -->
		<c:import url="nav/titlenav.jsp"></c:import>

		<!-- 引入左边导航 -->
		<c:import url="nav/leftnav.jsp"></c:import>



		<div class="layui-body">
			<!-- 内容主体区域 -->
			<fieldset class="layui-elem-field layui-field-title">
				<legend>员工信息</legend>
			</fieldset>

			<form class="layui-form" action="updateAdmin" method="POST"
				enctype="multipart/form-data">
				<input  type="hidden" name="id" value=""  > 
				
				<div class="layui-form-item">
					<label class="layui-form-label">员工id</label>
					<div class="layui-input-block" style="width: 400px;">
						<input disabled="disabled" type="text" name="employeeId" lay-verify="required"
							autocomplete="off" value="" class="layui-input" id="employeeId">
					</div>
				</div>

				
				<div class="layui-form-item">
					<label class="layui-form-label">员工编号</label>
					<div class="layui-input-block" style="width: 400px;">
						<input type="text" name="employeeNo" lay-verify="required"
							autocomplete="off" value="" class="layui-input" id="employeeNo">
							
					</div>
				</div>

				
<%--				<div class="layui-form-item">--%>
<%--					<label class="layui-form-label">密码</label>--%>
<%--					<div class="layui-input-block" style="width: 400px;">--%>
<%--						<input type="text" name="passWord" lay-verify="required"--%>
<%--							autocomplete="off" value="" class="layui-input"  id="passWord">--%>
<%--							--%>
<%--					</div>--%>
<%--				</div>--%>

				
				<div class="layui-form-item">
					<label class="layui-form-label">姓名</label>
					<div class="layui-input-inline" style="width: 100px;">
						<input type="text" name="employeeName" value="" autocomplete="off"
							class="layui-input" id="employeeName">
							
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">账号</label>
					<div class="layui-input-inline" style="width: 100px;">
						<input type="text" name="loginName" value="" autocomplete="off"
							class="layui-input" id="loginName">
							
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">密码</label>
					<div class="layui-input-inline" style="width: 100px;">
						<input type="password" name="passWord" value="" autocomplete="off"
							class="layui-input" id="passWord">

					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">职位</label>
					<div class="layui-input-inline" style="width: 100px;">
						<input type="text" name="job" value="" autocomplete="off"
							class="layui-input" id="job">
							
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">工资</label>
					<div class="layui-input-inline" style="width: 100px;">
						<input type="text" name="sal" value="" autocomplete="off"
							class="layui-input" id="sal">
							
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">入职日期</label>
					<div class="layui-input-inline" style="width: 100px;">
						<input type="date" name="time" value="" autocomplete="off"
							class="layui-input" id="time">
							
					</div>
				</div>

				<div class="layui-form-item">
					<div class="layui-input-block">
						<button  type="submit" class="layui-btn" lay-filter="demo1" id="submit">确定</button>
						
					</div>
				</div>
				
				
			</from>
		</div>
		<!-- 引入底部导航 -->
		<c:import url="nav/bottom.jsp"></c:import>
	</div>

</body>
</html>