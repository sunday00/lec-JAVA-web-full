<%--
  Created by IntelliJ IDEA.
  User: sunday00
  Date: 2020/05/10
  Time: 1:13 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JStest</title>
</head>
<body>
    <div>
        <button id="clear">clear</button>
        <button id="introduce">get Introduce page</button>
        <button id="time-page">get Time page</button>
        <button id="json">get Json page</button>
        <button id="post">post Json page</button>
    </div>

    <div id="view">

    </div>
    <script>
        function a() {
            console.log(arguments);
        }
        a(1,2,3,4);
    </script>
    <script>
        function clear() {
            document.querySelector('#view').innerHTML = '';
        }

        function get_introduce_page(){
            fetch('intro').then(function(result){
                return result.text();
            }).then(function(text){
                document.querySelector('#view').innerHTML = text
            });// fetch method returns promise object. could replace XMLHttpRequest, AJAX
        }

        function get_time_page(){
            let ajax = new XMLHttpRequest();
            ajax.addEventListener('load', function(){
                document.querySelector('#view').innerHTML = this.responseText;
            });
            ajax.open('GET','intro?page=time');
            ajax.send();
        }

        function get_json_page(){
            let ajax = new XMLHttpRequest();
            ajax.addEventListener('load', function(){
                document.querySelector('#view').innerHTML = this.responseText;
            });
            ajax.open('GET','json');
            ajax.send();
        }

        function get_post_page(){
            let ajax = new XMLHttpRequest();
            ajax.addEventListener('load', function(){
                document.querySelector('#view').innerHTML = this.responseText;
            });

            let data = {
                "kkk":"vvv",
                "lll":"bar"
            };
            ajax.open('POST','json?foo=bar');
            ajax.setRequestHeader('Content-Type', 'application/json');
            ajax.send(JSON.stringify(data));
        }

        document.querySelector('#introduce').addEventListener('click', get_introduce_page);
        document.querySelector('#time-page').addEventListener('click', get_time_page);
        document.querySelector('#json').addEventListener('click', get_json_page);
        document.querySelector('#post').addEventListener('click', get_post_page);
        document.querySelector('#clear').addEventListener('click', clear);
    </script>
</body>
</html>
