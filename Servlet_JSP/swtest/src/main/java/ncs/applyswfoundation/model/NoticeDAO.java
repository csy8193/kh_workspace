package ncs.applyswfoundation.model;

import java.sql.*;
import java.util.*;

import javax.naming.*;
import javax.sql.DataSource;

public class NoticeDAO implements InterNoticeDAO {

	private DataSource ds;	// DataSource ds 는 아파치톰캣이 제공하는 DBCP(DB Connection Pool) 이다.
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public NoticeDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env"); 
			ds = (DataSource)envContext.lookup("jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		} 
	}
	
	// === 사용한 자원을 반납하는 close() 메소드 생성하기 === //
	private void close() {
		try {
			if(rs != null) {rs.close();	rs=null;}
			if(pstmt != null) {pstmt.close(); pstmt=null;}
			if(conn != null) {conn.close(); conn=null;}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public int addComment(CommentVO vo) throws SQLException {
		// *** (요구사항5) *** //
		// 입력한 댓글내용을 ncstest_comments 테이블에 insert 되어지도록 작성하시오.
		// ncstest_comments 테이블의 no 컬럼에는 시퀀스 seq_ncstest_comments 을 사용하여 입력하도록 한다.	
		int result = 0;
		
		try {
			conn = ds.getConnection();
			String sql = "INSERT INTO NCSTEST_COMMENTS VALUES(SEQ_NCSTEST_COMMENTS.NEXTVAL, ?, DEFAULT)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getCommentContents());
			result = pstmt.executeUpdate();
			
		} finally {
			close();
		}
		return result;
	}
	
	
	@Override
	public List<CommentVO> commentVOList() throws SQLException {

		// *** (요구사항6) *** //
		// ncstest_comments 테이블에 저장되어진 모든 행들을 읽어들여 List<CommentVO> 형태로 리턴하도록 작성하시오.
		// 만약에 ncstest_comments 테이블에 저장되어진 행들이 1개도 없을 경우 NULL 을 리턴하도록 한다.
		
		List<CommentVO> CommentVOList = new ArrayList<CommentVO>();
		
		try {
			conn = ds.getConnection();
			String sql = "SELECT NO, COMMENTCONTENTS, TO_CHAR(WRITEDATE, 'YYYY-MM-DD HH24:MI:SS') WRITEDATE FROM NCSTEST_COMMENTS ORDER BY NO ASC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CommentVO vo = new CommentVO();
				
				vo.setNo(rs.getInt("NO"));
				vo.setCommentContents(rs.getString("COMMENTCONTENTS"));
				vo.setwriteDate(rs.getString("WRITEDATE"));
				
				CommentVOList.add(vo);
			}
					
			
		} finally {
			close();
		}
		
		return CommentVOList;
	}




 }