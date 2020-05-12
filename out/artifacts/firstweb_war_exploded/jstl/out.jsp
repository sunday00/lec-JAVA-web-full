<%--
  Created by IntelliJ IDEA.
  User: sunday00
  Date: 2020/05/13
  Time: 12:32 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="script" value="<script> alert(\"hello script\"); </script>" scope="request" />
<html>
<head>
    <title>Title</title>
</head>
<body>
    <ul>
        <li> ${script} </li>
        <li> <c:out value="${script}" /> </li>
        <li> <c:out value="${script}" escapeXml="false" /></li>
        <li> <c:out value="${fkdshfiuaiuaenckweanclwq}" default="not setted yet" /></li>
    </ul>
</body>
</html>
