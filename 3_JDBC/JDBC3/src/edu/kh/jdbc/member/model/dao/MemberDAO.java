package edu.kh.jdbc.member.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.jdbc.member.model.vo.Member;
import edu.kh.jdbc.view.MainView;

public class MemberDAO {
	
	// 필드
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private Properties prop = null;
	
	// 기본 생성자
	public MemberDAO(){
		// 기본생성자에 코드 작성 이유
		// 1. xml 파일을 읽어 오는 코드의 중복을 막기 위해
		// 2. 클래스 바로 아래에 작성될 수 있는 코드는 필드, 메소드 선언 밖에 안되기 때문에
		
		try {
			// 회원 관련 SQL 작성 되어있는 xml 파일을 읽어와 prop에 저장
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("member-sql.xml"));
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
	}
	
	

	/** 로그인 DAO
	 * @param memberId
	 * @param memberPw
	 * @param conn
	 * @return member (로그인된 회원 정보)
	 * @throws Exception
	 */
	public Member login(String memberId, String memberPw, Connection conn) throws Exception{
		Member member = null;
		
		try {
			
			// SQL을 Properties 객체에서 얻어오기
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				int memberNo = rs.getInt("MEMBER_NO");
				String memberId2 = rs.getString("MEMBER_ID");
				String memberNm = rs.getString("MEMBER_NM");
				String phone = rs.getString("PHONE");
				
				member = new Member(memberNo, memberId2, memberNm, phone);
				
			}
			
		}finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		return member;
	}



	/** 아이디 중복 검사 DAO
	 * @param memberId
	 * @param conn
	 * @return result
	 * @throws Exception
	 */
	public int idDupCheck(String memberId, Connection conn) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("idDupCheck");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
				
			}
			
		}finally {
			close(rs);
			close(pstmt);
			
		}
		
		return result;
	}



	/** 회원가입 DAO
	 * @param member
	 * @param conn
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Member member, Connection conn) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("signUp");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberNm());
			pstmt.setString(4, member.getPhone());
			
			result = pstmt.executeUpdate();
			
			
		}finally {
			close(pstmt);
			
			
		}
		
		return result;
	}



	/** 내 정보 수정 DAO
	 * @param memberPw
	 * @param phone
	 * @param conn
	 * @return result
	 * @throws Exception
	 */
	public int updateMember(String memberPw, String phone, Connection conn) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("updateMember");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberPw);
			pstmt.setString(2, phone);
			pstmt.setInt(3, MainView.loginMember.getMemberNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
			
		}
		
		return result;
	}



	/** 회원 탈퇴 DAO
	 * @param memberPw
	 * @param conn
	 * @return result
	 * @throws Exception
	 */
	public int deleteMember(String memberPw, Connection conn) throws Exception{
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("deleteMember");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, MainView.loginMember.getMemberNo());
			pstmt.setString(2, memberPw);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
			
		}
		return result;
	}

}
