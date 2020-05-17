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
            <ul></ul>
        </section>
        <section class="doing">
            <h2>Doing</h2>
            <ul></ul>
        </section>
        <section class="done">
            <h2>Done</h2>
            <ul></ul>
        </section>
    </div>
    <div id="input-modal">
        <div class="wrap">
            <h2>New TODO</h2>
            <form action="/api/v1/todos" method="POST">
                <div class="title">
                    <label for="title" class="modal-title">Title</label>
                    <input type="text" id="title" name="title" required />
                </div>
                <div class="name">
                    <label for="name" class="modal-title">Name</label>
                    <input type="text" id="name" name="name" required />
                </div>
                <div class="sequence">
                    <p class="modal-title">Ssequence</p>
                    <label for="sequence1">sequence1</label>
                    <input type="radio" id="sequence1" name="sequence" value="1" required />
                    <label for="sequence2">sequence2</label>
                    <input type="radio" id="sequence2" name="sequence" value="2" required />
                    <label for="sequence3">sequence3</label>
                    <input type="radio" id="sequence3" name="sequence" value="3" required />
                </div>
                <div class="btns">
                    <div class="text-left">
                        <button id="cancel">cancel</button>
                    </div>
                    <div class="text-right">
                        <button id="reset">reset</button>
                        <button type="submit">submit</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <script src="/resources/index.js"></script>
</body>
</html>