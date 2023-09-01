/**
 * reply.js
 */
class Reply{
	notUse(){ // 사용하지 않은 것
		fetch('AjaxReplyList.do?noticeId='+noticeId) //?noticeId=6은 파라미터값으로 넘김
		.then(resolve => resolve.json())
		.then(json => {
			console.log(json);
		})
		.catch(console.log);
	}
	// 댓글 목록 가져오는 것
	replyList(noticeId, callback){
		//$.getJSON('AjaxReplyList.do?noticeId='+ noticeId, function(data){
		//	callback(data);
		//})
		
		$.ajax({
			url: 'AjaxReplyList.do?noticeId=' + noticeId,
			success: function (data){
				callback(data);
			}
		})
	}
	// callback 쓰기
	// url 매개값 받아오는 값(키 앤 벨류 파람)
	// 댓글 등록 파라미터: 게시글 번호, 댓글 내용, 댓글 작성자,  
	replyAdd(param={noticeId, reply, replyer}, callback, errorcall){
		//$.post('AjaxReplyAdd.do', param, function(data){
		//	callback(data);
		//})
		
		$.ajax({
			url: 'AjaxReplyAdd.do',
			data: param,
			success: function (data){
				callback(data);
			},
			error: function(err){
				errorcall(err);
			}
		})
	}
	// 단건 조회 param = replyId;
	replySearch(replyId, callback){
		//$.getJSON('AjaxReplySearch.do?rno='+ replyId, function(data){
		//	callback(data);
		//})
		$.ajax({
			url: 'AjaxReplySearch.do',
			success: function (data){
				callback(data);
			}
		})
	}
	
	// 수정
	replyEdit(param={replyId, reply, replyer}, callback){
		$.ajax({
			url: 'AjaxReplyUpdate.do',
			data: param,
			success: function (data){
				callback(data);
			}
		})
	}
	
	// 문자열 받아오면 -> 날짜 포멧으로 변경
	displayDateTime(dateStr){
		var mils = Date.parse(dateStr); // Aug 29, 2023, 9:16:27 AM
		var today = new Date(mils); // 날짜 함수로 변환
		console.log(today.getDate());
		
		var yyyy = today.getFullYear();
		var mm = "0"+ (today.getMonth() +1); // 01 010
		var dd = "0"+ today.getDate();
		var hh = "0"+ today.getHours();
		var mi = "0"+ today.getMinutes();
		var ss = "0"+ today.getSeconds();
		
		return yyyy + "-" + mm.slice(-2) + "-" + dd.slice(-2) + " " +
		hh.slice(-2) + ":" + mi.slice(-2) + ":" + ss.slice(-2); 
	}
}
 
		
		
		