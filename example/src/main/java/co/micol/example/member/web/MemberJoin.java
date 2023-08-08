package co.micol.example.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.micol.example.common.ViewResolve;
import co.micol.example.member.service.MemberService;
import co.micol.example.member.service.MemberVO;
import co.micol.example.member.serviceImpl.MemberServiceImpl;

@WebServlet("/memberjoin.do")
public class MemberJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberJoin() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 파일 업로드 밑 데이터 관리를 한다.

		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		String saveDir = getServletContext().getRealPath("attech/member/");
		int sizeLimit = 100 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request, saveDir, sizeLimit, "UTF-8",
				new DefaultFileRenamePolicy());

		String originalFileName = multi.getOriginalFileName("file");
		if (originalFileName != null) {
			String fileName = multi.getFilesystemName("file"); // 물리적 위치에 저장.(saveDir)
			vo.setMemberImg(fileName);
		}

		vo.setMemberId(multi.getParameter("memberId"));
		vo.setMemberPassword(multi.getParameter("memberPassword"));
		vo.setMemberName(multi.getParameter("memberName"));
		vo.setMemberTel(multi.getParameter("memberTel"));
		vo.setMemberAddress(multi.getParameter("memberAddress"));

		if (dao.memberInsert(vo) != 0) {
			request.setAttribute("message", "회원가입 완료");
		} else {
			request.setAttribute("message", "회원가입 실패");
		}

		String viewName = "member/membermessage";
		ViewResolve.forward(request, response, viewName);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
