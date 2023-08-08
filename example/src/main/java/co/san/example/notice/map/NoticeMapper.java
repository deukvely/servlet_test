package co.san.example.notice.map;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.san.example.notice.service.NoticeVO;

public interface NoticeMapper {
	
	List<NoticeVO> noticeSelectList();
	List<NoticeVO> noticeSelectList(@Param("key") String key, @Param("val") String val);
	
	List<NoticeVO> noticeSearchList(@Param("key") String key, @Param("val") String val);
	
	
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	void noticeUpdateHit(int id);
}
