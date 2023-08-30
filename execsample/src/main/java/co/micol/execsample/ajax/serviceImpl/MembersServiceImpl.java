package co.micol.execsample.ajax.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.micol.execsample.ajax.mapper.AjaxMapper;
import co.micol.execsample.ajax.service.MembersService;
import co.micol.execsample.ajax.service.MembersVO;
import co.micol.execsample.common.DataSources;

public class MembersServiceImpl implements MembersService {
	private SqlSession sqlSession = DataSources.getInstance().openSession(true);
	private AjaxMapper map = sqlSession.getMapper(AjaxMapper.class);

	@Override
	public boolean membersInsert(MembersVO vo) {
		return map.insert(vo) == 1;
	}

	@Override
	public boolean membersUpdate(MembersVO vo) {
		return map.update(vo) == 1;
	}

	@Override
	public boolean membersDelete(int mbrId) {
		return map.delete(mbrId) == 1;
	}

	@Override
	public List<MembersVO> membersList() {
		return map.list();
		
	}

}
