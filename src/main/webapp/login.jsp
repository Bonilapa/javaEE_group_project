<%--
  Created by IntelliJ IDEA.
  User: Bonilapa
  Date: 11.03.2018
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login</title>
</head>
<body>
<form method="post" action="/auth">
  <input type="text" name="login" /><br>
  <input type="text" name="password"/><br>
  <input type="submit" value="login"/>
</form>
<form method="get" action="/reg">
<input type="submit" value="Sign up"/>
</form>
</body>
</html>