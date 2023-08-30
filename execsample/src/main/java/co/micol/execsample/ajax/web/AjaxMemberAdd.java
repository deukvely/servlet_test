package co.micol.execsample.ajax.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.micol.execsample.ajax.service.MembersService;
import co.micol.execsample.ajax.service.MembersVO;
import co.micol.execsample.ajax.serviceImpl.MembersServiceImpl;

/**
 * Servlet implementation class AjaxMemberAdd
 */
@WebServlet("/AjaxMemberAdd.do")
public class AjaxMemberAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxMemberAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String age = request.getParameter("age"); // json에선 이렇게 값을 못 가져옴
		
		// json 문자열
		ServletInputStream sis = request.getInputStream();
		byte[] buf = new byte[100];
		
		StringBuffer sb = new StringBuffer();
		while(true) {
			int size = sis.read(buf);
			if(size == -1) {
				break;
			}
			sb.append(new String(buf, 0, size));
		}
//		System.out.println(sb.toString());
		String json = sb.toString();
		
		JSONParser parser = new JSONParser();
		JSONObject obj = null;
		try {
			obj = (JSONObject) parser.parse(json);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		no = (String) obj.get("no");
		name = (String) obj.get("name");
		phone = (String) obj.get("phone");
		age = (String) obj.get("age");
		
		MembersVO vo = new MembersVO(Integer.parseInt(no), name, phone, Integer.parseInt(age));
		MembersService service = new MembersServiceImpl();
//		{"retCode": "Success", "result": vo}
//		{"retCode": "Fail", "result": "등록 중 에러"}
		Map<String, Object> map = new HashMap<>();
		
		if (service.membersInsert(vo)){
			map.put("retCode", "Success");
			map.put("result", vo);
		} else {
			map.put("retCode", "Fail");
			map.put("result", "등록 중 에러");
		}
		
		Gson gson = new GsonBuilder().create();
		json = gson.toJson(map);
		
		response.setContentType("text/json; charset=utf-8");
		response.getWriter().print(json);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
