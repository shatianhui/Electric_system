<%--
  Created by IntelliJ IDEA.
  User: 沙天慧
  Date: 2020/6/21
  Time: 9:43
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+
            ":"+request.getServerPort()+path;
%>
<html>
<head>
    <title>企业用电管理系统</title>
</head>
<body>
<jsp:include page="/pages/header.jsp"></jsp:include>
<br><br>
<div id="mainDiv">
    <div class="container">
    <div class="row">
        <div class="col-md-10">
            <div class="media">
                <a href="http://jwc.ycit.edu.cn/" class="pull-left">
                    <img src="<%=basePath%>/images/logo.jpg" style="width: 220px;height: 110px" class="media-object">
                </a>
                <div class="media-body">
                    <h4 class="media-heading"><font color="#191970" >欢迎你使用企业用电管理系统</font></h4>
                    <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本管理系统制作者为B计算机171沙天慧，如有问题或者建议，请发邮件至3272027591@qq.com。此外，特别提醒：疫情期间、必戴口罩、勤快洗手、拒吃野味、禁止聚会、不要恐慌、经常通风、注意消毒、不要熬夜、多吃果蔬、锻炼身体、不要传谣。祝你生活愉快！</p>
                </div>
            </div>
        </div>
    </div>
    </div>
</div>
</body>
</html>
