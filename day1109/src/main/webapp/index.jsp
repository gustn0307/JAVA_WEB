<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/* 자바코드도 사용가능 합니다만 사용하지 않을꺼에요 */
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="css/index.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script type="text/javascript">
		
		$(function(){
			$("#lnb>.wrap ul li").hover(function(){
				$(this).addClass("target");
				$("#lnb>.wrap ul li:not(.target) a").stop().animate({opacity:0.3},200);
			}, function(){
				$(this).removeClass("target");
				$("#lnb>.wrap ul li a").stop().animate({opacity:1},200);
			});
		});
		
		</script>
	</head>
	<body>
		<header id="header">
			<h1>상단메뉴</h1>
			<div class="wrap">
				<section id="h-top">
					<h1>h-top</h1>
					<div class="wrap flex between">
						<!-- ////////왼쪽 logo//////////////////////////// -->
						<section id="logo">
							<h1>gnb &emp; logo</h1>
							<div class="wrap flex">
								<div class="gnb flex column center">
									<a href="#" class="flex column center">
										<span>
											<i></i>
											<i></i>
											<i></i>
										</span>
									</a>
								</div>
								<div class="bi-logo">
									
								</div>
							</div>
						</section>
						<!-- ////////오른쪽 사용자//////////////////////////// -->
						<section id="user">
							<h1>user-menu</h1>
							<div class="wrap">
								<ul class="flex">
									<li><a href="#">로그인</a></li>
									<li><a href="member">회원가입</a></li>
								</ul>
							</div>
						</section>
					</div>
				</section>
				<section id="lnb">
					<h1>h-bottom</h1>
					<div class="wrap">
						<ul class="flex">
							<li><a href="#">소식<span>N</span></a></li>
							<li><a href="#">이벤트ON</a></li>
							<li><a href="#">가이드북<span>N</span></a></li>
							<li><a href="#">아레나 던전<span>N</span></a></li>
							<li><a href="#">커뮤니티<span>N</span></a></li>
							<li><a href="#">CM 아지트<span>N</span></a></li>
							<li><a href="#">혈맹아지트</a></li>
							<li><a href="#">미디어</a></li>
							<li><a href="#">퍼플on 플레이popup</a></li>
						</ul>
					</div>
				</section>
			</div>
		</header>
		<section id="visual">
			<h1>비주얼이미지</h1>
			<div class="wrap">
				<ul>
					<li></li>
				</ul>
			</div>
		</section>
		<footer id="footer">
			<h1>하단영역</h1>
			<div class="wrap">
				<section id="sns">
					<h1>sns</h1>
					<div class="wrap">
						<a href="#" class="facebook"></a>
						<a href="#" class="youtube"></a>
					</div>
				</section>
				<section id="link">
					<h1>link</h1>
					<div class="wrap">
						<ul class="flex center">
							<li><a href="#">회사소개</a></li>
							<li><a href="#">이용약관</a></li>
							<li><a href="#">개인정보처리방침</a></li>
							<li><a href="#">청소년 보호 정책</a></li>
							<li><a href="#">커뮤니티 정책</a></li>
							<li><a href="#">운영정책</a></li>
						</ul>
					</div>
				</section>
				<section id="copy">
					<h1>copyright</h1>
					<div class="wrap">
						<div class="info">
							<div class="flex center">
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
						<div class="copyright flex center">
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