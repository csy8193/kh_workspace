package edu.kh.control.condition.practice.service;

import java.util.Scanner;

public class PracticeService {
	
	public void practice1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. �Է�");
		System.out.println("2. ����");
		System.out.println("3. ��ȸ");
		System.out.println("4. ����");
		System.out.println("7. ����");
		System.out.print("�޴� ��ȣ�� �Է��ϼ��� : ");
		int input = sc.nextInt();
		String result = null;
		boolean flag = true;
		
		switch(input) {
		case 1 : result = "�Է�"; break;
		case 2 : result = "����"; break;
		case 3 : result = "��ȸ"; break;
		case 4 : result = "����"; break;
		case 7 : result = "����"; break;
		default : 
			System.out.println("�߸� �Է��Ͽ����ϴ�");
			flag = false; 
		}
		
		if(flag) {
			System.out.println(result + " �޴��Դϴ�.");
		}
	}
	
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �� �� �Է��ϼ��� : ");
		int num = sc.nextInt();
		String result;
		if (num > 0 && num % 2 == 0) {
			result = "¦���Դϴ�.";
		}else if (num > 0 && num % 2 == 1) {
			result = "Ȧ���Դϴ�.";
		}else {
			result = "����� �Է����ּ���.";
		}
		
		System.out.println(result);
	}
	
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� ���� : ");
		int num1 = sc.nextInt();
		if (num1 < 0 || num1 > 100) {
			System.out.println("������ �߸� �Է��߽��ϴ�.");
			
		}else {
			System.out.print("���� ���� : ");
			int num2 = sc.nextInt();
			if (num2 < 0 || num2 > 100) {
				System.out.println("������ �߸� �Է��߽��ϴ�.");

			}else {
				System.out.print("���� ���� : ");
				int num3 = sc.nextInt();
				if (num3 <0 || num3 > 100) {
					System.out.println("������ �߸� �Է��߽��ϴ�.");

				}else {
					int sum = num1 + num2 + num3;
					double avg = sum/3.0;
					
					if(num1 >= 40 && num2 >= 40 && num3 >= 40 && avg >= 60) {
						System.out.printf("���� : %d\n���� : %d\n���� : %d\n", num1, num2, num3);
						System.out.printf("�հ� : %d\n��� : %.1f\n", sum, avg);
						System.out.println("�����մϴ�, �հ��Դϴ�!");
					
					}else {
						System.out.println("���հ��Դϴ�.");
					}
				}
			}
		}
	}
	
	public void practice4() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1~12 ������ ���� �Է� : ");
		int month = sc.nextInt();
		
		switch(month) {
		case 1 : case 3 : case 5 : 
		case 7 : case 8 : case 10 : 
		case 12: System.out.println(month + "���� 31�ϱ��� �ֽ��ϴ�."); break;
		
		case 2 : System.out.println(month + "���� 28�ϱ��� �ֽ��ϴ�."); break;
		
		case 4 : case 6 : case 9 : 
		case 11 : System.out.println(month + "���� 30�ϱ��� �ֽ��ϴ�.");break;
		
		default : System.out.println(month + "���� �߸� �Էµ� ���Դϴ�.");
		}
		
	}
	
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Ű(m)�� �Է��� �ּ��� : ");
		double height = sc.nextDouble();
		if (height <= 0) {
			System.out.println("�߸��� ���Դϴ�.");
		}else {
			System.out.print("������(kg)�� �Է��� �ּ��� : ");
			double weight = sc.nextDouble();
			if (weight <= 0) {
				System.out.println("�߸��� ���Դϴ�.");
			}else {
				double bmi = weight / (height * height);
				String result;
				
				if (bmi < 0) {
					result = "�߸��� ���Դϴ�.";
				}else if (bmi < 18.5) {
					result = "��ü��";
				}else if (bmi >= 18.5 && bmi < 23) {
					result = "����ü��";
				}else if (bmi >= 23 && bmi < 25) {
					result = "������";
				}else if (bmi >= 25 && bmi < 30) {
					result = "��";
				}else {
					result = "����";
				}
				
				System.out.printf("BMI ���� : %.14f\n%s", bmi, result);
			}
		}	
	}
	
	public void practice6() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�߰� ��� ���� : ");
		int score1 = sc.nextInt();
		if (score1 < 0 || score1 > 100) {
			System.out.println("������ �߸� �Է��߽��ϴ�.");
			
		}else {
			System.out.print("�⸻ ��� ���� : ");
			int score2 = sc.nextInt();
			if (score2 < 0 || score2 > 100) {
				System.out.println("������ �߸� �Է��߽��ϴ�.");

			}else {
				System.out.print("���� ���� : ");
				int hw = sc.nextInt();
				if (hw < 0 || hw > 100) {
					System.out.println("������ �߸� �Է��߽��ϴ�.");

				}else {
					System.out.print("�⼮ Ƚ�� : ");
					int at = sc.nextInt();
					if (at < 0 || at > 20) {
						System.out.println("���ڸ� �߸� �Է��߽��ϴ�.");
					}else {
						double finalScore1 = score1*0.2;
						double finalScore2 = score2*0.3;
						double finalHw = hw*0.3;
						double finalAt = at*1.0;
						double sum = finalScore1 + finalScore2 + finalHw + finalAt;
						String result = null;
						boolean flag = true;
						System.out.println("====���====");
						if (sum < 70 || finalAt <= 14) {
							if (finalAt <= 14) {
								System.out.printf("Fail [�⼮ Ƚ�� ���� (%d/20)", at);
								flag = false;
							}else {
								result = "Fail [���� �̴�]";
							}
						}else {
							result = "PASS";
						}
						if (flag) {
							System.out.printf("�߰� ��� ����(20) : %.1f\n"
									+ "�⸻ ��� ����(30) : %.1f\n"
									+ "���� ����(30) : %.1f\n"
									+ "�⼮ ����(20) : %.1f\n"
									+ "���� : %.1f\n"
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
		
		System.out.print("�ǿ�����1 �Է� : ");
		int num1 = sc.nextInt();
		if (num1 < 0) {
			System.out.println("�ǿ����ڴ� 0���� ũ�ų� ���� ���� �Է����ּ���.");
		}else {
			System.out.print("������ �Է�(+,-,*,/,%) : ");
			char ch = sc.next().charAt(0);
			if (!(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%')) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}else {
				boolean flag = true;
				if (num1 == 0 && ch == '/') {
					System.out.println("0�� ���� �� �����ϴ�.");
				} else if (num1 == 0 && ch == '%') {
					System.out.println("0�� ���� �� �����ϴ�.");
				}else {
					System.out.print("�ǿ�����2 �Է� : ");
					int num2 = sc.nextInt();
					if (num2 < 0) {
						System.out.println("�ǿ����ڴ� 0���� ũ�ų� ���� ���� �Է����ּ���.");
					}else {
						double result = 0;
						switch(ch) {
						case '+' : result = num1 + num2; break;
						case '-' : result = num1 - num2; break;
						case '*' : result = num1 * num2; break;
						case '/' : 
							if (num2 == 0) {
								System.out.println("0���� ���� �� �����ϴ�.");
								flag = false;
							}else {
								result = num1 / num2; 
							}
							break;
						case '%' : 
							if (num2 == 0) {
								System.out.println("0���� ���� �� �����ϴ�.");
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
