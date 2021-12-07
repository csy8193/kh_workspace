package edu.kh.semi.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.semi.member.model.service.MemberService;

@WebServlet("/member/emailDupCheck")
public class EmailDupCheckServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("inputEmail");
		
		MemberService service = new MemberService();
		
		try {
			int result = service.emailDupCheck(email);
			
			PrintWriter out = resp.getWriter();
			
			out.print(result);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			// 강제로 에러 상태를 인식 시키고
			// 에러 메세지를 전달 하기
			
			// HTTP 응답 상태 코드
			// 200 : 요청/응답 성공
			// 400 : 잘못된 요청
			// 403 : 서버가 접근을 거부
			// 404 : 요청 주소를 찾을 수 없음
			// 405 : 지정된 method(데이터 전달 방식)을 사용할 수 없음
			// 500 : 서버 내부 에러
			
			resp.setStatus(500);
			
			resp.getWriter().print( e.getMessage() );
		}
		
		
	}
}
