<%--
  Created by IntelliJ IDEA.
  User: sunday00
  Date: 2020/05/11
  Time: 10:24 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL</title>
</head>
<%
    pageContext.setAttribute("apple", "red");
    session.setAttribute("banana", "yellow");
    request.setAttribute("cherry", "dark-red");
    application.setAttribute("durian", "green");
%>
<body>
    <h1>EL</h1>
    <div>
        <ul>
            <li>${pageContext.getAttribute("apple")}</li>
            <li>${sessionScope.get("banana")} : <%=session.getAttribute("banana")%></li>
            <li>${requestScope.get("cherry")} : <%=request.getAttribute("cherry")%></li>
            <li>${applicationScope.get("durian")} : <%=application.getAttribute("durian")%></li>
        </ul>
        <ul>
            <li>${pageScope.apple}</li>
            <li>${sessionScope.banana}</li>
            <li>${requestScope.cherry}</li>
            <li>${applicationScope.durian}</li>
        </ul>
        <ul>
            <li>${apple}</li>
            <li>${banana}</li>
            <li>${cherry}</li>
            <li>${durian}</li>
        </ul>
    </div>
</body>
</html>
