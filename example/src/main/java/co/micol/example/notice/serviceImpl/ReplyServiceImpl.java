package co.micol.example.notice.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.micol.example.common.DataSources;
import co.micol.example.notice.map.ReplyMapper;
import co.micol.example.notice.service.ReplyService;
import co.micol.example.notice.service.ReplyVO;

public class ReplyServiceImpl implements ReplyService {
	private SqlSession sqlSession = DataSources.getInstance().openSession(true);
    private ReplyMapper map = sqlSession.getMapper(ReplyMapper.class);
    
	@Override
	public boolean replyInsert(ReplyVO vo) {
		return map.replyInsert(vo) == 1;
	}

	@Override
	public boolean replyUpdate(ReplyVO vo) {
		return map.replyUpdate(vo) == 1;
	}

	@Override
	public boolean replyDelete(int replyId) {
		return map.replyDelete(replyId) == 1;
	}

	@Override
	public ReplyVO replySelect(int replyId) {
		return map.replySelect(replyId);
	}

	@Override
	public List<ReplyVO> replySelectList(int noticeId) {
		return map.replySelectList(noticeId);
	}

}
