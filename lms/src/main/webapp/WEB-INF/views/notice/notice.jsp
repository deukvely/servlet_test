<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"	prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../layout/header.jsp" />
	<div align="center">
		<div>
			<h1>회원 목록</h1>
		</div>
		<div>
			<table border="1">
				<thead>
					<tr>
						<th width="100">번호</th>
						<th width="100">작성자</th>
						<th width="100">제목</th>
						<th width="100">내용</th>
						<th width="200">작성일자</th>
						<th width="300">조회수</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${boards }" var="m">
					<tr>
						<td align="center">${m.boardId }</td>
						<td align="center">${m.boardWriter }</td>
						<td align="center">${m.boardTitle }</td>
						<td align="center">${m.boardSubject }</td>
						<td align="center">${m.boardDate }</td>
						<td align="center">${m.boardHit }</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>