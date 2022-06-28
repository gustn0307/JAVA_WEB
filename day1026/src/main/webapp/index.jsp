<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강현수 - 네트워크 프로그래밍 구현</title>
</head>
<body>
	<hr>
	<h1>상품등록</h1>
	<form action="<%=request.getContextPath() %>/input" method="post" >
		<p><input type="text" name="goodsName" placeholder="상품명을 입력하세요" required="required"></p>
		<p><input type="text" name="price" placeholder="가격을 입력하세요" required="required"></p>
		<p><button type="submit">입력</button></p>
	</form>
</body>
</html>