package edu.kh.control.branch.ex.service;

import java.util.Scanner;

public class BranchService {
	
	// 분기문 break;
	// - 반복문(for, while)을 종료 시키는 구문
	
	public void example1() {
		
		// 0이 입력될 때 까지 정수를 입력 받고
		// 0이 입력되면 입력된 모든 정수의 합을 출력하고 종료
		
		Scanner sc = new Scanner(System.in);
		
		int sum = 0; // 합계 저장용 변수
		while(true) { // 무한 루프
			// 반복문은 조건식 true일 때 반복
			// 항상 true == 무한 반복 == 무한 루프
			System.out.print("정수 입력 : ");
			int input = sc.nextInt();
			
			if (input == 0) { // 입력 된 정수가 0인 경우
				break; // break; 구문이 수행되면 반복문의 끝으로 이동하고 종료됨.
					   // --> break 구문 뒤에있는 코드를 모두 건너 뛴다.
			}
			sum += input;
		}
		
		System.out.println("합계 : " + sum);
	}
	
	public void example2() {
		
		// 구구단 옆으로 출력하기
		// 2x1 = 2 2x2=4 ...
		// 단, 분기문을 이용하여 2단은 x2까지, 3단은 x3 ...
		
		for(int i=2; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				System.out.printf("%d x %d = %2d ", i, j, i*j);
				if(j==i) {
					break; // 분기문은 중첩되어있는 반복문 안에서
						   // 가장 가까운 반복문에 작용한다.
				}
			}
			System.out.println();
		}
	}
	
	public void example3() {
		
		// 문자열을 계속 입력 받아 변수 하나에 누적
		// 단, "!exit" 단어가 입력된 경우 입력을 종료하고
		// 누적했던 모든 문자열 출력
		
		Scanner sc = new Scanner(System.in);
		
		String str = ""; // 문자열 표기법으로 작성했으니까 문자열인데 내용이 없다.
		System.out.println("문자열 입력 (종료 시 !exit) : ");

		while(true){
			String input = sc.next();
			if(input.equals("!exit")) {
				// 입력된 값이 "!exit"와 같으면 true, 아니면 false
				
				// 비교연산자( == )는 문자열을 비교할 때 거의 사용할 수 없음
				// 대신에 String.equals("비교할 문자열")을 사용
				// -> 보통 기본 자료형 비교 시 ==
				//	  기본 자료형을 제외한 참조형 비교시 .equals() 사용
				break;
			}
			str += input + "\n";
		}
		System.out.println(str);
	}
	
	
	
	// (참고) do ~ while문
	public void example4() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("문자열 입력 (종료 시 !exit)");
		
		String str = ""; // 문자열 누적 저장용 변수
		String input = "!exit"; // 입력 받는 용도의 변수
		
		 do {
			
			input = sc.nextLine();
			
			if( !input.equals("!exit")) {
				str += input + "\n";
				
			}
			
		} while(!input.equals("!exit"));
		 
		 // do ~ while문
		 // 일단은 do 내부에 있는 구문을 최소 한번은 수행하고
		 // 마지막에 반복 조건을 따지는 구문
		 
		 // do {
		 // 최소 한번은 수행할 코드
		 // } while(조건식);
		 
		 System.out.println(str);
	}
	
	public void example5() {
		
		// continue : 반복문 내에서만 사용 가능하며
		//			  다음 반복으로 건너뛰는 기능
		
		// - for문에서 continue : 증감식 부분으로 이동하여 증감 후 조건식을 따짐
		
		// - while문에서 continue : 조건식으로 이동
		
		// 1~10 사이에 있는 3의 배수의 합 구하기
		int sum = 0;
		for(int i =1; i<=10; i++) {
			if(i%3!=0) {
				continue;
			}
			sum += i;
		}
		System.out.println("합계 : " + sum);
	}
	
	public void example6() {
		// 1~100까지 1씩 증가하며 모두 출력 반복문에서
		// 5의 배수는 건너뛰고
		// 40일 때 종료 (분기문 사용)
		
		for(int i =1; i<=100; i++) {
			if (i==40) {
				break;
			}
			if(i%5 == 0) {
				continue;
			}
			System.out.println(i);
			
		}
	}
	
	public void example7() {
		
		// 사용자로부터 입력 받은 정수가 소수인지 판별하는 프로그램
		// 단, 입력 받은 수가 2보다 작을 경우 "잘못 입력하셨습니다." 출력
		
		// ex)
		// 입력 : 5
		// 소수입니다.
		
		// 입력 : 4
		// 소수가 아닙니다.
		
		// 입력 : 1
		// 잘못 입력하셨습니다.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력 : ");
		int input = sc.nextInt();
		
		if( input < 2 ) {
			System.out.println("잘못 입력하셨습니다.");
		}else {
			
			boolean flag = true; // 소수 판별용 변수
			// 소수 판별
			for(int i=2; i<input; i++) {
				// 반복문에서 i가 하는 역할 : 입력된 값을 나누는 역할
				// --> i로 나눴을 때 나머지가 0이 나옴
				//	== 1과 자기 자신을 제외한 수로 나눌 수 있다
				//	== 소수가 아니다
				if(input % i ==0) { // 나누어 떨어짐 == 소수 아님
					flag = false; // 소수가 아님을 저장
					break; 	// 한번 이라도 나누어 떨어진경우
							// 소수가 아닌것을 알수 있으므로
							// 남은 수로 나누는 수고를 할 필요 없이 반복 종료
				}
			}
			// for문이 끝났지만 한번도 if문이 수행되지 않음 == 소수
			if(flag) {
				System.out.println("소수 입니다.");
			}else {
				System.out.println("소수가 아닙니다.");
			}
		}
	}
	
	public void example8() {
		// 예제 7번의 코드에서
		// 잘못 입력한 경우
		// 프로그램을 종료하는 것이 아닌
		// 다시 입력을 받을 수 있게 구현하기
		// (정상 입력 시 한번 검사하고 종료)
		
		Scanner sc = new Scanner(System.in);
	
		boolean flag = true;
		int num = 0;
		
		do {
			System.out.print("숫자 입력 : ");
			num = sc.nextInt();
			for(int i=2; i<num; i++){
				if(num % i == 0) {
					flag = false;
					break;
				}
			}
			if(num<2) {
				System.out.println("잘못 입력하셨습니다");
			}
		}while(num<2);
		
		if(flag) {
			System.out.println("소수입니다");
		}else {
			System.out.println("소수가 아닙니다");
		}
	}
	
	
	
	// 3, 6, 9 족보 만들기
	
	//	- 조건1 : 10 ~ 99 사이 숫자가 입력 되었을 때만 족보 생성
	//	- 조건2 : 10 ~ 99 사이가 아닐 경우 "다시 입력해주세요" 출력 후 숫자 재입력
	//	- 조건3 : 숫자가 3, 6, 9가 포함되어 있을 경우 "짝", 아니면 해당 숫자
	//	- 조건4 : 33, 36, 39, 63, 66, 69, 93, 96, 99 "짝짝"
	//	
	//	결과 화면
	//	
	//	 1  2  짝  4  5  짝  7  8 짝 10
	//	11 12  짝 14 15  짝 17 18 짝 20
	//	21 22  짝 24 25  짝 27 28 짝 짝
	//	 짝 짝 짝짝  짝 짝 짝짝 짝 짝 짝짝 40
	
	public void example9() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("숫자 입력 : ");
			int num = sc.nextInt();
			
			if (!(num>= 10 && num<=99)) {
				System.out.println("다시 입력해주세요");
				continue;
			}else {
				for(int i = 1; i <= num; i++) {
					int ten = i / 10;
					int one = i % 10;
					if((ten % 3 ==0 && ten != 0)&&(one % 3 ==0 && one != 0)) {
						System.out.printf("짝짝 ", one);
					}
					else if(one % 3 ==0 && one != 0) {
						System.out.printf("짝 ", one);
					}
					else if(ten % 3 ==0 && ten != 0) {
						System.out.printf("짝 ", one);
					}else {
						if(ten == 0) {
							System.out.printf("%d ", one);
						}else {
							System.out.printf("%d%d ", ten, one);
						}
					}
					if(i % 10 == 0) {
						System.out.println();
					}
				}
				break;
			}
		}
		
	}
}
