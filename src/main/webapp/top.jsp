<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: innopolis
  Date: 28.04.2018
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Top 5 employees</title>
</head>
<body>
Hello, <c:out value="${userName}"/> :: <c:out value="${rights}"/><form method="post">
    <input type="hidden" name="dislogin" value="dislogin">
    <input type = "submit" value = "Dislogin"/>
</form>
<hr>
<table>
<c:forEach items="${list}" var="user">
    <tr>
        <td><c:out value="${user.name}"/></td>
        <td><c:out value="${user.rank}"/></td>
    </tr>
</c:forEach>
</table>
</body>
</html>
