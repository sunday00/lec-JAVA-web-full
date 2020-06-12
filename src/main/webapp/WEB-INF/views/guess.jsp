<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/guess" method="post">
        <input type="number" name="answer" autofocus />
        <input type="submit" value="submit" />
    </form>
    <p>try : ${tryNumber} </p>
    <c:if test="${ok != null}">
        <h1>${tryNumber}</h1>
    </c:if>
    <c:if test="${notOk != null}">
        <c:out value="${notOk}">
            <p>${notOk}</p>
        </c:out>
    </c:if>
    <h2>history</h2>
    <c:forEach var="prev" items="${history}" varStatus="idx">
        <p><c:out value="${prev}" /></p>
    </c:forEach>
</body>
</html>
