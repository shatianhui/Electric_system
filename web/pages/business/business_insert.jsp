<%--
  Created by IntelliJ IDEA.
  User: 沙天慧
  Date: 2020/6/21
  Time: 15:57
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort()
                + path + "/";
        String insertUrl = basePath + "pages/BusinessServlet/insert";
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
                    <legend><label><span></span> &nbsp;增加企业信息</label></legend>
                    <div class="form-group" id="nameDiv">
                        <label class="col-md-3 control-label" for="bname">名字：</label>
                        <div class="col-md-5">
                            <input type="text" id="bname" name="bname" class="form-control" placeholder="请输入企业名字">
                        </div>
                    </div>
                    <div class="form-group" >
                        <label class="col-md-3 control-label" for="place">地址：</label>
                        <div class="col-md-5">
                            <input type="text" id="place" name="place" class="form-control" placeholder="请输入企业地址，记得写入详细地址哦~">
                        </div>
                    </div>
                    <div class="form-group" >
                        <label class="col-md-3 control-label" for="corporation">法人：</label>
                        <div class="col-md-5">
                            <input type="text" id="corporation" name="corporation" class="form-control" placeholder="请输入企业法人">
                        </div>
                    </div>
                    <div class="form-group" >
                        <label class="col-md-3 control-label" for="count">职工数：</label>
                        <div class="col-md-5">
                            <input type="text" id="count" name="count" class="form-control" placeholder="请输入企业职工数">
                        </div>
                    </div>
                    <div class="form-group" >
                        <label class="col-md-3 control-label" for="money">产值：</label>
                        <div class="col-md-5">
                            <input type="text" id="money" name="money" class="form-control" placeholder="请输入产值">
                        </div>
                    </div>
                    <div class="form-group" >
                        <label class="col-md-3 control-label" for="phone">联系电话：</label>
                        <div class="col-md-5">
                            <input type="text" id="phone" name="phone" class="form-control" placeholder="请输入联系电话">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-5 col-md-offset-3">
                            <button type="submit" class="btn  btn-primary">提交</button>
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
