<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<header>
	<h1>상단영역</h1>
	<div class="wrap view-width">
		<ul class="flex between">
			<li><a href="<%=request.getContextPath() %>/">HOME</a></li>
			<li><a href="${ROOT }/board2/list">게시판</a></li>
			<li><a href="#">메뉴3</a></li>
			<li><a href="#">메뉴4</a></li>
		</ul>
	</div>
</header>