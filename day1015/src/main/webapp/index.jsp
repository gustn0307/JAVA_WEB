 <%@page import="java.sql.Connection" %>
 <%@page import="javax.sql.DataSource" %>
 <%@page import="javax.naming.InitialContext" %>
 <%@page import="javax.naming.Context" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:scriptlet>
 Context initContext = new InitialContext();
 Context envContext = (Context)initContext.lookup("java:/comp/env");
 DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
 Connection conn=ds.getConnection();
 </jsp:scriptlet>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
안녕하세요
<%
for(int i=0; i<10; i++)
{
%>
	<p><%=i %><p>
<%	
}

%>
</body>
</html>