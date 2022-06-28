<%@page import="domain.dto.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<MemberDTO> result=(List<MemberDTO>)request.getAttribute("list");
%>    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
		<p>멤버리스트 정보</p>
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
				<%
				for(MemberDTO dto :result){
				%>
				<tr>
					<td><%=dto.getNo() %></td>
					<td><%=dto.getEmail() %></td>
					<td><%=dto.getPass() %></td>
					<td><%=dto.getNick_name() %></td>
					<td><%=dto.getCreated_date() %></td>
				</tr>
				<%} %>
			</tbody>
		</table>
	</body>
</html>