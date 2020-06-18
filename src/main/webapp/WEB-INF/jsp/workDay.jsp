<%@ page language="java" contentType="text/html; charset=UTF-8"
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
			<legend>工作日</legend>
		</fieldset>

		<div class="layui-form">
			<table class="layui-table">
				<colgroup>
					<col width="150">
					<col width="150">
					<col width="150">
               <col>
				</colgroup>
				<thead>
				<tr>
					<th>id</th>
					<th>工作日</th>
					<th>操作</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${requestScope.workDateList}" var="workDateInfo" varStatus="stat">
				<tr id="data_${stat.index}" class="main_trbg" align="center">
					<td>${workDateInfo.workDateId }</td>
					<td><f:formatDate value="${workDateInfo.workDate}"
									  type="date" dateStyle="long"/></td>
					<td>
						<a href="${baseUri}/deleteWokeDay?workDateId=${workDateInfo.workDateId}">删除</a>
					</td>
				</tr>
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
			<a href="${baseUri}/selectWorkDay?page=1">[首页]</a>&nbsp;&nbsp;
			<a
					href="${baseUri}/selectWorkDay?page=${currPage-1}">[上一页]</a>
			&nbsp;&nbsp;
		</c:if> <c:if
				test="${currPage < totalPage}">
						<a
								href="${baseUri}/selectWorkDay?page=${currPage+1}">[下一页]</a>&nbsp;&nbsp;
			<a
					href="${baseUri}/selectWorkDay?page=${totalPage}">[尾页]</a>&nbsp;&nbsp;
		</c:if>
				</span>
		</div>
	</div>


	<!-- 引入底部导航 -->
	<c:import url="nav/bottom.jsp"></c:import>
</div>



</body>
</html>