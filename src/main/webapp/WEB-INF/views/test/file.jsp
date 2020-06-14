<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form enctype="multipart/form-data" method="POST">
        <input type="file" name="file" />
        <input type="submit" />
    </form>
    <script>
        document.querySelector("input[type='file']").addEventListener("change", function (e) {
            console.log(e.target.files[0].name);
            e.target.files[0].name = e.target.files[0].name.normalize()
            console.log(e.target.files[0].name);
        })
    </script>
</body>
</html>
