package co.san.example.member.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.san.example.common.ViewResolve;
import co.san.example.member.service.MemberService;
import co.san.example.member.service.MemberVO;
import co.san.example.member.serviceImpl.MemberServiceImpl;

@WebServlet("/memberlogin.do")
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberLogin() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession();

		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPassword(request.getParameter("memberPassword"));

		vo = dao.memberSelect(vo); // 값이없으면 null 반환

		if (vo != null) {
			session.setAttribute("id", vo.getMemberId());
			session.setAttribute("name", vo.getMemberName());
			session.setAttribute("author", vo.getMemberAuthor());
			// session :전역변수 (전 JSP에서 사용가능).

			request.setAttribute("message", vo.getMemberName() + "님 환영합니다.");
		} else {
			request.setAttribute("message", "아이디 또는 패스워드가 틀립니다.");
		}

		String viewName = "member/membermessage";
		ViewResolve.forward(request, response, viewName);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
