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
			<h1>게시글 목록</h1>
		</div>

		<div>
			<form id="searchfrm" method="post">
				<select id="key" name="key">
					<option value="title">제목</option>
					<option value="subject">내용</option>
					<option value="writer">작성자</option>
				</select>&nbsp;&nbsp;
				<input type="text" id="val" name="val">
				<input type="button" onclick="searchList()" value="검색">
			</form>
		</div>
		<div>
			<table border="1">
				<thead>
					<tr>
						<th width="70">글번호</th>
						<th width="300">제목</th>
						<th width="100">작성자</th>
						<th width="100">작성일</th>
						<th width="200">첨부파일</th>
						<th width="100">조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${not empty notices}">
						<c:forEach items="${notices}" var="m">
							<tr onmouseover="this.style.background='yellow'" onmouseout="this.style.background='white'" onclick="selectNotice('${m.noticeId}')">

								<td align="center">${m.noticeId}</td>
								<td align="center">${m.noticeTitle}</td>
								<td align="center">${m.noticeWriter}</td>
								<td align="center">${m.noticeDate}</td>
								<td align="center">${m.noticeAttech}</td>
								<td align="center">${m.noticeHit}</td>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${empty notices}}">
						<tr>
							<td colspan="6">데이터가 존재하지 않습니다.</td>
						</tr>
					</c:if>
				</tbody>


			</table>
		</div>
		<div>
			<c:if test="${not empty id}">
				<button type="button" onclick="location.href='noticeform.do'">글작성</button>
			</c:if>
		</div>
		<div>
			<form id="noticefrm" action="noticeselect.do" method="post">
				<input type="hidden" id="noticeId" name="noticeId">
			</form>
		</div>
	</div>
	<script type="text/javascript">
		function selectNotice(nid){
			document.getElementById("noticeId").value = nid;
			document.getElementById("noticefrm").submit();
		}
		
		function searchList(){
			// ajax를 이용해서 검색 결과를 가져오고 화면을 재구성한다.
			let key = document.getElementById("key").value;
			let val = document.getElementById("val").value;
			let payload = "key="+key+"&val="+val;
			let url = "ajaxnoticesearch.do";
			
			fetch(url,{
				method: "post",
				headers: { 'Content-Type' : 'application/x-www-form-urlencoded'},
				body: payload
			}).then(response => response.json())
				.then(json => htmpConvert(json));	
			  //.then(json => console.log(json));
		}
		
		function htmpConvert(datas){
			document.querySelector('tbody').remove();
			const tbody = document.createElement('tbody');
			// tbody data 추가
			tbody.innerHTML = datas.map(data => htmlView(data)).join('');
			// table tbody 추가
			document.querySelector('table').appendChild(tbody);
		}
		
		function htmlView(data){
			return `
				<tr onmouseover="this.style.background='yellow'"onmouseout="this.style.background='white'"
					onclick="selectNotice(\${data.noticeId})">

					<td align="center">\${data.noticeId}</td>
					<td align="center">\${data.noticeTitle}</td>
					<td align="center">\${data.noticeWriter}</td>
					<td align="center">\${data.noticeDate}</td>
					<td align="center">\${data.noticeAttech}</td>
					<td align="center">\${data.noticeHit}</td>
				</tr>
			`
		}
	</script>
</body>
</html>