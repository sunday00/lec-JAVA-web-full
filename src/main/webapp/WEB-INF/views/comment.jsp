<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta name="description" content="네이버 예약, 네이버 예약이 연동된 곳 어디서나 바로 예약하고, 네이버 예약 홈(나의예약)에서 모두 관리할 수 있습니다.">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no">
    <title>네이버 예약</title>
    <link href="/css/style.css" rel="stylesheet">
</head>

<body>
<div id="container">
    <!-- [D] 예약하기로 들어오면 header에 fade 클래스 추가로 숨김 -->
    <div class="header fade">
        <header class="header_tit">
            <h1 class="logo">
                <a href="/" class="lnk_logo" title="네이버"> <span class="spr_bi ico_n_logo">네이버</span> </a>
                <a href="/" class="lnk_logo" title="예약"> <span class="spr_bi ico_bk_logo">예약</span> </a>
            </h1>
            <c:choose>
                <c:when  test="${cookie.logged.value == 'true'}" >
                    <a href="/check-reserve" class="btn_my"> <span class="viewReservation" title="예약확인">예약확인</span> </a>
                </c:when>
                <c:otherwise>
                    <a href="/booking-login" class="btn_my"> <span class="viewReservation" title="예약확인">Login</span> </a>
                </c:otherwise>
            </c:choose>
        </header>
    </div>
    <div class="ct">
        <div class="wrap_review_list">
            <div class="review_header">
                <div class="top_title gr">
                    <a href="/display/show/${id}" class="btn_back" title="이전 화면으로 이동"> <i class="fn fn-backward1"></i> </a>
                    <h2><a class="title" href="#">${display.address}</a></h2>
                </div>
            </div>
            <div class="section_review_list">
                <div class="review_box">
                    <h3 class="title_h3">예매자 한줄평</h3>
                    <div class="short_review_area">
                        <div class="grade_area"> <span class="graph_mask"> <em class="graph_value" style="width: ${count.avg / 5 * 100}%;"></em> </span> <strong class="text_value"> <span>${String.format("%.2f", count.avg)}</span> <em class="total">5.0</em> </strong> <span class="join_count"><em class="green">${count.cnt}건</em> 등록</span>                                </div>
                        <ul class="list_short_review">
                            <c:forEach var="item" items="${comment}" varStatus="idx">
                            <li class="list_item">
                                <div>
                                    <div class="review_area<c:if test="${item.image == null}"> no_img</c:if>">
                                        <c:if test="${item.image != null}">
                                            <div class="thumb_area">
                                                <a href="/img/${item.image}" class="thumb" title="이미지 크게 보기">
                                                    <img width="90" height="90" class="img_vertical_top" src="/img/${item.image}" alt="리뷰이미지">
                                                </a>
                                                <span class="img_count">1</span>
                                            </div>
                                        </c:if>
                                        <h4 class="resoc_name">${display.title}</h4>
                                        <p class="review">${item.comment}</p>
                                    </div>
                                    <div class="info_area">
                                        <div class="review_info"> <span class="grade">${item.score}</span> <span class="name">${item.user_name}</span> <span class="date">${item.create_date.year}.${item.create_date.monthValue}.${item.create_date.dayOfMonth}. 방문</span> </div>
                                    </div>
                                </div>
                            </li>
                            </c:forEach>
                        </ul>
                    </div>
                    <p class="guide"> <i class="spr_book2 ico_bell"></i> <span>네이버 예약을 통해 실제 방문한 이용자가 남긴 평가입니다.</span> </p>
                </div>
            </div>
        </div>
    </div>
    <hr> </div>
<footer>
    <div class="gototop">
        <a href="#" class="lnk_top"> <span class="lnk_top_text">TOP</span> </a>
    </div>
    <div id="footer" class="footer">
        <p class="dsc_footer">네이버(주)는 통신판매의 당사자가 아니며, 상품의정보, 거래조건, 이용 및 환불 등과 관련한 의무와 책임은 각 회원에게 있습니다.</p>
        <span class="copyright">© NAVER Corp.</span>
    </div>
</footer>

<script src="/js/app.js"></script>

</body>

</html>
