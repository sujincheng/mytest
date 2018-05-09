<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<!--当前网页使用的语言和国家-->
<html lang="zh-CN">
  <head>
  	<base href="<%=basePath%>">
  	<!--设置网页的字符集-->
    <meta charset="utf-8">
    <!--使用最新的HTML5的浏览器进行解析，使用Edge内核进行解析-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--
    	viewport: 视口：在浏览器中虚拟的容器，可以根据设备的分辨率自动适应网页的内容
	    width: 默认的宽度是设备的宽度
	    initial-scale： 初始的缩放比1:1
    -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>模板</title>

    <!-- 1. 导入bootstrap的css样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
     <!--2. 导入jquery框架 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap中的js文件 -->
    <script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
    	$(function(){
    		//删除按钮
    		$("#btnDelete").click(function(){
    			//所有选中的长度为0，表示没有选中
    			if ($("input:checked").length == 0) {
    				alert("请先选中要删除的联系人");
    				return;
    			}
    			//确认是否删除
    			if (confirm("真的要删除这些联系人吗?")) {
    				//提交表单到DeleteContactServlet
    				$("#conForm").submit();   //提交表单
    			}
    		});
    	})
    </script>
  </head>
  <body>
    <div class="container">
    <h2>显示所有联系人</h2>
    	<form>
    		<table class="table table-border table-hover">
    			<tr class="success">
    				<th></th>
    				<th>编号</th>
    				<th>姓名</th>
    				<th>性别</th>
    				<th>年龄</th>
    				<th>籍贯</th>
    				<th>QQ</th>
    				<th>邮箱</th>
    				<th>操作</th>
    			</tr>
    			<c:forEach items="${contacts}" var="contact" varStatus="row">
	    			<tr>
	    				<td>
	    					<input type="checkbox" name="id" value="${contact.id}"/>
	    				</td>
	    				<td>${row.count}</td>  
	    				<td>${contact.name}</td>
	    				<td>${contact.gender}</td>
	    				<td>${contact.age}</td>
	    				<td>${contact.jiguan}</td>
	    				<td>${contact.qq}</td>
	    				<td>${contact.email}</td>
	    				<td>
	    					<a href="query?${contact.id}" class="btn btn-default">修改</a>
	    				</td>
	    			</tr>
    			</c:forEach>
    		</table>
    	</form>
    	<div class="row" sytle="text-align:center">
    		<a href="add.jsp" class="btn btn-default btn-primary">添加联系人</a>
    		<button value="删除联系人" class="btn btn-default" id="btnDelete">删除联系人</button>
    	</div>
    </div>
  </body>
</html>