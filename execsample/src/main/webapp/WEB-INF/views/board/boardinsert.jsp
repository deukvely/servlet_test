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
						<th width="150">작성자</th>
						<td width="300"><input type="text" size="84" id="boardWriter"
							name="boardWriter" value="${name }" readonly="readonly"></td>
							
						<th width="100">작성일자</th>
						<td><input type="date" id="boardDate" name="boardDate"
							required="required"></td>
					</tr>
					
					<tr>
						<th>제 목</th>
						<td colspan="3"><input type="text" size="84" id="boardTitle"
							required="required"></td>
					</tr>
					<tr>
						<th>내 용</th>
						<td colspan="3"><textarea rows="20" cols="60"></textarea></td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td><input type="file" id="file" name="file"></td>
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
		function NumCheck() {
			let id = document.getElementById().value;
		}function
	</script>
</body>
</html>