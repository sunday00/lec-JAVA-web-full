<%--
  Created by IntelliJ IDEA.
  User: sunday00
  Date: 2020/05/12
  Time: 9:04 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="simples.SimpleAco" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<c:import url="http://localhost:8080/firstweb_war_exploded/jstl/variables.jsp" var="nnn" scope="request">
    <c:param name="name" value="p" />
</c:import>
<%
    SimpleAco simpleAco = new SimpleAco();
    request.setAttribute("aco", simpleAco);

    request.setAttribute("bobo", "coco");
%>
<c:set var="color" scope="session" value="red" />
<c:set target="${aco}" property="bno" value="4" />
<c:set target="${aco}" property="cool" value="foo" />
<html>
<head>
    <title>JSTL</title>
</head>
<body>
    <h1>JSTL EXAMPLE</h1>
    <section>
        <ul>
            <li>${color}</li>
            <c:remove var="color" scope="session" />
            <li>${color}</li>
            <li>${aco.bno}</li>
            <c:if test="${aco.cool == 'foo'}" >
            <li>cool</li>
            </c:if>

            <c:choose>
                <c:when test="${aco.cool == 'bar'}">
                    <li>bar</li>
                </c:when>
                <c:when test="${aco.cool == 'baz'}">
                    <li>baz</li>
                </c:when>
                <c:otherwise>
                    <li>foo</li>
                </c:otherwise>
            </c:choose>
        </ul>
    </section>

<%
    List<String> list = new ArrayList<String>();
    list.add("red");
    list.add("green");
    list.add("blue");

    request.setAttribute("colors", list);
%>

    <section>
        <ul>
            <c:forEach items="${colors}" var="color">
                <li>${color}</li>
            </c:forEach>

            <li>${nnn}</li>
        </ul>
    </section>

    <section>
        <ul>
            <li>

            </li>
        </ul>
    </section>
</body>
</html>
