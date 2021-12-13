package edu.kh.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.semi.member.model.service.MemberService;
import edu.kh.semi.member.model.vo.Member;

@WebServlet("/member/updatePw")
public class UpdatePwServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/member/updatePw.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 암호화된 파라미터 얻어오기
		String currentPw = req.getParameter("currentPw");
		String newPw1 = req.getParameter("newPw1");
		
		HttpSession session = req.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		int memberNo = loginMember.getMemberNo();
		
		try {
			int result = new MemberService().updatePw(currentPw, newPw1, memberNo);
			
			if(result > 0) {
				session.setAttribute("message", "비밀번호가 변경되었습니다");
				resp.sendRedirect("myPage");
				
			}else {
				session.setAttribute("message", "현재 비밀번호가 일치하지 않습니다");
				resp.sendRedirect("updatePw");

			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
			req.setAttribute("errorMessage", "비밀번호 변경중 문제가 발생했습니다.");
			req.setAttribute("e", e);
			
			String path = "/WEB-INF/views/common/error.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
			
		}
	}
}
