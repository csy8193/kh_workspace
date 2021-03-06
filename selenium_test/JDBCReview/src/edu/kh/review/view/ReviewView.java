package edu.kh.review.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.review.model.service.ReviewService;
import edu.kh.review.model.vo.Member;

public class ReviewView {
	
	private Scanner sc = new Scanner(System.in);
	private ReviewService service = new ReviewService();
	
	public void displayMenu() {
		
		int sel = 1;
		
		do {
			
			System.out.println("=== JDBC 복습 ===");
			System.out.println("1. 회원 가입");
			System.out.println("2. 가입된 전체 회원 정보 조회");
			System.out.println("3. 특정 회원 정보 조회");
			System.out.println("4. 특정 회원 정보 수정");
			System.out.println("5. 특정 회원 탈퇴");
			System.out.println("0. 프로그램 종료");

			System.out.print("메뉴 선택 >> ");
			try {
				sel = sc.nextInt();
				sc.nextLine();
				System.out.println();
				
				switch(sel) {
				case 1 : signUp(); break;
				// 아이디, 비밀번호, 이름, 이메일 입력 받아서 DB에 삽입
				// (아이디 중복은 없다고 가정)
				
				case 2 : selectAll(); break;
				// 가입된 모든 회원의 회원번호, 아이디, 이름, 이메일 조회하여 출력
				
				case 3 : selectOne(); break;
				// 회원 번호를 입력 받아 일치하는 회원의 회원번호, 아이디, 이름, 이메일 조회하여 출력
				
				case 4 : updateMember(); break;
				// 아이디, 비밀번호, 이메일을 입력 받아
				// 아이디, 비밀번호가 일치하는 회원의 이메일을 수정
				
				case 5 : deleteMember(); break;
				// 아이디, 비밀번호를 입력 받은 후
				// "정말 탈퇴하시겠습니까?(y/n)" 문구를 출력하여
				// y 입력 시 회원 탈퇴
				
				case 0 : System.out.println("프로그램 종료"); break;
				default : System.out.println("잘못 입력하셨습니다.");
				}
				
			} catch (InputMismatchException e) {
				
				System.out.println("메뉴에 작성된 번호만 작성해주세요.");
				sc.nextLine();
			}
			
			
		}while(sel != 0);
	}


	
	/**
	 * 1. 회원 가입
	 */
	private void signUp() {
		System.out.println("=== 회원 가입 ===");
		
		String memberId;
		String memberPw;
		String memberName;
		String memberEmail;
		
		System.out.print("아이디 : ");
		memberId = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		memberPw = sc.nextLine();
		
		System.out.print("이름 : ");
		memberName = sc.nextLine();
		
		System.out.print("이메일 : ");
		memberEmail = sc.nextLine();
		
		
		try {
			int result = service.signUp(memberId, memberPw, memberName, memberEmail);
			
			if(result > 0) {
				System.out.println("회원가입 완료");
				
			}else {
				
				System.out.println("회원가입 실패");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	
	
	/**
	 *  2. 가입된 전체 회원 정보 조회
	 */
	private void selectAll() {
		System.out.println("=== 가입된 전체 회원 정보 조회 ===");
		
		try {
			List<Member> memberList = service.selectAll();
			
			if(memberList == null) {
				System.out.println("회원이 존재하지 않습니다");
				
			}else {
				for(Member member : memberList) {
					System.out.println(member.toString());
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 3. 특정 회원 정보 조회
	 */
	private void selectOne() {
		System.out.println("=== 특정 회원 정보 조회 ===");
		
		System.out.print("회원 번호 입력 : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		try {
			Member member = service.select(num);
			
			if(member == null) {
				System.out.println("회원이 존재하지 않습니다");
				
			}else {
				System.out.println(member.toString());
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/**
	 * 4. 특정 회원 정보 수정
	 */
	private void updateMember() {
		System.out.println("=== 회원 정보 수정 ===");
		
		System.out.print("아이디 : ");
		String memberId = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String memberPw = sc.nextLine();
		
		System.out.print("수정할 이메일 : ");
		String newMemberEmail = sc.nextLine();
		
		try {
			int result = service.update(memberId, memberPw, newMemberEmail);
			
			if(result > 0) {
				System.out.println("회원 정보가 수정되었습니다");
				
			}else {
				System.out.println("회원이 존재하지 않습니다");
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 5. 회원 탈퇴
	 */
	private void deleteMember() {
		System.out.println("=== 회원 정보 수정 ===");
		
		// 아이디, 비밀번호를 입력 받은 후
		// "정말 탈퇴하시겠습니까?(y/n)" 문구를 출력하여
		// y 입력 시 회원 탈퇴
		System.out.print("아이디 : ");
		String memberId = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String memberPw = sc.nextLine();
		
		while(true) {
			System.out.print("정말 탈퇴하시겠습니까? (y/n)");
			String yn = sc.nextLine();
			
			if(yn.toLowerCase().equals("y")) {
				try {
					int result = service.delete(memberId, memberPw);
					
					if(result > 0) {
						System.out.println("회원 탈퇴 되었습니다");
						break;
						
					}else {
						System.out.println("아이디 비밀번호를 확인해주세요");
						break;
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}else if(yn.toLowerCase().equals("n")) {
				System.out.println("회원 탈퇴를 취소했습니다");
				break;
			}else {
				System.out.println("y와 n만 입력해주세요");
				
			}
		}
	}
}
