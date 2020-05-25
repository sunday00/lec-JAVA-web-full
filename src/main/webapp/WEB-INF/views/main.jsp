<%@ page import="org.springframework.core.io.ResourceLoader" %><%--
  Created by IntelliJ IDEA.
  User: sunday00
  Date: 2020/05/25
  Time: 9:46 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello layered Design</title>
    <link rel="stylesheet" href="/css/main.css">
</head>
<body>
    <h1>This is main</h1>
<% response.sendRedirect("/guest/list"); %>
</body>
</html>
