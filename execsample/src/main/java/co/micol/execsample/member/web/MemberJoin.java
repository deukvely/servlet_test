package co.micol.execsample.member.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.micol.execsample.common.ViewResolve;
import co.micol.execsample.member.service.MemberService;
import co.micol.execsample.member.service.MemberVO;
import co.micol.execsample.member.serviceImpl.MemberServiceImpl;

/**
 * Servlet implementation class MemberJoin
 */
@WebServlet("/memberjoin.do")
public class MemberJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberJoin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 여기다가 파일 업로드 및 데이터 관리를 한다.
		MemberService dao = new MemberServiceImpl();
		
		request.setCharacterEncoding("UTF-8");
		MemberVO vo = new MemberVO();
		String saveDir = getServletContext().getRealPath("attech/member/");
		int sizeLimit = 100*1024*1024;
		System.out.println(saveDir + "--------------------");
		MultipartRequest multi = new MultipartRequest(
				request,
				saveDir,
				sizeLimit,
				"utf-8",
				new DefaultFileRenamePolicy());
				
		String orginalFileName = multi.getOriginalFileName("file");
		if(orginalFileName != null) {
			String fileName = multi.getFilesystemName("file");
			vo.setMemberImg(fileName);
		}
		
		vo.setMemberId(multi.getParameter("memberId"));
		vo.setMemberPassword(multi.getParameter("memberPassword"));
		vo.setMemberName(multi.getParameter("memberName"));
		vo.setMemberTel(multi.getParameter("memberTel"));
		vo.setMemberAddress(multi.getParameter("memberAddress"));
		
		int n = dao.memberInsert(vo);
		if (n!=0) {
			request.setAttribute("message", "회원가입이 정상적으로 처리되었습니다.");
		} else {
			request.setAttribute("message", "회원가입이 실패하였습니다.");
		}
		
		String viewName="member/membermessage";
		ViewResolve.forward(request, response, viewName);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
