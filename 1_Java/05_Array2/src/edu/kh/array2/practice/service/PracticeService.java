package edu.kh.array2.practice.service;

import java.util.Scanner;

public class PracticeService {
	public void practice1() {
//		3행 3열짜리 문자열 배열을 선언 및 할당하고
//		인덱스 0행 0열부터 2행 2열까지 차례대로 접근하여 “(0, 0)”과 같은 형식으로 저장 후 출력하세요.
//		[실행 화면]
//		(0, 0)(0, 1)(0, 2)
//		(1, 0)(1, 1)(1, 2)
//		(2, 0)(2, 1)(2, 2)
		String[][] arr = new String[3][3];
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = "("+i+", "+j+")";
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public void practice2() {
//		4행 4열짜리 정수형 배열을 선언 및 할당하고
//		1) 1 ~ 16까지 값을 차례대로 저장하세요.
//		2) 저장된 값들을 차례대로 출력하세요.
//		[실행 화면]
//		1 2 3 4
//		5 6 7 8
//		9 10 11 12
//		13 14 15 16
		
		int[][] arr = new int[4][4];
		int num = 1;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = num++;
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public void practice3() {
//		4행 4열짜리 정수형 배열을 선언 및 할당하고
//		1) 16 ~ 1과 같이 값을 거꾸로 저장하세요.
//		2) 저장된 값들을 차례대로 출력하세요.
//		[실행 화면]
//		16 15 14 13
//		12 11 10 9
//		8 7 6 5
//		4 3 2 1 
		
		int[][] arr = new int[4][4];
		int num = 16;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = num--;
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public void practice4() {
		int[][] arr = new int[4][4];
		
		for(int i=0; i<arr.length; i++) {
			int sum = 0;
			for(int j=0; j<arr[i].length; j++) {
				if(j==arr[i].length-1) {
					arr[i][j] = sum;
				}else {
					arr[i][j] = (int)(Math.random()*11);
					sum += arr[i][j];
				}
			}
		}
		int temp = 0;
		for(int j=0; j<arr[temp].length; j++) {
			int sum = 0;
			for(int i=0; i<arr.length; i++) {
				if(i==arr.length-1) {
					if(i==arr.length-1 && j==arr[i].length-1) {
						arr[i][j] = sum*2;
					}else {
						arr[i][j] = sum;
					}
				}else {
						sum += arr[i][j];
				}
				System.out.printf("%4d", arr[i][j]);
				
			}
			System.out.println();
		}
	}
	
	// 4번문제 변형
	public void practice4b() {
		int[][] arr = new int[4][4];
		
		// 상수 사용 방법 == 변하지 않는 특정 값의 이름을 붙여주는 용도
		final int ROW_LAST_INDEX = arr.length-1;
		final int COL_LAST_INDEX = arr[0].length-1;
		
		// arr이 참조 하고있는 2차원 배열의 요소를
		// 모두 순차적으로 접근하여
		// 난수대입, 행의합, 열의합, 총합, 출력까지 한 번에 수행
		
		for(int row=0; row<arr.length; row++) {
			for(int col=0; col<arr[row].length; col++) {
				
				// 마지막 행, 열이 아닌 경우에만 난수 대입
				if( row != ROW_LAST_INDEX && col != COL_LAST_INDEX ) {
					
					arr[row][col] = (int)(Math.random() * 10 + 1); // 난수 대입
					
					// 각 행의 마지막 열에 난수를 누적
					arr[row][COL_LAST_INDEX] += arr[row][col];
					
					// 각 열의 마지막 행에 난수를 누적
					arr[ROW_LAST_INDEX][col] += arr[row][col];
					
					// 생성된 난수를 4행 4열에 누적
					arr[ROW_LAST_INDEX][COL_LAST_INDEX] += arr[row][col];
				}
				
				System.out.printf("%4d",arr[row][col]); // 출력 
			}
		}
	}
	
	
	public void practice5() {
//		2차원 배열의 행과 열의 크기를 사용자에게 직접 입력받되, 1~10사이 숫자가 아니면
//		“반드시 1~10 사이의 정수를 입력해야 합니다.” 출력 후 다시 정수를 받게 하세요.
//		크기가 정해진 이차원 배열 안에는 영어 대문자가 랜덤으로 들어가게 한 뒤 출력하세요.
//		(char형은 숫자를 더해서 문자를 표현할 수 있고 65는 A를 나타냄, 알파벳은 총 26글자)
//		[실행 화면]
//		행 크기 : 5
//		열 크기 : 4
//		T P M B
//		U I H S
//		Q M B H
//		H B I X
//		G F X I 
		
		Scanner sc = new Scanner(System.in);
		
		int num1 = -1;
		do {
			System.out.print("행 크기 : ");
			num1 = sc.nextInt();
			if(num1<1 || num1>10) {
				System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
			}
		}while(num1<0 || num1> 10);
		
		int num2 = -1;
		do {
			System.out.print("열 크기 : ");
			num2 = sc.nextInt();
			if(num2<1 || num2>10) {
				System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
			}
		}while(num2<0 || num2> 10);
		
		char[][] arr = new char[num1][num2];
		
		
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = (char)((Math.random()*26)+65);
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void practice6() {
//		사용자에게 행의 크기를 입력 받고 그 수만큼의 반복을 통해 열의 크기도 받아
//		문자형 가변 배열을 선언 및 할당하세요.
//		그리고 각 인덱스에 ‘a’부터 총 인덱스의 개수만큼 하나씩 늘려 저장하고 출력하세요.
//		[실행 화면]
//		행의 크기 : 4
//		0열의 크기 : 2
//		1열의 크기 : 6
//		2열의 크기 : 3
//		3열의 크기 : 5
//		a b
//		c d e f g h
//		i j k
//		l m n o p
		Scanner sc = new Scanner(System.in);
		System.out.print("행의 크기 : ");
		int rowSize = sc.nextInt();
		
		char[][] arr = new char[rowSize][];
		
		int num = 0;
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(i+"열의 크기 : ");
			int colSize = sc.nextInt();
			arr[i] = new char[colSize];
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = (char)(num+97);
				num++;
			}
		}
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void practice7() {
//		1차원 문자열 배열에 학생 이름 초기화되어 있다.
//		3행 2열 짜리 2차원 문자열 배열 2개를 새로 선언 및 할당하여
//		학생 이름을 2차원 배열에 순서대로 저장하고 아래와 같이 출력하시오.
//		(첫 번째 2차원 배열이 모두 저장된 경우 두 번째 2차원 배열에 저장 진행)
//		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배", 
//		"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
//		[실행 화면]
//		== 1분단 ==
//		강건강 남나나
//		도대담 류라라
//		문미미 박보배
//		== 2분단 ==
//		송성실 윤예의
//		진재주 차천축
//		피풍표 홍하하
		
		
		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배", 
				"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
		
		String[][] str1 = new String[3][2];
		String[][] str2 = new String[3][2];
		
		int num = 0;
		System.out.println("== 1분단 ==");
		for(int i=0; i<str1.length; i++) {
			for(int j=0; j<str1[i].length; j++) {
				str1[i][j] = students[num];
				num++;
				System.out.print(str1[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("== 2분단 ==");
		for(int i=0; i<str2.length; i++) {
			for(int j=0; j<str2[i].length; j++) {
				str2[i][j] = students[num];
				num++;
				System.out.print(str2[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void practice8() {
//		위 문제에서 자리 배치한 것을 가지고 학생 이름을 검색하여
//		해당 학생이 어느 자리에 앉았는지 출력하세요.
//		[실행 화면]
//		== 1분단 ==
//		강건강 남나나
//		도대담 류라라
//		문미미 박보배
//		== 2분단 ==
//		송성실 윤예의
//		진재주 차천축
//		피풍표 홍하하
//		============================
//		검색할 학생 이름을 입력하세요 : 차천축
//		검색하신 차천축 학생은 2분단 2번째 줄 오른쪽에 있습니다.
		
		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배", 
				"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
		
		Scanner sc = new Scanner(System.in);
		
		String[][] str1 = new String[3][2];
		String[][] str2 = new String[3][2];
		
		int num = 0;
		System.out.println("== 1분단 ==");
		for(int i=0; i<str1.length; i++) {
			for(int j=0; j<str1[i].length; j++) {
				str1[i][j] = students[num];
				num++;
				System.out.print(str1[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("== 2분단 ==");
		for(int i=0; i<str2.length; i++) {
			for(int j=0; j<str2[i].length; j++) {
				str2[i][j] = students[num];
				num++;
				System.out.print(str2[i][j] + " ");
			}
			System.out.println();
		}
		
		// 검색
		System.out.println("===================");
		System.out.print("검색할 학생 이름을 입력하세요 : ");
		
		String inputName = sc.next();
		
		// 검색 후 검색 결과가 있을 경우에
		// 학생의 위치를 저장할 변수를 선언
		int seat = 0; // 몇 분단
		int searchRow = 0; // 몇 번줄
		String direction = ""; // 왼쪽, 오른쪽 방향
		
		
		for(int i=0; i<str1.length; i++) {
			for(int j=0; j<str1[i].length; j++) {
				
				// 1분단에 검색한 학생이 있는 경우
				if(inputName.equals( str1[i][j] )) {
					seat = 1; // 1분단
					searchRow = i + 1; // 몇 번줄
					
					if (j == 0) {
						direction = "왼쪽";
					}else {
						direction = "오른쪽";
					}
				} else if ( inputName.equals( str2[i][j] )) {
					seat = 2; // 1분단
					searchRow = i + 1; // 몇 번줄
					
					if (j == 0) {
						direction = "왼쪽";
					}else {
						direction = "오른쪽";
					}
				}
			}
		}
	}
	
	public void practice9() {
//		String 2차원 배열 6행 6열을 만들고 행의 맨 위와 제일 앞 열은 각 인덱스를 저장하세요.
//		그리고 사용자에게 행과 열을 입력 받아 해당 좌표의 값을 'X'로 변환해 2차원 배열을 출력하세요.
//		[실행 화면]
//		행 인덱스 입력 : 4
//		열 인덱스 입력 : 2
//		  0 1 2 3 4
//		0 
//		1
//		2
//		3
//		4 X
//		String[][] str = {
//				{" ", "1", "2", "3", "4"},
//				{"1", " ", " ", " ", " "},
//				{"2", " ", " ", " ", " "},
//				{"3", " ", " ", " ", " "},
//				{"4", " ", " ", " ", " "}
//		};
//		
		String[][] str = new String[6][6];
		
		Scanner sc = new Scanner(System.in);
		System.out.print("행 인덱스 입력 : ");
		int rowIndex = sc.nextInt()+1;
		System.out.print("열 인덱스 입력 : ");
		int colIndex = sc.nextInt()+1;
		
		
		
		for(int i=0; i<str.length; i++) {
			for(int j=0; j<str[i].length; j++) {
				if (i>=1 && j == 0) {
					System.out.print(i-1);
					str[i][j] = " ";
				}else if (j>=1 && i == 0){
					System.out.print(j-1);
					str[i][j] = " ";
				}else if(i==rowIndex && j == colIndex) {
					str[i][j] = "X";
				}else if(str[i][j] == null) {
					str[i][j] = " ";
				}
				System.out.print(str[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void practice10() {
//		실습문제9와 내용은 같으나 행 입력 시 99가 입력되지 않으면 무한 반복이 되도록 구현하세요.
//		[실행 화면]
//		행 인덱스 입력 : 2 		행 인덱스 입력 : 3
//		열 인덱스 입력 : 2 		열 인덱스 입력 : 1
//		  0 1 2 3 4 			  0 1 2 3 4
//		0 					0
//		1 					1
//		2     X 			2 
//		3 					3   X
//		4					4
//							행 인덱스 입력 >> 99
//							프로그램 종료
		
//		String[][] str = {
//				{" ", "1", "2", "3", "4"},
//				{"1", " ", " ", " ", " "},
//				{"2", " ", " ", " ", " "},
//				{"3", " ", " ", " ", " "},
//				{"4", " ", " ", " ", " "}
//		};
		
		String[][] str = new String[6][6];

		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("행 인덱스 입력 : ");
			int rowIndex = sc.nextInt()+1;
			if (rowIndex-1 == 99) {
				break;
			}
			System.out.print("열 인덱스 입력 : ");
			int colIndex = sc.nextInt()+1;
			
			for(int i=0; i<str.length; i++) {
				for(int j=0; j<str[i].length; j++) {
					if (i>=1 && j == 0) {
						System.out.print(i-1);
						str[i][j] = " ";
					}else if (j>=1 && i == 0){
						System.out.print(j-1);
						str[i][j] = " ";
					}else if(i==rowIndex && j == colIndex) {
						str[i][j] = "X";
					}else if(str[i][j] == null) {
						str[i][j] = "  ";
					}
					System.out.print(str[i][j] + " ");
				}
				System.out.println();
			}
		}
		System.out.println("프로그램 종료");
	}
}
