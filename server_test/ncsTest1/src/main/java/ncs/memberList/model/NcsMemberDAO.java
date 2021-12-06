package ncs.memberList.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class NcsMemberDAO {
	private DataSource ds; // DataSource ds 는 아파치톰캣이 제공하는 DBCP(DB Connection Pool) 이다.
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public NcsMemberDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private void close() {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}

			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}

			if (conn != null) {
				conn.close();
				conn = null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// *** (요구사항4) int memberRegister(MemberVO mvo) throws SQLException 메소드를 생성하시오 *** 
	public int memberRegister(MemberVO mvo) throws SQLException{
		int result = 0;
		
		try {
			conn = ds.getConnection();
			String query = "INSERT INTO NCSTEST_MEMBER VALUES(?, ?, ?, ?, DEFAULT)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mvo.getUserId());
			pstmt.setString(2, mvo.getUserName());
			pstmt.setString(3, mvo.getBirthday());
			pstmt.setInt(4, mvo.getGender());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close();
		}
		
		return result;
	}
	
	
	// *** (요구사항8) ***
	// 가입된 모든 회원정보가 보여지도록 ncs.memberList.model.NcsMemberDAO 클래스에서 메소드를 생성하는데 
	// 그 형태는 List<MemberVO> memberVOList() throws SQLException; 으로 한다.
	public List<MemberVO> memberVOList() throws SQLException {
		List<MemberVO> memberVOList = new ArrayList<MemberVO>();
		
		try {
			conn = ds.getConnection();
			String query = "SELECT USERID, USERNAME, BIRTHDAY, GENDER FROM NCSTEST_MEMBER";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO member = new MemberVO();
				
				member.setUserId(rs.getString("USERID"));
				member.setUserName(rs.getString("USERNAME"));
				member.setBirthday(rs.getString("BIRTHDAY"));
				member.setGender(rs.getInt("GENDER"));
				
				memberVOList.add(member);
				
			}
			
			
		}finally {
			close();
		}
		
		return memberVOList;
		
	}

}
