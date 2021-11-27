package edu.kh.control.condition.practice.service;

import java.util.Scanner;

public class PracticeService {
	
	public void practice1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. 입력");
		System.out.println("2. 수정");
		System.out.println("3. 조회");
		System.out.println("4. 삭제");
		System.out.println("7. 종료");
		System.out.print("메뉴 번호를 입력하세요 : ");
		int input = sc.nextInt();
		String result = null;
		boolean flag = true;
		
		switch(input) {
		case 1 : result = "입력"; break;
		case 2 : result = "수정"; break;
		case 3 : result = "조회"; break;
		case 4 : result = "삭제"; break;
		case 7 : result = "종료"; break;
		default : 
			System.out.println("잘못 입력하였습니다");
			flag = false; 
		}
		
		if(flag) {
			System.out.println(result + " 메뉴입니다.");
		}
	}
	
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 한 개 입력하세요 : ");
		int num = sc.nextInt();
		String result;
		if (num > 0 && num % 2 == 0) {
			result = "짝수입니다.";
		}else if (num > 0 && num % 2 == 1) {
			result = "홀수입니다.";
		}else {
			result = "양수만 입력해주세요.";
		}
		
		System.out.println(result);
	}
	
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 점수 : ");
		int num1 = sc.nextInt();
		if (num1 < 0 || num1 > 100) {
			System.out.println("점수를 잘못 입력했습니다.");
			
		}else {
			System.out.print("수학 점수 : ");
			int num2 = sc.nextInt();
			if (num2 < 0 || num2 > 100) {
				System.out.println("점수를 잘못 입력했습니다.");

			}else {
				System.out.print("영어 점수 : ");
				int num3 = sc.nextInt();
				if (num3 <0 || num3 > 100) {
					System.out.println("점수를 잘못 입력했습니다.");

				}else {
					int sum = num1 + num2 + num3;
					double avg = sum/3.0;
					
					if(num1 >= 40 && num2 >= 40 && num3 >= 40 && avg >= 60) {
						System.out.printf("국어 : %d\n수학 : %d\n영어 : %d\n", num1, num2, num3);
						System.out.printf("합계 : %d\n평균 : %.1f\n", sum, avg);
						System.out.println("축하합니다, 합격입니다!");
					
					}else {
						System.out.println("불합격입니다.");
					}
				}
			}
		}
	}
	
	public void practice4() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1~12 사이의 정수 입력 : ");
		int month = sc.nextInt();
		
		switch(month) {
		case 1 : case 3 : case 5 : 
		case 7 : case 8 : case 10 : 
		case 12: System.out.println(month + "월은 31일까지 있습니다."); break;
		
		case 2 : System.out.println(month + "월은 28일까지 있습니다."); break;
		
		case 4 : case 6 : case 9 : 
		case 11 : System.out.println(month + "월은 30일까지 있습니다.");break;
		
		default : System.out.println(month + "월은 잘못 입력된 달입니다.");
		}
		
	}
	
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("키(m)를 입력해 주세요 : ");
		double height = sc.nextDouble();
		if (height <= 0) {
			System.out.println("잘못된 값입니다.");
		}else {
			System.out.print("몸무게(kg)를 입력해 주세요 : ");
			double weight = sc.nextDouble();
			if (weight <= 0) {
				System.out.println("잘못된 값입니다.");
			}else {
				double bmi = weight / (height * height);
				String result;
				
				if (bmi < 0) {
					result = "잘못된 값입니다.";
				}else if (bmi < 18.5) {
					result = "저체중";
				}else if (bmi >= 18.5 && bmi < 23) {
					result = "정상체중";
				}else if (bmi >= 23 && bmi < 25) {
					result = "과제충";
				}else if (bmi >= 25 && bmi < 30) {
					result = "비만";
				}else {
					result = "고도비만";
				}
				
				System.out.printf("BMI 지수 : %.14f\n%s", bmi, result);
			}
		}	
	}
	
	public void practice6() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("중간 고사 점수 : ");
		int score1 = sc.nextInt();
		if (score1 < 0 || score1 > 100) {
			System.out.println("점수를 잘못 입력했습니다.");
			
		}else {
			System.out.print("기말 고사 점수 : ");
			int score2 = sc.nextInt();
			if (score2 < 0 || score2 > 100) {
				System.out.println("점수를 잘못 입력했습니다.");

			}else {
				System.out.print("과제 점수 : ");
				int hw = sc.nextInt();
				if (hw < 0 || hw > 100) {
					System.out.println("점수를 잘못 입력했습니다.");

				}else {
					System.out.print("출석 횟수 : ");
					int at = sc.nextInt();
					if (at < 0 || at > 20) {
						System.out.println("숫자를 잘못 입력했습니다.");
					}else {
						double finalScore1 = score1*0.2;
						double finalScore2 = score2*0.3;
						double finalHw = hw*0.3;
						double finalAt = at*1.0;
						double sum = finalScore1 + finalScore2 + finalHw + finalAt;
						String result = null;
						boolean flag = true;
						System.out.println("====결과====");
						if (sum < 70 || finalAt <= 14) {
							if (finalAt <= 14) {
								System.out.printf("Fail [출석 횟수 부족 (%d/20)", at);
								flag = false;
							}else {
								result = "Fail [점수 미달]";
							}
						}else {
							result = "PASS";
						}
						if (flag) {
							System.out.printf("중간 고사 점수(20) : %.1f\n"
									+ "기말 고사 점수(30) : %.1f\n"
									+ "과제 점수(30) : %.1f\n"
									+ "출석 점수(20) : %.1f\n"
									+ "총점 : %.1f\n"
									+ "%s", finalScore1, finalScore2, finalHw,
									finalAt, sum, result);
						}
						
					}
				}
				
			}
			
		}
		
		
	}
	
	public void practice7() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("피연산자1 입력 : ");
		int num1 = sc.nextInt();
		if (num1 < 0) {
			System.out.println("피연산자는 0보다 크거나 같은 수만 입력해주세요.");
		}else {
			System.out.print("연산자 입력(+,-,*,/,%) : ");
			char ch = sc.next().charAt(0);
			if (!(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%')) {
				System.out.println("잘못 입력하셨습니다.");
			}else {
				boolean flag = true;
				if (num1 == 0 && ch == '/') {
					System.out.println("0은 나눌 수 없습니다.");
				} else if (num1 == 0 && ch == '%') {
					System.out.println("0은 나눌 수 없습니다.");
				}else {
					System.out.print("피연산자2 입력 : ");
					int num2 = sc.nextInt();
					if (num2 < 0) {
						System.out.println("피연산자는 0보다 크거나 같은 수만 입력해주세요.");
					}else {
						double result = 0;
						switch(ch) {
						case '+' : result = num1 + num2; break;
						case '-' : result = num1 - num2; break;
						case '*' : result = num1 * num2; break;
						case '/' : 
							if (num2 == 0) {
								System.out.println("0으로 나눌 수 없습니다.");
								flag = false;
							}else {
								result = num1 / num2; 
							}
							break;
						case '%' : 
							if (num2 == 0) {
								System.out.println("0으로 나눌 수 없습니다.");
								flag = false;
							}else {
								result = num1 % num2; 
							}
							break;
						}
						if (flag) {
							System.out.printf("%d %c %d = %f", num1, ch, num2, result);
						}
					}
				}
				
			}
		}
	}
}
