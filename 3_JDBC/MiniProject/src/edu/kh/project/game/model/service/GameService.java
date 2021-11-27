package edu.kh.project.game.model.service;

import static edu.kh.project.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.project.game.model.dao.GameDAO;
import edu.kh.project.game.model.vo.Game;
import edu.kh.project.user.model.vo.User;
import edu.kh.project.view.LoginView;

public class GameService {
	
	private GameDAO dao = new GameDAO(); 
	
	
	/** 가위바위보 게임 Service
	 * @param rps
	 * @param str
	 * @return game
	 * @throws Exception
	 */
	public Game rpsGame(String rps, String str) throws Exception{
		Connection conn = getConnection();
		
		int check = dao.userCheck(conn); 
		int winLose = 0; // 승, 무, 패 저장 변수
		Game gameResult = new Game();
		
		// 승, 무, 패 조건문
		if(str.equals("가위")) {
			if(rps.equals("바위")) {
				winLose = -1;
				
			}
			if(rps.equals("보")) {
				winLose = 1;
				
			}
		}else if (str.equals("바위")) {
			if(rps.equals("보")) {
				winLose = -1;
				
			}
			if(rps.equals("가위")) {
				winLose = 1;
				
			}
		}else if(str.equals("보")) {
			if(rps.equals("가위")) {
				winLose = -1;
				
			}
			if(rps.equals("바위")) {
				winLose = 1;
				
			}
		}else {
			winLose = 0;
			
		}
		
		if(check == 1) { // 이미 게임을 실행해본 유저
			int result = dao.rpsGame(winLose, conn);
			
			if(result > 0) {
				commit(conn);
				gameResult = dao.selectRpsScore(gameResult, conn);

			}else {
				rollback(conn);
			}
		}else { // 처음 게임을 실행하는 유저
			int result = dao.newRpsGame(winLose, conn);
			
			if(result > 0) {
				commit(conn);
				gameResult = dao.selectRpsScore(gameResult, conn);
				
			}else {
				rollback(conn);
			}
		}
		
		close(conn);
		
		gameResult.setRpsWl(winLose); // 객체에 승, 무, 패를 숫자로 저장
		
		return gameResult;
		
		
	}


	/** 내가 한 게임 점수, 랭킹 Service
	 * @return gameResult(가위바위보, 업/다운 점수, 랭킹, 실행 여부)
	 * @throws Exception
	 */
	public Game selectAllScore() throws Exception{
		Connection conn = getConnection();
		Game gameResult = new Game();
		
		gameResult = dao.selectRpsScore(gameResult, conn);
		gameResult = dao.selectUpDownScore(gameResult, conn);
		
		
		close(conn);
		
		return gameResult;
	}


	/** 가위바위보 전체 랭킹 Service
	 * @return gameList (랭킹 목록)
	 * @throws Exception
	 */
	public List<Game> rpsAllRank() throws Exception{
		Connection conn = getConnection();
		
		List<Game> gameList = dao.rpsAllRank(conn);
		
		close(conn);
		
		return gameList;
	}


	/** 업/다운 게임 Service
	 * @param count
	 * @return gameList
	 * @throws Exception
	 */
	public Game upDownStart(int count) throws Exception{
		Connection conn = getConnection();
		
		Game gameResult = new Game();
		
		int check = dao.userCheck(conn);
		
		if(check == 1) { // 이미 게임을 실행해본 유저
			int result = dao.upDownGame(count, conn);
			
			if(result > 0) {
				commit(conn);
				gameResult = dao.selectUpDownScore(gameResult, conn);

			}else {
				rollback(conn);
			}
			
		}else { // 처음 게임을 실행하는 유저
			int result = dao.newUpDownGame(count, conn);
			
			if(result > 0) {
				commit(conn);
				gameResult = dao.selectUpDownScore(gameResult, conn);
				
			}else {
				rollback(conn);
			}
			
		}
		close(conn);
		
		return gameResult;
		
	}


	/** 업/다운 전체 랭킹 Service
	 * @return gameLise (랭킹 목록)
	 * @throws Exception
	 */
	public List<Game> UpdownAllRank() throws Exception{
		Connection conn = getConnection();
		
		List<Game> gameList = dao.upDownAllRank(conn);
		
		close(conn);
		
		return gameList;
	}


}
