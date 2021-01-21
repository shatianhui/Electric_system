<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 沙天慧
  Date: 2020/6/21
  Time: 9:54
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort()
                + path + "/";
        String listUrl = basePath + "pages/RecorderServlet/list";
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
    <jsp:include page="/pages/header.jsp"></jsp:include><br><br>
    <div class="row">
        <div class="col-md-4 col-md-offset-2">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <strong>抄表人信息列表</strong>
                </div>
                <div class="panel-body">
                    <table class="table table-striped table-bordered table-hover table-condensed table-responsive">
                        <tr class="active">
                            <td><strong>编号</strong></td>
                            <td><strong>姓名</strong></td>
                        </tr>
                    <c:forEach items="${allRecorders}" var="recorders">
                        <tr>
                            <td>${recorders.rnid}</td>
                            <td>${recorders.rname}</td>
                        </tr>
                    </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <br><br>
    <jsp:include page="/pages/footer.jsp"></jsp:include>
</div>
</body>
</html>
