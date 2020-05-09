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
<section class="text-left p-20">
    <article class="top text-left w-80p mx-auto">
        <div class="float-left w-20p">
            <img class="w-150 h-150 border" src="https://via.placeholder.com/150/1232C4/FFFFFF?text=pic1" alt="pic1">
        </div>
        <div class="float-right w-80p">
            <p>2020.05.09</p>
            <p>Lorem ipsum dolor sit amet,</p>
            <p>consectetur adipisicing elit.</p>
            <p>Adipisci aliquam aperiam autem commodi consequatur consequuntur debitis dignissimos dolore dolorem dolores doloribus, enim eum harum nihil non, qui, quos soluta voluptate.</p>
        </div>
    </article>
    <hr />
    <article class="bottom text-left w-80p mx-auto">
        <div class="float-left w-20p">
            <img class="w-150 h-150 border" src="https://via.placeholder.com/150/f43734/FFFFFF?text=pic2" alt="pic2">
        </div>
        <div class="float-right w-80p">
            <p>2020.05.08</p>
            <p>Lorem ipsum dolor sit amet, m harum nihil non, qui...</p>
            <p>consectetur adipisicing elit.  consequuntur debitis dignissimos d.</p>
            <p>Adipisci aliquam aperiam autem commodi consequaturolore dolorem dolores doloribus, enim eu, quos soluta voluptate.</p>
        </div>
    </article>
</section>
<footer>
    &copy;Sunday00 / <a href="mailto:sunday_0@hotmail.com">sunday_0@hotmail.com</a> / <a href="${url}">${ url }</a>
</footer>
</body>
</html>
