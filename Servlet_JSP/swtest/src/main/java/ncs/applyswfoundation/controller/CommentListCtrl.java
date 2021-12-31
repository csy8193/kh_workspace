package ncs.applyswfoundation.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;

import com.google.gson.Gson;

import ncs.applyswfoundation.model.*;

@WebServlet("/ncstest/commentList.do")
public class CommentListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		execute(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		execute(req, resp);
	}
	
	@SuppressWarnings("unchecked") // 경고 삭제 어노테이션
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		InterNoticeDAO dao = new NoticeDAO();
		                	
        //JSONArray jsArr = new JSONArray();
		
		try {
			List<CommentVO> commentVOList = dao.commentVOList();
			
			if(commentVOList != null && commentVOList.size() > 0) {
				
				// *** (요구사항7) *** //
				// [원본 문제 요구사항]
				// JSONObject 객체 js 를 생성한다.
				// CommentVO vo 에서 댓글내용을 꺼내와서 js 에 키이름을 "commentContents" 으로 저장시킨다.
				// CommentVO vo 에서 댓글작성날짜를 꺼내와서 js 에 키이름을 "writeDate" 으로 저장시킨다. 
				// js를 JSONArray jsArr 에 저장시킨다. 	
				
				// [수정된 문제 요구 사항]
				// Gson 타입 객체 gson을 생성
				Gson gson = new Gson();
				
				
				
				// *** (요구사항8) *** //
				// [원본 문제 요구사항]
				// JSONArray jsArr 를 String 타입으로 바꾸어서 문자열 변수 result 에 저장시킨다.
				// 문자열 변수 result에 저장된 값을 키이름을 "result" 으로 하여 request 영역으로 넘긴다.
				
				// [수정된 문제 요구 사항]
				// Gson gson을 String 타입으로 바꾸어서 문자열 변수 result 에 저장시킨다.
				// 문자열 변수 result에 저장된 값을 키이름을 "result" 으로 하여 request 영역으로 넘긴다.
				
				String result = gson.toJson(commentVOList);
				
				request.setAttribute("result", result);
			}
			
			
			
			// *** (요구사항9) *** //
			// request 영역으로 넘겨진 데이터를 View단 페이지 /WEB-INF/ncstestNotice/commentList.jsp 에서 보여지도록 한다.
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ncstestNotice/commentList.jsp");
			dispatcher.forward(request, response);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		


	}

}