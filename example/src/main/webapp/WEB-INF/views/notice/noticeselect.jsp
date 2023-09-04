<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Custom fonts for this template-->
<link href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">
<script src="./js/jquery.min.js"></script>
<script src="//cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
	<style>
		.cheader .replyId {
			display: inline-block;
			width: 50px;
		}
		
		.cheader .replyer {
			float: right;
		}
	</style>
</head>
<body>
<div align="center">
		<div><h1>게시글 보기</h1></div>
		<div>
			<div>
				<table border="1">
					<tr>
						<th width="100">작성자</th>
						<td align="center">${n.noticeWriter }</td>
						<th width="100">작성일자</th>
						<td align="center">${n.noticeDate }</td>
						<th width="100">조회수</th>
						<td width="100" align="center">${n.noticeHit }</td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="5">${n.noticeTitle }</td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="5">
							<textarea rows="4" cols="80" readonly="readonly">${n.noticeSubject }</textarea>
						</td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td colspan="5">${n.noticeAttech }</tr>
				</table>
			</div>
			<br>
			<div>
				<c:if test="${name eq n.noticeWriter }">
					<button type="button" onclick="noticeUpdate('E')">수정</button>&nbsp;&nbsp;
					<button type="button" onclick="noticeUpdate('D')">삭제</button>&nbsp;&nbsp;
				</c:if>
			<button type="button" onclick="location.href='noticelist.do'">목록</button>
			</div>
			<div>
				<form id="frm" method="post">
					<input type="hidden" id="noticeId" name="noticeId" value="${n.noticeId}">
				</form>
			</div>	
		</div>
	</div>
	<!-- 댓글부분. -->
	<div class="addReply">
		<label>댓글내용<input type="text" name="addContent"></label>
		<label>작성자<input type="text" name="addWriter"></label>
		<button type="button" id="addBtn">추가</button>
	</div>
	<!-- /.modal -->
	<table id="example" class="display" style="width:100%">
        <thead>
            <tr>
                <th>댓글번호</th>
                <th>댓글내용</th>
                <th>작성자</th>
                <th>작성일자</th>
            </tr>
        </thead>
        <tfoot>
            <tr>
               	<th>댓글번호</th>
                <th>댓글내용</th>
                <th>작성자</th>
                <th>작성일자</th>
            </tr>
        </tfoot>
    </table>
    <script src="./js/reply.js"></script>
	<script type="text/javascript">
	
		function noticeUpdate(str) {
			if (str == 'E') {
				document.getElementById("frm").action = "noticeeditform.do";
			} else {
				document.getElementById("frm").action = "noticedelete.do";
			}
			document.getElementById("frm").submit();
		}
	</script>
	
	<script>
		var noticeId = '<c:out value="${n.noticeId}" />';
		console.log('notice: ', noticeId);
		
		//datatable 목록 만들기
		
	</script>
	<script>
		const table = new DataTable('#example', {
	        ajax: './AjaxDatatable.do',
	        columns: [
	        	{ data: 'replyId'},
	        	{ data: 'reply'},
	        	{ data: 'replyer'},
	        	{ data: 'replyDate'},
	        ]
	    });
		
		// 추가 버튼
	
		
		$('#addBtn').on('click', function(){
			var content = $('input[name=addContent]').val();
			var writer = $('input[name=addWriter]').val();
			console.log(writer)
			const reply = new Reply();
			const param={
					noticeId,
					reply:content,
					replyer:writer
			}
			reply.replyAdd(param, function(data){
				addNewRow(data.data); // data.data는 vo 객체를 가져옴
			})
		})
		function addNewRow(row) {
		    table.row
		        .add({
		        	replyId: row.replyId,
		        	reply: row.reply,
		        	replyer: row.replyer,
		        	replyDate: row.replyDate,
			})
		        .draw(false);
		}
		 
		 
		
    </script>
</body>
</html>