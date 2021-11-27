package edu.kh.oop.method.service;

import java.util.Arrays;
import java.util.Scanner;

// �޼ҵ带 �̿��Ͽ� ���� ��� �����ϱ�
public class Calculator {
	
	// �ʵ�
	private Scanner sc = new Scanner(System.in);
	// �ʵ忡 Scanner ��ü ���� -> ��ü ������ ��� �޼ҵ忡�� sc ��� ����
	// == �ν��Ͻ� ���� �� ���� ����
	
	
	// ������
	public Calculator() { } // �⺻ ������
	// -> ���� �ƹ��͵� ���� �� ��ü ������ �ַ� ���
	
	
	
	// �޼ҵ�
	
	// ���� �޴� ȭ�� ��� ���
	public void displayMenu() {
		
		int menuNum = 0; // �Է��� �޴� ��ȣ�� �����ϴ� ����
		
		do {
			
			System.out.println("==== ���� ���α׷� ====");
			System.out.println("1. ���� ���� ���");
			System.out.println("2. �� ���� �� ���ϱ�");
			System.out.println("3. �� ���� �� ���ϱ�");
			System.out.println("4. a^2 + b^2 = c^2 ���� c^2 ���ϱ�");
			System.out.println("5. �Է� ���� ���� ũ�⸦ ������ �迭 ���� �� 1���� ���ʴ�� �ʱ�ȭ");
			System.out.println("6. �迭 ���� �� �հ� ���ϱ�");
			
			System.out.println("9. ���α׷� ����");
			
			System.out.print("�޴� ��ȣ �Է� �ޱ� : ");
			menuNum = sc.nextInt();
			sc.nextLine();
			
			
			switch(menuNum) {
			case 1 : 
				printVersion(); 
				// ���� Ŭ���� ������ �ٸ� �޼ҵ� ȣ��
				break;
			
			case 2 : 
				// �� ���� �Է� �޾� �޼ҵ��� �Ű������� ����
				System.out.print("ù ��° �� �Է� : ");
				int num1 = sc.nextInt();
				
				System.out.print("�� ��° �� �Է� : ");
				int num2 = sc.nextInt();
				
				sum1(num1, num2); // sum1 �޼ҵ��� �Ű������� num1, num2 ����
				
				break;
			case 3 : 
				System.out.println( sum2() ); // sum2 �޼ҵ��� ��ȯ���� ����ϴ� ����
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
				System.out.println("���α׷� ����");
				break;
				
			default : System.out.println("�޴� ��ȣ�� �߸� �Է��ϼ̽��ϴ�.");
			
			}
			
			
			
		}while( menuNum != 9 );
	}
	
	
	// ���� ���� ��� ���
	private void printVersion() {
		System.out.println("���� ���� ���� : version 0.1");
	}
	
	// �� ���� ���� �޾� ���� ����ϴ� �޼ҵ�
	private void sum1(int param1, int param2) { // �Ű�����O, ��ȯ��X
						// �Ű����� (parameter)
						// num1		num2
		System.out.printf("%d + %d = %d\n", param1, param2, param1+param2);
		
	}
	
	// �� ���� �Է¹޾� ����� ��ȯ�ϴ� �޼ҵ�
	private String sum2() { // �Ű�����X, ��ȯ��O
			// -> ��ȯ�Ǵ� �ڷ��� == ��ȯ��
		String result = null;
		
		System.out.print("ù ��° �� �Է� : ");
		int num1 = sc.nextInt();
		
		System.out.print("�� ��° �� �Է� : ");
		int num2 = sc.nextInt();
		
		System.out.print("�� ��° �� �Է� : ");
		int num3 = sc.nextInt();
		
		int sum = num1 + num2 + num3;
		
		result = num1 + " + " + num2 + " + " + num3 + " = " + sum;
		// "1 + 2 + 3 = 6"
		
		return result; // String == ������ ���� -> �������� �⺻�� null
		// result�� �ִ� ���� ��ȯ(����)
		// return; -> ȣ���� ������ ���ư���
		// resturn result; -> result���� ������ ȣ���� ������ ���ư���
	}
	
	// �� ���� �Է� �޾� ������ �� ���ϱ�
	private void pythagoras() {
		
		System.out.print("ù ��° �� �Է� : ");
		int num1 = sc.nextInt();
		
		System.out.print("�� ��° �� �Է� : ");
		int num2 = sc.nextInt();
		
		// ���� ����� �ۼ��� Ŭ������ �̿��� ��ü ����
		ApplicationSet as = new ApplicationSet();
		
		int sum = as.squared(num1) + as.squared(num2);
					// �Ű�����O, ��ȯ��O
		
		System.out.println("�� �� ������ �� : " + sum);
		
	}
	
	private void createArray() {
		
		System.out.print("ũ�� �Է� : ");
		int size = sc.nextInt();
		
		ApplicationSet as = new ApplicationSet();
		
		System.out.println(Arrays.toString(as.createArray(size)));
	}
	
	
	private void arraySum() {
		
		System.out.print("ũ�� �Է� : ");
		int size = sc.nextInt();
		
		ApplicationSet as = new ApplicationSet();
		
		int[] arr = as.createArray(size);
		
		int sum = as.arraySum(arr); // ������ �迭�� �Ű������� �����Ͽ� �� ���ϱ�
		
		System.out.println("�迭 : " + Arrays.toString(arr));
		System.out.println("�迭 �� : " + sum);
	}
}
