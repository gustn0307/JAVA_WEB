<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="js/signup.js"></script>
		<link rel="stylesheet" href="css/signup.css">
	</head>
	<body>
	 	<header>
	 		<h1>상단</h1>
	 		<div class="wrap flex column center">
	 			<div>
		 			<a href="home">
		 				<span></span>
		 			</a>
	 			</div>
	 		</div>
	 	</header>
	 	<main>
	 		<h1>메인</h1>
	 		<div class="wrap">
	 			<div class="tit">
	 				<p>정보 입력</p>
	 				<span>계정 정보를 입력해 주세요.</span>
	 			</div>
	 			<form action="member-reg" method="post">
	 				<div class="email">
	 					<div class="flex">
			 				<input class="style_box" type="email"  placeholder="계정 (이메일)" id="email" name="email">
			 				<button type="button">인증메일 발송</button>
		 				</div>
		 				<p class="result"></p>
	 				</div>
	 				<div class="sec">
	 					<p><i class="fas fa-exclamation-circle"></i><span>보안 안내</span></p>
	 				</div>
	 				<div>
		 				<input disabled="disabled" class="style_box" type="password" placeholder="비밀번호" name="pass" id="pass">
		 				<p class="msg">8 ~ 16자 영문 대소문자, 숫자, 특수문자를 조합해 주세요.</p>
		 				<p class="error"></p>
	 				</div>
	 				<div>
		 				<input disabled="disabled" class="style_box" type="password" placeholder="비밀번호 확인"  id="pass2">
		 				<p class="msg">비밀번호를 한번 더 입력해 주세요.</p>
		 				<p class="error"></p>
	 				</div>
	 				<div>
		 				<input type="submit" value="회원가입" id="btn-submit" disabled="disabled">
	 				</div>
	 			</form>
	 			
	 			
	 			
	 		</div>
	 	</main>
	 	<footer>
			<h1>하단영역</h1>
			<div class="wrap">
				<section id="lang">
					<h1>lang</h1>
					<div class="wrap flex center">
		 				<select class="style_box">
		 					<option>한국어</option>
		 					<option>English</option>
		 					<option>日本語</option>
		 				</select>
	 				</div>
	 			</section>
				<section id="link">
					<h1>link</h1>
					<div class="wrap">
						<ul class="flex center">
							<li><a href="#">회사소개</a></li>
							<li><a href="#">이용약관</a></li>
							<li><a href="#"><strong>개인정보처리방침</strong></a></li>
							<li><a href="#"><strong>청소년 보호 정책</strong></a></li>
							<li><a href="#">운영정책</a></li>
							<li><a href="#">정보주체의 권리보장</a></li>
							<li><a href="#">고객지원</a></li>
						</ul>
					</div>
				</section>
				<section id="copy">
					<h1>copyright</h1>
					<div class="wrap">
						<div class="info line">
							<div class="flex center ">
								<dl>
									<dt>상호</dt>
									<dd>(주)엔씨소프트</dd>
								</dl>
								<dl>
									<dt>대표</dt>
									<dd>김택진</dd>
								</dl>
								<dl>
									<dt>사업자 등록번호</dt>
									<dd>144-85-04244</dd>
								</dl>
								<dl>
									<dt>통신판매업신고</dt>
									<dd>제2013-경기성남-1268호</dd>
								</dl>
								<p>
									<a href="#">사업자정보확인</a>
								</p>
							</div>
							<div class="flex center">
								<dl>
									<dt>주소</dt>
									<dd>경기도 성남시 분당구 대왕판교로 644번길 12 모바일게임</dd>
								</dl>
								<dl>
									<dt>고객상담</dt>
									<dd>1566-7004</dd>
								</dl>
								<dl>
									<dt>팩스</dt>
									<dd>02-2186-3499</dd>
								</dl>
								<dl>
									<dt>이메일</dt>
									<dd>credit@ncsoft.com</dd>
								</dl>
							</div>
						</div>
						<div class="copyright flex center line">
							<p>Copyright &copy; NCSOFT Corporation. All Rights Reserved</p>
						</div>
						<div class="footer-logo flex center">
							<a href="#" class="f-logo"></a>
							<span></span>
							<a href="#" class="sword"></a>
						</div>
					</div>
				</section>
			</div>
		</footer>
	</body>
</html>