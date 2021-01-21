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
    %>
    <title>详情</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>bootstrap/js/bootstrap.min.js"></script>
    <link type="text/css" rel="stylesheet" href="<%=basePath%>bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <fieldset>
            <legend><label><span></span> &nbsp;详情</label></legend>
            <div class="col-md-5 form-inline">
                <label class="col-md-3 control-label" >企业编号：</label>
                <label class="col-md-3 control-label" >${business.bid}</label>
            </div>
            <div class="col-md-5 form-inline">
                <label class="col-md-3 control-label" >企业名称：</label>
                <label class="col-md-3 control-label" >${business.bname}</label>
            </div>
            <div class="col-md-5 form-inline">
                <label class="col-md-3 control-label" >地址：</label>
                <label class="col-md-3 control-label" >${business.place}</label>
            </div>
            <div class="col-md-5 form-inline">
                <label class="col-md-3 control-label" >法人：</label>
                <label class="col-md-3 control-label" >${business.corporation}</label>
            </div>
            <div class="col-md-5 form-inline">
                <label class="col-md-3 control-label" >职工数：</label>
                <label class="col-md-3 control-label" >${business.count}</label>
            </div>
            <div class="col-md-5 form-inline">
                <label class="col-md-3 control-label" >产值：</label>
                <label class="col-md-3 control-label" >${business.money}</label>
            </div>
            <div class="col-md-5 form-inline">
                <label class="col-md-3 control-label" >联系电话：</label>
                <label class="col-md-3 control-label" >${business.phone}</label>
            </div>
            <div class="col-md-5 form-inline">
                <label class="col-md-3 control-label" >电价编号：</label>
                <label class="col-md-3 control-label" >${price.pid}</label>
            </div>
            <div class="col-md-5 form-inline">
                <label class="col-md-3 control-label" >发布日期：</label>
                <label class="col-md-3 control-label" >${price.pubdate}</label>
            </div>
            <div class="col-md-5 form-inline">
                <label class="col-md-3 control-label" >谷价：</label>
                <label class="col-md-3 control-label" >${price.valley}</label>
            </div>
            <div class="col-md-5 form-inline">
                <label class="col-md-3 control-label" >峰价：</label>
                <label class="col-md-3 control-label" >${price.peak}</label>
            </div>
            <div class="col-md-5 form-inline">
                <label class="col-md-3 control-label" >抄表人编号：</label>
                <label class="col-md-3 control-label" >${recorder.rnid}</label>
            </div>
            <div class="col-md-5 form-inline">
                <label class="col-md-3 control-label" >抄表人姓名：</label>
                <label class="col-md-3 control-label" >${recorder.rname}</label>
            </div>
        </fieldset>
    </div>
</div>
</body>
</html>
