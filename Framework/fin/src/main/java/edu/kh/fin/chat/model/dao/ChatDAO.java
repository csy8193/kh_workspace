package edu.kh.fin.chat.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.fin.chat.model.vo.ChatMessage;
import edu.kh.fin.chat.model.vo.ChatRoom;
import edu.kh.fin.chat.model.vo.ChatRoomJoin;

@Repository
public class ChatDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 채팅방 목록 조회
	 * @return chatRoomList
	 */
	public List<ChatRoom> chatRoomList() {
		return sqlSession.selectList("chatMapper.chatRoomList");
	}

	/** 채팅방 만들기
	 * @param room
	 * @return result
	 */
	public int openChatRoom(ChatRoom room) {
		return sqlSession.insert("chatMapper.openChatRoom", room);
	}

	/** 채팅방 존재 여부 확인
	 * @param chatRoomNo
	 * @return result
	 */
	public int existsChatRoom(int chatRoomNo) {
		return sqlSession.selectOne("chatMapper.existsChatRoom", chatRoomNo);
	}

	/** 채팅방 입장
	 * @param join
	 */
	public void joinChatRoom(ChatRoomJoin join) {
		sqlSession.insert("chatMapper.joinChatRoom", join);
	}

	/** 채팅 메시지 조회
	 * @param chatRoomNo
	 * @return list
	 */
	public List<ChatMessage> selectChatMessage(int chatRoomNo) {
		return sqlSession.selectList("chatMapper.selectChatMessage", chatRoomNo);
	}

	/** 채팅 내용 삽입
	 * @param cm
	 * @return result
	 */
	public int insertMessage(ChatMessage cm) {
		return sqlSession.insert("chatMapper.insertMessage", cm);
	}

	/** 채팅방 나가기
	 * @param cm
	 * @return result
	 */
	public int exitChatRoom(ChatMessage cm) {
		return sqlSession.delete("chatMapper.exitChatRoom", cm);
	}
}
