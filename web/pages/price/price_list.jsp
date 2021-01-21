<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 沙天慧
  Date: 2020/6/21
  Time: 16:05
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String deleteUrl=basePath+"pages/PriceServlet/delete";
%>
<html>
<head>
    <title>企业用电管理系统</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>bootstrap/js/bootstrap.min.js"></script>
    <link type="text/css" rel="stylesheet" href="<%=basePath%>bootstrap/css/bootstrap.min.css">
    <script type="text/javascript" src="<%=basePath%>js/common.js"></script>
</head>
<body>
<div class="container">
    <jsp:include page="/pages/header.jsp"></jsp:include><br><br>
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <strong>电价信息列表</strong>
                </div>
                <div class="panel-body">
                    <div id="splitSearchDiv">
                        <jsp:include page="/pages/split_page_plugin_search.jsp"></jsp:include>
                        <br>
                    </div>
                    <table class="table table-striped table-bordered table-hover table-condensed table-responsive">
                        <tr class="active">
                            <td><input type="checkbox" onclick="checkboxSelect(this,'pid')"></td>
                            <td><strong>编号</strong></td>
                            <td><strong>发布日期</strong></td>
                            <td><strong>谷价</strong></td>
                            <td><strong>峰价</strong></td>
                        </tr>
                        <c:forEach items="${allPrice}" var="price">
                            <tr>
                                <td><input type="checkbox" id="pid" name="pid" value="${price.pid}"></td>
                                <td>${price.pid}</td>
                                <td>${price.pubdate}</td>
                                <td>${price.valley}</td>
                                <td>${price.peak}</td>
                            </tr>
                        </c:forEach>
                    </table>
                    <button class="btn btn-primary" onclick="deleteAll('<%=deleteUrl%>','ids','pid')">删除</button>
                    <div id="splitBarDiv" style="float:right">
                        <jsp:include page="/pages/split_page_plugin_bars.jsp"></jsp:include>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br><br>
    <jsp:include page="/pages/footer.jsp"></jsp:include>
</div>
</body>
</html>
