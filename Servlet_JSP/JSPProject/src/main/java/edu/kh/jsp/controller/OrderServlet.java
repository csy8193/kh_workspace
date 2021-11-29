package edu.kh.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/order")
public class OrderServlet extends HttpServlet{
	
	// Servlet : 웹 서비스를 위한 자바 클래스
	// 요청에 따른 응답 화면을 만드는 클래스
	
	// get방식 요청 처리 메소드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// HttpServletRequest : 요청(클라이언트 -> 서버)
		// -> 요청과 관련된 데이터, 정보 등을 담고있는 객체
		// ex) 파라미터, 요청방식, Context Root, 요청 주소, 요청자 ip, RequestDispatcher
		
		// HttpServletResponse : 응답(서버 -> 클라이언트)
		// -> 응답과 관련된 정보, 스트림 등을 가지고 있는 객체
		
		String pName = req.getParameter("pName");
		String price = req.getParameter("price");
		String amount = req.getParameter("amount");
		
		int total = Integer.parseInt(price) * Integer.parseInt(amount);
		
		// total을 jsp로 전달하기 위하여 HttpServletRequest에 속성으로 추가
		req.setAttribute("total", total);
		// -> 이 때, 세팅된 값의 자료형은 Object로 업캐스팅된다
		
		
		
		// 응답 화면을 JSP를 이용하여 만들기
		// 1) Servlet -> JSP로 요청 정보를 전달할 발송자 RequestDispatcher 생성
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/orderResult.jsp");
		
		// 2) RequestDispatcher를 이용하여 요청, 응답 관련 객체 전달
		dispatcher.forward(req, res);
		
		
	}
	
	// POST 방식 요청 시 처리 메소드
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// POST 방식은 문자인코딩 문제가 발생함
		// -> 문자 인코딩 변환 작업 필요
		req.setCharacterEncoding("UTF-8"); // 대소문자 구분 x
		
		// 파라미터를 얻어와 int로 변환
		int price = Integer.parseInt(req.getParameter("price"));
		int amount = Integer.parseInt(req.getParameter("amount"));
		
		// price, amount 곱연산 결과를 total이라는 키값으로 req 속성에 추가
		req.setAttribute("total", price*amount);
		
		req.getRequestDispatcher("/WEB-INF/views/orderResult.jsp").forward(req, res);
		
		
		
	}
}
