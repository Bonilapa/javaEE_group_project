<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: valeriy
  Date: 28.04.18
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Hello, <c:out value="${userName}"/> :: <c:out value="${rights}"/><form method="post">
    <input type="hidden" name="dislogin" value="dislogin">
    <input type = "submit" value = "Dislogin"/>
</form>
<hr>
<form action="/import" method="POST" enctype="multipart/form-data">
    <table>
        <tr>
            <td>File to upload:</td>
            <td><input type="file" class="file" name="file"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Upload" /></td>
        </tr>
    </table>
</form>
</body>
</html>
