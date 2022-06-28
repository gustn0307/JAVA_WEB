<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
		<p>멤버리스트 정보 JSTL</p>
		<hr>
		<table>
			<thead>
				<tr>
					<th>no</th>
					<th>email</th>
					<th>pass</th>
					<th>nick_name</th>
					<th>date</th>
				</tr>
			</thead>
			<tbody>
				<!-- dto: MemberDTO의 객체변수 -->
				<c:forEach var="dto" items="${list }">
				<tr>
					<td>${dto.no }</td><!-- getNo()에 의해서 데이터를 갖고옵니다 -->
					<td>${dto.email }</td>
					<td>${dto.pass }</td>
					<td><c:out value="${dto.nick_name }" /></td>
					<td>${dto.created_date }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>