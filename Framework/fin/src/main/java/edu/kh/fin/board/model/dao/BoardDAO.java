package edu.kh.fin.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.fin.board.model.vo.Board;
import edu.kh.fin.board.model.vo.BoardImage;
import edu.kh.fin.board.model.vo.Category;
import edu.kh.fin.board.model.vo.Pagination;
import edu.kh.fin.board.model.vo.Search;

@Repository // 저장소(파일, DB)에 접근하는 객체(DAO)임을 알려줌 + Bean 등록
public class BoardDAO {
	
	// 마이바티스에서 SQL을 수행하는 객체
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 전체 게시글 수 조회
	 * @return listCount
	 */
	public int getListCount() {
		return sqlSession.selectOne("boardMapper.getListCount");
	}

	/** 지정된 범위의 게시글 목록 조회
	 * @param pagination
	 * @return boardList
	 */
	public List<Board> selectBoardList(Pagination pagination) {
		
		// RowBounds : offset과 limit 값을 넘겨 받아 페이징 처리를 쉽게 할 수 있게하는 객체
		// offset : 몇 행을 건너 뛸 것인지 지정
		// limit : 건너 뛴 위치 부터 몇 행을 조회할지 지정
		
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		int limit = pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		// RowBounds 사용시 3번째 인자로 작성
		// -> 이때, 파라미터가 없는 경우 null 작성
		return sqlSession.selectList("boardMapper.selectBoardList", null, rowBounds);
	}

	/** 게시글 상세 조회
	 * @param boardNo
	 * @return board
	 */
	public Board selectBoard(int boardNo) {
		return sqlSession.selectOne("boardMapper.selectBoard", boardNo);
		// 게시글 정보 + 해당 게시글 이미지 정보
	}

	/** 게시글 조회 수 증가
	 * @param boardNo
	 * @return result
	 */
	public int increaseReadCount(int boardNo) {
		return sqlSession.update("boardMapper.increaseReadCount", boardNo);
	}

	/** 카테고리 목록 조회
	 * @return category
	 */
	public List<Category> selectCategory() {
		return sqlSession.selectList("boardMapper.selectCategory");
	}

	/** 게시글 부분 삽입
	 * @param board
	 * @return boardNo
	 */
	public int insertBoard(Board board) {
		
		int result = sqlSession.insert("boardMapper.insertBoard", board);
		
		if(result > 0) return board.getBoardNo();
		else 		   return 0;
	}

	/** 이미지 목록 삽입
	 * @param imgList
	 * @return result
	 */
	public int insertImgList(List<BoardImage> imgList) {
		return sqlSession.insert("boardMapper.insertImgList", imgList);
	}

	/** 게시글 수정
	 * @param board
	 * @return result
	 */
	public int updateBoard(Board board) {
		return sqlSession.update("boardMapper.updateBoard", board);
	}

	/** 게시글 이미지 삭제
	 * @param map
	 * @return result
	 */
	public int deleteImages(Map<String, Object> map) {
		return sqlSession.delete("boardMapper.deleteImages", map);
	}

	/** 게시글 이미지 수정
	 * @param img
	 * @return result
	 */
	public int updateBoardImage(BoardImage img) {
		return sqlSession.update("boardMapper.updateBoardImage", img);
	}

	/** 게시글 이미지 삽입
	 * @param img
	 * @return result
	 */
	public int insertBoardImage(BoardImage img) {
		return sqlSession.insert("boardMapper.insertBoardImage", img);
	}

	/** 게시글 삭제
	 * @param boardNo
	 * @return result
	 */
	public int deleteBoard(int boardNo) {
		return sqlSession.update("boardMapper.deleteBoard", boardNo);
	}

	/** 검색 조건에 맞는 전체 게시글 수 count + 페이징 처리에 필요한 값 계산
	 * @param search
	 * @return searchListCount
	 */
	public int getSearchListCount(Search search) {
		return sqlSession.selectOne("boardMapper.getSearchListCount", search);
	}

	public List<Board> selectSearchBoardList(Pagination pagination, Search search) {
		
		// 건너 뛸 행의 수 계산
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		// pagination.getLimit() : 건너 뛴 후 조회할 행의 수
		int limit = pagination.getLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return sqlSession.selectList("boardMapper.selectSearchBoardList", search, rowBounds);
	}

	/** 이미지 파일명 목록 조회
	 * @return dbImgList
	 */
	public List<String> selectImgList() {
		return sqlSession.selectList("boardMapper.selectImgList");
	}
	
}
