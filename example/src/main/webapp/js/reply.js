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
		$.getJSON('AjaxReplyList.do?noticeId='+ noticeId, function(data){
			callback(data);
		})
	}
	// callback 쓰기
	// url 매개값 받아오는 값(키 앤 벨류 파람)
	// 댓글 등록 파라미터: 게시글 번호, 댓글 내용, 댓글 작성자,  
	replyAdd(param={noticeId, reply, replyer}, callback){
		$.post('', param, function(data){
			callback(data);
		})
	}
}
 
		
		
		