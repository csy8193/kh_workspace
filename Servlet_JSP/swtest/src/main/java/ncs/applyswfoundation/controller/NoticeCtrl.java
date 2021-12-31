package ncs.applyswfoundation.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ncstest/notice.do")
public class NoticeCtrl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		execute(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		execute(req, resp);
	}
	
    // *** (요구사항1) *** //
    //     위에서 호출한 execute(req, resp); 메소드를 작성하시오.
    //     단, View단 페이지는 /WEB-INF/ncstestNotice/notice.jsp 로 한다. 
	private void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/ncstestNotice/notice.jsp");
		dispatcher.forward(req, resp);
	
	}

}