package co.micol.execsample.board.service;

import java.util.List;

public interface BoardService {
	List<BoardVO> boardSelectList();
	List<BoardVO> boardSelectList(String key, String val); // 검색
	
	List<BoardVO> boardSearchList(String key, String val); // 검색
	BoardVO boardSelect(BoardVO vo);
	int boardInsert(BoardVO vo);
	int boardUpdate(BoardVO vo);
	int boardDelete(BoardVO vo);
	
	void boardUpdateHit(int id); // 조회수 증가
}
