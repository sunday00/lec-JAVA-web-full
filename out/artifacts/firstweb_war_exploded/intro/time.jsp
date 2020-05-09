<%--
  Created by IntelliJ IDEA.
  User: sunday00
  Date: 2020/05/09
  Time: 8:47 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Introduce myself</title>
    <link rel="stylesheet" href="static/intro/global.css">
</head>
<body>
<header>
    <ul>
        <li><a href="intro">Home</a></li>
        <li><a href="intro?page=about">About</a></li>
        <li><a href="intro?page=picture">Picture</a></li>
        <li><a href="intro?page=time">WhatTime</a></li>
    </ul>
</header>
<section>
    <div class="w-80p mx-auto">
        <p>NOW TIME IS ...</p>
        <hr />
        <h1 class="mt-20">${time}</h1>
        <hr />
        <p class="mt-20"><a href="${url}">Go HOME</a></p>
    </div>
</section>
<footer>
    &copy;Sunday00 / <a href="mailto:sunday_0@hotmail.com">sunday_0@hotmail.com</a> / <a href="${url}">${ url }</a>
</footer>
</body>
</html>
