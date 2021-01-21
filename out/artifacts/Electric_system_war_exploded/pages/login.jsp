<%--
  Created by IntelliJ IDEA.
  User: 沙天慧
  Date: 2020/6/20
  Time: 23:42
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort()
                + path + "/";
        String loginUrl = basePath + "pages/UserLoginServlet/login";
    %>
    <title>企业用电管理系统</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>bootstrap/js/bootstrap.min.js"></script>
    <link type="text/css" rel="stylesheet" href="<%=basePath%>bootstrap/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <div class="col-md-12">
                <h2 align="center"><font color="#191970">欢迎使用企业用电系统</font></h2>
        </div>
    </div>
        <div class="row">
            <div class="container">
                <form action="<%=loginUrl%>" method="post" id="myForm" class="form-horizontal">
                    <fieldset>
                        <legend><label><span class="glyphicon glyphicon-user"></span> &nbsp;用户登录</label></legend>
                        <div class="form-group" id="nameDiv">
                            <label class="col-md-3 control-label" for="uname">用户名：</label>
                            <div class="col-md-5">
                                <input type="text" id="uname" name="uname" class="form-control" placeholder="请输入用户名">
                            </div>
                        </div>
                        <div class="form-group" id="pwdDiv">
                            <label class="col-md-3 control-label" for="password">密码：</label>
                            <div class="col-md-5">
                                <input type="password" id="password" name="password" class="form-control" placeholder="请输入密码">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">请选择：</label>
                            <div class="radio-inline">
                                <label><input type="radio"checked name="grade" value="管理员">管理员</label>
                            </div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <div class="radio-inline">
                                <label><input type="radio" name="grade" id="grade"value="员工">员工</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-5 col-md-offset-3">
                                <button type="submit" class="btn  btn-primary">登录</button>
                                <button type="reset" class="btn btn-default">重置</button>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
