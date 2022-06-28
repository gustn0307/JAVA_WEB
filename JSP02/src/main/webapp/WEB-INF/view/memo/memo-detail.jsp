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
		<p>메모 상세페이지 입니다.</p>
		<div style="text-align: right;">
			<a href="<%=request.getContextPath() %>/">
				<button type="button">HOME</button>
			</a>
		</div>
		<table border="1" style="border-collapse: collapse;">
			<tr>
				<td>no</td>
				<td colspan="3">${detail.no }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${detail.writer }</td>
				<td>작성일</td>
				<td>${detail.created_date }</td>
			</tr>
			<tr>
				<td>메모내용</td>
				<td colspan="3">${detail.content }</td>
			</tr>
			<tr>
				<td colspan="4">
					<a href="#"><button>수정</button></a>
					<a href="delete?no=${detail.no }"><button>삭제</button></a>
				</td>
				
			</tr>
		</table>
	
	</body>
</html>