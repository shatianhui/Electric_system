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
        String insertUrl = basePath + "pages/UseeleServlet/insert";
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
                    <legend><label><span></span> &nbsp;发布企业用电信息</label></legend>
                    <div class="form-group" >
                        <label class="col-md-3 control-label" for="bid">企业编号：</label>
                        <div class="col-md-5">
                            <input type="text" id="bid" name="bid" class="form-control" placeholder="请输入企业编号">
                        </div>
                    </div>
                    <div class="form-group" >
                        <label class="col-md-3 control-label" for="pid">电价编号：</label>
                        <div class="col-md-5">
                            <input type="text" id="pid" name="pid" class="form-control" placeholder="请输入电价编号">
                        </div>
                    </div>
                    <div class="form-group" >
                        <label class="col-md-3 control-label" for="rnid">抄表人工号：</label>
                        <div class="col-md-5">
                            <input type="text" id="rnid" name="rnid" class="form-control" placeholder="请输入抄表人工号">
                        </div>
                    </div>
                    <div class="form-group" id="nameDiv">
                        <label class="col-md-3 control-label" >日期：</label>
                        <div class="col-md-5 form-inline">
                            <select id="year" name="year" class="form-control"  style="width:140px" >
                                <option value="2018" s>2018</option>
                                <option value="2019">2019</option>
                                <option value="2020" selected>2020</option>
                                <option value="2021">2021</option>
                                <option value="2022">2022</option>
                            </select>&nbsp;&nbsp;年&nbsp;&nbsp;
                            <select id="month" name="month" class="form-control" style="width:120px " >
                                <option value="1" selected>1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                            </select>&nbsp;&nbsp;月&nbsp;&nbsp;
                        </div>
                    </div>
                    <div class="form-group" >
                        <label class="col-md-3 control-label" for="vcount">谷电量：</label>
                        <div class="col-md-5">
                            <input type="text" id="vcount" name="vcount" class="form-control" placeholder="请输入谷电量">
                        </div>
                    </div>
                    <div class="form-group" >
                        <label class="col-md-3 control-label" for="pcount">峰电量：</label>
                        <div class="col-md-5">
                            <input type="text" id="pcount" name="pcount" class="form-control" placeholder="请输入峰电量">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-5 col-md-offset-3">
                            <button type="submit" class="btn  btn-primary">发布</button>
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
