package edu.kh.project.view;

import java.util.List;
import java.util.Scanner;

import edu.kh.project.game.model.service.GameService;
import edu.kh.project.game.model.vo.Game;
import edu.kh.project.user.model.service.UserService;

public class UserMethod {
	
	private GameService gameService = new GameService();
	private UserService userService = new UserService();
	private Scanner sc = new Scanner(System.in);

	// 내 정보
	public void selectUser() {
		
		Game game = new Game();
		
		System.out.println("닉네임 : " + LoginView.loginUser.getUserName());
		
		try {
			game = gameService.selectAllScore();
			
			System.out.println("[가위바위보]");
			if(game.getRpsYn() == 1) {
				System.out.printf("가위바위보 점수 : %d점\t가위바위보 랭킹 : %d등\n", game.getRpsScore(), game.getRpsRank());
				
			}else {
				System.out.println("가위바위보를 한번도 하지 않았습니다.");
				
			}
			System.out.println();
			System.out.println("[업/다운]");
			if(game.getUpDownYn() == 1) {
				System.out.printf("업/다운 점수 : %d점\t\t업/다운 랭킹 : %d등\n", game.getUpDownScore(), game.getUpDownRank());
				
			}else {
				System.out.println("업/다운을 한번도 하지 않았습니다.");
				
			}
		}catch (Exception e) {
			System.out.println("정보를 불러오는데 문제가 생겼습니다");
			e.printStackTrace();
		}
		
		
	}
	
	// 비밀번호 변경
	public void changePw() {
		
		System.out.print("비밀번호를 변경하시겠습니까?(y/n) : "); // 비밀번호를 변경할지 확인 y or n
		char yn = sc.next().toLowerCase().charAt(0);
		sc.nextLine();
		
		if(yn == 'n') { // 비밀번호 변경 종료
			System.out.println("비밀번호 변경을 종료합니다.");
			
		}else if (yn == 'y') { // 비밀번호 변경
			System.out.print("현재 비밀번호 입력 : ");
			String pw = sc.nextLine();
			
			try {
				int check = userService.checkPw(pw); // 현재 비밀번호 확인
				
				if(check > 0) { // 비밀번호가 확인됐을 경우
					String newPw = "";
					while(true) { // 변경할 비밀번호를 입력, 확인
						System.out.print("변경할 비밀번호 입력 : ");
						newPw = sc.nextLine();
						System.out.print("변경할 비밀번호 확인 : ");
						String checkNewPw = sc.nextLine();
						if(newPw.equals(checkNewPw)) { // 변경할 비밀번호가 맞을경우
							break;
						}else { // 변경할 비밀번호가 맞지 않을경우
							System.out.println("비밀번호를 확인해주세요.");
							System.out.println();
							
						}
					}
					int result = userService.changePw(newPw); // 비밀번호 변경
					
					if(result > 0) { // 비밀번호 변경 업데이트 됐을경우
						System.out.println("비밀번호 변경이 완료됐습니다.");
						
					}else { // 비밀번호 변경 업데이트 실패했을경우
						System.out.println("비밀번호 변경을 실패했습니다.");
					}
					
				}else { // 비밀번호가 맞지 않을경우
					System.out.println("비밀번호를 잘못 입력하셨습니다.");
					
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("비밀번호 확인중 오류가 발생했습니다.");
				
			}
		}else {
			System.out.println("y나 n만 입력해주세요.");
			
		}
	}
	
	// 회원 탈퇴
	public void deleteUser() {
		System.out.print("회원을 탈퇴하시겠습니까?(y/n) : "); //  회원을 탈퇴할지 확인 y or n
		char yn = sc.next().toLowerCase().charAt(0);
		sc.nextLine();
		
		if(yn == 'n') { // 회원 탈퇴 종료
			System.out.println("회원 탈퇴를 종료합니다.");
			
		}else if (yn == 'y') { // 회원 탈퇴 진행
			System.out.print("현재 비밀번호 입력 : ");
			String pw = sc.nextLine();
			
			try {
				int check = userService.checkPw(pw); // 현재 비밀번호 확인
				
				if(check > 0) { // 비밀번호가 확인됐을 경우
					int result = userService.deleteUser(); // 회원 탈퇴
					
					if(result > 0) { // 회원 탈퇴가 성공했을경우
						LoginView.loginUser = null;
						System.out.println("회원 탈퇴되었습니다.");
						
					}else {
						System.out.println("회원 탈퇴 실패");
						
					}
				}else { // 비밀번호가 맞지 않을경우
					System.out.println("비밀번호를 잘못 입력하셨습니다.");
					
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("회원 탈퇴중 오류가 발생했습니다.");
				
			}
		}else {
			System.out.println("y나 n만 입력해주세요.");
			
		}
		
	}
	
	
}
