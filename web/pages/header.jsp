<%--
  Created by IntelliJ IDEA.
  User: 沙天慧
  Date: 2020/6/21
  Time: 9:25
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+
            ":"+request.getServerPort()+path;
    String logoutUrl= basePath + "/pages/UserLoginServlet/logout" ;
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
    <script type="text/javascript">
        $(function () {
            $(".dropdown-toggle").dropdown('toggle');
        })
        function logout(){
            if (confirm("您确定要退出控制面板吗？"))
                top.location = "<%=logoutUrl%>";
            return false;
        }
    </script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-10">
            <ul class="nav nav-pills nav-tabs">
                <li ><a href="<%=basePath%>/pages/index.jsp"><span class="glyphicon glyphicon-home" ></span>&nbsp;&nbsp;主页</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">企业管理<span class="caret"></span> </a>
                    <ul class="dropdown-menu">
                        <li><a href="<%=basePath%>/pages/business/business_insert.jsp"><span class="	glyphicon glyphicon-plus-sign" ></span>&nbsp;&nbsp;增加企业</a></li>
                        <li><a href="<%=basePath%>/pages/BusinessServlet/list"><span class="	glyphicon glyphicon-th-list"></span> &nbsp;&nbsp;企业列表</a></li>
                    </ul>
                </li>
                <!--二级导航-->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">抄表人管理<span class="caret"></span> </a>
                    <ul class="dropdown-menu">
                        <li><a href="<%=basePath%>/pages/recorder/recorders_insert.jsp"><span class="	glyphicon glyphicon-plus-sign" ></span>&nbsp;&nbsp;增加抄表人</a></li>
                        <li><a href="<%=basePath%>/pages/RecorderServlet/list"><span class="	glyphicon glyphicon-th-list"></span>&nbsp;&nbsp;抄表人列表</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">电价管理<span class="caret"></span> </a>
                    <ul class="dropdown-menu">
                        <li><a href="<%=basePath%>/pages/price/price_insert.jsp"><span class="	glyphicon glyphicon-plus-sign" ></span>&nbsp;&nbsp;发布电价</a></li>
                        <li><a href="<%=basePath%>/pages/PriceServlet/list"><span class="	glyphicon glyphicon-th-list"></span>&nbsp;&nbsp;电价列表</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">企业用电管理<span class="caret"></span> </a>
                    <ul class="dropdown-menu">
                        <li><a href="<%=basePath%>/pages/useele/useele_insert.jsp"><span class="	glyphicon glyphicon-plus-sign" ></span>&nbsp;&nbsp;发布企业用电信息</a></li>
                        <li><a href="<%=basePath%>/pages/UseeleServlet/list"><span class="	glyphicon glyphicon-th-list"></span>&nbsp;&nbsp;企业用电信息列表</a></li>
                    </ul>
                </li>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                欢迎&nbsp;&nbsp;<b><font color="#6495ed"><%=session.getAttribute("uname")%></font> </b>&nbsp;登陆使用!&nbsp;&nbsp;&nbsp;
                <a href="#" target="_self" onClick="logout();"><img src="<%=basePath%>/images/out.gif" alt="安全退出" width="46" height="20" border="0"></a>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
