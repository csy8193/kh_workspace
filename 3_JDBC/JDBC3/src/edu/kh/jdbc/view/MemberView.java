package edu.kh.jdbc.view;

import java.util.Scanner;

import edu.kh.jdbc.member.model.service.MemberService;
import edu.kh.jdbc.member.model.vo.Member;

public class MemberView {
	
	private Scanner sc = new Scanner(System.in);
	
	private MemberService service = new MemberService();
	
	// 메인 메뉴 1. 로그인
	public void login() {
		
		System.out.println("[로그인]");
		System.out.print("아이디 : ");
		String memberId = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String memberPw = sc.nextLine();
		
		// 로그인 Service 호출 후 결과 반환 받기
		try {
			Member member = service.login(memberId, memberPw);
			
			if(member == null) {
				System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
				
			}else {
				System.out.println(member.getMemberNm() + "님 환영합니다.");
				
				// static 변수로 선언된 loginMember에 로그인된 정보를 저장
				MainView.loginMember = member;
				
			}
		} catch (Exception e) {
			
			System.out.println("로그인 과정에서 문제가 발생했습니다.");
			
		}
		
		
	}
	
	// 메인 메뉴 2. 회원 가입
	public void signUp() {
		System.out.println("[회원 가입]");
		
		
		// 아이디 중복 검사 Service 호출 후 결과 반환 받기
		try {
			
			String memberId = null;
			
			while(true) {
				// 1. 아이디 중복 검사
				// -> 아이디를 입력 받으면 바로 중복 검사 진행
				System.out.print("아이디 : ");
				memberId = sc.nextLine();
				
				
				int result = service.idDupCheck(memberId);
				
				if(result > 0) {
					System.out.println("이미 사용중인 아이디 입니다.");
					
				}else {
					System.out.println("사용 가능한 아이디 입니다.");
					break;
					
				}
				
			}
			
			String memberPw = null;
			
			while(true) {
				System.out.print("비밀번호 : ");
				memberPw = sc.nextLine();
				
				System.out.print("비밀번호 확인 : ");
				String memberPwCheck = sc.nextLine();
				
				if(memberPw.equals(memberPwCheck)) {
					break;
				}else {
					System.out.println("비밀번호를 확인해주세요.");

				}
				
			}
			
			System.out.print("이름 : ");
			String memberNm = sc.nextLine();
			
			System.out.print("전화번호 : ");
			String phone = sc.nextLine();
			
			Member member = new Member(memberId, memberPw, memberNm, phone);
			
			int result = service.signUp(member);
			
			if(result > 0) {
				System.out.println("회원가입 성공");
				
			}else {
				System.out.println("회원가입 실패");
				
			}
			
		} catch (Exception e) {
			System.out.println("회원가입 중 문제가 발생했습니다.");
			e.printStackTrace();
		}
		
		
		
		// 중복 O : 다시 아이디 입력 받기
		// 중복 X : 다음 회원 정보 입력 받기
		
	}
	
	// 로그인 메뉴 1. 내 정보 조회
	public void myInfo() {
		
		Member member = MainView.loginMember;
		// 로그인된 회원 정보를 저장하고있는 static 변수
		System.out.println("[내 정보 조회]");
		
		System.out.println("아이디 : " + member.getMemberId());
		
		System.out.println("이름 : " + member.getMemberNm());
		
		System.out.println("전화번호 : " + member.getPhone());
		
	}

	public void updateMember() {
		System.out.println("[내 정보 수정]");
		System.out.print("변경할 비밀번호 입력 :");
		String memberPw = sc.nextLine();
		
		System.out.print("변경할 전화번호 입력 : ");
		String phone = sc.nextLine();
		
		try {
			int result = service.updateMember(memberPw, phone);
			
			if(result > 0) {
				System.out.println("수정 완료");
				
			}else {
				System.out.println("수정 실패");
				
			}
		} catch (Exception e) {
			System.out.println("내 정보 수정 중 문제가 발생했습니다.");
			e.printStackTrace();
		}
	}
	
	// 회원 탈퇴
	public void deleteMember() {
		System.out.println("[회원 탈퇴]");
		
		System.out.print("비밀번호 입력 : ");
		String memberPw = sc.nextLine();
		
		while(true) {
			System.out.print("정말로 탈퇴 하시겠습니까? (y/n)");
			char yn = sc.nextLine().toLowerCase().charAt(0);
			// String.toLowerCase() : 문자열을 모두 소문자로 변경
			// String.toUpperCase() : 문자열을 모두 대문자로 변경
			
			
			if(yn == 'y') {
				// 탈퇴 Service 호출 후 결과 반환 받기
				try {
					int result = service.deleteMember(memberPw);
					
					if(result > 0) {
						System.out.println("탈퇴 되었습니다.");
						MainView.loginMember = null; // 로그아웃
						
					}else {
						System.out.println("비밀번호가 일치하지 않습니다.");
						
					}
					
				} catch (Exception e) {
					System.out.println("회원 탈퇴 중 문제가 발생했습니다.");
					e.printStackTrace();
					
				}
				break;
				
			}else if (yn == 'n') {
				System.out.println("취소되었습니다.");
				break;
				
			}else {
				System.out.println("잘못 입력 하셨습니다.");
				
			}
		}
	}
}
