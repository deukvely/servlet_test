package co.micol.example.ajax.mapper;

import java.util.List;

import co.micol.example.ajax.service.MembersVO;
import co.micol.example.ajax.service.TodoVO;

public interface TodoMapper {
	public boolean todoInsert(TodoVO vo);
	public boolean todoUpdate(TodoVO vo);
	public boolean todoDelete(int todoNumber);
	public List<TodoVO> todoList();
}
