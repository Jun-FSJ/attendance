<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:set var="baseUri" value="${pageContext.request.contextPath }"
	   scope="request"></c:set>
<div class="layui-header">
	<div class="layui-logo">智能考勤管理系统</div>
	<!-- 头部区域（可配合layui已有的水平导航） -->
	<ul class="layui-nav layui-layout-left">
		<li class="layui-nav-item">
			<a href="${baseUri}/clock" id="colck" >考勤打卡</a>
		</li>
		<c:if test="${msg != null}">
			<li class="layui-nav-item">
				<span href="" id="msg" style="color: red" >${requestScope.msg}</span>
			</li>
		</c:if>
	</ul>
	<ul class="layui-nav layui-layout-right">
		<li class="layui-nav-item"><a href="javascript:;"> <img
				src="${baseUri}/static/images/head.jpg" class="layui-nav-img"> ${sessionScope.employee.employeeName }
		</a>
			<dl class="layui-nav-child">
				<dd>
					<a href="${baseUri}/jsp/employeeInfo.jsp">基本资料</a>
				</dd>
				
			</dl>
		</li>
		<li class="layui-nav-item"><a href="loginOut" onclick="return confirm('确认退出账号${sessionScope.employee.employeeName }？')">安全退出</a></li>
	</ul>
</div>