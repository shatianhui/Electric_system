<%--
  Created by IntelliJ IDEA.
  User: 沙天慧
  Date: 2020/6/21
  Time: 9:40
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+
            ":"+request.getServerPort()+path;

%>
<html>
<head>
    <title>企业用电管理系统</title>
    <meta charset="UTF-8">
    <!--可以根据设备的大小调整页面的显示-->
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <script type="text/javascript" src="<%=basePath%>/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/bootstrap/js/bootstrap.min.js"></script>
    <link type="text/css" rel="stylesheet" href="<%=basePath%>/bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-10">
            <div class="panel panel-success">
                <div class="panel-footer">
                    B计算机171沙天慧
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
