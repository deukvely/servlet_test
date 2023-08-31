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

import co.micol.example.ajax.service.MembersService;
import co.micol.example.ajax.service.MembersVO;
import co.micol.example.ajax.serviceImpl.MembersServiceImpl;

/**
 * Servlet implementation class AjaxMemberList
 */
@WebServlet("/AjaxMemberList.do")
public class AjaxMemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxMemberList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MembersService service = new MembersServiceImpl();
		List<MembersVO> members = new ArrayList<MembersVO>();
		members = service.membersList();
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(members);
		
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().append(json);
		
		return;
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
