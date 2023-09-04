package co.micol.example.ajax.service;

import java.util.List;
// 목록 삽입 수정 삭제
public interface TodoService {
	public boolean todoInsert(TodoVO vo);
	public boolean todoUpdate(TodoVO vo);
	public boolean todoDelete(int todoNumber);
	public List<TodoVO> todoList();
}
