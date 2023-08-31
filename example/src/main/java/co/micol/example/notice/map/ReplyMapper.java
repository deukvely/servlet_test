package co.micol.example.notice.map;

import java.util.List;

import co.micol.example.notice.service.ReplyVO;

public interface ReplyMapper {
	public int replyInsert(ReplyVO vo);
	public int replyUpdate(ReplyVO vo);
	public int replyDelete(int replyId);
	public ReplyVO replySelect(int replyId);
	public List<ReplyVO> replySelectList(int noticeId);
}
