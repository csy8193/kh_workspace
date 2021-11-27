package edu.kh.project.view;

import java.util.List;
import java.util.Scanner;

import edu.kh.project.game.model.vo.Game;
import edu.kh.project.user.model.service.UserService;

public class GameView {
	
	private Scanner sc = new Scanner(System.in);
	private RSPGame rspGame = new RSPGame();
	private UserMethod userMethod = new UserMethod();
	private UserService service = new UserService();
	private UpDown upDown = new UpDown();

	public void displayMenu() {
		
		int sel = -1;
		

		System.out.println("[게임 메뉴]");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("1. 가위바위보"); // RPSGame
		System.out.println("2. 업/다운"); // UpDown
		System.out.println("3. 총 랭킹");
		System.out.println();
		
		// UserMethod
		System.out.println("4. 내 정보");
		System.out.println("5. 비밀번호 변경");
		System.out.println("6. 회원 탈퇴");
		System.out.println("0. 로그아웃");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("메뉴 선택 >> ");
		sel = sc.nextInt();
		sc.nextLine();
		System.out.println();
		
		switch(sel) {
		case 1 : rspGame.displayMenu(); break; // 가위바위보게임 화면
		case 2 : upDown.displayMenu(); break; // 업다운게임 화면
		case 3 : allRanking(); break; // 총 랭킹
		
		// UserMethod
		case 4 : userMethod.selectUser(); break; // 내 정보
		case 5 : userMethod.changePw(); break; // 비밀번호 변경
		case 6 : userMethod.deleteUser(); break; // 회원 탈퇴
		case 0 : LoginView.loginUser = null; break; // 로그아웃
		default : System.out.println("잘못 입력하셨습니다.");
		
		}
		System.out.println();
			
		
	}
	
	// 총 랭킹
	private void allRanking() {
		
		try {
			List<Game> rankList = service.allRanking();
			
			if(rankList.isEmpty()) {
				System.out.println("랭크된 유저가 없습니다.");
				
			}else {
				System.out.printf("| %s | %6s | %2s |\n", "등수", "유저 닉네임", "점수");
				for(Game game : rankList) {
					System.out.printf("| %2d | %8s | %2d |\n", game.getRpsRank(), game.getUserName(), game.getRpsScore());
					
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
