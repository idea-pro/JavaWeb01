<%--
  Created by IntelliJ IDEA.
  User: 24208
  Date: 2020/3/4
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script>
    <%--时间戳来点击更换验证码图片--%>
        window.onload=function(){
            document.getElementById("img").onclick=function () {
                this.src = "/JavaWeb/CheckCodeServlet?time" + new Date().getTime();
            }
        }
    </script>
</head>
<body>

<h1>请登录:</h1>
<form action="/JavaWeb/LoginServlet" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="text" name="password"></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td><input type="text" name="checkcode"></td>
        </tr>
        <tr>
            <td colspan="2"><img id="img" src="/JavaWeb/CheckCodeServlet" alt=""></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"></td>
        </tr>
    </table>
</form>
<div>${requestScope.login_error}</div>
<div>${requestScope.checkcode_error}</div>
</body>
</html>
