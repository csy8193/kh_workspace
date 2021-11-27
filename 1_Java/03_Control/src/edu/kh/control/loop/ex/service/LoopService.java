package edu.kh.control.loop.ex.service;

import java.util.Scanner;

public class LoopService {
	
//	for��
//	
//	for(�ʱ��; ���ǽ�; ������) {
//		�ݺ� ���� �ڵ�
//	}
//	
//	- �ʱ�� : for�� ���ο��� ��� �� ����. ���� for���� �ݺ� ��� ���� �����.
//	
//	- ���ǽ� : for���� �ݺ� ���θ� �����ϴ� ��
//			 ���� �ʱ�Ŀ� ����� ������ �̿��Ͽ� ���ǽ��� �ۼ���.
//	
//	- ������ : �ʱ�Ŀ� ���� ������ for���� ���� �� �� ���� ���� �Ǵ� ���ҽ���
//			 ���ǽ��� ����� ��ȭ�ϰ� ��.
	
	public void example1() {
		// for�� ���� ����1
		// 1~10���� 1�� �����ϸ� �ݺ��ؼ� ���
		
		for(int i=1; i <= 10; i++) {
			// �������� �ܼ��� �ʱ�� 1 ����/���ҷ� �ۼ��� ���
			// ����, ���� ������ �������� ����.(�Ȱ���)
			System.out.println(i + "���");
		}
	}
	
	public void example2() {
		// for�� ���� ����2
		// 5���� 15���� 1�� �����ϸ� ���
		for(int i = 5; i <= 15; ++i) {
			System.out.println(i + "���");
		}
	}
	
	public void example3() {
		// for�� ���� ����3
		// 1���� 20���� 2�� �����ϸ� ���
		for(int i = 1; i<=20; i += 2) {
			System.out.println(i);
		}
	}
	
	public void example4() {
		// for�� ���� �����1
		
		// 10���� 1���� 1�� �����ϸ� ���
		for(int i = 10; i>= 1 ; i--) {
			System.out.println(i);
			
			// ���� 1 : ���ǽ� �ε�ȣ ������ �߸� �ۼ��� ���
			// -> �ѹ��� ������� �ʰų�, ������ �����
		}
	}
	
	public void example5() {
		// for�� ���� �����2
		// 1.0���� 5.0���� 0.5�� ����
		
		for(double i = 1.0; i<=5.0 ; i+=0.5) {
			System.out.println(i);
		}
	}
	
	public void example6() {
		// for�� ���� �����3
		// 'A' ~ 'Z' ������� �˹ٺ� ��� ����ϱ�
		
		// ��� 1
		for(int i = 65; i <= 90 ; i++) {
			System.out.println((char)i);
		}
		System.out.println("----");
		
		// ��� 2
		for(char i = 'A'; i <= 'Z'; i++) {
			System.out.println(i);
		}
	}
	
	public void example7() {
		// for�� ����1
		// ������ 5���� �Է� �޾� �հ� ���
		
		Scanner sc = new Scanner(System.in);
		
		int sum = 0; // �ݺ��Ǿ� �ԷµǴ� ���� ������ ���� sum ����
					 // 0���� �ʱ�ȭ
		// 0���� �ʱ�ȭ �ϴ� ���� : ������ ���� ���� ����� ��Ȯ�� �����ϱ� ���ؼ�
		
		for(int i = 1; i <= 5; i++) {
			// Ư�� Ƚ����ŭ �ݺ��ؾߵǴ� ���
			// -> �ʱ���� ���� ���� �Ǵ��İ� �ƴ�
			//	  �ʱ���� ���ϴ� ���� ������ �� �����ΰ�
			// -> ���ϴ� ���� �� == �ݺ� Ƚ��
			System.out.print(i + "�� �Է� : ");
			int input = sc.nextInt();
			
			sum += input; // ����
		}
		
		System.out.println("�հ� : " + sum);
	}

	public void example8() {
		// for�� ����2 (for + if)
		
		// 1~20���� 1�� �����ϸ� ���
		// ��, 5�� ����� ��� �� ���� (5), (10) ó�� ��ȣ�� �ٿ��� ���
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
		// for�� ���� 3
		// 2~9 ���� ������ �Է� �޾�
		// �ش� ������ �������� ����Ͻÿ�
		// ��, 2~9������ ���ڰ� �ƴ� ��� "�߸� �Է��ϼ̽��ϴ�." ���
		Scanner sc = new Scanner(System.in);
		System.out.print("�� �Է� : ");
		int num = sc.nextInt();
		int result = 0;
		if (num >= 2 && num <= 9) {
			for(int i = 1; i<= 10; i++) {
				result = num * i;
				System.out.printf("%d x %2d = %2d\n", num, i, result);
			}
		}else {
			System.out.println("�߸� �Է��Ͽ����ϴ�.");
		
		}
	}
	
