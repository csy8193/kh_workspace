package edu.kh.jdbc.view;

import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.board.model.service.BoardService;
import edu.kh.jdbc.board.model.vo.Board;

public class BoardView {
	
	private Scanner sc = new Scanner(System.in);
	
	private BoardService service = new BoardService();
	
	// 게시글 삽입
	public void insertBoard() {
		System.out.println("[게시글 작성]");
		
		System.out.print("제목 : ");
		String boardTitle = sc.nextLine();
		
		
		System.out.println("내용 입력 (종료 시 !q 입력 후 엔터) ");
		String boardContent = "";
		
		while(true) {
			String temp = sc.nextLine();
			if(temp.equals("!q")) {
				break;
				
			}else {
				boardContent += temp + "\n";
				
			}
		}
		
		// 게시글 삽입 Service 호출 후 결과 반환 받기
		try {
			
			int result = service.insertBoard(boardTitle, boardContent);
			
			if(result > 0) {
				System.out.println("게시글이 작성되었습니다.");
				
			}else {
				System.out.println("게시글 작성 실패");
				// 이 구문을 보게되는 경우 service, dao의 return 구문이 잘못되었을 가능성이 크다.
			}
			
		}catch(Exception e) {
			System.out.println("게시글 삽입 과정에서 문제가 발생했습니다.");
			e.printStackTrace();
			
		}
		
		
	}
	
	// 입력 받은 번호의 게시글이 로그인한 회원의 글이 맞는지 확인
	private int checkBoard() throws Exception{
		System.out.print("게시글 번호 입력 : ");
		int boardNo = sc.nextInt();
		sc.nextLine();
		
		int result = service.checkBoard(boardNo);
		
		if(result > 0) {
			return boardNo; // 글 번호를 반환해서 수정, 삭제 시 활용
			
		}else {
			return 0;
			
		}
	}
	
	// 게시글 수정
	public void updateBoard() {
		System.out.println("[게시글 수정]");
		
		try {
			
			int boardNo = checkBoard();
			
			// 본인 게시글이 맞는지 확인
			if(boardNo > 0) {
				
				System.out.print("수정할 제목 입력 : ");
				String boardTitle = sc.nextLine();
				
				
				System.out.println("수정할 내용 입력 (종료 시 !q 입력 후 엔터) ");
				String boardContent = "";
				
				while(true) {
					String temp = sc.nextLine();
					if(temp.equals("!q")) {
						break;
						
					}else {
						boardContent += temp + "\n";
						
					}
				}
				
				int result = service.updateBoard(boardTitle, boardContent, boardNo);
				
				if(result > 0) {
					System.out.println("수정 완료");
					
				}else {
					System.out.println("수정 실패");
					
				}
				
			}else {
				System.out.println("본인이 작성한 글만 수정할 수 있습니다.");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// 게시글 삭제
	public void deleteBoard() {
		System.out.println("[게시글 삭제]");
		
		// 1) 본인 글이 맞는지 확인
		// 2-1) 아닐경우 -> 작성한 글만 삭제 할수 있습니다
		// 2-2) 맞을경우 -> 정말로 삭제하시겠습니까? y/n
		
		// 3) n이면 취소
		// 	  y면 삭제 -> 삭제 성공 / 삭제 실패
		//    잘못 입력하는 경우 "잘못 입력하셨습니다. 다시 입력해주세요" 무한반복
		
		try {
			int boardNo = checkBoard();
			
			if(boardNo > 0) {
				while(true) {
					System.out.print("정말로 삭제하시겠습니까? (y/n)");
					char yn = sc.nextLine().toLowerCase().charAt(0);
					
					if(yn == 'y') {
						int result = service.deleteBoard(boardNo);
						
						if(result > 0) {
							System.out.println("게시글이 삭제되었습니다.");
							
						}else {
							System.out.println("게시글 삭제 실패했습니다.");
							
						}
						break;
					}else if (yn == 'n') {
						System.out.println("삭제 취소되었습니다.");
						break;
					}else {
						System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
						
					}
				}
			}else {
				System.out.println("본인이 작성한 글만 삭제할 수 있습니다.");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

	// 게시글 상세 조회
	public void selectBoard() {
		
		System.out.println("[게시글 상세 조회]");
		
		System.out.println("게시글 번호 입력 : ");
		int boardNo = sc.nextInt();
		sc.nextLine();
		
		try {
			Board board = service.selectBoard(boardNo);
			
			if(board == null) {
				System.out.println("존재하지 않는 게시글 번호입니다.");
				
			}else {
				System.out.println(board);
				
			}
			
		}catch (Exception e) {
			System.out.println("게시글 상세 조회 중 문제가 발생했습니다.");
			e.printStackTrace();
			
		}
		
		
	}
	
	// 게시글 목록 출력 메소드
	private void printBoardList(List<Board> boardList) {
		
		if(boardList.isEmpty()) { // boardList가 비어있다 == 조회 결과가 없다 == 게시글이 없다
			System.out.println("조회 결과가 없습니다.");
			
		}else {
				
			System.out.printf("번호             제목           조회수  작성자  작성일\n"
					+ "------------------------------------------------------\n");
	
			// 향상된 for문
			for( Board board  : boardList  ) {
				
				System.out.printf("%2d %15s %15d %5s %s\n",
								  board.getBoardNo(), board.getBoardTitle(),
								  board.getReadCount(), board.getMemberNm(), 
								  board.getCreateDt().toString());
				
			}
		
		}
		
	}
	
	
	// 게시글 목록 조회
	public void selectBoardList() {
		
		System.out.println("[게시글 목록 조회]");
		
		try {
			List<Board> boardList = service.selectBoardList();
			
			printBoardList(boardList);
			
		}catch (Exception e) {
			System.out.println("게시글 목록 조회 중 문제가 발생했습니다.");
			e.printStackTrace();
			
		}
		
	}

	// 게시글 검색
	public void searchBoard() {
		
		System.out.println("[게시글 검색]");
		
		int searchKey = 0;
		
		while(true) {
			// 1. 제목, 내용, 제목+내용, 작성자 중 어떤 검색을 할 것인지 선택
			System.out.println("1. 제목 / 2. 내용 / 3. 제목+내용 / 4. 작성자");
			System.out.print("검색 카테고리 선택 : ");
			searchKey = sc.nextInt();
			sc.nextLine();
			
			if(searchKey >= 1 && searchKey <= 4) {
				break;
			}else {
				System.out.println("1~4 사이 번호만 입력해주세요.");
			}
			
		}
		
		// 2. 검색어 입력
		System.out.println("검색어 입력 : ");
		String searchValue = sc.nextLine();
		
		// 3. 게시글 검색 Service 호출 -> 결과 반환
		try {
			List<Board> searchList = service.searchList(searchKey, searchValue);
			
			// 4. printBoardList() 메소드를 이용해서 출력
			printBoardList(searchList);
			
		} catch (Exception e) {
			System.out.println("게시글 검색 중 문제가 발생했습니다.");
			e.printStackTrace();
		}
		
		
		
	}
}
