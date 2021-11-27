package edu.kh.board.model.dao;

// static 임포트 : 지정된 경로에 있는 static 변수, 메소드 호출 시 클래스명을 생략 가능
import static edu.kh.board.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.board.common.JDBCTemplate;
import edu.kh.board.model.vo.Board;

public class BoardDAO {
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	/** 게시글 삽입 DAO
	 * @param board
	 * @param conn
	 * @return result (DML 성공한 행의 수)
	 */
	public int insertBoard(Board board, Connection conn) throws Exception{
														// -> 호출한 곳으로 발생 한 예외를 던짐
		
		// 결과 저장용 변수
		int result = 0;
		
		try {
			
			// Connection 얻어오기 -> 매개변수로 전달 받음
			
			// SQL 작성
			String sql = "INSERT INTO TB_BOARD "
					+ "VALUES( SEQ_BOARD_NO.NEXTVAL, ?, ?, ?, ?, DEFAULT, DEFAULT)";
			
			// PrearedStatement 생성
			pstmt = conn.prepareStatement(sql);
			
			// 위치 홀더에 알맞은 값 세팅
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardContent());
			pstmt.setString(3, board.getBoardWriter());
			pstmt.setString(4, board.getBoardPw());
			
			// SQL 수행 후 결과를 반환 받기
			result = pstmt.executeUpdate();
			
			
			
			
		}finally {
			// 사용한 JDBC 객체 자원 반환
			close(pstmt);
			
		}
		
		
		
