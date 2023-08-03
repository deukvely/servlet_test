<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@ include file="header.jsp" %>
<body>
	<div align ="center">
		<div>
			<h1>로그인 결과</h1>
		</div>
		<div>
		<h2>아이디 : ${param.id }</h2>
			<h2>아이디 : <%= request.getParameter("id") %></h2>
			<h2>패스워드 : <%= request.getParameter("password") %></h2>
			<%= request.getRequestURL() %><p> <!-- 호출 URL -->
			<%= request.getRequestURI() %><p> <!-- URI를 보여준다 -->
			<%= request.getContextPath() %><p> <!-- contextPath -->
			<%= request.getRemoteAddr() %><p> <!-- 접속한 클라이언트 주소 -->
		</div>
		<a href = "index.jsp">홈 가기</a>
	</div>
</body>
<%@ include file="footer.jsp" %>
</html>