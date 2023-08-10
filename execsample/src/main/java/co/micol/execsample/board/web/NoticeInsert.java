package co.micol.execsample.board.web;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.micol.execsample.board.service.BoardService;
import co.micol.execsample.board.service.BoardVO;
import co.micol.execsample.board.serviceImpl.BoardServiceImpl;
import co.micol.execsample.common.ViewResolve;

/**
 * Servlet implementation class NoticeInsert
 */
@WebServlet("/NoticeInsert")
public class NoticeInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService dao = new BoardServiceImpl();
		BoardVO vo = new BoardVO();
		String saveDir = getServletContext().getRealPath("attech/board/");
		int sizeLimit = 100 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(
				request,
				saveDir,
				sizeLimit,
				"uft-8",
				new DefaultFileRenamePolicy());
		
		String orignalFile = multi.getOriginalFileName("file");
		if(orignalFile != null) {
			String fileName = multi.getFilesystemName("file");
			vo.setBoardAttech(orignalFile);
			vo.setBoardAttechDiv(saveDir + fileName);
			
			vo.setBoardWriter(multi.getParameter("boardWriter"));
			vo.setBoardDate(LocalDate.parse(multi.getParameter("boardDate")));
			vo.setBoardTitle(multi.getParameter("boardTitle"));
			vo.setBoardSubject(multi.getParameter("boardSubject"));
			
			int n = dao.boardInsert(vo);
			if(n==1) {
				request.setAttribute("message", "게시글이 정상적으로 입력되었습니다.");
			} else {
				request.setAttribute("message", "게시글 작성이 실패하였습니다.");
			}
			
			String viewName = "board/boardmessage";
			ViewResolve.forward(request, response, viewName);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
