<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Bonilapa
  Date: 26.04.2018
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Hello, <c:out value="${userName}"/> :: <c:out value="${rights}"/>
<hr>
<p>Map:</p>
<p><a href="/hello" method="get" name="getDescription" value="hello">Index</a></p>
<p><a href="/reg" method="get" name="getDescription" value="Register">Register</a></p>
Users:
<table>
    <c:forEach items="${list}" var="user">
        <tr>
            <td><c:out value="${user.login}"/></td>
            <td><c:out value="${user.rights}"/></td>
            <td>
                <form method="post">
                    <input type="hidden" name="adminRights" value="${user.id}"/>
                    <input type="submit" value="Admin"/>
                </form>
            </td>
            <td>
                <form method="post">
                    <input type="hidden" name="userRights" value="${user.id}"/>
                    <input type="submit" value="User"/>
                </form>
            </td>
            <td>
                <form method="post">
                    <input type="hidden" name="deleteUser" value="${user.id}"/>
                    <input type="submit" value="Delete"/>
                </form>
            </td>


        </tr>
    </c:forEach>
</table>

</body>
</html>
