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
			<h1>회 원 가 입</h1>
		</div>
		<div>
			<form id="frm" onsubmit="return formCheck()" method="post">
				<div>
					<table border="1">
						<tr>
							<th width="150">아이디</th>
							<td width="250"><input type="text" id="memberId" name="memberId" required="required">&nbsp;&nbsp;
								<button type="button" id="btn" value="NoCheck" onclick="idCheck()">중복체크</button>
							</td>
						</tr>
						<tr>
							<th>패스워드</th>
							<td><input type="password" id="memberPassword" name="memberPassword" required="required"></td>
						</tr>
						<tr>
							<th>패스워드확인</th>
							<td><input type="password" id="passwordCheck" required="required"></td>
						</tr>
						<tr>
							<th>이 름</th>
							<td>
								<input type="text" id="memberName" name="memberName">
							</td>
						</tr>
						<tr>
							<th>전화번호</th>
							<td>
								<input type="text" id="memberTel" name="memberTel">
							</td>
						</tr>
						<tr>
							<th>주 소</th>
							<td>
								<input type="text" id="memberAddress" name="memberAddress">
							</td>
						</tr>
						<tr>
							<th>사 진</th>
							<td>
								<input type="file" id="file" name="file">
							</td>
						</tr>
					</table>
				</div>
				<br>
				<div>
					<input type="submit" value="회원가입">&nbsp;&nbsp;&nbsp; <input
						type="reset" value="취소">
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		function idCheck() { // ajax를 통신을 이용해서 아이디 중복체크를 한다.
			let id = document.getElementbyId("btn").value;
			// ajax 루틴 처리
			
		}
		
		function formCheck(){
			let password = frm.memberPassword.value;
			let passcheck = frm.passwordCheck.value;
			let id = document.getElementbyId("btn").value;
			if(id == 'NoCheck'){
				alert("아이디 중복체크를 하세요.");
				return false;
			}
			
			if(password != passcheck){
				alert("패스워드가 일치하지 않습니다.");
				return false;
			} else{
				frm.action = "memberlogin.do";
				return true;
			}
		}
	</script>
</body>
</html>