package edu.kh.semi.member.model.dao;

import static edu.kh.semi.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.semi.member.model.vo.Member;


// DAO(Database Access Object)
public class MemberDAO {
	
	// JDBC 객체 참조 변수
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// XML에 작성된 SQL을 얻어와 저장할 Collection 객체 참조 변수 선언
	private Properties prop;
	// Properties : key, value 가 모두 String인 Map
	
	public MemberDAO() {
      try {
          prop = new Properties();
          String filePath = MemberDAO.class.getResource("/edu/kh/semi/sql/member-query.xml").getPath();     
          // -> SQL이 작성된 XML 파일의 경로
          
          prop.loadFromXML( new FileInputStream( filePath ) );
       }catch (Exception e) {
          e.printStackTrace();
       }
		
	}

	/** 로그인 DAO
	 * @param conn
	 * @param memberId
	 * @param memberPw
	 * @return loginMember (실패시 null값 반환)
	 * @throws Exception
	 */
	public Member login(Connection conn, String memberId, String memberPw) throws Exception{
		Member loginMember = null;
		
		try {
			String sql = prop.getProperty("login");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				loginMember = new Member();
				
				loginMember.setMemberNo(rs.getInt("MEMBER_NO"));
				loginMember.setMemberId(memberId); // 전달 받은 매개변수
				loginMember.setMemberName(rs.getString("MEMBER_NM"));
				loginMember.setMemberPhone(rs.getString("MEMBER_PHONE"));
				loginMember.setMemberEmail(rs.getString("MEMBER_EMAIL"));
				loginMember.setMemberAddress(rs.getString("MEMBER_ADDR"));
				loginMember.setEnrollDate(rs.getDate("ENROLL_DT"));
				loginMember.setStatusCode(rs.getInt("STATUS_CD"));
				loginMember.setGradeCode(rs.getInt("GRADE_CD"));
				
			}
			
		}finally {
			close(rs); // rs.close()
			close(pstmt); // pstmt.close()
			
		}
		
		return loginMember;
	}

	/** 회원가입 DAO
	 * @param conn
	 * @param member
	 * @return result (1 성공)
	 * @throws Exception
	 */
	public int signUp(Connection conn, Member member) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("signUp");
			pstmt = conn.prepareStatement(sql);
			System.out.println(member);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberPhone());
			pstmt.setString(5, member.getMemberEmail());
			pstmt.setString(6, member.getMemberAddress());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
			
		}
		
		return result;
	}

	/** 아이디 중복 확인 DAO
	 * @param conn
	 * @param inputId
	 * @return
	 * @throws Exception
	 */
	public int idDupCheck(Connection conn, String inputId) throws Exception{
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("idDupCheck");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inputId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} finally {
			
			close(rs);
			close(pstmt);
		}
		
		
		return result;
	}

	/** 이메일 죽복 확인 DAO
	 * @param conn
	 * @param email
	 * @return result (1 중복)
	 * @throws Exception
	 */
	public int emailDupCheck(Connection conn, String email) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("emailDupCheck");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				result = rs.getInt(1);
			}
			
		} finally {
			close(rs);
			close(pstmt);
			
		}
		
		return result;
	}

}
