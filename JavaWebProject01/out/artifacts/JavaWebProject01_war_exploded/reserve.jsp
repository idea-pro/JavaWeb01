<%--
  Created by IntelliJ IDEA.
  User: 24208
  Date: 2020/3/10
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>预约界面</title>
</head>
<body>
<h1>请勾选您要预约的活动种类与名称</h1>
<form action="/JavaWeb/ReserveServlet" method="post">
    <table><%--表格--%>
        <tr><%--一行--%>
            <td><input type="radio" name="kind" value="学习"/>学习</td>
            <td><input type="radio" name="kind" value="运动"/>运动</td>
        </tr>
        <tr>
            <td><input name="name" type="radio" value="篮球"/>篮球</td>
            <td><input name="name" type="radio" value="跑步"/>跑步</td>
            <td><input name="name" type="radio" value="自习"/>自习</td>
            <td><input name="name" type="radio" value="辅导"/>辅导</td>
        </tr>
        <tr>
            <td><input type="submit" value="确定预约"></td>
        </tr>
    </table>
</form>
<div>${requestScope.reserve_error}</div>
</body>
</html>


