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
			<legend>考勤信息</legend>
		</fieldset>

		<div class="layui-form">
			<table class="layui-table">
				<colgroup>
					<col width="150">
					<col width="150">
					<col width="150">
					<col width="200">
					<col width="100">
					<col width="200">
					<col width="100">

					<col>
				</colgroup>
				<thead>
				<tr>
					<th>考勤编号</th>
					<th>员工编号</th>
					<th>打卡日期</th>
					<th>上班打卡时间</th>
					<th>打卡状态</th>
					<th>下班打卡时间</th>
					<th>打卡状态</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${requestScope.clockInfoList}" var="clockInfo" varStatus="stat">
				<tr id="data_${stat.index}" class="main_trbg" align="center">
					<td>${clockInfo.clockId }</td>
					<td>${clockInfo.employeeNo }</td>
					<td>
						<f:formatDate value="${clockInfo.clockDate}"
									  type="date" dateStyle="long"/>
					</td>
					<td>
						<f:formatDate pattern="yyyy-MM-dd hh:mm:ss"
                                      value="${clockInfo.clockInTime}" />
					</td>
					<td>
							${clockInfo.inStatus}
					</td>
					<td>
						<f:formatDate pattern="yyyy-MM-dd hh:mm:ss"
                                        value="${clockInfo.clockOffTime}" />
					</td>
					<td>${clockInfo.offStatus}</td>

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
			<a href="${baseUri}/showAllAttendance?page=1">[首页]</a>&nbsp;&nbsp;
			<a
					href="${baseUri}/showAllAttendance?page=${currPage-1}">[上一页]</a>
			&nbsp;&nbsp;
		</c:if> <c:if
				test="${currPage < totalPage}">
						<a
								href="${baseUri}/showAllAttendance?page=${currPage+1}">[下一页]</a>&nbsp;&nbsp;
			<a
					href="${baseUri}/showAllAttendance?page=${totalPage}">[尾页]</a>&nbsp;&nbsp;
		</c:if>
				</span>
		</div>
	</div>


	<!-- 引入底部导航 -->
	<c:import url="nav/bottom.jsp"></c:import>
</div>



</body>
</html>