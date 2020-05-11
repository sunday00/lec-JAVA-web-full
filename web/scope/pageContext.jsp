<%--
  Created by IntelliJ IDEA.
  User: sunday00
  Date: 2020/05/11
  Time: 9:00 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>scope</title>
</head>
<body>
    <% pageContext.setAttribute("alpha", "A"); %>
    <h1>hello <%=pageContext.getAttribute("alpha")%></h1>
    <p> <%=request.hashCode()%> </p>
    <div>
        <ul>
            <li><%=session.getAttribute("beta")%></li>
            <li><%=application.getAttribute("gamma")%></li>
            <li>${1+1}</li>
            <li>${'1'+1}</li>
            <li>${12 div 3}</li>
            <li>${17 mod 4}</li>
            <li>${null + 3}</li>
            <li>${"t" == 't'}</li>
        </ul>
    </div>
</body>
</html>
