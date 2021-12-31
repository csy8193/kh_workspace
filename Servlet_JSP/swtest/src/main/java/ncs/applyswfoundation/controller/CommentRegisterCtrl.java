package ncs.applyswfoundation.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncs.applyswfoundation.model.*;

@WebServlet("/ncstest/commentRegister.do")
public class CommentRegisterCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	private String replaceParameter(String param) {
		String result = param;

		if (param != null) {
			result = result.replaceAll("&", "&amp;");
			result = result.replaceAll("<", "&lt;");
			result = result.replaceAll(">", "&gt;");
			result = result.replaceAll("\"", "&quot;");
		}

		return result;
	}
	
	// end of private String replaceParameter(String param)----------

	private void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String commentContents = request.getParameter("commentContents");

		if (commentContents != null) {
			commentContents = this.replaceParameter(commentContents);

			CommentVO vo = new CommentVO();
			vo.setCommentContents(commentContents.replaceAll("\n", "<br/>"));

			InterNoticeDAO dao = new NoticeDAO();

			try {
				dao.addComment(vo);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
