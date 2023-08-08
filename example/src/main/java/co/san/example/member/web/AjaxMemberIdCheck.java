package co.san.example.member.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.san.example.member.service.MemberService;
import co.san.example.member.service.MemberVO;
import co.san.example.member.serviceImpl.MemberServiceImpl;

@WebServlet("/ajaxMemberIdCheck.do")
public class AjaxMemberIdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AjaxMemberIdCheck() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("id"));

		vo = dao.memberSelect(vo);
		String txt = "yes"; // 사용가능ID
		if (vo != null) {
			txt = "no"; // 중복 사용불가ID
		}
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append(txt);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
