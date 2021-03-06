package edu.kh.servlet.model.service;

import static edu.kh.servlet.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.servlet.model.dao.MemberDAO;
import edu.kh.servlet.model.vo.Member;

public class MemberService {
	
	private MemberDAO dao = new MemberDAO();

	/** 회원가입 Service
	 * @param member
	 * @return result (1 성공)
	 * @throws Exception
	 */
	public int signUp(Member member) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.signUp(conn, member);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}
	
	
}
