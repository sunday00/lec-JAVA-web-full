<%--
  Created by IntelliJ IDEA.
  User: sunday00
  Date: 2020/05/10
  Time: 4:20 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>syntax</title>
</head>
<body>
    <h1>Syntax</h1>
    <section>
        <div>
            <ul>
                <li>html write</li>
                <li>id = <%= getId(3) %></li>
                <li>
                    <div>
                        <ul>
                        <% for( int i=0; i<5; i++ ){ %>
                            <li> what's up <%=i+1%> ?</li>
                        <% } %>
                        </ul>
                    </div>
                </li>
            </ul>
        </div>
    </section>
    <footer>
        <%-- this will not be compiled --%>
        <% //this will not act %>
        <!-- this will not be shown -->
    </footer>
</body>
</html>

<%!
    int id = 1;

    public int getId(int arg){
        return id + arg;
    }

    public int getId(){
        return id;
    }

%>