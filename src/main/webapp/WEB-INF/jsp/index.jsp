﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
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
		
		

		<div class="layui-body" style="background-color: white">
			<!-- 内容主体区域 -->
			<div class="mg-b20 text-center">
				<h2 align="center">欢迎你！ <a >
					${sessionScope.employee.employeeName }
				</a></h2>
				<hr/>
				<p align="center">&nbsp;&nbsp;&nbsp;&nbsp;
					考勤系统，在包含薪资计算模块的情况下，可以灵活定义各个工资项目的计算公式，自动调用员工的出勤数据、人员资料、就餐等与工资相关的数据，计算出员工的工资情况，可提供银行代发工资所需的相关文件。同时提供丰富的统计分析报表，可即时掌握企业工资支出情况。
					RQHR基于拥有自主版权的RQBuilder开发平台开发，它具有鲜明的技术特点及众多成熟的解决方案。
					1. 真正在线式二次开发，面向对象的脚本语言，可视化开发环境，功能可无限扩充，客户可轻松摆脱对源代码的依赖；
					2. 系统界面可自由定义，界面布局大方得体，操作方式全面符合Windows标准，操作灵活方便；
					3. C/S体系架构, 具有强大的SQL Sever数据库管理功能；可以控制管理数据库, 表，索引，触发器，规则约束及存储过程等，我们提供的RQHR系统标准数据库具有详尽的数据完整性约束，杜绝非法数据进入系统。
					4. 整个系统中所有的繁杂的计算工作全部交由SQL Server后台计算。
					5. 多语言支持，自适应简体、繁体及英文操作系统等；
					6. 录入资料方便快捷，全面支持批量录入资料；
					7. 自定义的界面, 实现个性化的操作向导, 动态切换操作风格以满足不同的需求
					8. 自定义的功能模块, 添加新的模块控制极为轻松愉快；
					9. 自定义的报表与统计图，可对报表数据进行动态变换, 统计分析以及作图形输出；
					10. 自定义的代码表，使用各种人事资料的录入更为轻松；
					11. 强大快捷的动态化查询无处不在，自动保存历史查询，众多友好的操作向导；
					12. 所有的数据都可与Excel, Access等数据作双向导入导出；
					13. 全面严谨的系统权限及安全控制，审核机制完善；
					14. 支持多个帐套，可以动态切换帐套，方便集团化的企业管理。
					15. 万能适应各种人力资源管理模式，快速上线，可维护性很好；
					16. 全面支持无限层次的部门组织架构，可快速对任一层的数据进行统计报表
					17. 对各种人事资料进行分析、统计、预警；
					18. 全面、精确、快捷的考勤分析，包罗万象的上班模式，大大简化考勤效率；
					19. 考勤单据的录入全面支持人个，群组录入及反录入，大幅提升工作效率。
					20. 考勤规则全面，深入，细致，体贴。
					21. 自定义工资表，工资项目计算方法及形形色色的工资报表；
					22. 方便的厂牌、工卡制作，万能挂接各型号的刷卡机器；
					23. 考勤、就餐、门禁一卡通，支持IC卡消费卡模式；
					24. 自定义的统计结算周期
					25. 无限层次的组织架构图
					26. 工号，卡号的变更处理
					27. 照片的显示及打印处理
					28. 培训，绩效与考核的管理
					29. 动态的异动、离职资料处理方案
					30. 新员工的自动转正及定期调薪的处理方案
					31. 待聘员工资料库的管理
					32. 人才储备资料库的管理
					33. 工号变更,部门变更及离职对汇总报表影响的解决方案
					34. 薪资异动对薪资计算的影响解决方案
					35. 计件计时异动对考勤、薪资计算的影响解决方案
					36. 部门异动对考勤、薪资计算的影响解决方案
					37. 实时可靠采集刷卡数据的方案
					38. 累计项目（如按金，积假，年休）的薪资自动设置
					39. 超长时间上下班打卡的可靠解决方案
					40. 电脑自动化排班或不排班的解决方案
					41. 各种模式的轮班解决方案
					42. 无限制的加班类别及请假类别
					43. 动态的班别（如大夜班，小夜班等）的算法定义
					44. 对劳动法规的合理解决方案
					45. 薪资发放报表所需各种货币的数据报表
					46. 对薪资尾数的处理方案
					47. 自定义的个人所得税税率
					48. 多供应商的就餐汇总
					49. 可选的界面风格，报表风格
					50. 其它的子系统的如图书管理，水电管理，宿舍管理，停车管理，巡更管理等
				</p>
			</div>
		</div>


		<!-- 引入底部导航 -->
		<c:import url="nav/bottom.jsp"></c:import>
	</div>


	
</body>
</html>