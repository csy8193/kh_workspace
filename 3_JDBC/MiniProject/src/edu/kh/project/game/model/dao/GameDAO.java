package edu.kh.project.game.model.dao;

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


public class GameDAO {
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Properties prop = null;
	
	
	public GameDAO() {
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("game-sql.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	/** 게임을 처음하는지 확인하는 DAO
	 * @param conn
	 * @return result (유저가 게임을 처음 실행 : 0, 이미 실행 : 1)
	 * @throws Exception
	 */
	public int userCheck(Connection conn) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("userCheck");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, LoginView.loginUser.getUserNo());
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

	/** 가위바위보 처음 시작하는 유저 DAO
	 * @param winLose
	 * @param conn
	 * @return result (insert 성공 : 1, 실패 : 0)
	 * @throws Exception
	 */
	public int newRpsGame(int winLose, Connection conn) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("newRpsGame");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, winLose);
			pstmt.setInt(2, LoginView.loginUser.getUserNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
			
		}
		
		return result;
	}
	

	/** 이미 가위바위보를 해본 유저 DAO
	 * @param winLose
	 * @param conn
	 * @return result (update 성공 : 1, 실패 : 0)
	 * @throws Exception
	 */
	public int rpsGame(int winLose, Connection conn) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("rpsGame");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, winLose);
			pstmt.setInt(2, LoginView.loginUser.getUserNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
			
		}
		
		return result;
	}

	/** 가위바위보 점수 확인 DAO
	 * @param gameResult 
	 * @param conn
	 * @return gameResult (점수, 랭킹, 게임실행여부)
	 * @throws Exception
	 */
	public Game selectRpsScore(Game gameResult, Connection conn) throws Exception{
		// 가위바위보 해봤는지 안해봤는지, Default로 0을 넣어줌
		gameResult.setRpsYn(0);
		
		try {
			String sql = prop.getProperty("selectRpsScore");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, LoginView.loginUser.getUserNo());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				gameResult.setRpsRank( rs.getInt("RPS_RANK") );
				gameResult.setRpsScore( rs.getInt("RPS_SCORE") );
				gameResult.setRpsYn( rs.getInt("RPS_YN") );
				
			}
		}finally {
			close(rs);
			close(pstmt);
			
		}
		return gameResult;
		
	}


	/** 가위바위보 전체 랭킹 DAO
	 * @param conn
	 * @return gameList (랭킹 목록)
	 * @throws Exception
	 */
	public List<Game> rpsAllRank(Connection conn) throws Exception{
		List<Game> gameList = new ArrayList<Game>();
		
		try {
			String sql = prop.getProperty("rpsAllRank");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Game game = new Game();
				
				game.setUserName(rs.getString("USER_NAME"));
				game.setRpsScore(rs.getInt("RPS_SCORE"));
				game.setRpsRank(rs.getInt("RPS_RANK"));
				
				gameList.add(game);
				
			}
			
		}finally {
			close(rs);
			close(stmt);
			
		}
		return gameList;
		
	}

	/** 업/다운 처음 시작하는 유저 DAO
	 * @param count
	 * @param conn
	 * @return result (insert 성공 : 1, 실패 : 0)
	 * @throws Exception
	 */
	public int upDownGame(int count, Connection conn) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("upDownGame");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, count);
			pstmt.setInt(2, LoginView.loginUser.getUserNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
			
		}
		return result;
		
	}

	/** 업/다운 처음 시작하는 유저 DAO
	 * @param count
	 * @param conn
	 * @return result (insert 성공 : 1, 실패 : 0)
	 * @throws Exception
	 */
	public int newUpDownGame(int count, Connection conn) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("newUpDownGame");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, count);
			pstmt.setInt(2, LoginView.loginUser.getUserNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
			
		}
		
		return result;
	}

	/** 업/다운 점수 확인 DAO
	 * @param gameResult
	 * @param conn
	 * @return gameResult (점수, 랭킹, 게임실행여부)
	 * @throws Exception
	 */
	public Game selectUpDownScore(Game gameResult, Connection conn) throws Exception{
		// 업/다운 해봤는지 안해봤는지, Default로 0을 넣어줌
		gameResult.setUpDownYn(0);
		
		try {
			String sql = prop.getProperty("selectUpDownScore");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, LoginView.loginUser.getUserNo());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				gameResult.setUpDownRank( rs.getInt("UPDOWN_RANK") );
				gameResult.setUpDownScore( rs.getInt("UPDOWN_SCORE") );
				gameResult.setUpDownYn( rs.getInt("UPDOWN_YN") );
			}
			
		}finally {
			close(rs);
			close(pstmt);
			
		}
		
		return gameResult;
	}


	/** 업/다운 전체 랭킹 DAO
	 * @param conn
	 * @return gameList (랭킹 목록)
	 * @throws Exception
	 */
	public List<Game> upDownAllRank(Connection conn) throws Exception{
		List<Game> gameList = new ArrayList<Game>();
		
		try {
			String sql = prop.getProperty("upDownAllRank");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Game game = new Game();
				
				game.setUserName(rs.getString("USER_NAME"));
				game.setUpDownScore(rs.getInt("UPDOWN_SCORE"));
				game.setUpDownRank(rs.getInt("UPDOWN_RANK"));
				
				gameList.add(game);
				
			}
			
		}finally {
			close(rs);
			close(stmt);
			
		}
		
		return gameList;
	}





	

}
