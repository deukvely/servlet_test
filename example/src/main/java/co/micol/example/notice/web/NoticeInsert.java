package co.micol.example.notice.web;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.micol.example.common.ViewResolve;
import co.micol.example.notice.service.NoticeService;
import co.micol.example.notice.service.NoticeVO;
import co.micol.example.notice.serviceImpl.NoticeServiceImpl;

@WebServlet("/noticeinsert.do")
public class NoticeInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NoticeInsert() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NoticeService dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		String saveDir = getServletContext().getRealPath("attech/notice/");
		System.out.println(saveDir+"======================================");
		int sizeLimit = 100 * 1024 * 1024; // 파일 첨부 제한

		MultipartRequest multi = new MultipartRequest(request, saveDir, sizeLimit, "UTF-8",
				new DefaultFileRenamePolicy());

		String originalFile = multi.getOriginalFileName("file");
		if (originalFile != null) {
			String fileName = multi.getFilesystemName("file");	// 물리적인 위치로 저장
			vo.setNoticeAttech(originalFile);
			vo.setNoticeAttechDirectory(saveDir + fileName);
		}
		vo.setNoticeWriter(multi.getParameter("noticeWriter"));
		vo.setNoticeDate(LocalDate.parse(multi.getParameter("noticeDate")));
		vo.setNoticeTitle(multi.getParameter("noticeTitle"));
		vo.setNoticeSubject(multi.getParameter("noticeSubject"));

		if (dao.noticeInsert(vo) != 0) {
			request.setAttribute("message", "작성 완료");
		} else {
			request.setAttribute("message", "작성 실패");
		}

		String viewName = "notice/noticemessage";
		ViewResolve.forward(request, response, viewName);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
