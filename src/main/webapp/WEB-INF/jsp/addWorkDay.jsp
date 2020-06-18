<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <fieldset class="layui-elem-field layui-field-title">
            <legend>新增工作日</legend>
        </fieldset>

        <form class="layui-form" action="addWokeDay" method="POST"
              enctype="multipart/form-data">

            <div class="layui-form-item">
                <label class="layui-form-label">增加工作日</label>
                <div class="layui-input-inline" style="width: 200px;">
                    <input type="date" name="workDate" value="" autocomplete="off"
                           class="layui-input" id="workDate">
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button type="submit" class="layui-btn" lay-filter="demo1" id="submit">确定</button>

                </div>
            </div>

        </form>
    </div>
    <!-- 引入底部导航 -->
    <c:import url="nav/bottom.jsp"></c:import>
</div>

</body>
</html>