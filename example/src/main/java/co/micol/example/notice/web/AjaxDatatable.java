package co.micol.example.notice.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.micol.example.notice.service.ReplyService;
import co.micol.example.notice.service.ReplyVO;
import co.micol.example.notice.serviceImpl.ReplyServiceImpl;

/**
 * Servlet implementation class AjaxDataTable
 */
@WebServlet("/AjaxDatatable.do")
public class AjaxDatatable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxDatatable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, Object> map = new HashMap<>();
		
		ReplyService svc = new ReplyServiceImpl();
		List<ReplyVO> list = svc.replySelectList(6);
		
		map.put("data", list);
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(map);
		
		
		response.setContentType("text/json; charset=utf-8");
		response.getWriter().print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		ReplyService svc = new ReplyServiceImpl();
		List<ReplyVO> list = svc.replySelectList(6);
		
		String json = "{\"data\":[";
		int cnt = list.size();
		//for(int i=1; i<=75; i++) {
		for(int i = 0; i < list.size(); i++) {
			json += "[\""+list.get(i).getReplyId()+"\",\""//
		+list.get(i).getReply()+""+i+"\","//
					+"\""+list.get(i).getReplyer()+"\", \""+list.get(i).getReplyDate()+"\"]";
			if(i!= (cnt - 1)) {
				json += ",";
				
			}
		}
		json += "]}";
	}

}
