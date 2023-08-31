package co.micol.example.notice.service;

import java.util.List;

public interface ReplyService {
	public boolean replyInsert(ReplyVO vo);
	public boolean replyUpdate(ReplyVO vo);
	public boolean replyDelete(int replyId);
	public ReplyVO replySelect(int replyId);
	public List<ReplyVO> replySelectList(int noticeId);
}
