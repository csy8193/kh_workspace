package edu.kh.semi.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.semi.member.model.service.MemberService;
import edu.kh.semi.member.model.vo.Member;

// MVC Model2 패턴
// Model View Controller의 약자로
// 백엔드, 프론트를 구분해서 협업을 원할하게 진행할 수 있게 하는 디자인 패턴

// Model : 비즈니스 로직(백엔드 코드, 보이지 않는 곳에서 수행되는 로직)
// View : 모든 화면(html, jsp, 프론트엔드)
// Controller : 클라이언트의 요청을 받아들이고
// 				요청에 따라 알맞은 Service를 선택
// 				Service 결과에 따라 응답 화면 제어
// 				(요청, 응답 흐름 제어 역할)

@WebServlet("/member/login")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String memberId = req.getParameter("memberId");
		String memberPw = req.getParameter("memberPw");
		
		
		// 파라미터 확인
//		System.out.println("memberId : " + memberId);
//		System.out.println("memberPw : " + memberPw);
		
		
		// 아이디, 비밀번호를 DB로 전달하여 일치하는 회원 정보 조회 Service 호출
		try {
			// DB 연결 중 발생하는 예외를 모두 Controller에 모아서 일괄 처리
			
			// 1) Service 객체 생성
			MemberService service = new MemberService();
			
			// 2) 로그인 Service 메소드 호출 후 결과 반환 받기
			Member loginMember = service.login(memberId, memberPw);
			
			// 중간 확인
			System.out.println(loginMember);
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		
	}
}
