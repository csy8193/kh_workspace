package edu.kh.control.condition.ex.service;

import java.util.Scanner;

public class ConditionService {
	
	// 제어문
	// - 프로그램의 흐름을 바꾸는(제어하는) 역할을 하는 코드
	
	// 조건문
	// - 제어문 중 하나로 조건에 따라 다른 문장(코드)이 실행되도록 하는 코드
	
	// if문
	// - 조건식이 true 일때만 내부에 작성된 코드를 수행
	
	// if(조건식) {
	//		수행할 코드
	// }
	
	public void example1() {
		// 키보드로 정수를 하나 입력 받아
		// 양수일 경우 : "양수 입니다"
		// 양수가 아닐 경우 : "양수가 아닙니다"
		// if문 가지고 코드 작성
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 하나 입력 : ");
		int input = sc.nextInt();
		
		if (input > 0) {
			// 입력 받은 값이 0보다 클 경우
			System.out.println("양수 입니다");
		}
		
		if (input <= 0) {
			// 입력 받은 값이 0보다 작거나 같을 경우
			System.out.println("양수가 아닙니다");
		}
	}
	
	// if - else
	// - 조건식이 true일 경우 if문, false인 경우 else문 내부 코드를 수행
	//	if (조건식) {
	//		조건식이 true일 경우 수행 할 코드
	//	}else {
	//		조건식이 false일 경우 수행 할 코드
	//	}
	
	public void example2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 하나 입력 : ");
		int input = sc.nextInt();
		
		if (input > 0) {
			System.out.println("양수 입니다.");
		}else {
			System.out.println("양수가 아닙니다.");
		}
	}
	
	// if - else if - else 예제
	public void example3() {
		
		// 정수를 하나 입력 받아
		// 양수일 경우 : "양수 입니다."
		// 음수일 경우 : "음수 입니다."
		// 0일 경우 : "0 입니다."
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 하나 입력 : ");
		int input = sc.nextInt();
		
		String result; // 결과 저장용 변수
		
		if (input > 0) { 
			result = "양수";
		}else if (input < 0) { // 앞에 조건을 만족하지 않으면 다른 조건
			result = "음수";
		}else {
			result = "0";
		}
		
		System.out.println(result + " 입니다.");
		
	}
	
	public void example4() {
		
		// 나이를 입력 받아
		// 13세 이하 : "어린이 입니다."
		// 13세 초과 19세 이하 : "청소년 입니다."
		// 19세 초과 : "성인 입니다."
		
		// if - else if - else
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이 입력 : ");
		int input = sc.nextInt();
		
		String result;
		
		if (input <= 13) {
			result = "어린이";
		}else if (input > 13 && input <= 19) {
			result = "청소년";
		}else {
			result = "성인";
		}
		
		System.out.println(result + " 입니다.");
		
	}
	
	public void example5() {
		
		// 달(월)을 하나 입력 받아
		// 입력 받은 달이 3,4,5 이면 "봄"
		// 6,7,8 이면 "여름"
		// 9,10,11 이면 "가을"
		// 12,1,2 이면 "겨울"
		// 1~12 사이 숫자가 아니면 "잘못 입력하셨습니다" 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("달(월) 입력 : ");
		int month = sc.nextInt();
		
		String result;
		
		if (month >= 3 && month <= 5) {
			result = "봄";
		}else if (month >= 6 && month <= 8) {
			result = "여름";
		}else if (month >= 9 && month <= 11) {
			result = "가을";
		}else if (month == 1 || month == 2 || month == 12) {
			result = "겨울";
		}else {
			result = "잘못 입력하셨습니다.";
			
			// 지역변수는 반드시 초기화 되어야 한다!
		}
		System.out.println(result);
	}
	
	public void example6() {
		
		// 점수를 입력 받아
		// 90점 이상일 경우 : A
		// 80점 이상, 90점 미만일 경우 : B
		// 70점 이상, 80점 미만일 경우 : C
		// 60점 이상, 70점 미만일 경우 : D
		// 60점 미만인 경우 : F
		// 100점 초과 0점 미만인 경우 : 잘못 입력하셨습니다
		
		Scanner sc = new Scanner(System.in);
		System.out.print("점수 입력 : ");
		int score = sc.nextInt();
		String result;
		
		if (score > 100 || score < 0) { // 90점 이상
			result = "잘못 입력하셨습니다";
			
		}else if (score >= 90) {
			result = "A";
			
		}else if (score >= 80) {
			result = "B";
			
		}else if (score >= 70) {
			result = "C";
			
		}else if (score >= 60) {
			result = "D";
			
		}else {
			result = "F";
			
		}
		
		System.out.println(result);
		
		
	}
	
	//중첩 if문 예제
	public void example7() {
		
		// 놀이기구 탑승 제한 검사
		// 나이가 12세 이상, 키 140.0cm 이상 일 경우에만 "탑승 가능"
		// 나이가 12세 미만인 경우 : "적정 연령이 아닙니다."
		// 키가 140.0cm 미만 : "적정 키가 아닙니다."
		// 나이를 0세 미만, 100세 초과 시 : "잘못 입력하셨습니다."
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		System.out.print("키 입력(cm) : ");
		double height = sc.nextDouble();
		
		String result;
		
		// 0세 미만, 100세 초과
		if (age > 100 || age < 0) {
			result = "적정 연련이 아닙니다.";
			
		}else { // 0세 이상, 100세 이하
			if (age < 12) { // 12세 미만
				result = "적정 연령이 아닙니다.";
				
			}else { // 12세 이상
				if (height < 140.0) { // 키 140.0cm 미만
					result = "적정 키가 아닙니다.";
					
				}else { // 12세 이상, 키 140.0cm 이상
					result = "탑승 가능";
					
				}
			}
			
		}
		
		System.out.println(result);
		
	}
	
	// 놀이기구 탑승 제한 검사 프로그램
	// 조건 - 나이 : 12세 이상
	//	   - 키 : 140.0cm 이상
	
	// 나이를 0~100세로 입력하지 않은 경우 : "나이를 잘못 입력 하셨습니다."
	// 키를 0~250.0cm 사이로 입력하지 않은 경우 : "키를 잘못 입력 하셨습니다."
	// -> 입력이 되자마자 검사를 진행하여 잘못된 경우 프로그램 종료
	
	// 나이 O, 키 X : "나이는 적절하나, 키가 적절치 않음"
	// 나이 X, 키 O : "키는 적절하나, 나이는 적절치 않음"
	// 나이 X, 키 X : "나이와 키 모두 적절치 않음";
	// 나이 O, 키 O : "탑승 가능";
	
	public void example8() {
		Scanner sc = new Scanner(System.in);
		
		String result;
		
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		if(!(age >= 0 && age <= 100)) {
			System.out.println("나이를 잘못 입력 하셨습니다.");
		}else {
			System.out.print("키 입력 : ");
			double height = sc.nextDouble();
			if(!(height >= 0 && height <= 250.0)) {
				System.out.println("키를 잘못 입력 하셨습니다.");
				
			}else {
				if(age >= 12){
					if (height >= 140.0) {
						result = "탑승 가능";
					}else {
						result = "나이는 적절하나, 키가 적절치 않음";
					}
				}else {
					if (height >= 140.0) {
						result = "키는 적절하나, 나이가 적절치 않음";
					}else {
						result = "나이와 키 모두 적절치 않음";
					}
				}
				System.out.println(result);
			}
		}
		
		
		
		
		
		
	}

}
