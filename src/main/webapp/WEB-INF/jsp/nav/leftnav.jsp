<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<script src="${baseUri}/static/layui/layui.js"></script>
	<script>
		//JavaScript代码区域
		layui.use('element', function() {
			var element = layui.element;

		});
		layui.use('carousel', function() {
			var carousel = layui.carousel;
			//建造实例
			carousel.render({
				elem : '#test1',
				width : '100%' //设置容器宽度
				,
				arrow : 'always' //始终显示箭头
			,anim: 'updown' //切换动画方式
			});
		});
	</script>
<div class="layui-side layui-bg-black">
	<div class="layui-side-scroll">
		<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
		<ul class="layui-nav layui-nav-tree" lay-filter="test">
			<li class="layui-nav-item layui-nav-itemed">
			<a class="" href="javascript:;">个人情况</a>
				<dl class="layui-nav-child">
					<dd>
						<a href="showAllAttendance">考勤情况</a>
					</dd>
					<dd>
						<a href="showAllAttendance">工作日</a>
					</dd>
					
					<dd>
						<a href="showAllAttendance">考勤统计</a>
					</dd>
				</dl></li>
			<li class="layui-nav-item layui-nav-itemed"><a href="javascript:;">考勤管理</a>
				<dl class="layui-nav-child ">
					<dd>
						<a href="showAllAttendance">工作日管理</a>
					</dd>
					<dd>
						<a href="showAllAttendance.jsp">查看员工考勤</a>
					</dd>
					<dd>
						<a href="showAllAttendance">员工考勤统计</a>
					</dd>
					<dd>
						<a href="employeeInfo">员工考勤统计</a>
					</dd>
					
				</dl></li>
		</ul>
	</div>
</div>