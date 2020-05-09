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
    <article>
        <h1>DO WHAT?</h1>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. At, deleniti dolorum fugit hic nesciunt nisi, numquam quas qui quidem saepe sequi sunt suscipit tempora tempore totam velit voluptate. Illum, tenetur.</p>
    </article>
    <article>
        <h1>Portfolio</h1>
        <ul>
            <li>
                <p><a href="${url}">${url}</a></p>
                <p>this is what you see</p>
            </li>
            <li>
                <p><a href="http://grayfield.net">http://grayfield.net</a></p>
                <p>my major homepage</p>
            </li>
            <li>
                <p><a href="https://github.com/sunday00/lec-JAVA-web-full">https://github.com/sunday00/lec-JAVA-web-full</a></p>
                <p>source for this site</p>
            </li>
        </ul>
    </article>
    <article>
        <h1>Recent Issue</h1>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Assumenda cumque delectus distinctio error exercitationem labore nostrum quae quia, unde veniam. Dolorum facilis id laborum minus pariatur quod saepe. Dolore, veritatis.</p>
    </article>
</section>
<footer>
    &copy;Sunday00 / <a href="mailto:sunday_0@hotmail.com">sunday_0@hotmail.com</a> / <a href="${url}">${ url }</a>
</footer>
</body>
</html>
