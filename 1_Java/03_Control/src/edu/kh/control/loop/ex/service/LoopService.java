package edu.kh.control.loop.ex.service;

import java.util.Scanner;

public class LoopService {
	
//	for문
//	
//	for(초기식; 조건식; 증감식) {
//		반복 수행 코드
//	}
//	
//	- 초기식 : for문 내부에서 사용 할 변수. 보통 for문의 반복 제어를 위해 사용함.
//	
//	- 조건식 : for문의 반복 여부를 지정하는 식
//			 보통 초기식에 사용한 변수를 이용하여 조건식을 작성함.
//	
//	- 증감식 : 초기식에 사용된 변수를 for문이 종료 할 때 마다 증가 또는 감소시켜
//			 조건식의 결과를 변화하게 함.
	
	public void example1() {
		// for문 기초 사용법1
		// 1~10까지 1씩 증가하며 반복해서 출력
		
		for(int i=1; i <= 10; i++) {
			// 증감식이 단순히 초기식 1 증가/감소로 작성된 경우
			// 전위, 후위 연산을 구분하지 않음.(똑같음)
			System.out.println(i + "출력");
		}
	}
	
	public void example2() {
		// for문 기초 사용법2
		// 5에서 15까지 1씩 증가하면 출력
		for(int i = 5; i <= 15; ++i) {
			System.out.println(i + "출력");
		}
	}
	
	public void example3() {
		// for문 기초 사용법3
		// 1부터 20까지 2씩 증가하며 출력
		for(int i = 1; i<=20; i += 2) {
			System.out.println(i);
		}
	}
	
	public void example4() {
		// for문 기초 응용법1
		
		// 10부터 1까지 1씩 감소하며 출력
		for(int i = 10; i>= 1 ; i--) {
			System.out.println(i);
			
			// 오류 1 : 조건식 부등호 방향을 잘못 작성한 경우
			// -> 한번도 식행되지 않거나, 무한히 실행됨
		}
	}
	
	public void example5() {
		// for문 기초 응용법2
		// 1.0부터 5.0까지 0.5씩 증가
		
		for(double i = 1.0; i<=5.0 ; i+=0.5) {
			System.out.println(i);
		}
	}
	
	public void example6() {
		// for문 기초 응용법3
		// 'A' ~ 'Z' 순서대로 알바벳 모두 출력하기
		
		// 방법 1
		for(int i = 65; i <= 90 ; i++) {
			System.out.println((char)i);
		}
		System.out.println("----");
		
		// 방법 2
		for(char i = 'A'; i <= 'Z'; i++) {
			System.out.println(i);
		}
	}
	
	public void example7() {
		// for문 응용1
		// 정수를 5개를 입력 받아 합계 출력
		
		Scanner sc = new Scanner(System.in);
		
		int sum = 0; // 반복되어 입력되는 수를 누적할 변수 sum 선언
					 // 0으로 초기화
		// 0으로 초기화 하는 이유 : 누적된 값의 최종 결과를 정확히 추출하기 위해서
		
		for(int i = 1; i <= 5; i++) {
			// 특정 횟수만큼 반복해야되는 경우
			// -> 초기식의 값이 몇이 되느냐가 아닌
			//	  초기식의 변하는 값의 종류가 몇 가지인가
			// -> 변하는 값의 수 == 반복 횟수
			System.out.print(i + "번 입력 : ");
			int input = sc.nextInt();
			
			sum += input; // 누적
		}
		
		System.out.println("합계 : " + sum);
	}

	public void example8() {
		// for문 응용2 (for + if)
		
		// 1~20까지 1씩 증가하며 출력
		// 단, 5의 배수를 출력 할 때는 (5), (10) 처럼 괄호를 붙여서 출력
		// ex) 1 2 3 4 (5) 6 7 8 9 (10) ...
		for(int i=1; i<=20; i++) {
			if(i%5 == 0) {
				System.out.print("("+i+") ");
			}else {
				System.out.print(i+" ");
			}
		}
	}
	
	public void example9() {
		// for문 응용 3
		// 2~9 사이 정수를 입력 받아
		// 해당 숫자의 구구단을 출력하시오
		// 단, 2~9사이의 숫자가 아닐 경우 "잘못 입력하셨습니다." 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("단 입력 : ");
		int num = sc.nextInt();
		int result = 0;
		if (num >= 2 && num <= 9) {
			for(int i = 1; i<= 10; i++) {
				result = num * i;
				System.out.printf("%d x %2d = %2d\n", num, i, result);
			}
		}else {
			System.out.println("잘못 입력하였습니다.");
		
		}
	}
	
	public void example10() {
		// for문 응용문제
		// 정수를 두개 입력받아
		// 두 정수 사이의 모든 정수의 합계를 구함
		// 단, 합계에서 3의 배수는 제외
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력1 : ");
		int num1 = sc.nextInt();
		System.out.print("정수 입력2 : ");
		int num2 = sc.nextInt();
		int sum = 0;
		
		if (num2 > num1) {
			for (int i = num1; i<=num2; i++) {
				if (i%3 != 0) {
					sum += i;
				}
			}
		}else {
			for (int i = num2; i<=num1; i++) {
				if (i%3 != 0) {
					sum += i;
				}
			}
		}
		
		System.out.println("합계 : "+sum);
		
	}
	
	
	// 중첩 반복문
	// - 반복문 내부 수행코드에 반복문이 작성되는 코드
	
