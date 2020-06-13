<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>

<section class="container mx-auto flex content-center flex-wrap h-screen bg-gray-300">
    <div class="w-full max-w-xs mx-auto">
        <form class="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4" name="myForm" method="POST">
<%--            <div class="mb-4 email-sec">--%>
<%--                <label class="block text-gray-700 text-sm font-bold mb-2" for="email">--%>
<%--                    Email--%>
<%--                </label>--%>
<%--                <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" id="email" type="email" placeholder="Email">--%>
<%--                <p class="text-red-500 text-xs italic error-message"></p>--%>
<%--            </div>--%>
            <div class="mb-6 pass-sec">
                <label class="block text-gray-700 text-sm font-bold mb-2" for="password">
                    Password
                </label>
                <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 mb-3 leading-tight focus:outline-none focus:shadow-outline" id="password" name="password" type="password" placeholder="******************">
                <c:if test="${error != null}">
                    <p class="text-red-500 text-xs italic error-message text-red-400"><c:out value="${error}"></c:out></p>
                </c:if>
            </div>
            <div class="flex items-center justify-between">
                <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline" type="button">
                    Sign In
                </button>
                <a class="inline-block align-baseline font-bold text-sm text-blue-500 hover:text-blue-800" href="#">
                    Forgot Password?
                </a>
            </div>
        </form>
        <p class="text-center text-gray-500 text-xs">
            &copy;2020 Acme Corp. All rights reserved.
        </p>
    </div>
</section>

</body>
</html>
