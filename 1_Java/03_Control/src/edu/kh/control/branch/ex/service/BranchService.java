package edu.kh.control.branch.ex.service;

import java.util.Scanner;

public class BranchService {
	
	// �б⹮ break;
	// - �ݺ���(for, while)�� ���� ��Ű�� ����
	
	public void example1() {
		
		// 0�� �Էµ� �� ���� ������ �Է� �ް�
		// 0�� �ԷµǸ� �Էµ� ��� ������ ���� ����ϰ� ����
		
		Scanner sc = new Scanner(System.in);
		
		int sum = 0; // �հ� ����� ����
		while(true) { // ���� ����
			// �ݺ����� ���ǽ� true�� �� �ݺ�
			// �׻� true == ���� �ݺ� == ���� ����
			System.out.print("���� �Է� : ");
			int input = sc.nextInt();
			
			if (input == 0) { // �Է� �� ������ 0�� ���
				break; // break; ������ ����Ǹ� �ݺ����� ������ �̵��ϰ� �����.
					   // --> break ���� �ڿ��ִ� �ڵ带 ��� �ǳ� �ڴ�.
			}
			sum += input;
		}
		
		System.out.println("�հ� : " + sum);
	}
	
	public void example2() {
		
		// ������ ������ ����ϱ�
		// 2x1 = 2 2x2=4 ...
		// ��, �б⹮�� �̿��Ͽ� 2���� x2����, 3���� x3 ...
		
		for(int i=2; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				System.out.printf("%d x %d = %2d ", i, j, i*j);
				if(j==i) {
					break; // �б⹮�� ��ø�Ǿ��ִ� �ݺ��� �ȿ���
						   // ���� ����� �ݺ����� �ۿ��Ѵ�.
				}
			}
			System.out.println();
		}
	}
	
	public void example3() {
		
		// ���ڿ��� ��� �Է� �޾� ���� �ϳ��� ����
		// ��, "!exit" �ܾ �Էµ� ��� �Է��� �����ϰ�
		// �����ߴ� ��� ���ڿ� ���
		
		Scanner sc = new Scanner(System.in);
		
		String str = ""; // ���ڿ� ǥ������� �ۼ������ϱ� ���ڿ��ε� ������ ����.
		System.out.println("���ڿ� �Է� (���� �� !exit) : ");

		while(true){
			String input = sc.next();
			if(input.equals("!exit")) {
				// �Էµ� ���� "!exit"�� ������ true, �ƴϸ� false
				
				// �񱳿�����( == )�� ���ڿ��� ���� �� ���� ����� �� ����
				// ��ſ� String.equals("���� ���ڿ�")�� ���
				// -> ���� �⺻ �ڷ��� �� �� ==
				//	  �⺻ �ڷ����� ������ ������ �񱳽� .equals() ���
				break;
			}
			str += input + "\n";
		}
		System.out.println(str);
	}
	
	
	
	// (����) do ~ while��
	public void example4() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���ڿ� �Է� (���� �� !exit)");
		
		String str = ""; // ���ڿ� ���� ����� ����
		String input = "!exit"; // �Է� �޴� �뵵�� ����
		
		 do {
			
			input = sc.nextLine();
			
			if( !input.equals("!exit")) {
				str += input + "\n";
				
			}
			
		} while(!input.equals("!exit"));
		 
		 // do ~ while��
		 // �ϴ��� do ���ο� �ִ� ������ �ּ� �ѹ��� �����ϰ�
		 // �������� �ݺ� ������ ������ ����
		 
		 // do {
		 // �ּ� �ѹ��� ������ �ڵ�
		 // } while(���ǽ�);
		 
		 System.out.println(str);
	}
	
	public void example5() {
		
		// continue : �ݺ��� �������� ��� �����ϸ�
		//			  ���� �ݺ����� �ǳʶٴ� ���
		
		// - for������ continue : ������ �κ����� �̵��Ͽ� ���� �� ���ǽ��� ����
		
		// - while������ continue : ���ǽ����� �̵�
		
		// 1~10 ���̿� �ִ� 3�� ����� �� ���ϱ�
		int sum = 0;
		for(int i =1; i<=10; i++) {
			if(i%3!=0) {
				continue;
			}
			sum += i;
		}
		System.out.println("�հ� : " + sum);
	}
	
	public void example6() {
		// 1~100���� 1�� �����ϸ� ��� ��� �ݺ�������
		// 5�� ����� �ǳʶٰ�
		// 40�� �� ���� (�б⹮ ���)
		
		for(int i =1; i<=100; i++) {
			if (i==40) {
				break;
			}
			if(i%5 == 0) {
				continue;
			}
			System.out.println(i);
			
		}
	}
	
	public void example7() {
		
		// ����ڷκ��� �Է� ���� ������ �Ҽ����� �Ǻ��ϴ� ���α׷�
		// ��, �Է� ���� ���� 2���� ���� ��� "�߸� �Է��ϼ̽��ϴ�." ���
		
		// ex)
		// �Է� : 5
		// �Ҽ��Դϴ�.
		
		// �Է� : 4
		// �Ҽ��� �ƴմϴ�.
		
		// �Է� : 1
		// �߸� �Է��ϼ̽��ϴ�.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�Է� : ");
		int input = sc.nextInt();
		
		if( input < 2 ) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}else {
			
			boolean flag = true; // �Ҽ� �Ǻ��� ����
			// �Ҽ� �Ǻ�
			for(int i=2; i<input; i++) {
				// �ݺ������� i�� �ϴ� ���� : �Էµ� ���� ������ ����
				// --> i�� ������ �� �������� 0�� ����
				//	== 1�� �ڱ� �ڽ��� ������ ���� ���� �� �ִ�
				//	== �Ҽ��� �ƴϴ�
				if(input % i ==0) { // ������ ������ == �Ҽ� �ƴ�
					flag = false; // �Ҽ��� �ƴ��� ����
					break; 	// �ѹ� �̶� ������ ���������
							// �Ҽ��� �ƴѰ��� �˼� �����Ƿ�
							// ���� ���� ������ ���� �� �ʿ� ���� �ݺ� ����
				}
			}
			// for���� �������� �ѹ��� if���� ������� ���� == �Ҽ�
			if(flag) {
				System.out.println("�Ҽ� �Դϴ�.");
			}else {
				System.out.println("�Ҽ��� �ƴմϴ�.");
			}
		}
	}
	
	public void example8() {
		// ���� 7���� �ڵ忡��
		// �߸� �Է��� ���
		// ���α׷��� �����ϴ� ���� �ƴ�
		// �ٽ� �Է��� ���� �� �ְ� �����ϱ�
		// (���� �Է� �� �ѹ� �˻��ϰ� ����)
		
		Scanner sc = new Scanner(System.in);
	
		boolean flag = true;
		int num = 0;
		
		do {
			System.out.print("���� �Է� : ");
			num = sc.nextInt();
			for(int i=2; i<num; i++){
				if(num % i == 0) {
					flag = false;
					break;
				}
			}
			if(num<2) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�");
			}
		}while(num<2);
		
		if(flag) {
			System.out.println("�Ҽ��Դϴ�");
		}else {
			System.out.println("�Ҽ��� �ƴմϴ�");
		}
	}
	
	
	
	// 3, 6, 9 ���� �����
	
	//	- ����1 : 10 ~ 99 ���� ���ڰ� �Է� �Ǿ��� ���� ���� ����
	//	- ����2 : 10 ~ 99 ���̰� �ƴ� ��� "�ٽ� �Է����ּ���" ��� �� ���� ���Է�
	//	- ����3 : ���ڰ� 3, 6, 9�� ���ԵǾ� ���� ��� "¦", �ƴϸ� �ش� ����
	//	- ����4 : 33, 36, 39, 63, 66, 69, 93, 96, 99 "¦¦"
	//	
	//	��� ȭ��
	//	
	//	 1  2  ¦  4  5  ¦  7  8 ¦ 10
	//	11 12  ¦ 14 15  ¦ 17 18 ¦ 20
	//	21 22  ¦ 24 25  ¦ 27 28 ¦ ¦
	//	 ¦ ¦ ¦¦  ¦ ¦ ¦¦ ¦ ¦ ¦¦ 40
	
	public void example9() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("���� �Է� : ");
			int num = sc.nextInt();
			
			if (!(num>= 10 && num<=99)) {
				System.out.println("�ٽ� �Է����ּ���");
				continue;
			}else {
				for(int i = 1; i <= num; i++) {
					int ten = i / 10;
					int one = i % 10;
					if((ten % 3 ==0 && ten != 0)&&(one % 3 ==0 && one != 0)) {
						System.out.printf("¦¦ ", one);
					}
					else if(one % 3 ==0 && one != 0) {
						System.out.printf("¦ ", one);
					}
					else if(ten % 3 ==0 && ten != 0) {
						System.out.printf("¦ ", one);
					}else {
						if(ten == 0) {
							System.out.printf("%d ", one);
						}else {
							System.out.printf("%d%d ", ten, one);
						}
					}
					if(i % 10 == 0) {
						System.out.println();
					}
				}
				break;
			}
		}
		
	}
}
