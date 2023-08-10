<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>게시판 목록 보기</h1>
		</div>
		<div>
			<form action="" id="frm" method="post">
				<select id="key" name="key">
					<option value="title">제목</option>
					<option value="subject">내용</option>
					<option value="writer">작성자</option>
				</select>&nbsp;&nbsp;&nbsp;
				<input type="text" id="val" name="val">
				<input type="button" onclick="searchList()" value="검색">
			</form>
			<table border="1">
				<thead>
					<tr>
						<th width="100">번호</th>
						<th width="100">작성자</th>
						<th width="100">제목</th>
						<th width="300">내용</th>
						<th width="100">작성일자</th>
						<th width="100">조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${not empty boards }">
						<c:forEach items="${boards }" var="m">
							<tr>
								<td align="center">${m.boardNumber }</td>
								<td align="center">${m.boardWriter }</td>
								<td align="center">${m.boardTitle }</td>
								<td>${m.boardSubject }</td>
								<td align="center">${m.boardDate }</td>
								<td align="center">${m.boardHit }</td>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${empty boards }"></c:if>
					<tr>

						<td colspan="6" align="center">데이터가 존재하지 않습니다.</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div>
		<c:if test="${not empty id }">
			<button type="button" onclick="location.href='noticeform.do'">글쓰기</button>
		</c:if>
	</div>
</body>
</html>