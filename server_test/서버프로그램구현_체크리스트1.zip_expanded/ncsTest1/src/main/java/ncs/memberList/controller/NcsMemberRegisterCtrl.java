package ncs.memberList.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncs.memberList.model.MemberVO;
import ncs.memberList.model.NcsMemberDAO;

@WebServlet("/ncstest/memberRegister.do")
public class NcsMemberRegisterCtrl extends HttpServlet {
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		execute(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		execute(req, resp);
	}
	
	private void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			String method = req.getMethod();

			if("GET".equalsIgnoreCase(method)) { // get 방식인 경우
				// *** (요구사항2) /WEB-INF/ncstestMember/memberRegister.jsp 페이지가 보여지도록 작성하시오. *** //
			}
			else { // post 방식인 경우

				req.setCharacterEncoding("UTF-8");
				
				String userId = req.getParameter("userId");
				String userName = req.getParameter("userName");
				String birthday = req.getParameter("birthday");
				String gender = req.getParameter("gender");

				MemberVO mvo = new MemberVO();
	
				mvo.setUserId(userId);
				mvo.setUserName(userName);
				mvo.setBirthday(birthday);
				mvo.setGender(Integer.parseInt(gender));

			try {	
				NcsMemberDAO dao = new NcsMemberDAO();
				int result = dao.memberRegister(mvo);
				
				if(result==1) {
					//*** (요구사항5) ***
					//웹브라우저에서 회원가입창을 띄우게 한 후 입력된 회원정보가 데이터베이스 ncstest_member 테이블에 입력이 성공되면
					//웹브라우저의 URL주소가 /ncstest/memberRegister.do 에서 /ncstest/memberList.do 로 이동하도록 
					//ncs.memberList.controller.NcsMemberRegisterCtrl 서블릿을 수정하시오.
				
				}
				

			} catch (SQLException e) {
				e.printStackTrace();
				
				//*** (요구사항7) ***
				//회원가입 서블릿인 ncs.memberList.controller.NcsMemberRegisterCtrl 서블릿에 
				//SQLException 이 발생시 /WEB-INF/ncstestMember/error.jsp 에 
				//"SQL문 장애발생으로 데이터 입력 실패함!!" 이라는 에러메시지가 보여지도록 
				//ncs.memberList.controller.NcsMemberRegisterCtrl 서블릿을 수정하시오.
				
			}
		}
	}

}