		return result;
	}

	/** 게시글 수정(비밀번호 x) DAO
	 * @param board
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public int updateBoardPwx(Board board, Connection conn) throws Exception {
		// 1. 결과 저장용 변수 선언
		int result = 0;
		
		try {
			// 2. 커넥션 얻어오기 == Service에서 매개변수로 전달 받음
			
			// 3. SQL 작성하기
			String sql = "UPDATE TB_BOARD SET BOARD_TITLE = ?, BOARD_CONTENT = ? WHERE BOARD_NO = ?";
			
			// 4. PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 5. 위치 홀더에 알맞은 값 세팅
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardContent());
			pstmt.setInt(3, board.getBoardNo());
			
			// 6. SQL 수행 후 결과를 반환 받아 저장
			result = pstmt.executeUpdate();
			
			
		}finally {
			
			// 7. 사용한 JDBC 객체 자원 반환
			close(pstmt);
			
		}
		
		
		return result;
	}

	/** 게시글 수정 DAO
	 * @param boardNo
	 * @param boardPw
	 * @param conn
	 * @return result
	 * @throws Exception
	 */
	public int checkBoard(int boardNo, String boardPw, Connection conn) throws Exception {
		
		// 1. 결과 저장용 변수 선언
		int result = 0;
		
		try {
			// 2. SQL 작성
			String sql = "SELECT COUNT(*) FROM TB_BOARD WHERE BOARD_NO = ? AND BOARD_PW = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			pstmt.setString(2, boardPw);
			rs = pstmt.executeQuery();
			// count(*) 수행 결과로 1행 1열 값이 조회되었지만 이것도 ResultSet이다
			
			// 조회 결과에 커서를 이동하여 다음 행이 존재하는지 확인
			if(rs.next()) {
				result = rs.getInt(1);
				// 조회 결과에서 컬럼값을 얻어오는 방법 : 1) 컬럼명, 2) 컬럼 순서
			}
			
		}finally {
			// JDBC 객체 자원 반환 코드(close())의 무조건적인 실행을 위해
			// try-finally 구문 작성
			close(rs);
			close(pstmt);
			
		}
		
		
		return result;
	}

	/** 게시글 삭제 DAO
	 * @param boardNo
	 * @param conn
	 * @return result
	 * @throws Exception
	 */
	public int deleteBoard(int boardNo, Connection conn) throws Exception{
		int result = 0;
		
		try {
			String sql = "DELETE FROM TB_BOARD WHERE BOARD_NO = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
			
		}
		
		
		return result;
	}

	/** 게시글 목록 조회 DAO
	 * @param conn
	 * @return list
	 * @throws Exception
	 */
	public List<Board> selectAll(Connection conn) throws Exception{
		
		// 억지로 null이라는 상태를 만들 필요가 없어졌음
		// 예외를 직접 던져서 알려주기 때문에 (throws Exception)
		List<Board> list = new ArrayList<Board>(); 
		
		try {
			String sql = "SELECT BOARD_NO, BOARD_TITLE, BOARD_WRITER, CREATE_DT, READ_COUNT FROM TB_BOARD "
					+ "WHERE BOARD_NO > 0 "
					+ "ORDER BY BOARD_NO DESC";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			
			// List 같은 경우 세가지 상태를 가질 수 있음.
			// 1. DB 연결 중 오류 발생 == throws Exception
			// 2. 조회 결과 없음 == isEmpty()
			// 3. 조회 결과 있음 == !isEmpty()
			
			while(rs.next()) {
				
				int 	boardNo 	= rs.getInt("BOARD_NO");
				String 	boardTitle 	= rs.getString("BOARD_TITLE");
				String 	boardWriter = rs.getString("BOARD_WRITER");
				Date 	createDt 	= rs.getDate("CREATE_DT");
				int 	readCount 	= rs.getInt("READ_COUNT");
				
				Board board = new Board(boardNo, boardTitle, boardWriter, createDt, readCount);
				
				list.add(board);
				
			}
			
			
		}finally {
			close(rs);
			close(stmt);
			
			
		}
		
		
		
		return list;
	}

	/** 게시글 제목 검색 DAO
	 * @param boardTitle
	 * @param conn
	 * @return list
	 * @throws Exception
	 */
	public List<Board> searchTitle(String boardTitle, Connection conn) throws Exception{
		List<Board> list = new ArrayList<Board>();
		
		try {
			String sql = "SELECT BOARD_NO, BOARD_TITLE, BOARD_WRITER, CREATE_DT, READ_COUNT FROM TB_BOARD "
					+ "WHERE BOARD_NO > 0 "
					+ "AND BOARD_TITLE LIKE '%' || ? || '%' "
					+ "ORDER BY BOARD_NO DESC";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardTitle);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int 	boardNo 	= rs.getInt("BOARD_NO");
				 		boardTitle 	= rs.getString("BOARD_TITLE");
				String 	boardWriter = rs.getString("BOARD_WRITER");
				Date 	createDt 	= rs.getDate("CREATE_DT");
				int 	readCount 	= rs.getInt("READ_COUNT");
				
				Board board = new Board(boardNo, boardTitle, boardWriter, createDt, readCount);
				
				list.add(board);
				
			}
			
			
		}finally {
			
			close(rs);
			close(pstmt);
			
		}
	
		return list;
	}

	/** 게시글 상세 조회 DAO
	 * @param boardNo
	 * @param conn
	 * @return board
	 * @throws Exception
	 */
	public Board selectBoard(int boardNo, Connection conn) throws Exception{
		Board board = null;
		
		try {
			String sql = "SELECT * FROM TB_BOARD WHERE BOARD_NO = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // 조회 결과가 최대 1행 -> if문 사용
				
						boardNo 		= rs.getInt(1);
				String 	boardTitle 		= rs.getString(2);
				String 	boardContent 	= rs.getString(3);
				String 	boardWriter 	= rs.getString(4);
				String 	boardPw 		= rs.getString(5);
				Date 	createDt 		= rs.getDate(6);
				int 	readCount 		= rs.getInt(7);
				
				// 얻어온 컬럼 값을 하나의 Board 객체를 생성하여 저장
				board = new Board(boardNo, boardTitle, boardContent, boardWriter, boardPw, createDt, readCount);
				
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
			
			
		}
		
		return board;
	}

	/** 조회수 증가 DAO
	 * @param boardNo
	 * @param conn
	 * @return result (성공 1, 실패 0)
	 * @throws Exception
	 */
	public int increaseReadCount(int boardNo, Connection conn) throws Exception{
		int result = 0;
		
		try {
			String sql = "UPDATE TB_BOARD SET READ_COUNT = READ_COUNT + 1 WHERE BOARD_NO = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			result = pstmt.executeUpdate();
			
			
		}finally {
			close(pstmt);
			
			
		}
		
		return result;
	}

}
