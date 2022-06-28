<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    String str="안녕하세요";
    
    pageContext.setAttribute("str2", str);
    
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css">
</head>
<body>
	<!-- header.jsp -->
	<jsp:include page="/WEB-INF/view/common/header.jsp" />
	<main>
		<h1>메인영역</h1>
		<div class="wrap view-size" style="padding: 50px 0;">
			<h2>로그인 페이지 입니다.</h2>
			<form action="<%=request.getContextPath() %>/member/log-pro" method="post">
				<ul>
					<li>
						<input type="text" name="id" placeholder="아이디">
					</li>
					<li>
						<input type="password" name="pw" placeholder="비밀번호">
					</li>
					<li>
						<hr>
						<p style="color: red;font-size: 14px;">${msg }</p>
					</li>
					<li>
						<button  type="submit">로그인</button>
					</li>
					<li>
						<a href="<%=request.getContextPath()%>/member/page">회원가입</a>
						<p>pageContext : ${str2 }</p>
					</li>
				</ul>
			</form>
		</div>
	</main>
</body>
</html>