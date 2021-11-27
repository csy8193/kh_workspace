package edu.kh.project.view;

import java.util.List;
import java.util.Scanner;

import edu.kh.project.game.model.service.GameService;
import edu.kh.project.game.model.vo.Game;

public class RSPGame {
	
	private Scanner sc = new Scanner(System.in);
	private GameService service = new GameService();
	
	public void displayMenu() {
		
		int sel = -1;
		
		do {
			System.out.println("[가위바위보 게임]");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("1. 게임 시작");
			System.out.println("2. 가위바위보 전체 랭킹");
			System.out.println("0. 게임 종료");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.print("메뉴 선택 >> ");
			sel = sc.nextInt();
			sc.nextLine();
			System.out.println();
			
			switch(sel) {
			case 1 : gameStart(); break; // 가위바위보 게임 시작
			case 2 : rpsAllRank(); break; // 가위바위보 전체 랭킹
			case 0 : break;
			default : System.out.println("잘못 입력하셨습니다.");
			
			}
			
			System.out.println();
			
			
			
		}while(sel != 0);
		
	}

	// 가위바위보 게임 시작
	private void gameStart() {
		int random = (int)(Math.random() * 3 + 1); // 랜덤값 저장
		String rps = "";
		
		// 랜덤값을 가위, 바위, 보로 변환
		if(random == 1) rps = "가위";
		if(random == 2) rps = "바위";
		if(random == 3) rps = "보";
		
		System.out.print("가위 / 바위 / 보 입력 : ");
		String str = sc.nextLine();
		
		switch(str) {
		case "가위" : case "바위" : case "보" : // 가위, 바위, 보를 입력했을 경우
			try {
				Game game = service.rpsGame(rps, str);
				
				System.out.println("컴퓨터 : " + rps);
				
				if(game != null) {
					if(game.getRpsWl() == 1 ) {
						System.out.println("승리");
						
					}else if (game.getRpsWl() == 0) {
						System.out.println("무승부");
						
					}else {
						System.out.println("패배");
						
					}
					System.out.println("현재 점수 : " + game.getRpsScore());
					System.out.println("현재 랭킹 : " + game.getRpsRank());
					
				}else {
					System.out.println("게임 정보에 문제가 발생했습니다.");
					
				}
			} catch (Exception e) {
				System.out.println("게임중 문제가 발생했습니다.");
				e.printStackTrace();
			}
			break;
			
		default : System.out.println("잘못 입력하셨습니다."); // 다른 값을 입력했을 경우
		}
		
	}
	
	// 가위바위보 전체 랭킹
	private void rpsAllRank() {
		try {
			List<Game> gameList = service.rpsAllRank(); // 랭킹정보 가져오기
			
			if(gameList.isEmpty()) {
				System.out.println("랭크된 유저가 없습니다.");
				
			}else {
				System.out.printf("| %s | %6s | %2s |\n", "등수", "유저 닉네임", "점수");
				for(Game game : gameList) {
					System.out.printf("| %2d | %8s | %2d |\n", game.getRpsRank(), game.getUserName(), game.getRpsScore());
					
				}
				
			}
		} catch (Exception e) {
			System.out.println("정보를 가져오는데 문제가 생겼습니다.");
			e.printStackTrace();
		}  
		
	}
}
