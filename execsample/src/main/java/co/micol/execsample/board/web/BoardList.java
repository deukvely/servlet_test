package co.micol.execsample.board.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.execsample.board.service.BoardService;
import co.micol.execsample.board.service.BoardVO;
import co.micol.execsample.board.serviceImpl.BoardServiceImpl;
import co.micol.execsample.common.ViewResolve;

/**
 * Servlet implementation class BoardList
 */
@WebServlet("/boardlist.do")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService dao = new BoardServiceImpl();
		List<BoardVO> boards = new ArrayList<BoardVO>();

		
		boards = dao.boardSelectList();
		request.setAttribute("boards", boards);
		String viewName = "board/boardlist";
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
