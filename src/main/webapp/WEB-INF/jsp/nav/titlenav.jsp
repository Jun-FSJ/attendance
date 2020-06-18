<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="layui-header">
	<div class="layui-logo">智能考勤管理系统</div>
	<!-- 头部区域（可配合layui已有的水平导航） -->
	<ul class="layui-nav layui-layout-left">
		<li class="layui-nav-item"><a href="###">考勤打卡</a></li>
		
	</ul>
	<ul class="layui-nav layui-layout-right">
		<li class="layui-nav-item"><a href="javascript:;"> <img
				src="${baseUri}/static/images/head.jpg" class="layui-nav-img"> ${msAdmin.adminName }
		</a>
			<dl class="layui-nav-child">
				<dd>
					<a href="${baseUri}/jsp/employeeInfo.jsp">基本资料</a>
				</dd>
				
			</dl></li>
		<li class="layui-nav-item"><a href="loginOut" onclick="return confirm('确认退出账号${msAdmin.adminName }？')">安全退出</a></li>
	</ul>
</div>