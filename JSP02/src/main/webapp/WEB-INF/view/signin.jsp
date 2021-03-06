<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
		<link rel="stylesheet" href="css/signin.css">
	</head>
	<body>
		<main>
			<h1>로그인페이지</h1>
			<div class="wrap">
				<c:if test="${not empty logMsg }">
				<p class="log-msg">
					${logMsg }<!-- el이용하면 null값일때는 view에서 확인않됨 -->
				</p>
				</c:if>
				<section id="logo">
					<h1>로고</h1>
					<div class="wrap">
						<a href="<%=request.getContextPath() %>/"><img alt="" src="images/bi-plaync.svg"></a>
					</div>
				</section>
				<section id="login-form">
					<h1>로그인폼</h1>
					<div class="wrap">
						<p>
							<i class="fas fa-globe"></i>
							<span>국가선택></span>
						</p>
						<form>
							<div class="style_box flex account">
								<select>
									<option>통합계정</option>
									<option>리니지</option>
									<option>리니지2</option>
								</select>
								<input type="text" placeholder="아이디 또는 이메일">
							</div>
							<div >
								<input class="style_box" type="password" placeholder="비밀번호">
							</div>
							<div class="submit-btn">
								<button  class="style_btn" type="submit">로그인</button>
							</div>
							<div class="phone-login">
								<i class="fas fa-phone-alt"></i>
								<button class="style_box" type="button">전화번로 로그인</button>
							</div>
						</form>
					</div>
				</section>
				<section id="other-login">
					<h1>다른계정로그인</h1>
					<div class="wrap">
						<p>다음 계정으로 로그인</p>
						<ul class="grid-container">
							<li><a href="#">구글</a></li>
							<li><a href="#">페이스북</a></li>
							<li><a href="#">애플</a></li>
							<li><a href="#">트위터</a></li>
							<li><a href="#">라인</a></li>
							<li><a href="#">vk</a></li>
						</ul>
					</div>
				</section>
				<section id="account-info">
					<h1>계정정보</h1>
					<div class="wrap">
						<ul class="flex center">
							<li><a href="#">계정찾기</a></li>
							<li><a href="#">비밀번호 찾기</a></li>
							<li><a href="#">회원가입</a></li>
						</ul>
					</div>
				</section>
			</div>
		</main>
		<aside>
			<h1>구글</h1>
			<div class="wrap">
				<p>This site is protected by reCAPTCHA and the Google</p>
				<p><a href="#">Privacy Policy</a> and <a href="#">Terms of Service</a> apply.</p>
			</div>
		</aside>
	</body>
</html>