	public void example10() {
		// for�� ���빮��
		// ������ �ΰ� �Է¹޾�
		// �� ���� ������ ��� ������ �հ踦 ����
		// ��, �հ迡�� 3�� ����� ����
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է�1 : ");
		int num1 = sc.nextInt();
		System.out.print("���� �Է�2 : ");
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
		
		System.out.println("�հ� : "+sum);
		
	}
	
	
	// ��ø �ݺ���
	// - �ݺ��� ���� �����ڵ忡 �ݺ����� �ۼ��Ǵ� �ڵ�
	
	// �ð� -> 0 ~ 59�� �ݺ��ϴٰ� 60�ʰ� �Ǹ� 1�� ����
	public void example11() {
		// 0�� 0�ʺ��� 59�� 59�ʱ��� ���
		for(int min=0; min < 60; min++) {
			// 1�� == 60��
			for(int sec=0; sec < 60; sec++) {
				System.out.printf("%02d�� %02d��\n", min, sec);
			}
		}
	}
	
	public void example12() {
		// ��ø �ݸ� ����1
		// ������ 2~9�� ��� ����ϱ�
		
		for(int dan = 2; dan <= 9; dan++) {
			
			for(int su = 1; su <=9; su++) {
				System.out.printf("%d x %d = %2d\n", dan, su, dan*su);
				
			}
			System.out.println("-----------");
		}
	}
	
	public void example13() {
		// ��ø �ݺ��� ����2
		// ������ 2~9�� ��� ����ϱ�
		// �� �ٿ� �� �ܾ� ����ϱ�
		for(int dan = 2; dan <= 9; dan++) {
			
			for(int su = 1; su <=9; su++) {
				System.out.printf("%d x %d = %2d\t", dan, su, dan*su);
				
			}
				System.out.println();
		}
		
	}
	
	public void example14() {
		// ��ø �ݺ��� ����1
		
		// 2�� for���� �̿��Ͽ� ���� ����� ����Ͻÿ�.
		
		//12345
		//12345
		//12345
		//12345
		//12345
		
		for(int i=1 ; i<=5; i++) { // ��(��)�� �����ϴ� �ݺ���
		
			for(int j=1; j<=5; j++) { // ĭ(��)�� �����ϴ� �ݺ���
				
				System.out.print(j);
			}
			System.out.println();
			
		}
		
	}
	
	public void example15() {
		// ��ø �ݸ� ����2
		
		// 2�� for���� �̿��Ͽ� ���� ����� ����Ͻÿ�.
		
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
		// ��ø �ݺ��� ����3
		
		// 9 ~ 2�ܱ��� �Ųٷ� ���
		
		// === 9�� ===
		// 9 x 9 = 81
		// 9 x 8 == 72
		// ...
		
		// === 2�� ===
		
		for(int dan = 9; dan >= 1; dan--) {
			System.out.printf("=== %d�� ===\n",dan);
			for(int su = 9; su >= 1; su--) {
				System.out.printf("%d x %d = %2d\n", dan, su, dan*su);
			}
			System.out.println();
		}
		
	}
	
	public void example17() {
		// ��ø �ݺ��� ���� 4
		
		// 2�� for���� �̿��Ͽ� �Ʒ� ����� ���
		
		//1
		//12
		//123
		//1234
		
		for(int i=1; i<=4; i++) { // 1~4�� ���� �ݺ�
			// i=1 �϶� 1
			// i=2 �϶� 12
			// i=3 �϶� 123
			// i=4 �϶� 1234
			
			for(int j=1; j<=i; j++) {
				System.out.print(j);
			}
			System.out.println();
			
			
		}
	}
	
	public void example18() {
		// ��ø �ݺ��� ���� 5
		
		// 2�� for���� �̿��Ͽ� �Ʒ� ����� ���
		
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
		// ��ø �ݺ��� ���� 6
		
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
	
	
	// while��
	// ������ �ʱ��, �������� �������� �ʰ�
	// �ݺ� ���� ������ �����Ӱ� �����ϴ� �ݺ���
	// --> ���� �������� ������ �����ϴ� ������ ����.
	
	//	while( ���ǽ� ) {
	//		���ǽ��� true�� ��� ���� �� ����
	//	}
	
	public void example20() {
		// �Էµ� ��� ������ �� ���ϱ�
		// ��, 0�� �ԷµǸ� ��� ��� �� ����
		Scanner sc = new Scanner(System.in);
		
		int input = -1; // �ʱⰪ�� 0�ϰ�� while���� ������ �� �����Ƿ�
						// 0 �̿��� �ƹ� ���̳� ����
		
		int sum = 0;
		
		while(input != 0) {
			// while���� ���ǽ��� true�� �� ����
			// while���� ���ǽ��� false�� �� ���� x
			System.out.print("���� �Է� : ");
			input = sc.nextInt();
			
			sum += input; // ����
		}
		System.out.println("�հ� : " + sum);
	}
	
	
	public void example21() {
		// while���� for�� ó�� ����ϱ�
		
		// for(�ʱ��; ���ǽ�; ������)
		
		// while(���ǽ�) + �ʱ�� + ������
		
		// while���� �̿��Ͽ� 1 ~ 10 ���� ���
		
		int i = 1; // �ʱ��
		while(i <= 10) { // ���ǽ�
			
			System.out.println(i);
			
			i++; // ������
			
		}
	}
	
}
