<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
		<div>
			<h1>게시글 작성</h1>
		</div>
		<div>
			<div>
				<table border="1">
					<tr>
						<th width="150">게시판 번호</th>
						<td width="300"><input type="text" id="boardNumber" name="boardNumber" required="required">&nbsp;&nbsp;
							<button type="button" id="btn" value="NoCheck" onclick="numCheck()">중복체크</button></td>
					</tr>
					<tr>
						<th>제 목</th>
						<td><input type="text" id="boardTitle" required="required"></td>
					</tr>
					<tr>
						<th>내 용</th>
						<td><input type="text" id="boardSubject" name="boardSubject">
						</td>
					</tr>
					<tr>
						<th>날 짜</th>
						<td><input type="text" id="boardDate" name="boardDate">
						</td>
					</tr>
				</table>
			</div>
			<br>
			<div>
				<input type="submit" value="등록">&nbsp;&nbsp;&nbsp; <input
					type="reset" value="취소">
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function NumCheck(){
			let id = document.getElementById().value;
		}
		
		function 
	</script>
</body>
</html>