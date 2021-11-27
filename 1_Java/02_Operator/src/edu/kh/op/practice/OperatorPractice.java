package edu.kh.op.practice;

import java.util.Scanner;

public class OperatorPractice {
	
	public void practice1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("인원 수 : ");
		int input = sc.nextInt();
		System.out.print("사탕 개수 : ");
		int input2 = sc.nextInt();
		
		System.out.printf("1인당 사탕 개수 : %d\n", input2/input);
		System.out.printf("남는 사탕 개수 : %d", input2%input);
	}
	
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String input = sc.next();
		System.out.print("학년 : ");
		int input2 = sc.nextInt();
		System.out.print("반 : ");
		int input3 = sc.nextInt();
		System.out.print("번호 : ");
		int input4 = sc.nextInt();
		System.out.print("성적 : ");
		double input5 = sc.nextDouble();
		
		System.out.printf("%d학년 %d반 %d번 %s의 성적은 %.2f이다.", input2, input3, input4, input, input5);
	}
	
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 : ");
		int input = sc.nextInt();
		System.out.print("영어 : ");
		int input2 = sc.nextInt();
		System.out.print("수학 : ");
		int input3 = sc.nextInt();
		
		int sum = input+input2+input3;
		System.out.printf("합계 : %d\n", sum);
		System.out.printf("평균 : %.1f", (double)(sum/3.0));
		
	}
	
	public void practice4() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력1 : ");
		int input = sc.nextInt();
		System.out.print("입력2 : ");
		int input2 = sc.nextInt();
		System.out.print("입력3 : ");
		int input3 = sc.nextInt();
		
		String result = input == input2 && input2 == input3 ? "true" : "false";
		
		System.out.println(result);
	}
	
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이 : ");
		int input = sc.nextInt();
		
		String result = input <= 13 ? "어린이" : (input > 13 && input <= 19 ? "청소년" : "성인");
		
		System.out.println(result);
		
		
	}
}
