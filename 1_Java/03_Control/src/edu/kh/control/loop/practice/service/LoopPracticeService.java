package edu.kh.control.loop.practice.service;

import java.util.Scanner;

public class LoopPracticeService {
	public void practice1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1�̻��� ���ڸ� �Է��ϼ��� : ");
		int num = sc.nextInt();
		
		if (num > 0) {
			for(int i=1; i<=num; i++) {
				System.out.print(i + " ");
			}
		}else {
			System.out.println("1�̻��� ���ڸ� �Է����ּ���.");
		}
		
		
	}
	
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1�̻��� ���ڸ� �Է��ϼ��� : ");
		int num = sc.nextInt();
		
		if (num > 0) {
			for(int i=num; i>=1; i--) {
				System.out.print(i + " ");
			}
		}else {
			System.out.println("1�̻��� ���ڸ� �Է����ּ���.");
		}
		
		
	}
	
	public void practice3() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �ϳ� �Է��ϼ��� : ");
		int num = sc.nextInt();
		int sum = 0;
		for(int i = 1; i <=num; i++ ) {
			if (i==num) {
				System.out.print(i);
			}else {
				System.out.print(i + " + ");
			}
			sum += i;
		}
		System.out.print(" = "+sum);
	}
	
	
	public void practice4() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է�1 : ");
		int num1 = sc.nextInt();
		if(num1 <= 0) {
			System.out.println("1 �̻��� ���ڸ� �Է����ּ���.");
		}else {
			System.out.print("���� �Է�2 : ");
			int num2 = sc.nextInt();
			if(num2 <= 0) {
				System.out.println("1 �̻��� ���ڸ� �Է����ּ���.");
			}else {

				if (num2 > num1) {
					for (int i = num1; i<=num2; i++) {
						System.out.print(i + " ");
					}
				}else {
					for (int i = num2; i<=num1; i++) {
						System.out.print(i + " ");
					}
				}
			}
		}
	}
	
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� : ");
		int num = sc.nextInt();
		
		System.out.printf("==== %d�� ====\n", num);
		for(int i=1; i<=9; i++) {
			System.out.printf("%d * %d = %d\n", num, i, num*i);
		}
		
	}
	
	public void practice6() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� : ");
		int num = sc.nextInt();
		if(num >= 2 && num <= 9) {
			for(int i = num; i <= 9; i++) {
				System.out.printf("==== %d�� ====\n", i);
				for(int j = 1; j <= 9; j++) {
					System.out.printf("%d x %d = %d\n", i, j, i*j);
				}
				System.out.println();
			}
		}else {
			System.out.println("2~9 ���� ���ڸ� �Է����ּ���.");
		}
		
	}
	
	public void practice7() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է� : ");
		int num = sc.nextInt();
		for(int i = 1; i <= num; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void practice8() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է� : ");
		int num = sc.nextInt();
		for(int i = num; i >= 1; i--) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void practice9() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�ڿ��� �ϳ��� �Է��ϼ��� : ");
		int num = sc.nextInt();
		int count = 0;
		
		for(int i = 1; i<= num; i++) {
			if (i%2 == 0 || i%3 == 0) {
				System.out.print(i + " ");
			}
			if (i%6 == 0) {
				count++;
			}
		}
		System.out.println();
		System.out.println("count : " + count);
	}
	
	
	public void practice10() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է� : ");
		int num = sc.nextInt();
		for(int i=1; i<=num; i++) {
			for(int j=num; j>=1; j--) {
				if(i<j) {
					System.out.print(" ");
				}else {
					System.out.print("*");
				}
			}

			System.out.println();
		}
	}
	
	public void practice11() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է� : ");
		int num = sc.nextInt();
		for(int i=1; i<=num; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int k=num-1; k>=1; k--) {
			for(int h=1; h<=k; h++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void practice12() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է� : ");
		int num = sc.nextInt();
		for(int i=1; i<=num; i++) {
			for(int j=num; j>=1; j--) {
				if(i<j) {
					System.out.print(" ");
				}else {
					System.out.print("*");
				}
			}
			for(int k=1; k<=i-1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void practice13() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է� : ");
		int num = sc.nextInt();
		for(int i=1; i<=num; i++) {
			for(int j=1; j<=num; j++) {
				if(!(j == 1 || j == num)) {
					if(i==1 || i == num) {
						System.out.print("*");
					}else {
						System.out.print(" ");
					}
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	
	
	
	
}
