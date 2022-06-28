<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css">
</head>
<body>
	<!-- header.jsp -->
	<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
	<main>
		<h1>메인영역</h1>
		<div class="wrap view-size" style="padding: 50px 0;">
			<h2>인덱스 페이지 입니다.</h2>
		</div>
	</main>
</body>
</html>