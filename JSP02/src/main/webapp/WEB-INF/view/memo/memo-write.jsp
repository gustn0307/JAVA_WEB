<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>메모장</title>
	</head>
	<body>
		<p>메모쓰기 페이지 입니다.</p>
		<div style="text-align: right;">
			<a href="<%=request.getContextPath() %>/">
				<button type="button">HOME</button>
			</a>
		</div>
		<form action="memo-reg" method="post">
			<table border="1" style="border-collapse: collapse;">
				<tr>
					<td>작성자</td>
					<td>
						<input type="text" name="writer">
					</td>
				</tr>
				<tr>
					<td>메모내용</td>
					<td >
						<textarea rows="3" cols="50" name="content"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="submit">등록</button>
						<button type="reset">취소</button>
					</td>
					
				</tr>
			</table>
		</form>
	
	</body>
</html>