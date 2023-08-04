package co.micol.lms.member.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.lms.common.ViewResolve;
import co.micol.lms.member.servicImpl.MemberServiceImpl;
import co.micol.lms.member.service.MemberService;
import co.micol.lms.member.service.MemberVO;

/**
 * Servlet implementation class MemberList
 */
@WebServlet("/memberlist.do")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService dao = new MemberServiceImpl();
		List<MemberVO> members = new ArrayList<MemberVO>();
		members = dao.memberSelectList();
		
		request.setAttribute("members", members);
		String viewName = "member/memberlist";
		ViewResolve.forword(request, response, viewName);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
