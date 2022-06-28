<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="${ROOT }/css/board2/list.css">
	</head>
	<body>
		<!-- header가 들어갈영역 -->
		<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
		<main>
			<h1>컨텐츠영역</h1>
			<div class="wrap view-width">
				<p class="tit">게시판영역</p>
				<div class="btn-write">
					<a href="${ROOT }/board2/write">글쓰기</a>
				</div>
				<ul class="flex">
					<li>no</li>
					<li>제목</li>
					<li>조회수</li>
					<li>작성자</li>
					<li>작성일</li>
				</ul>
				<!-- for(Board2DTO dto :result) {} -->
				<c:forEach var="dto" items="${list }">
				<ul class="flex">
					<li>${dto.no }</li>
					<li>
						<!-- url 마지막 ?name=value&name=value -->
						<a href="detail?no=${dto.no }" >${dto.subject }</a>
					</li>
					<li>${dto.read_count }</li>
					<li>${dto.writer }</li>
					<li>
					<%@ page import="java.time.LocalDate" %>   
						<c:choose>
						
							<c:when test="${LocalDate.now() eq dto.created_date.toLocalDate()}">
								<span>
								${dto.created_date.toLocalTime() }
								</span>
							</c:when>
							<c:otherwise>
								<!-- 년월일만 출력 -->
								<span>${dto.created_date.toLocalDate() }</span>
							</c:otherwise>
						</c:choose>
					</li>
				</ul>
				</c:forEach>
			</div>
		</main>
		<!-- footer.jsp파일을 여기에 포함시키세요 -->
		<jsp:include page="/WEB-INF/view/common/footer.jsp" />
	</body>
</html>