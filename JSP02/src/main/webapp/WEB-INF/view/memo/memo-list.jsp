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
		<p>메모장입니다.</p>
		<div style="text-align: right;">
			<a href="./memo-write">
				<button>글쓰기</button>
			</a>
		</div>
		<table>
			<thead>
				<tr>
					<td>no</td>
					<td>메모</td>
					<td>작성자</td>
					<td>작성일</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dto" items="${list }">
				<tr>
					<td>${dto.no }</td>
					<td>
					<!-- 쿼리 스트링 파라미터 : url 주소 다음에 ?name=value&name=value -->
						<a href="detail?no=${dto.no }">${dto.content }</a>
					</td>
					<td>${dto.writer }</td>
					<td>${dto.created_date }</td>
				</tr>
				</c:forEach>
				<c:if test="${empty list }">
				<tr>
					<td colspan="4">데이터가 존재 하지 않습니다.</td>
				</tr>
				</c:if>
			</tbody>
		</table>
	
	</body>
</html>