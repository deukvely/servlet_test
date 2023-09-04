package co.micol.example.ajax.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.micol.example.ajax.service.TodoService;
import co.micol.example.ajax.service.TodoVO;
import co.micol.example.ajax.serviceImpl.TodoServiceImpl;

/**
 * Servlet implementation class AjaxTodoInsert
 */
@WebServlet("/AjaxTodoInsert.do")
public class AjaxTodoInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTodoInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String todo = request.getParameter("todo");
		String date = request.getParameter("dueDate");
		
		
		TodoVO vo = new TodoVO();
		vo.setTodo(todo);
		vo.setComplete("false");
		
		boolean isConvert = true;
		
		// date가 해당 format에 맞지 않으면 오류 발생 - try/catch 예외처리
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date convertDate = format.parse(date);
			vo.setDueDate(convertDate);
		} catch (ParseException e) {
			isConvert = false;
		}
		
		Map<String, Object>map = new HashMap<String, Object>();
		TodoService service = new TodoServiceImpl();
		
		if(isConvert && service.todoInsert(vo)) {
			System.out.println("asdasdasd"+vo.getDueDate());
			map.put("data", vo);
			map.put("retCode", "Success");
		} else {
			map.put("data", "데이터 추가 도중 오류 발생");
			map.put("retCode", "Fail");
		}
		Gson gson = new GsonBuilder().create();
		response.setContentType("text/json; charset=utf-8");
		response.getWriter().append(gson.toJson(map));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
