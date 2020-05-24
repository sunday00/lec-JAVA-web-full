<%--
  Created by IntelliJ IDEA.
  User: sunday00
  Date: 2020/05/24
  Time: 11:48 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>info</title>
</head>
<body>
<form action="/user/register" method="POST">
    <input type="text" name="name" />
    <input type="email" name="email" />
    <input type="number" name="age" min="1" max="120" />
    <input type="submit" value="submit" />
</form>
</body>
</html>
