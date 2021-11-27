package edu.kh.jdbc.board.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.jdbc.board.model.dao.BoardDAO;
import edu.kh.jdbc.board.model.vo.Board;

public class BoardService {
	
	private BoardDAO dao = new BoardDAO();

	/** 게시글 삽입 Service
	 * @param boardTitle
	 * @param boardContent
	 * @return result
	 * @throws Exception
	 */
	public int insertBoard(String boardTitle, String boardContent) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.insertBoard(boardTitle, boardContent, conn);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 로그인한 회원의 작성글이 맞는지 확인 Service
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int checkBoard(int boardNo) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.checkBoard(boardNo, conn);
		
		close(conn);
		
		return result;
	}

	/** 게시글 수정 Service
	 * @param boardTitle
	 * @param boardContent
	 * @param boardNo
	 * @return 
	 * @throws Exception
	 */
	public int updateBoard(String boardTitle, String boardContent, int boardNo) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.updateBoard(boardTitle, boardContent, boardNo, conn);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	public int deleteBoard(int boardNo) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.deleteBoard(boardNo, conn);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 게시글 상세 조회 Service
	 * @param boardNo
	 * @return board
	 * @throws Exception
	 */
	public Board selectBoard(int boardNo) throws Exception{
		Connection conn = getConnection();
		
		Board board = dao.selectBoard(boardNo, conn);
		
		if(board != null) {
			int result = dao.increaseReadCount(boardNo, conn);
			
			if(result > 0) {
				commit(conn);
				// DB는 조회수가 증가 했지만
				// 이전에 조회한 board에는 조회수가 증가되지 않음
				board.setReadCount( board.getReadCount() + 1 );
				
			}else {
				rollback(conn);
			}
			
		}
		
		close(conn);
		
		return board;
	}

	/** 게시글 목록 조회 Service
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectBoardList() throws Exception {
		
		// 1. Connection 얻어오기 -> JDBCTemplate.getConnection()
		//						--> Oracle JDBC Driver 메모리 로드
		Connection conn = getConnection();
		
		List<Board> boardList = dao.selectBoardList(conn);
		
		close(conn);
		
		return boardList;
	}

	/** 게시글 검색 Service
	 * @param searchKey
	 * @param searchValue
	 * @return searchList
	 * @throws Exception
	 */
	public List<Board> searchList(int searchKey, String searchValue) throws Exception{
		Connection conn = getConnection();
		
		List<Board> searchList = dao.searchList(searchKey, searchValue, conn);
		
		close(conn);
		
		return searchList;
	}

}
