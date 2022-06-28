<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<header>
	<h1>상단영역</h1>
	<div class="wrap view-size flex between">
		<section>
			<h1>HOME</h1>
			<div>
				<a href="<%=request.getContextPath()%>/">HOME</a>
			</div>
		</section>
		<section id="user">
			<h1>회원메뉴</h1>
			<div class="wrap">
				<ul class="flex end">
					<li>
						<c:if test="${empty userInfo }">
						<a href="<%=request.getContextPath()%>/member/page">회원가입</a>
						</c:if>
					</li>
					<li>
						<!-- 최초 화면 또는 로그아웃 했을때 -->
						<c:if test="${empty userInfo }">
						<a href="<%=request.getContextPath()%>/member/login">로그인</a>
						</c:if>
						<!-- //로그인 성공시 화면 -->
						<c:if test="${not empty userInfo }">
						<a href="<%=request.getContextPath()%>/member/detail" >${userInfo.name }</a>님! 환영합니다.
						<a href="<%=request.getContextPath()%>/member/logout">로그아웃</a>
						</c:if>
						
					</li>
					<li><a href="#">고객센터</a></li>
				</ul>
			</div>
		</section>
	</div>
</header>