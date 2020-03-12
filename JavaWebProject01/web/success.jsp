<%--
  Created by IntelliJ IDEA.
  User: 24208
  Date: 2020/3/4
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>柚约系统</title>
</head>
<body>
<h1>尊敬的<%=request.getSession().getAttribute("username")%>，欢迎您</h1>
<%--li有序标签，显示圆点--%>
<%--a超链接标签--%>
<li><a href="/JavaWeb/reserve.jsp">点击跳转预约界面</a></li>
</body>
</html>
