<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: valeriy
  Date: 11.04.18
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Start page</title>
  </head>
  <body>
  Hello, <c:out value="${userName}"/> :: <c:out value="${rights}"/><hr>
  <p>Map:</p>
  <p><a href="/hello" method="get" name="getDescription" value="hello">Index</a></p>
  <p><a href="/editAdmin" method="get" name="getDescription" value="editUsers">Edit user rights</a></p>
  <p><a href="/auth" method="get" name="getDescription" value="login">Login</a></p>
  <p><a href="/reg" method="get" name="getDescription" value="Register">Register</a></p>

  <div>
    <c:out value="${errorMessage}"></c:out>
  </div>
  </body>
</html>
