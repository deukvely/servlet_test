package co.micol.example.main;

import java.util.List;

import co.micol.example.notice.service.ReplyService;
import co.micol.example.notice.service.ReplyVO;
import co.micol.example.notice.serviceImpl.ReplyServiceImpl;

public class MainExe {
	public static void main(String[] args) {
		ReplyService service = new ReplyServiceImpl();
		
		ReplyVO reply = new ReplyVO();
		reply.setNoticeId(6);
		reply.setReply("Mapper Test22");
		reply.setReplyer("kim");
		
		service.replyDelete(6);
		
		service.replyInsert(reply);
		
		service.replySelectList(6).forEach((vo) -> {		// consumer interface 익명 구현객체
			System.out.println(vo);                         // notice 아이디 6을 리스트로 받아와 forEach로 출력
		});
//		List<ReplyVO> lists = service.replySelectList(6);   // 화살표 함수 만들기 전
//		for(ReplyVO vo : lists){                            
//			System.out.println((vo));
//		}
		
	}	
}
