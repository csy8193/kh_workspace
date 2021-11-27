package edu.kh.project.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.project.game.model.vo.Game;
import edu.kh.project.user.model.service.UserService;
import edu.kh.project.user.model.vo.User;

public class LoginView {
	
	private Scanner sc = new Scanner(System.in);
	private UserService service = new UserService();
	private GameView gameView = new GameView();
	
	public static User loginUser = null;
	
	public void displayMenu() {
		
		int sel = -1;
		
		do {
			try {
				if(loginUser == null) { // 유저 정보가 없으면 로그인/회원가입
					System.out.println("[로그인 / 회원가입]");
					System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
					System.out.println("1. 로그인");
					System.out.println("2. 회원가입");
					System.out.println("0. 종료");
					System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
					System.out.print("메뉴 선택 >> ");
					sel = sc.nextInt();
					sc.nextLine();
					System.out.println();
					
					switch(sel) {
					case 1 : login(); break; // 로그인 메소드 실행
					case 2 : userReg(); break; // 회원가입 메소드 실행
					case 0 : System.out.println("시스템을 종료합니다."); break;
					default : System.out.println("잘못 입력하셨습니다.");
					
					}
				}else { // 유저 정보가 있으면 gameView
					System.out.println();
					gameView.displayMenu();
					
				}
				
			}catch(InputMismatchException e ) {
				System.out.println("메뉴에 있는 숫자만 입력해주세요.");
				sc.nextLine();
			}
		}while(sel != 0);
		
	}
	
	// 회원가입
	public void userReg() {
		try {
			String userId = "";
			
			while(true) {
				System.out.print("아이디 : ");
				 userId = sc.nextLine();
				
				int result = service.checkId(userId); // 아이디 존재 확인
				
				if(result > 0) {
					System.out.println("이미 존재하는 아이디입니다. 다시 입력해주세요.");
					
				}else {
					break;
					
				}
			}
			System.out.print("비밀번호 : ");
			String userPw = sc.nextLine();
			
			System.out.print("닉네임 : ");
			String userName = sc.nextLine();
			
			int result = service.userReg(userId, userPw, userName); // 회원가입
			
			if (result > 0) {
				System.out.println("회원가입 완료");
				
			}else {
				System.out.println("회원가입 실패");
				
			}
		} catch (Exception e) {
			System.out.println("회원가입중 오류가 발생했습니다.");
			e.printStackTrace();
		}
		
	}
	
	// 로그인
	public void login() {
		try {
			String userId = "";
			
			while(true) {
				System.out.print("아이디 : ");
				 userId = sc.nextLine();
				
				int result = service.checkId(userId); // 아이디 존재 확인
				
				if(result > 0) {
					System.out.print("비밀번호 : ");
					String userPw = sc.nextLine();
					System.out.println();
					
					User user = service.login(userId, userPw); // 로그인
					
					if(user == null) {
						System.out.println("비밀번호가 잘못되었습니다.");
						
					}else {
						LoginView.loginUser = user;
						System.out.printf("%s님이 로그인 하셨습니다.\n", LoginView.loginUser.getUserId());
						break;
						
					}
				}else {
					System.out.println("존재하지 않는 아이디입니다.");
					
				}
			}
		} catch (Exception e) {
			System.out.println("로그인중 오류가 발생했습니다.");
			e.printStackTrace();
		}
		
	}
	
}
