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
    String listUrl = basePath + "pages/RecorderServlet/list";
    String deleteUrl=basePath+"pages/BusinessServlet/delete";
    String updateUrl=basePath+"pages/BusinessServlet/update";
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
                    <strong>企业信息列表</strong>
                </div>
                <div class="panel-body">
                    <div id="splitSearchDiv">
                        <jsp:include page="/pages/split_page_plugin_search.jsp"></jsp:include>
                        <br>
                    </div>
                    <table class="table table-striped table-bordered table-hover table-condensed table-responsive">
                        <tr class="active">
                            <td><input type="checkbox" onclick="checkboxSelect(this,'bid')"></td>
                            <td><strong>编号</strong></td>
                            <td><strong>名字</strong></td>
                            <td><strong>地址</strong></td>
                            <td><strong>法人</strong></td>
                            <td><strong>职工数</strong></td>
                            <td><strong>产值</strong></td>
                            <td><strong>联系方式</strong></td>
                            <td><strong>操作</strong></td>
                        </tr>
                        <c:forEach items="${allBusiness}" var="business">
                            <tr>
                                <td><input type="checkbox" id=bid" name="bid" value="${business.bid}"></td>
                                <td>${business.bid}</td>
                                <td>${business.bname}</td>
                                <td>${business.place}</td>
                                <td>${business.corporation}</td>
                                <td>${business.count}</td>
                                <td>${business.money}</td>
                                <td>${business.phone}</td>
                                <td>
                                    <button class="btn btn-primary"  data-backdrop="true" data-toggle="modal" data-target="#businessInfo-${business.bid}" name="btn-${business.bid}" id="btn-${business.bid}">修改</button>
                                    <div class="modal fade" id="businessInfo-${business.bid}" aria-labelledby="modalTitle" tabindex="-1">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button class="close" data-dismiss="modal">&times;</button>
                                                </div>
                                                <div class="modal-body">
                                                    <form action="<%=updateUrl%>?bid=${business.bid}" method="post" id="myForm" class="form-horizontal">
                                                        <fieldset>
                                                            <legend><label><span></span> &nbsp;修改企业信息</label></legend>
                                                            <div class="form-group" id="nameDiv">
                                                                <label class="col-md-3 control-label" for="bname">名字：</label>
                                                                <div class="col-md-5">
                                                                    <input type="text" id="bname" name="bname" class="form-control" value="${business.bname}">
                                                                </div>
                                                            </div>
                                                            <div class="form-group" >
                                                                <label class="col-md-3 control-label" for="place">地址：</label>
                                                                <div class="col-md-5">
                                                                    <input type="text" id="place" name="place" class="form-control" value="${business.place}">
                                                                </div>
                                                            </div>
                                                            <div class="form-group" >
                                                                <label class="col-md-3 control-label" for="corporation">法人：</label>
                                                                <div class="col-md-5">
                                                                    <input type="text" id="corporation" name="corporation" class="form-control" value="${business.corporation}">
                                                                </div>
                                                            </div>
                                                            <div class="form-group" >
                                                                <label class="col-md-3 control-label" for="count">职工数：</label>
                                                                <div class="col-md-5">
                                                                    <input type="text" id="count" name="count" class="form-control" value="${business.count}">
                                                                </div>
                                                            </div>
                                                            <div class="form-group" >
                                                                <label class="col-md-3 control-label" for="money">产值：</label>
                                                                <div class="col-md-5">
                                                                    <input type="text" id="money" name="money" class="form-control" value="${business.money}">
                                                                </div>
                                                            </div>
                                                            <div class="form-group" >
                                                                <label class="col-md-3 control-label" for="phone">联系电话：</label>
                                                                <div class="col-md-5">
                                                                    <input type="text" id="phone" name="phone" class="form-control" value="${business.phone}">
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <div class="col-md-5 col-md-offset-3">
                                                                    <button type="submit" class="btn  btn-primary">修改</button>
                                                                </div>
                                                            </div>
                                                        </fieldset>
                                                    </form>
                                                </div>
                                                <div class="modal-footer">
                                                    <button class="btn btn-default" data-dismiss="modal">关闭窗口</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <button class="btn btn-primary" onclick="deleteAll('<%=deleteUrl%>','ids','bid')">删除</button>
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
