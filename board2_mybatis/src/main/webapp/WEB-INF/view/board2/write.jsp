<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
				<section id="write-form">
					<h1>글쓰기</h1>
					<div class="wrap ">
						<p class="tit">글쓰기 페이지</p>
						<form action="insert" method="post">
							<table>
								<tr>
									<td>작성자</td>
									<td>
										<input type="text" name="writer">
									</td>
								</tr>
								<tr>
									<td>제목</td>
									<td>
										<input type="text" name="subject">
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<textarea rows="5" cols="50" name="content"></textarea>
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<button type="submit">글쓰기</button>
									</td>
								</tr>
							</table>
						</form>
					</div>
				</section>
				
			</div>
		</main>
	
	</body>
</html>