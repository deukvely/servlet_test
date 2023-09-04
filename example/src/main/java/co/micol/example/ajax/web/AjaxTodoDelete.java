package co.micol.example.ajax.web;

import java.io.IOException;
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
import co.micol.example.ajax.serviceImpl.TodoServiceImpl;

/**
 * Servlet implementation class AjaxTodoDelete
 */
@WebServlet("/AjaxTodoDelete.do")
public class AjaxTodoDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTodoDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String number = request.getParameter("todoNumber");
		System.out.println(Integer.parseInt(number));
		Map<String, Object> map = new HashMap<String, Object>();
		TodoService service = new TodoServiceImpl();
		
		if(service.todoDelete(Integer.parseInt(number))) {
			map.put("data", Integer.parseInt(number));
			map.put("retCode", "Success");
		} else {
			map.put("data", "데이터 삭제 도중 오류 발생");
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
