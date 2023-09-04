package co.micol.example.ajax.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.micol.example.ajax.mapper.TodoMapper;
import co.micol.example.ajax.service.MembersVO;
import co.micol.example.ajax.service.TodoService;
import co.micol.example.ajax.service.TodoVO;
import co.micol.example.common.DataSources;

public class TodoServiceImpl implements TodoService {
	private SqlSession sqlSession = DataSources.getInstance().openSession(true);
	private TodoMapper map = sqlSession.getMapper(TodoMapper.class);
	@Override
	public boolean todoInsert(TodoVO vo) {
		return map.todoInsert(vo);
	}

	@Override
	public boolean todoUpdate(TodoVO vo) {
		return map.todoUpdate(vo);
	}

	@Override
	public boolean todoDelete(int todoNumber) {
		return map.todoDelete(todoNumber);
	}

	@Override
	public List<TodoVO> todoList() {
		return map.todoList();
	}

}
