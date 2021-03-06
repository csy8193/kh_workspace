package edu.kh.review.model.dao;

import static edu.kh.review.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.review.model.vo.Member;

public class ReviewDAO {
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private Properties prop = null;
	
	public ReviewDAO() {
		try {
			prop = new Properties();
			prop.loadFromXML( new FileInputStream("review-query.xml") );
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	public int signUp(Connection conn, String memberId, String memberPw, String memberName, String memberEmail) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("signUp");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			pstmt.setString(3, memberName);
			pstmt.setString(4, memberEmail);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
			
		}
		return result;
		
	}

	public List<Member> selectAll(Connection conn) throws Exception{
		List<Member> memberList = new ArrayList<Member>();
		
		try {
			String sql = prop.getProperty("selectAll");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Member member = new Member();
				member.setMemberNo(rs.getInt("MEMBER_NO"));
				member.setMemberId(rs.getString("MEMBER_ID"));
				member.setMemberName(rs.getString("MEMBER_NAME"));
				member.setMemberEmail(rs.getString("MEMBER_EMAIL"));
				
				memberList.add(member);
				
			}
			
		}finally {
			close(rs);
			close(stmt);
			
		}
		
		
		return memberList;
	}

	public Member select(Connection conn, int num) throws Exception{
		Member member = null;
		
		try {
			String sql = prop.getProperty("select");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				
				member.setMemberNo(rs.getInt("MEMBER_NO"));
				member.setMemberId(rs.getString("MEMBER_ID"));
				member.setMemberName(rs.getString("MEMBER_NAME"));
				member.setMemberEmail(rs.getString("MEMBER_EMAIL"));
			}
			
		}finally{
			close(rs);
			close(pstmt);
			
		}
		
		return member;
	}

	public int update(Connection conn, String memberId, String memberPw, String newMemberEmail) throws Exception{
		int update = 0;
		
		try {
			String sql = prop.getProperty("update");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newMemberEmail);
			pstmt.setString(2, memberId);
			pstmt.setString(3, memberPw);
			update = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
			
		}
		return update;
	}

	public int delete(Connection conn, String memberId, String memberPw) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("delete");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
			
		}
		
		return result;
	}

}
