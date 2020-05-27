<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>guest book</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>

<section class="container">
    <div class="jumbotron">
        <h1>Guest Book</h1>
        <p>Total count : ${ count }</p>
    </div>

    <ul class="list-group list-group-flush">
        <c:forEach items="${list}" var="guestbook">
        <li class="list-group-item"><div>
            <p>${ guestbook.id } ${ guestbook.name }</p>
            <div>${guestbook.content }</div>
            <p>${guestbook.regdate }</p>
        </div></li>
        </c:forEach>
    </ul>

    <div>
        <nav aria-label="...">
            <ul class="pagination justify-content-center">
                <li class="page-item ${param.start eq '0' or param.start == null ? 'disabled' : ''}">
                    <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
                </li>
                <c:forEach items="${pageStartList}" var="pageIndex" varStatus="status">
                <li class="page-item ${ param.start eq pageIndex ? 'active' : '' } ${ param.start == null and pageIndex == 0 ? 'active' : '' }" aria-current="page">
                    <a class="page-link" href="/list?start=${pageIndex}">${ status.index +1 }<span class="sr-only">${status.index +1 }</span></a>
                </li>
                </c:forEach>
                <li class="page-item ${pageStartList.get(pageStartList.size() - 1) eq param.start ? 'disabled' : ''}">
                    <a class="page-link" href="#">Next</a>
                </li>
            </ul>
        </nav>
    </div>

    <form method="POST" action="/write">
        <div class="form-group">
            <label for="name">name</label>
            <input type="text" name="name" class="form-control" id="name">
        </div>
        <div class="form-group">
            <label for="content">Example textarea</label>
            <textarea class="form-control" name="content" id="content" rows="10"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</section>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

</body>
</html>
