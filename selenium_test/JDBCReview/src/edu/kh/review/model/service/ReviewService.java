package edu.kh.review.model.service;

import static edu.kh.review.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.review.model.dao.ReviewDAO;
import edu.kh.review.model.vo.Member;

public class ReviewService {
	
	private ReviewDAO dao = new ReviewDAO();

	public int signUp(String memberId, String memberPw, String memberName, String memberEmail) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.signUp(conn, memberId, memberPw, memberName, memberEmail);
		
		if( result > 0 ) {
			conn.commit();
			
		}else {
			conn.rollback();
			
		}
		
		conn.close();
		
		return result;
	}

	
	public List<Member> selectAll() throws Exception{
		Connection conn = getConnection();
		
		List<Member> memberList = dao.selectAll(conn);
		
		conn.close();
		
		return memberList;
	}

	public Member select(int num) throws Exception{
		Connection conn = getConnection();
		
		Member member = dao.select(conn, num);
		
		close(conn);
		
		return member;
	}

	public int update(String memberId, String memberPw, String newMemberEmail) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.update(conn, memberId, memberPw, newMemberEmail);
		
		if(result > 0) conn.commit();
		else conn.rollback();

		close(conn);
		
		return result;
	}


	public int delete(String memberId, String memberPw) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.delete(conn, memberId, memberPw);
		
		close(conn);
		
		return result;
	}
	
}