	// 시계 -> 0 ~ 59초 반복하다가 60초가 되면 1분 증가
	public void example11() {
		// 0분 0초부터 59분 59초까지 출력
		for(int min=0; min < 60; min++) {
			// 1분 == 60초
			for(int sec=0; sec < 60; sec++) {
				System.out.printf("%02d분 %02d초\n", min, sec);
			}
		}
	}
	
	public void example12() {
		// 중첩 반목문 기초1
		// 구구단 2~9단 모두 출력하기
		
		for(int dan = 2; dan <= 9; dan++) {
			
			for(int su = 1; su <=9; su++) {
				System.out.printf("%d x %d = %2d\n", dan, su, dan*su);
				
			}
			System.out.println("-----------");
		}
	}
	
	public void example13() {
		// 중첩 반복문 기초2
		// 구구단 2~9단 모두 출력하기
		// 한 줄에 한 단씩 출력하기
		for(int dan = 2; dan <= 9; dan++) {
			
			for(int su = 1; su <=9; su++) {
				System.out.printf("%d x %d = %2d\t", dan, su, dan*su);
				
			}
				System.out.println();
		}
		
	}
	
	public void example14() {
		// 중첩 반복문 응용1
		
		// 2중 for문을 이용하여 다음 모양을 출력하시오.
		
		//12345
		//12345
		//12345
		//12345
		//12345
		
		for(int i=1 ; i<=5; i++) { // 줄(행)을 제어하는 반복문
		
			for(int j=1; j<=5; j++) { // 칸(열)을 제어하는 반복문
				
				System.out.print(j);
			}
			System.out.println();
			
		}
		
	}
	
	public void example15() {
		// 중첩 반목문 응용2
		
		// 2중 for문을 이용하여 다음 모양을 출력하시오.
		
		// 4321
		// 4321
		// 4321
		
		for(int i=1; i<=3; i++) {
			for(int j=4; j>=1; j--) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
	
	public void example16() {
		// 중첩 반복문 응용3
		
		// 9 ~ 2단까지 거꾸로 출력
		
		// === 9단 ===
		// 9 x 9 = 81
		// 9 x 8 == 72
		// ...
		
		// === 2단 ===
		
		for(int dan = 9; dan >= 1; dan--) {
			System.out.printf("=== %d단 ===\n",dan);
			for(int su = 9; su >= 1; su--) {
				System.out.printf("%d x %d = %2d\n", dan, su, dan*su);
			}
			System.out.println();
		}
		
	}
	
	public void example17() {
		// 중첩 반복문 응용 4
		
		// 2중 for문을 이용하여 아래 모양을 출력
		
		//1
		//12
		//123
		//1234
		
		for(int i=1; i<=4; i++) { // 1~4행 까지 반복
			// i=1 일때 1
			// i=2 일때 12
			// i=3 일때 123
			// i=4 일때 1234
			
			for(int j=1; j<=i; j++) {
				System.out.print(j);
			}
			System.out.println();
			
			
		}
	}
	
	public void example18() {
		// 중첩 반복문 응용 5
		
		// 2중 for문을 이용하여 아래 모양을 출력
		
		//1234
		//123
		//12
		//1
		
		for(int i=4; i>=1; i--) {
			for(int j=1; j<=i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
	
	public void example19() {
		// 중첩 반복문 응용 6
		
		// 1  2  3  4
		// 5  6  7  8
		// 9 10 11 12
		int k = 0;
		for(int i=1; i<=3; i++) {
			for(int j=1; j<=4; j++) {
				k++;
				System.out.printf("%3d", k);
			}
			System.out.println();
		}
		
	}
	
	
	// while문
	// 별도의 초기식, 증감식이 존재하지 않고
	// 반복 종료 조건을 자유롭게 설정하는 반복문
	// --> 언제 끝날지는 모르지만 종료하는 조건은 있음.
	
	//	while( 조건식 ) {
	//		조건식이 true일 경우 수행 할 구문
	//	}
	
	public void example20() {
		// 입력된 모든 정수의 합 구하기
		// 단, 0이 입력되면 결과 출력 후 종류
		Scanner sc = new Scanner(System.in);
		
		int input = -1; // 초기값이 0일경우 while문을 수행할 수 없으므로
						// 0 이외의 아무 값이나 대입
		
		int sum = 0;
		
		while(input != 0) {
			// while문의 조건식이 true일 때 수행
			// while문의 조건식이 false일 때 수행 x
			System.out.print("정수 입력 : ");
			input = sc.nextInt();
			
			sum += input; // 누적
		}
		System.out.println("합계 : " + sum);
	}
	
	
	public void example21() {
		// while문을 for문 처럼 사용하기
		
		// for(초기식; 조건식; 증감식)
		
		// while(조건식) + 초기식 + 증감식
		
		// while문을 이용하여 1 ~ 10 까지 출력
		
		int i = 1; // 초기식
		while(i <= 10) { // 조건식
			
			System.out.println(i);
			
			i++; // 증감식
			
		}
	}
	
}
