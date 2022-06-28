<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<%-- <link rel="stylesheet" href="${ROOT }/css/index.css"> --%>
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/index.css">
	</head>
	<body>
		<!-- header가 들어갈영역 -->
		<jsp:include page="/WEB-INF/view/common/header.jsp" />
		<main>
			<h1>컨텐츠영역</h1>
			<div class="wrap view-width">
				메인영역
			</div>
		</main>
		
		<!-- footer.jsp파일을 여기에 포함시키세요 -->
		<jsp:include page="/WEB-INF/view/common/footer.jsp" />
	</body>
</html>