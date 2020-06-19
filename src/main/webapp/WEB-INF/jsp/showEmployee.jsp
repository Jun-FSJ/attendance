﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="baseUri" value="${pageContext.request.contextPath }"
	scope="request"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>智能考勤系统</title>
<link rel="stylesheet" href="${baseUri}/static/layui/css/layui.css">
</head>
<style>
<!--
.pageshow {
	background-color: orage;
	float: right;
	line-height: 50px;
	margin-right: 100px;
}
-->
</style>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">

		<!-- 引入头部导航 -->
		<c:import url="nav/titlenav.jsp"></c:import>

		<!-- 引入左边导航 -->
		<c:import url="nav/leftnav.jsp"></c:import>



		<div class="layui-body">
			<!-- 内容主体区域 -->
			<fieldset class="layui-elem-field layui-field-title"
				style="margin-top: 20px;">
				<legend>员工信息</legend>
			</fieldset>

			<div class="layui-form">
				<table class="layui-table">
					<colgroup>
						<col width="150">
						<col width="150">
						<col width="150">
						<col width="200">
						<col width="100">
						<col width="300">
						<col width="300">
						<col width="100">
						<col width="100">
						<col width="300">

						<col>
					</colgroup>
					<thead>
						<tr>
							<th>员工id</th>
							<th>员工编号</th>
							<th>员工姓名</th>
							<th>账号</th>
							<th>密码</th>
							<th>职位</th>
							<th>入职时间</th>
							<th>薪水</th>
							<th>权限</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${requestScope.EmployeeInfoList}" var="employeeInfo" varStatus="stat">
						<tr id="data_${stat.index}" class="main_trbg" align="center">
							<td>${employeeInfo.employeeId }</td>
							<td>${employeeInfo.employeeNo }</td>
							<td>${employeeInfo.employeeName }</td>
							<td>${employeeInfo.loginName }</td>
							<td>${employeeInfo.passWord }</td>
							<td>${employeeInfo.job }</td>
							<td>
									${employeeInfo.hiredate }
<%--								<f:formatDate value="${employeeInfo.hiredate}"--%>
<%--											  type="date" dateStyle="long"/>--%>
							</td>
							<td>${employeeInfo.sal }</td>
							<td>${employeeInfo.role }</td>
							<td>
								<a style="color: skyblue" href="${baseUri}/showUpdateAdmin?employeeId=${employeeInfo.employeeId}">
									<i class="layui-icon">&#xe642;</i>   修改
								</a>
								&nbsp;
								<a style="color: red" href="${baseUri}/deleteAdmin?employeeId=${employeeInfo.employeeId}">
									<i class="layui-icon">&#xe640;</i>删除
								</a>
							</td>
					</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- 页码显示 -->
			<div class="pageshow">
				<span> 第${currPage }/${totalPage}页</span>
				&nbsp;&nbsp; <span>总记录数：${totalCount }&nbsp;&nbsp;每页显示:${pageSize}</span>
				&nbsp;&nbsp; <span> <c:if
						test="${currPage > 1}">
						<a href="${baseUri}/showEmployee?page=1">[首页]</a>&nbsp;&nbsp;
           				<a
							href="${baseUri}/showEmployee?page=${currPage-1}">[上一页]</a>
           				&nbsp;&nbsp;
       				</c:if> <c:if
						test="${currPage < totalPage}">
						<a
							href="${baseUri}/showEmployee?page=${currPage+1}">[下一页]</a>&nbsp;&nbsp;
           				<a
							href="${baseUri}/showEmployee?page=${totalPage}">[尾页]</a>&nbsp;&nbsp;
       				</c:if>
				</span>
			</div>
		</div>


		<!-- 引入底部导航 -->
		<c:import url="nav/bottom.jsp"></c:import>
	</div>


	
</body>
</html>