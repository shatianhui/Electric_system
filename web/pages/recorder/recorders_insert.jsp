<%--
  Created by IntelliJ IDEA.
  User: 沙天慧
  Date: 2020/6/21
  Time: 9:49
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort()
                + path + "/";
        String insertUrl = basePath + "pages/RecorderServlet/insert";
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
        <div class="container">
            <form action="<%=insertUrl%>" method="post" id="myForm" class="form-horizontal">
                <fieldset>
                    <legend><label><span></span> &nbsp;增加抄表人</label></legend>
                    <div class="form-group" id="nameDiv">
                        <label class="col-md-3 control-label" for="rname">姓名：</label>
                        <div class="col-md-5">
                            <input type="text" id="rname" name="rname" class="form-control" placeholder="请输入抄表人姓名">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-5 col-md-offset-3">
                            <button type="submit" class="btn  btn-primary">增加</button>
                            <button type="reset" class="btn btn-default">重置</button>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
</div>
<jsp:include page="/pages/footer.jsp"></jsp:include>
</body>
</html>
