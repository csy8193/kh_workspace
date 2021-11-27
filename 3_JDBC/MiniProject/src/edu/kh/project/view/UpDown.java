package edu.kh.project.view;

import java.util.List;
import java.util.Scanner;

import edu.kh.project.game.model.service.GameService;
import edu.kh.project.game.model.vo.Game;

public class UpDown {
	
	private Scanner sc = new Scanner(System.in);
	private GameService service = new GameService();
	
	public void displayMenu() {
		
		int sel = -1;
		
		do {
			System.out.println("[업/다운 게임]");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("1. 게임 시작");
			System.out.println("2. 업/다운 전체 랭킹");
			System.out.println("0. 게임 종료");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.print("메뉴 선택 >> ");
			sel = sc.nextInt();
			sc.nextLine();
			System.out.println();
			
			switch(sel) {
			case 1 : upDownStart(); break; // 업/다운 게임 시작
			case 2 : upDownAllRank(); break; // 업/다운 전체 랭킹
			case 0 : break;
			default : System.out.println("잘못 입력하셨습니다.");
			
			}
			
			System.out.println();
			
			
			
		}while(sel != 0);
		
	}

	// 업/다운 게임 시작
	private void upDownStart() {
		int random = (int)(Math.random()*100+1); // 변수 생성
		int count = 1; // 랜덤 숫자를 몇번만에 맞추는지 저장할 변수, 이후에 점수를 저장할 변수
		Game game = new Game();

		while(true) {
			System.out.println("1~100사이 숫자 입력 : ");
			int num = sc.nextInt();
			sc.nextLine();
			
			if(num == random) {
				try {
					if(count<=5) count = 1; // 5번 이하면 1점
					else if (count <= 8) count = 0; // 8번 이하면 0점
					else count = -1; // 나머지 -1점
					
					game = service.upDownStart(count);
					
					if(game == null) {
						System.out.println("게임 정보를 불러올수 없습니다.");
						
					}else {
						System.out.println("정답입니다.");
						System.out.println("업/다운 점수 : " + game.getUpDownScore());
						System.out.println("업/다운 랭킹 : " + game.getUpDownRank());
						
					}
				} catch (Exception e) {
					System.out.println("게임중 오류가 발생했습니다.");
					e.printStackTrace();
				}
				
				break;
				
			}else if(num < random){
				System.out.println("UP!");
				count += 1;
				
			}else if(num > random) {
				System.out.println("DOWN!");
				count += 1;
				
			}
		}
	}
	
	// 업/다운 전체 랭킹
	private void upDownAllRank() {
		try {
			List<Game> gameList = service.UpdownAllRank();
			
			if(gameList.isEmpty()) {
				System.out.println("랭크된 유저가 없습니다.");
				
			}else {
				System.out.printf("| %s | %6s | %2s |\n", "등수", "유저 닉네임", "점수");
				for(Game game : gameList) {
					System.out.printf("| %2d | %8s | %2d |\n", game.getUpDownRank(), game.getUserName(), game.getUpDownScore());
					
				}
				
			}
		} catch (Exception e) {
			System.out.println("정보를 가져오는데 문제가 생겼습니다.");
			e.printStackTrace();
		}  
		
	}
}
