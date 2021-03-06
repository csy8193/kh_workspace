package edu.kh.fin.chat.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.fin.chat.model.service.ChatService;
import edu.kh.fin.chat.model.vo.ChatMessage;
import edu.kh.fin.chat.model.vo.ChatRoom;
import edu.kh.fin.chat.model.vo.ChatRoomJoin;
import edu.kh.fin.common.Util;
import edu.kh.fin.member.model.vo.Member;

@Controller
@SessionAttributes({"loginMember", "chatRoomNo"})
public class ChatController {
	
	@Autowired
	private ChatService service;
	
	// 채팅방 목록 조회
	@RequestMapping("/chat/roomList")
	public String chatRoomList(Model model) {
		
		List<ChatRoom> chatRoomList = service.chatRoomList();
		
		model.addAttribute("chatRoomList", chatRoomList);
		
		return "chat/chatRoomList";
	}
	
	
	// 채팅방 열기(만들기)
	@RequestMapping(value="/chat/openChatRoom", method=RequestMethod.POST)
	public String openChatRoom(ChatRoom room, @ModelAttribute("loginMember") Member loginMember, RedirectAttributes ra) {
		room.setMemberNo(loginMember.getMemberNo());
		
		// 채팅방 열기 Service 호출 후 생성된 방 번호 얻어오기
		int chatRoomNo = service.openChatRoom(room);
		
		String path = "redirect:/chat/";
		
		if(chatRoomNo > 0) {
			path += "room/" + chatRoomNo;
		}else {
			Util.swalSetMessage("채팅방 생성 실패", null, "error", ra);
			path += "roomList";
		}
		
		
		return path;
	}
	
	
	// 채팅방 참여 + 이전 채팅 내역 얻어오기
	@RequestMapping("/chat/room/{chatRoomNo}")
	public String joinChatRoom(@PathVariable("chatRoomNo") int chatRoomNo, @ModelAttribute("loginMember") Member loginMember,
								ChatRoomJoin join, RedirectAttributes ra, Model model) {
		
		// 1. ChatRoomJoin VO에 방번호, 회원 번호 추가
		join.setChatRoomNo(chatRoomNo);
		join.setMemberNo(loginMember.getMemberNo());
		
		// 2. 채팅방 입장 + 채팅 내역(메시지) 조회하는 Service 호출
		List<ChatMessage> list = service.joinChatRoom(join);
		
		// 3-1. 채팅방이 존재하면 조회한 채팅 내역과 채팅 번호를 jsp로 forward
		if(list != null) {
			model.addAttribute("list", list);
			
			// ******************************************
			model.addAttribute("chatRoomNo", chatRoomNo);
			// model은 기본적으로 request
			// -> @SessionAttributes에 추가되면 session 으로 변경
			// ******************************************
			
			return "chat/chatRoom";
		}else { // 3-2. 채팅방이 존재하지 않으면 roomList로 리다이렉트
			
			Util.swalSetMessage("해당 채팅방이 존재하지 않습니다", null, "info", ra);
			
			return "redirect:../roomList";
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	// HttpSessionRequiredException : Session 값을 얻어오려고 했으나 없는 경우 발생하는 예외
	// -> 채팅방 입장 시 로그인이 되어있지 않은 경우
	// == 주소로 채팅방에 강제 접근
	@ExceptionHandler(HttpSessionRequiredException.class)
	public String exceptionHandler(Exception e, Model model) {
		
		return "redirect:/chat/roomList";
	}
	
}
