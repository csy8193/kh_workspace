package edu.kh.fin.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.fin.board.model.vo.Board;
import edu.kh.fin.board.model.vo.Pagination;

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
	
}