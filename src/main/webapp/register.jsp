<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Bonilapa
  Date: 09.04.2018
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>


Hello, <c:out value="${userName}"/> :: <c:out value="${rights}"/><hr>

<p>Map:</p>
<p><a href="/hello" method="get" name="getDescription" value="hello">Index</a></p>
<p><a href="/editAdmin" method="get" name="getDescription" value="editUsers">Edit user rights</a></p>
<p><a href="/auth" method="get" name="getDescription" value="login">Login</a></p>
<div>
    <c:out value="${errorMessage}"></c:out>
</div>
<body>
<form method="post" action="/reg">
    <input type="text" name="login" /><br>
    <input type="text" name="password"/><br>
    <input type="submit" value="Register"/>
</form>
</body>
</html>

