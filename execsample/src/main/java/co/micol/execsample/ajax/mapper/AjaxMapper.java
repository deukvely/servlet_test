package co.micol.execsample.ajax.mapper;

import java.util.List;

import co.micol.execsample.ajax.service.MembersVO;

public interface AjaxMapper {
	public int insert(MembersVO vo);
	public int update(MembersVO vo);
	public int delete(int mbrId);
	public List<MembersVO> list();
	
}
