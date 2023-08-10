package co.micol.execsample.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.micol.execsample.board.service.BoardVO;

public interface BoardMapper {
	List<BoardVO> boardSelectList();
	List<BoardVO> boardSelectList(@Param("key") String key, @Param("val") String val); // 검색
	
	List<BoardVO> boardSearchList(@Param("key") String key, @Param("val") String val); // 검색
	BoardVO boardSelect(BoardVO vo);
	int boardInsert(BoardVO vo);
	int boardUpdate(BoardVO vo);
	int boardDelete(BoardVO vo);
	
	void boardUpdateHit(int id); // 조회수 증가
}
