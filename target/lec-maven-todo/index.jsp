<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="/resources/index.css">
</head>
<body>
    <header>
        <div>
            <h1>My Legacy Todo</h1>
            <i class="Design"></i>
        </div>
        <div>
            <button>New Todo</button>
        </div>
    </header>
    <div class="container">
        <section class="todo">
            <h2>TODO</h2>
        </section>
        <section class="doing">
            <h2>Doing</h2>
        </section>
        <section class="done">
            <h2>Done</h2>
        </section>
    </div>
    <script src="/resources/index.js"></script>
</body>
</html>