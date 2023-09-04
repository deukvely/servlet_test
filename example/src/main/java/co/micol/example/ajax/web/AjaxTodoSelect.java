package co.micol.example.ajax.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class AjaxTodoSelect
 */
@WebServlet("/AjaxTodoSelect.do")
public class AjaxTodoSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTodoSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TodoService service = new TodoServiceImpl();
		List<TodoVO> vo = new ArrayList<TodoVO>();
		vo = service.todoList();
		
		Gson gson = new GsonBuilder().create();
		System.out.println(vo);
		
		response.setContentType("text/json; charset=utf-8");
		response.getWriter().print(gson.toJson(vo));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
