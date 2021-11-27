package edu.kh.project.user.model.service;

import static edu.kh.project.common.JDBCTemplate.close;
import static edu.kh.project.common.JDBCTemplate.commit;
import static edu.kh.project.common.JDBCTemplate.getConnection;
import static edu.kh.project.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import edu.kh.project.game.model.dao.GameDAO;
import edu.kh.project.game.model.vo.Game;
import edu.kh.project.user.model.dao.UserDAO;
import edu.kh.project.user.model.vo.User;

public class UserService {
	
	UserDAO dao = new UserDAO();

	/** 아이디 확인 Service
	 * @param userId
	 * @return result (아이디 존재O : 1, 존재X : 0)
	 * @throws Exception
	 */
	public int checkId(String userId) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.checkId(userId, conn);
		
		close(conn);
		
		return result;
	}


	/** 회원가입 Service
	 * @param userId
	 * @param userPw
	 * @param userName
	 * @return result (회원가입 완료 : 1, 실패 : 0)
	 * @throws Exception
	 */
	public int userReg(String userId, String userPw, String userName) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.userReg(userId, userPw, userName, conn);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}


	/** 로그인 Service
	 * @param userId
	 * @param userPw
	 * @return user (로그인하는 user 정보)
	 * @throws Exception
	 */
	public User login(String userId, String userPw) throws Exception{
		Connection conn = getConnection();
		
		User user = dao.login(userId, userPw, conn);
		
		close(conn);
		
		return user;
	}
	
	/** 비밀번호 확인 Service
	 * @param pw
	 * @return result (확인 성공 : 1, 실패 0)
	 * @throws Exception
	 */
	public int checkPw(String pw) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.checkPw(pw, conn);
		
		close(conn);
		
		return result;
	}


	/** 비밀번호 변경 Service
	 * @param newPw
	 * @return result (성공 : 1, 실패 : 0)
	 * @throws Exception
	 */
	public int changePw(String newPw) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.changePw(newPw, conn);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}
	
	
	/** 회원 탈퇴 Service
	 * @return result (탈퇴 성공 : 1, 실패 : 0)
	 * @throws Exception
	 */
	public int deleteUser() throws Exception{
		Connection conn = getConnection();
		
		int result = dao.deleteUser(conn);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}


	/** 총 랭킹 조회 Service
	 * @return rankList (랭킹 목록)
	 * @throws Exception
	 */
	public List<Game> allRanking() throws Exception{
		Connection conn = getConnection();
		
		List<Game> rankList = dao.allRanking(conn);
		
		close(conn);
		
		return rankList;
	}
}
