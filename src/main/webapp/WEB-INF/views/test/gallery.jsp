<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <img src="${src}" alt="" style="width: 250px;">

    <c:forEach var="img" items="${images}" varStatus="idx">
        <c:url value="/file/download/${img.name}" var="url"></c:url>
        <p><a href="${url}">${img.name}</a></p>
    </c:forEach>
</body>
</html>
