package edu.kh.jdbc.board.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.board.model.vo.Board;
import edu.kh.jdbc.view.MainView;

public class BoardDAO {
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private Properties prop = null;
	
	public BoardDAO() {
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("board-sql.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/** 게시글 삽입 DAO
	 * @param boardTitle
	 * @param boardContent
	 * @param conn
	 * @return result
	 * @throws Exception
	 */
	public int insertBoard(String boardTitle, String boardContent, Connection conn) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("insertBoard");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, boardTitle);
			pstmt.setString(2, boardContent);
			pstmt.setInt(3, MainView.loginMember.getMemberNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
			
		}
		return result;
		
	}

	/** 로그인한 회원의 작성글이 맞는지 확인 DAO
	 * @param boardNo
	 * @param conn
	 * @return result
	 * @throws Exception
	 */
	public int checkBoard(int boardNo, Connection conn) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("checkBoard");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			pstmt.setInt(2, MainView.loginMember.getMemberNo());
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

	/** 게시글 수정 DAO
	 * @param boardTitle
	 * @param boardContent
	 * @param boardNo
	 * @param conn
	 * @return result
	 * @throws Exception
	 */
	public int updateBoard(String boardTitle, String boardContent, int boardNo, Connection conn) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("updateBoard");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardTitle);
			pstmt.setString(2, boardContent);
			pstmt.setInt(3, boardNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
			
		}
		return result;
	}

	public int deleteBoard(int boardNo, Connection conn) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("deleteBoard");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
			
		}
		
		return result;
	}

	/** 게시글 상세 조회 DAO
	 * @param boardNo
	 * @param conn
	 * @return board
	 * @throws Exception
	 */
	public Board selectBoard(int boardNo, Connection conn) throws Exception {
		Board board = null;
		
		try {
			String sql = prop.getProperty("selectBoard");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				board = new Board();
				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setBoardContent(rs.getString("BOARD_CONTENT"));
				board.setCreateDt(rs.getDate("CREATE_DT"));
				board.setReadCount(rs.getInt("READ_COUNT"));
				board.setMemberNm(rs.getString("MEMBER_NM"));
				
				}
			
		}finally {
			close(rs);
			close(pstmt);
			
		}
		
		return board;
	}

	public int increaseReadCount(int boardNo, Connection conn) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("increaseReadCount");
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
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectBoardList(Connection conn) throws Exception {
		
		List<Board> boardList = new ArrayList<Board>();
		
		try {
			// 2. SQL 얻어오기
			// -> BoardDAO 객체 생성 시 board-sql.xml파일의 내용을 읽어와
			//	  Properties 객체에 저장
			//	  --> Properties 객체에 저장된 내용을 얻어와 사용
			String sql = prop.getProperty("selectBoardList");
			
			// Statement 객체 생성
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int boardNo = rs.getInt("BOARD_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				Date createDt = rs.getDate("CREATE_DT");
				int readCount = rs.getInt("READ_COUNT");
				String memberNm = rs.getString("MEMBER_NM");
				
				Board board = new Board(boardNo, boardTitle, createDt, readCount, memberNm);
				
				boardList.add(board);
				
			}
			
			
		}finally {
			close(rs);
			close(stmt);
			
		}
		
		return boardList;
	}

	/** 게시글 검색 DAO
	 * @param searchKey
	 * @param searchValue
	 * @param conn
	 * @return searchList
	 * @throws Exception
	 */
	public List<Board> searchList(int searchKey, String searchValue, Connection conn) throws Exception {
		List<Board> searchList = new ArrayList<Board>();
		
		try {
			// SQL 얻어오기
			// SELECT FROM절
			String sql1 = prop.getProperty("searchList");
			
			// WHERE절
			String sql2 = null;
			
			switch(searchKey) {
			case 1 : sql2 = prop.getProperty("title"); break;
			case 2 : sql2 = prop.getProperty("content"); break;
			case 3 : sql2 = prop.getProperty("title_content"); break;
			case 4 : sql2 = prop.getProperty("writer"); break;
			}
			
			String sql = sql1 + sql2;
			
			
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, searchValue);
			
			if(searchKey == 3)	{
				pstmt.setString(2, searchValue);
			}
			
			// SQL 수행 후 결과 반환 받기
			rs = pstmt.executeQuery();
			
			// 조회 결과를 searchList에 옮겨 담기
			while(rs.next()) {
				
				int boardNo = rs.getInt("BOARD_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				Date createDt = rs.getDate("CREATE_DT");
				int readCount = rs.getInt("READ_COUNT");
				String memberNm = rs.getString("MEMBER_NM");
				
				Board board = new Board(boardNo, boardTitle, createDt, readCount, memberNm);
				
				searchList.add(board);
				
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
			
			
		}
		
		return searchList;
	}

}
