<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
    <head>
    	<base href="<%=basePath%>"/>
        <!-- 指定字符集 -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>修改用户</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-2.1.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        
    </head>
    <body>
        <div class="container" style="width: 400px;">
        <h3 style="text-align: center;">修改联系人</h3>
        <form action="update" method="post">
      <div>
      	<input type="hidden" name="id" value="${contact.id}"/>
      </div>
      <div class="form-group">
        <label for="name">姓名：</label>
        <input type="text" class="form-control" id="name" name="name"  readonly="readonly" placeholder="请输入姓名"
        value="${contact.name}" />
      </div>

      <div class="form-group">
        <label>性别：</label>
          <input type="radio" name="gender" value="男" ${contact.gender='男'?"chacked='chacked':''" } />男
    		<input type="radio" name="gender" value="女" ${contact.gender='女'?"chacked='chacked':''" } />女
      </div>
      
      <div class="form-group">
        <label for="age">年龄：</label>
        <input type="text" class="form-control" id="age"  name="age" placeholder="请输入年龄" value="${contact.age}"/>
      </div>

      <div class="form-group">
        <label for="jiguan">籍贯：</label>
	     <select name="jiguan" class="form-control" >
	      <c:forEach items="${jgs}" var="jiguan">
	      	<!-- 如果联系人的籍贯与当前循环的籍贯相同，则选中 -->
	      	<option value="${jiguan}" ${contact.jiguan=jiguan?'selected="selected"':''}>${jiguan}</option>
	      </c:forEach>
        </select>
      </div>
      
      <div class="form-group">
        <label for="qq">QQ：</label>
        <input type="text" class="form-control" name="qq" placeholder="请输入QQ号码"/>
      </div>

      <div class="form-group">
        <label for="email">Email：</label>
        <input type="text" class="form-control" name="email" placeholder="请输入邮箱地址"/>
      </div>

         <div class="form-group" style="text-align: center">
			<input class="btn btn-primary" type="submit" value="提交" />
			<input class="btn btn-default" type="reset" value="重置" />
			<input class="btn btn-default" type="button" value="返回" onclick="history:back()"/>
         </div>
        </form>
        </div>
    </body>
</html>