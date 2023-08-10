package co.micol.execsample.board.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.micol.execsample.board.mapper.BoardMapper;
import co.micol.execsample.board.service.BoardService;
import co.micol.execsample.board.service.BoardVO;
import co.micol.execsample.common.DataSources;

public class BoardServiceImpl implements BoardService {
	private SqlSession sqlSession = DataSources.getInstance().openSession(true);
	private BoardMapper map = sqlSession.getMapper(BoardMapper.class);
	
	@Override
	public List<BoardVO> boardSelectList() {
		return map.boardSelectList();
	}
	
	@Override
	public List<BoardVO> boardSelectList(String key, String val) {
		return map.boardSelectList(key, val);

	}

	@Override
	public List<BoardVO> boardSearchList(String key, String val) {
		return map.boardSelectList(key, val);
	}

	@Override
	public BoardVO boardSelect(BoardVO vo) {
		boardUpdateHit(vo.getBoardNumber());
		return map.boardSelect(vo);
	}

	@Override
	public int boardInsert(BoardVO vo) {
		return map.boardInsert(vo);
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		return map.boardUpdate(vo);
	}
	
	

	@Override
	public int boardDelete(BoardVO vo) {
		return map.boardDelete(vo);
	}

	@Override
	public void boardUpdateHit(int id) {
		map.boardUpdateHit(id);
	}
}
