package edu.kh.project.user.model.dao;

import static edu.kh.project.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.project.game.model.vo.Game;
import edu.kh.project.user.model.vo.User;
import edu.kh.project.view.LoginView;


public class UserDAO {
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Properties prop = null;
	
	
	public UserDAO() {
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("user-sql.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/** 아이디 존재 확인 DAO
	 * @param userId
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public int checkId(String userId, Connection conn) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("checkId");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
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
	 * @param userId
	 * @param userPw
	 * @param userName
	 * @param conn
	 * @return result (회원가입 완료 : 1, 실패 : 0)
	 * @throws Exception
	 */
	public int userReg(String userId, String userPw, String userName, Connection conn) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("userReg");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			pstmt.setString(3, userName);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
			
		}
		
		return result;
	}

	/** 로그인 DAO
	 * @param userId
	 * @param userPw
	 * @param conn
	 * @return user (로그인 유저 정보)
	 * @throws Exception
	 */
	public User login(String userId, String userPw, Connection conn) throws Exception{
		User user = null;
		
		try {
			String sql = prop.getProperty("login");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user = new User();
				user.setUserNo( rs.getInt("USER_NO") );
				user.setUserId( rs.getString("USER_ID") );
				user.setUserName( rs.getString("USER_NAME") );
				
			}
		}finally {
			close(rs);
			close(pstmt);
			
		}
		return user;
	}

	/** 비밀번호 확인 DAO
	 * @param pw
	 * @param conn
	 * @return result (확인 성공 : 1, 실패 : 0)
	 * @throws Exception
	 */
	public int checkPw(String pw, Connection conn) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("checkPw");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, LoginView.loginUser.getUserNo());
			pstmt.setString(2, pw);
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

	/** 비밀번호 변경 DAO
	 * @param conn 
	 * @param newPw 
	 * @return result (성공 : 1, 실패 : 0)
	 * @throws Exception
	 */
	public int changePw(String newPw, Connection conn) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("changePw");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPw);
			pstmt.setInt(2, LoginView.loginUser.getUserNo());
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
			
		}
		return result;
		
	}

	/** 회원 탈퇴 DAO
	 * @param conn
	 * @return result (회원 탈퇴 성공 : 1, 실패 : 0)
	 * @throws Exception
	 */
	public int deleteUser(Connection conn) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("deleteUser");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, LoginView.loginUser.getUserNo());
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
			
		}
		return result;
		
	}

	/** 총 랭킹 조회 DAO
	 * @param conn
	 * @return rankList (랭킹 목록)
	 * @throws Exception
	 */
	public List<Game> allRanking(Connection conn) throws Exception{
		List<Game> rankList = new ArrayList<Game>();
		
		try {
			String sql = prop.getProperty("allRanking");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Game game = new Game();
				
				game.setUserName(rs.getString("USER_NAME"));
				game.setRpsScore(rs.getInt("SCORE"));
				game.setRpsRank(rs.getInt("ALLRANK"));
				
				rankList.add(game);
				
			}
		}finally {
			close(rs);
			close(pstmt);
			
		}
		return rankList;
	}
}
