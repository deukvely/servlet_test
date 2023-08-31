package co.micol.example.ajax.service;

import java.util.List;

public interface MembersService {
	public boolean membersInsert(MembersVO vo);
	public boolean membersUpdate(MembersVO vo);
	public boolean membersDelete(int mbrId);
	public List<MembersVO> membersList();
}
