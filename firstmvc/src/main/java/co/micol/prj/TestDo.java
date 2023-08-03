package co.micol.prj;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test.do")
public class TestDo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public TestDo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "WEB-INF/views/member/test.jsp";
		String message = request.getParameter("me"); // me에서 홍길동이구요라는 값을 message에게 건내줌
		
		request.setAttribute("message", message); // message라는 변수를 만들고 message라는 홍길동이구요라는 값을 넘겨줌
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
//		response.sendRedirect(viewPage);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
