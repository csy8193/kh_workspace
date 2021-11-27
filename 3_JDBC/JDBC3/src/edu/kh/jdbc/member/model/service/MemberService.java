package edu.kh.jdbc.member.model.service;

// static import
import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.jdbc.member.model.dao.MemberDAO;
import edu.kh.jdbc.member.model.vo.Member;
import edu.kh.jdbc.view.MainView;

public class MemberService {
	
	// 필드
	private MemberDAO dao = new MemberDAO();

	
	/** 로그인 Service
	 * @param memberId
	 * @param memberPw
	 * @return member
	 * @throws Exception
	 */
	public Member login(String memberId, String memberPw) throws Exception{
		
		Connection conn = getConnection();
		
		Member member = dao.login(memberId, memberPw, conn);
		
		close(conn);
		
		return member;
	}


	/** 아이디 중복 검사 Service
	 * @param memberId
	 * @return result
	 * @throws Exception
	 */
	public int idDupCheck(String memberId) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.idDupCheck(memberId, conn);
		
		close(conn);
		
		return result;
	}


	/** 회원가입 Service
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Member member) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.signUp(member, conn);
		
		if(result > 0) commit(conn);
		else rollback(conn);
			
		close(conn);
		
		return result;
	}


	/** 내 정보 수정 Service
	 * @param memberPw
	 * @param phone
	 * @return result
	 * @throws Exception
	 */
	public int updateMember(String memberPw, String phone) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.updateMember(memberPw, phone, conn);
		
		if(result > 0) {
			commit(conn);
			MainView.loginMember.setPhone(phone);
		}
		else rollback(conn);
		
		close(conn);
		
		return result;
	}


	/** 회원 탈퇴 Service
	 * @param memberPw
	 * @return result
	 * @throws Exception
	 */
	public int deleteMember(String memberPw) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.deleteMember(memberPw, conn);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

}
