package ncs.memberList.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncs.memberList.model.MemberVO;
import ncs.memberList.model.NcsMemberDAO;

@WebServlet("/ncstest/memberList.do")
public class NcsMemberListCtrl extends HttpServlet {
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		execute(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		execute(req, resp);
	}

	private void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// *** (요구사항9) ncstest_member 테이블에 입력된 모든 회원정보가 보여지도록 하시오 *** //
		NcsMemberDAO dao = new NcsMemberDAO();
		
		try {
			List<MemberVO> memberList = dao.memberVOList();
			req.setAttribute("memberList", memberList);
			

			String path = "/WEB-INF/ncstestMember/memberVOList.jsp";
			req.getRequestDispatcher(path).forward(req, resp);

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
