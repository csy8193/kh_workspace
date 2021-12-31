package ncs.applyswfoundation.model;

import java.sql.SQLException;
import java.util.List;

public interface InterNoticeDAO {

        List<CommentVO> commentVOList() throws SQLException;

        int addComment(CommentVO vo) throws SQLException;
	
}