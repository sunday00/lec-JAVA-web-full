<%--
  Created by IntelliJ IDEA.
  User: sunday00
  Date: 2020/05/10
  Time: 5:12 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%-- this is import class --%>
<html>
<head>
    <title>Methods and inner Object</title>
</head>
<body>
    <h1>Methods and Inner Object</h1>
    <section>
        <div>
            <h2>Req and res</h2>
            <p>
                <%=
                    request.getRequestURI()
                %>
                <br />
                <%
                    StringBuffer uri = request.getRequestURL();
                    out.print(uri);
                %>
                <hr />
                <%
                    Date date = new Date();
                    out.print(date);
                %>
            </p>
        </div>
    </section>
</body>
</html>
