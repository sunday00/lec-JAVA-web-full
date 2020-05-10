<%--
  Created by IntelliJ IDEA.
  User: sunday00
  Date: 2020/05/10
  Time: 3:09 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sum 10</title>
</head>
<body>
    <h1>SUM 10</h1>

    <%
        int sum = 0;
        for(int i = 1; i <= 10; i++ ){
            sum += i;
        }
    %>

    <p> total : <%=sum%> </p>

    <p>
        ls ~/Library/Caches/IntelliJIdea2019.3/tomcat/Tomcat_9_0_22_firstweb<b>/work/Catalina/localhost/firstweb_war_exploded/org/apache/jsp/JSPTest</b>
    </p>
    <p>
        you can see claa, java file, even you didn't make.
    </p>

    <% System.out.println("jsp servicing"); %>

</body>
</html>

<%!
//    public void _jspInit() {
//        System.out.println("_jsp init");
//    }

    public void jspInit() {
        System.out.println("jsp init");
    }

//    public void _jspDestroy() {
//        System.out.println("_jsp destroy");
//    }

    public void jspDestroy() {
        System.out.println("jsp destroy");
    }

//    public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response) throws java.io.IOException, javax.servlet.ServletException {
//        System.out.println("_jsp servicing");
//    }

    public void jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response) throws java.io.IOException, javax.servlet.ServletException {
        System.out.println("jsp servicing");
    }

%>
