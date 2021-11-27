package edu.kh.array2.practice.service;

import java.util.Scanner;

public class PracticeService {
	public void practice1() {
//		3�� 3��¥�� ���ڿ� �迭�� ���� �� �Ҵ��ϰ�
//		�ε��� 0�� 0������ 2�� 2������ ���ʴ�� �����Ͽ� ��(0, 0)���� ���� �������� ���� �� ����ϼ���.
//		[���� ȭ��]
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
//		4�� 4��¥�� ������ �迭�� ���� �� �Ҵ��ϰ�
//		1) 1 ~ 16���� ���� ���ʴ�� �����ϼ���.
//		2) ����� ������ ���ʴ�� ����ϼ���.
//		[���� ȭ��]
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
//		4�� 4��¥�� ������ �迭�� ���� �� �Ҵ��ϰ�
//		1) 16 ~ 1�� ���� ���� �Ųٷ� �����ϼ���.
//		2) ����� ������ ���ʴ�� ����ϼ���.
//		[���� ȭ��]
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
	
	// 4������ ����
	public void practice4b() {
		int[][] arr = new int[4][4];
		
		// ��� ��� ��� == ������ �ʴ� Ư�� ���� �̸��� �ٿ��ִ� �뵵
		final int ROW_LAST_INDEX = arr.length-1;
		final int COL_LAST_INDEX = arr[0].length-1;
		
		// arr�� ���� �ϰ��ִ� 2���� �迭�� ��Ҹ�
		// ��� ���������� �����Ͽ�
		// ��������, ������, ������, ����, ��±��� �� ���� ����
		
		for(int row=0; row<arr.length; row++) {
			for(int col=0; col<arr[row].length; col++) {
				
				// ������ ��, ���� �ƴ� ��쿡�� ���� ����
				if( row != ROW_LAST_INDEX && col != COL_LAST_INDEX ) {
					
					arr[row][col] = (int)(Math.random() * 10 + 1); // ���� ����
					
					// �� ���� ������ ���� ������ ����
					arr[row][COL_LAST_INDEX] += arr[row][col];
					
					// �� ���� ������ �࿡ ������ ����
					arr[ROW_LAST_INDEX][col] += arr[row][col];
					
					// ������ ������ 4�� 4���� ����
					arr[ROW_LAST_INDEX][COL_LAST_INDEX] += arr[row][col];
				}
				
				System.out.printf("%4d",arr[row][col]); // ��� 
			}
		}
	}
	
	
	public void practice5() {
//		2���� �迭�� ��� ���� ũ�⸦ ����ڿ��� ���� �Է¹޵�, 1~10���� ���ڰ� �ƴϸ�
//		���ݵ�� 1~10 ������ ������ �Է��ؾ� �մϴ�.�� ��� �� �ٽ� ������ �ް� �ϼ���.
//		ũ�Ⱑ ������ ������ �迭 �ȿ��� ���� �빮�ڰ� �������� ���� �� �� ����ϼ���.
//		(char���� ���ڸ� ���ؼ� ���ڸ� ǥ���� �� �ְ� 65�� A�� ��Ÿ��, ���ĺ��� �� 26����)
//		[���� ȭ��]
//		�� ũ�� : 5
//		�� ũ�� : 4
//		T P M B
//		U I H S
//		Q M B H
//		H B I X
//		G F X I 
		
		Scanner sc = new Scanner(System.in);
		
		int num1 = -1;
		do {
			System.out.print("�� ũ�� : ");
			num1 = sc.nextInt();
			if(num1<1 || num1>10) {
				System.out.println("�ݵ�� 1~10 ������ ������ �Է��ؾ� �մϴ�.");
			}
		}while(num1<0 || num1> 10);
		
		int num2 = -1;
		do {
			System.out.print("�� ũ�� : ");
			num2 = sc.nextInt();
			if(num2<1 || num2>10) {
				System.out.println("�ݵ�� 1~10 ������ ������ �Է��ؾ� �մϴ�.");
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
//		����ڿ��� ���� ũ�⸦ �Է� �ް� �� ����ŭ�� �ݺ��� ���� ���� ũ�⵵ �޾�
//		������ ���� �迭�� ���� �� �Ҵ��ϼ���.
//		�׸��� �� �ε����� ��a������ �� �ε����� ������ŭ �ϳ��� �÷� �����ϰ� ����ϼ���.
//		[���� ȭ��]
//		���� ũ�� : 4
//		0���� ũ�� : 2
//		1���� ũ�� : 6
//		2���� ũ�� : 3
//		3���� ũ�� : 5
//		a b
//		c d e f g h
//		i j k
//		l m n o p
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ũ�� : ");
		int rowSize = sc.nextInt();
		
		char[][] arr = new char[rowSize][];
		
		int num = 0;
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(i+"���� ũ�� : ");
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
//		1���� ���ڿ� �迭�� �л� �̸� �ʱ�ȭ�Ǿ� �ִ�.
//		3�� 2�� ¥�� 2���� ���ڿ� �迭 2���� ���� ���� �� �Ҵ��Ͽ�
//		�л� �̸��� 2���� �迭�� ������� �����ϰ� �Ʒ��� ���� ����Ͻÿ�.
//		(ù ��° 2���� �迭�� ��� ����� ��� �� ��° 2���� �迭�� ���� ����)
//		String[] students = {"���ǰ�", "������", "�����", "�����", "���̹�", "�ں���", 
//		"�ۼ���", "������", "������", "��õ��", "��ǳǥ", "ȫ����"};
//		[���� ȭ��]
//		== 1�д� ==
//		���ǰ� ������
//		����� �����
//		���̹� �ں���
//		== 2�д� ==
//		�ۼ��� ������
//		������ ��õ��
//		��ǳǥ ȫ����
		
		
		String[] students = {"���ǰ�", "������", "�����", "�����", "���̹�", "�ں���", 
				"�ۼ���", "������", "������", "��õ��", "��ǳǥ", "ȫ����"};
		
		String[][] str1 = new String[3][2];
		String[][] str2 = new String[3][2];
		
		int num = 0;
		System.out.println("== 1�д� ==");
		for(int i=0; i<str1.length; i++) {
			for(int j=0; j<str1[i].length; j++) {
				str1[i][j] = students[num];
				num++;
				System.out.print(str1[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("== 2�д� ==");
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
//		�� �������� �ڸ� ��ġ�� ���� ������ �л� �̸��� �˻��Ͽ�
//		�ش� �л��� ��� �ڸ��� �ɾҴ��� ����ϼ���.
//		[���� ȭ��]
//		== 1�д� ==
//		���ǰ� ������
//		����� �����
//		���̹� �ں���
//		== 2�д� ==
//		�ۼ��� ������
//		������ ��õ��
//		��ǳǥ ȫ����
//		============================
//		�˻��� �л� �̸��� �Է��ϼ��� : ��õ��
//		�˻��Ͻ� ��õ�� �л��� 2�д� 2��° �� �����ʿ� �ֽ��ϴ�.
		
		String[] students = {"���ǰ�", "������", "�����", "�����", "���̹�", "�ں���", 
				"�ۼ���", "������", "������", "��õ��", "��ǳǥ", "ȫ����"};
		
		Scanner sc = new Scanner(System.in);
		
		String[][] str1 = new String[3][2];
		String[][] str2 = new String[3][2];
		
		int num = 0;
		System.out.println("== 1�д� ==");
		for(int i=0; i<str1.length; i++) {
			for(int j=0; j<str1[i].length; j++) {
				str1[i][j] = students[num];
				num++;
				System.out.print(str1[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("== 2�д� ==");
		for(int i=0; i<str2.length; i++) {
			for(int j=0; j<str2[i].length; j++) {
				str2[i][j] = students[num];
				num++;
				System.out.print(str2[i][j] + " ");
			}
			System.out.println();
		}
		
		// �˻�
		System.out.println("===================");
		System.out.print("�˻��� �л� �̸��� �Է��ϼ��� : ");
		
		String inputName = sc.next();
		
		// �˻� �� �˻� ����� ���� ��쿡
		// �л��� ��ġ�� ������ ������ ����
		int seat = 0; // �� �д�
		int searchRow = 0; // �� ����
		String direction = ""; // ����, ������ ����
		
		
		for(int i=0; i<str1.length; i++) {
			for(int j=0; j<str1[i].length; j++) {
				
				// 1�дܿ� �˻��� �л��� �ִ� ���
				if(inputName.equals( str1[i][j] )) {
					seat = 1; // 1�д�
					searchRow = i + 1; // �� ����
					
					if (j == 0) {
						direction = "����";
					}else {
						direction = "������";
					}
				} else if ( inputName.equals( str2[i][j] )) {
					seat = 2; // 1�д�
					searchRow = i + 1; // �� ����
					
					if (j == 0) {
						direction = "����";
					}else {
						direction = "������";
					}
				}
			}
		}
	}
	
	public void practice9() {
//		String 2���� �迭 6�� 6���� ����� ���� �� ���� ���� �� ���� �� �ε����� �����ϼ���.
//		�׸��� ����ڿ��� ��� ���� �Է� �޾� �ش� ��ǥ�� ���� 'X'�� ��ȯ�� 2���� �迭�� ����ϼ���.
//		[���� ȭ��]
//		�� �ε��� �Է� : 4
//		�� �ε��� �Է� : 2
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
		System.out.print("�� �ε��� �Է� : ");
		int rowIndex = sc.nextInt()+1;
		System.out.print("�� �ε��� �Է� : ");
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
//		�ǽ�����9�� ������ ������ �� �Է� �� 99�� �Էµ��� ������ ���� �ݺ��� �ǵ��� �����ϼ���.
//		[���� ȭ��]
//		�� �ε��� �Է� : 2 		�� �ε��� �Է� : 3
//		�� �ε��� �Է� : 2 		�� �ε��� �Է� : 1
//		  0 1 2 3 4 			  0 1 2 3 4
//		0 					0
//		1 					1
//		2     X 			2 
//		3 					3   X
//		4					4
//							�� �ε��� �Է� >> 99
//							���α׷� ����
		
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
			System.out.print("�� �ε��� �Է� : ");
			int rowIndex = sc.nextInt()+1;
			if (rowIndex-1 == 99) {
				break;
			}
			System.out.print("�� �ε��� �Է� : ");
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
		System.out.println("���α׷� ����");
	}
}
