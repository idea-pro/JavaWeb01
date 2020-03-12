<%--
  Created by IntelliJ IDEA.
  User: 24208
  Date: 2020/3/4
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="/JavaWeb/RegisterServlet" method="post">
    <table><%--表格--%>
        <tr><%--一行--%>
            <td>用户名</td><%--一列--%>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="text" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="确定注册"></td>
        </tr>
    </table>
</form>
<div>${requestScope.register_success}</div>
<div>${requestScope.register_error}</div>
</body>
</html>
