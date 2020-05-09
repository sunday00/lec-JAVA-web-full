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
        <div class="top mt-20">
            <h1>Full Stack Developer Sunday00</h1>
            <p>I'm working in maintenance School homepage service company.<br />Now living in Su-won</p>
        </div>
        <div class="middle">
            <div class="float-left"><a href="intro?page=about">About</a></div>
            <div class="float-right"><a href="intro?page=picture">Picture</a></div>
        </div>
        <div class="bottom">
            <img src="https://via.placeholder.com/150/1232C4/FFFFFF?text=MAP" alt="map">
        </div>
    </section>
    <footer>
        &copy;Sunday00 / <a href="mailto:sunday_0@hotmail.com">sunday_0@hotmail.com</a> / <a href="${url}">${ url }</a>
    </footer>
</body>
</html>
