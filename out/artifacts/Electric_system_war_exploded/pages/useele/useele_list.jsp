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
    String deleteUrl=basePath+"pages/UseeleServlet/delete";
    String showUrl=basePath+"pages/UseeleServlet/show";
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
                    <strong>企业用电信息列表</strong>
                </div>
                <div class="panel-body">
                    <div id="splitSearchDiv">
                        <jsp:include page="/pages/split_page_plugin_search.jsp"></jsp:include>
                        <br>
                    </div>
                    <table class="table table-striped table-bordered table-hover table-condensed table-responsive">
                        <tr class="active">
                            <td><input type="checkbox" onclick="checkboxSelect(this,'ueid')"></td>
                            <td><strong>编号</strong></td>
                            <td><strong>企业编号</strong></td>
                            <td><strong>用电编号</strong></td>
                            <td><strong>抄表人工号</strong></td>
                            <td><strong>用电年月</strong></td>
                            <td><strong>谷电量</strong></td>
                            <td><strong>峰电量</strong></td>
                            <td><strong>操作</strong></td>
                        </tr>
                        <c:forEach items="${allUseele}" var="useele">
                            <tr>
                                <td><input type="checkbox" id="ueid" name="ueid" value="${useele.ueid}"></td>
                                <td>${useele.ueid}</td>
                                <td>${useele.business.bid}</td>
                                <td>${useele.price.pid}</td>
                                <td>${useele.recorder.rnid}</td>
                                <td>${useele.usemonth}</td>
                                <td>${useele.vcount}</td>
                                <td>${useele.pcount}</td>
                                <td><a href="<%=showUrl%>?bid=${useele.business.bid}&pid=${useele.price.pid}&rnid=${useele.recorder.rnid}">查看</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                    <button class="btn btn-primary" onclick="deleteAll('<%=deleteUrl%>','ids','ueid')">删除</button>
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
