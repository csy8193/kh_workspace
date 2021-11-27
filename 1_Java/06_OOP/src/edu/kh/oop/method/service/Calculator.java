package edu.kh.oop.method.service;

import java.util.Arrays;
import java.util.Scanner;

// 메소드를 이용하여 계산기 기능 구현하기
public class Calculator {
	
	// 필드
	private Scanner sc = new Scanner(System.in);
	// 필드에 Scanner 객체 생성 -> 객체 내부의 모든 메소드에서 sc 사용 가능
	// == 인스턴스 변수 ≒ 전역 변수
	
	
	// 생성자
	public Calculator() { } // 기본 생성자
	// -> 보통 아무것도 없는 빈 객체 생성에 주로 사용
	
	
	
	// 메소드
	
	// 계산기 메뉴 화면 출력 기능
	public void displayMenu() {
		
		int menuNum = 0; // 입력한 메뉴 번호를 저장하는 변수
		
		do {
			
			System.out.println("==== 계산기 프로그램 ====");
			System.out.println("1. 버전 정보 출력");
			System.out.println("2. 두 수의 합 구하기");
			System.out.println("3. 세 수의 합 구하기");
			System.out.println("4. a^2 + b^2 = c^2 에서 c^2 구하기");
			System.out.println("5. 입력 받은 수의 크기를 가지는 배열 선언 및 1부터 차례대로 초기화");
			System.out.println("6. 배열 생성 후 합계 구하기");
			
			System.out.println("9. 프로그램 종료");
			
			System.out.print("메뉴 번호 입력 받기 : ");
			menuNum = sc.nextInt();
			sc.nextLine();
			
			
			switch(menuNum) {
			case 1 : 
				printVersion(); 
				// 같은 클래스 내부의 다른 메소드 호출
				break;
			
			case 2 : 
				// 두 수를 입력 받아 메소드의 매개변수로 전달
				System.out.print("첫 번째 수 입력 : ");
				int num1 = sc.nextInt();
				
				System.out.print("두 번째 수 입력 : ");
				int num2 = sc.nextInt();
				
				sum1(num1, num2); // sum1 메소드의 매개변수로 num1, num2 전달
				
				break;
			case 3 : 
				System.out.println( sum2() ); // sum2 메소드의 반환값을 출력하는 구문
				break;
				
			case 4 :
				pythagoras();
				break;
				
			case 5 : 
				createArray();
				break;
				
			case 6 :
				arraySum();
				break;
			
			case 9 : 
				System.out.println("프로그램 종료");
				break;
				
			default : System.out.println("메뉴 번호를 잘못 입력하셨습니다.");
			
			}
			
			
			
		}while( menuNum != 9 );
	}
	
	
	// 버전 정보 출력 기능
	private void printVersion() {
		System.out.println("현재 버전 정보 : version 0.1");
	}
	
	// 두 수를 전달 받아 합을 출력하는 메소드
	private void sum1(int param1, int param2) { // 매개변수O, 반환값X
						// 매개변수 (parameter)
						// num1		num2
		System.out.printf("%d + %d = %d\n", param1, param2, param1+param2);
		
	}
	
	// 세 수를 입력받아 결과를 반환하는 메소드
	private String sum2() { // 매개변수X, 반환값O
			// -> 반환되는 자료형 == 반환형
		String result = null;
		
		System.out.print("첫 번째 수 입력 : ");
		int num1 = sc.nextInt();
		
		System.out.print("두 번째 수 입력 : ");
		int num2 = sc.nextInt();
		
		System.out.print("세 번째 수 입력 : ");
		int num3 = sc.nextInt();
		
		int sum = num1 + num2 + num3;
		
		result = num1 + " + " + num2 + " + " + num3 + " = " + sum;
		// "1 + 2 + 3 = 6"
		
		return result; // String == 참조형 변수 -> 참조형의 기본값 null
		// result에 있는 값을 반환(리턴)
		// return; -> 호출한 곳으로 돌아가다
		// resturn result; -> result값을 가지고 호출한 곳으로 돌아가다
	}
	
	// 두 수를 입력 받아 제곱의 합 구하기
	private void pythagoras() {
		
		System.out.print("첫 번째 수 입력 : ");
		int num1 = sc.nextInt();
		
		System.out.print("두 번째 수 입력 : ");
		int num2 = sc.nextInt();
		
		// 응용 기능이 작성된 클래스를 이용해 객체 생성
		ApplicationSet as = new ApplicationSet();
		
		int sum = as.squared(num1) + as.squared(num2);
					// 매개변수O, 반환값O
		
		System.out.println("두 수 제곱의 합 : " + sum);
		
	}
	
	private void createArray() {
		
		System.out.print("크기 입력 : ");
		int size = sc.nextInt();
		
		ApplicationSet as = new ApplicationSet();
		
		System.out.println(Arrays.toString(as.createArray(size)));
	}
	
	
	private void arraySum() {
		
		System.out.print("크기 입력 : ");
		int size = sc.nextInt();
		
		ApplicationSet as = new ApplicationSet();
		
		int[] arr = as.createArray(size);
		
		int sum = as.arraySum(arr); // 생성한 배열을 매개변수로 전달하여 합 구하기
		
		System.out.println("배열 : " + Arrays.toString(arr));
		System.out.println("배열 합 : " + sum);
	}
}
