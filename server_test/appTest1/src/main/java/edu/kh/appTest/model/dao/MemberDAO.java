package edu.kh.appTest.model.dao;

import static edu.kh.appTest.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class MemberDAO {
	
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public boolean isEmailExist(String email) throws Exception{
		
		boolean isTrue = true;
		
		try {
			Connection conn = getConnection();
		
			//  요구사항 6. isEmailExist 함수는 전달받은 email이 member 테이블 내에 존재하는지 검사하고 그 결과를 boolean 형으로 반환한다.
			String sql = "SELECT COUNT(*) FROM MEMBER WHERE MEMBER_EMAIL = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getInt(1) == 1) {
					isTrue = true;
					
				}else {
					isTrue = false;
					
				}
			}
		}finally {
			close(rs);
			close(pstmt);
		}

		return isTrue;
	}
	
}
