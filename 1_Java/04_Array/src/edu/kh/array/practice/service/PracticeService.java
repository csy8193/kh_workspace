package edu.kh.array.practice.service;

import java.util.Arrays;
import java.util.Scanner;

import javax.lang.model.element.AnnotationValueVisitor;
import javax.swing.plaf.basic.BasicInternalFrameUI.InternalFrameLayout;

public class PracticeService {
	
	public void practice1() {
		
//		���̰� 9�� �迭�� ���� �� �Ҵ��ϰ�, 1���� 9������ ���� �ݺ����� �̿��Ͽ�
//		������� �迭�� �� �ε��� ��ҿ� �����ϰ� ����� ��
//		¦�� ��° �ε��� ���� ���� ����ϼ���. (0 ��° �ε����� ¦���� ���)
//		[���� ȭ��]
//		1 2 3 4 5 6 7 8 9
//		¦�� ��° �ε��� �� : 25
		
		int[] arr = new int[9];
		int sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = i+1;
			System.out.print(arr[i] + " ");
			
			if(i%2==0) {
				sum += arr[i];
			}
		}
		System.out.println("\n¦�� ��° �ε��� �� : "+sum);
	}
	
	public void practice2() {
		
//		���̰� 9�� �迭�� ���� �� �Ҵ��ϰ�, 9���� 1������ ���� �ݺ����� �̿��Ͽ�
//		������� �迭�� �� �ε��� ��ҿ� �����ϰ� ����� ��
//		Ȧ�� ��° �ε��� ���� ���� ����ϼ���. (0 ��° �ε����� ¦���� ���)
//		[���� ȭ��]
//		9 8 7 6 5 4 3 2 1
//		Ȧ�� ��° �ε��� �� : 20
		
		int[] arr = new int[9];
		int sum = 0;
		
//		for(int i=arr.length; i>=1; i--) {
//			arr[i-1] = i;
//			System.out.print(i + " ");
//		}
//		for(int j=0; j<arr.length; j++) {
//			if(j%2==1) {
//				sum+=arr[j];
//			}
//		}
		for(int i=0; i<arr.length; i++) {
			arr[i] = arr.length-i;
			System.out.print(arr[i] + " ");
			
			if(i%2==1) {
				sum += arr[i];
			}
		}
		System.out.println();
		System.out.println(sum);

	}
	
	public void practice3() {
//		����ڿ��� �Է� ���� ���� ������ŭ �迭 ũ�⸦ �Ҵ��ϰ�
//		1���� �Է� ���� ������ �迭�� �ʱ�ȭ�� �� ����ϼ���.
//		[���� ȭ��]
//		���� ���� : 5
//		1 2 3 4 5
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� ���� : ");
		int size = sc.nextInt();
		
		int[] arr = new int[size];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = i+1;
			System.out.print(arr[i] + " ");
		}
		
	}
	
	public void practice4() {
//		���� 5���� �Է� �޾� �迭�� �ʱ�ȭ �ϰ�
//		�˻��� ������ �ϳ� �Է� �޾� �迭���� ���� ���� �ִ� �ε����� ã�� ���.
//		�迭�� ���� ���� ���� ��� ����ġ�ϴ� ���� �������� �ʽ��ϴ١� ���
		
//		[���� ȭ�� 1]
//		�Է� 0 : 5
//		�Է� 1 : 8
//		�Է� 2 : 9
//		�Է� 3 : 10
//		�Է� 4 : 4
//		�˻��� �� : 8
//		�ε��� : 1
		
//		[���� ȭ�� 2]
//		�Է� 0 : 5
//		�Է� 1 : 8
//		�Է� 2 : 9
//		�Է� 3 : 10
//		�Է� 4 : 4
//		�˻��� �� : 1
//		��ġ�ϴ� ���� �������� �ʽ��ϴ�.
		
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[5];
		for(int i=0; i<arr.length; i++) {
			System.out.print("�Է�"+i+" : ");
			arr[i] = sc.nextInt();
		}
		
		System.out.print("�˻��� �� : ");
		int num = sc.nextInt();
		boolean flag = true;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == num) {
				System.out.println("�ε��� : "+i);
				flag = false;
			}
		}
		if(flag) {
			System.out.println("��ġ�ϴ� ���� �������� �ʽ��ϴ�");
		}
	}
	
	public void practice5() {
		
//		���ڿ��� �Է� �޾� ���� �ϳ��ϳ��� �迭�� �ְ� �˻��� ���ڰ� ���ڿ��� �� �� �� �ִ���
//		������ �� ��° �ε����� ��ġ�ϴ��� �ε����� ����ϼ���.
//		[���� ȭ��]
//		���ڿ� : application
//		���� : i
//		application�� i�� �����ϴ� ��ġ(�ε���) : 4 8
//		i ���� : 2
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���ڿ� : ");
		String str = sc.next();
		System.out.print("���� : ");
		char ch = sc.next().charAt(0);
		int count = 0;
		 
		
		int[] arr = new int[str.length()];
		int[] arr2 = new int[count];
		
		System.out.print(str+"�� "+ch+"�� �����ϴ� ��ġ(�ε���) : ");
		
		for(int i=0; i<str.length(); i++) {
			arr[i] = str.charAt(i);
			if(arr[i] == ch) {
				++count;
				System.out.print(i + " ");
			}
		}
		System.out.println();
		System.out.println(ch+"���� : "+count);
	}
	
	public void practice6() {
//		����ڰ� �迭�� ���̸� ���� �Է��Ͽ� �� ����ŭ ������ �迭�� ���� �� �Ҵ��ϰ�
//		�迭�� ũ�⸸ŭ ����ڰ� ���� ���� �Է��Ͽ� ������ �ε����� ���� �ʱ�ȭ �ϼ���.
//		�׸��� �迭 ��ü ���� �����ϰ� �� �ε����� ����� ������ ���� ����ϼ���.
//		[���� ȭ��]
//		���� : 5
//		�迭 0��° �ε����� ���� �� : 4
//		�迭 1��° �ε����� ���� �� : -4
//		�迭 2��° �ε����� ���� �� : 3
//		�迭 3��° �ε����� ���� �� : -3
//		�迭 4��° �ε����� ���� �� : 2
//		4 -4 3 -3 2
//		�� �� : 2
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� : ");
		int num = sc.nextInt();
		int[] arr = new int[num];
		int sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			System.out.print("�迭 "+i+"��° �ε����� ���� �� : ");
			int indexNum = sc.nextInt();
			arr[i] = indexNum;
			sum += indexNum;
		}
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		
		System.out.println();
		System.out.println("�� �� : "+sum);
	}
	
	
	public void practice7() {
//		�ֹε�Ϲ�ȣ ��ȣ�� �Է� �޾� char �迭�� ������ �� ����ϼ���.
//		��, char �迭 ���� �� ������ ��Ÿ���� ���� ���ĺ��� *�� �����ϼ���.
//		[���� ȭ��]
//		�ֹε�Ϲ�ȣ(-����) : 123456-1234567
//		123456-1******
		Scanner sc = new Scanner(System.in);
		System.out.print("�ֹε�Ϲ�ȣ(-����) : ");
		String str = sc.next();
		char[] arr = new char[str.length()];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = str.charAt(i);
			if(i>=8) {
				arr[i] = '*';
			}
			System.out.print(arr[i]);
		}
		
	}
	
	public void practice8() {
//		3�̻��� Ȧ���� �Է� �޾� �迭�� �߰������� 1���� 1�� �����Ͽ� ������������ ���� �ְ�,
//		�߰� ���ĺ��� �������� 1�� �����Ͽ� ������������ ���� �־� ����ϼ���.
//		��, �Է��� ������ Ȧ���� �ƴϰų� 3 �̸��� ��� ���ٽ� �Է��ϼ��䡱�� ����ϰ�
//		�ٽ� ������ �޵��� �ϼ���.
//		[���� ȭ��]
//		���� : 4
//		�ٽ� �Է��ϼ���.
//		���� : -6
//		�ٽ� �Է��ϼ���.
//		���� : 5
//		1, 2, 3, 2, 1
		
		
		
		Scanner sc = new Scanner(System.in);
		int num1 = -1;
		
		do {
			System.out.print("���� : ");
			num1 = sc.nextInt();
			if(num1<3 || num1%2==0) {
				System.out.println("�ٽ� �Է��ϼ���.");
			}
			
		}while(num1<3 || num1%2==0);
		
		int[] arr = new int[num1];
		int count = 0;
		for(int i=0; i<arr.length; i++) {
			if((arr.length+1)/2 <= i) {
				count--;
			}else {
				count++;
			}
			System.out.print(count+", ");
		}
		
	}
	
	public void practice9() {
//		10���� ���� ������ �� �ִ� ������ �迭�� ���� �� �Ҵ��ϰ�,
//		1~10 ������ ������ �߻����� �迭�� �ʱ�ȭ�� �� ����ϼ���.
//		[���� ȭ��]
//		�߻��� ���� : 9 7 6 2 5 10 7 2 9 6
		
		int[] arr = new int[10];
		
		System.out.print("�߻��� ���� : ");
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*10+1);
			System.out.print(arr[i]+" ");
		}
	}
	
	public void practice10() {
//		10���� ���� ������ �� �ִ� ������ �迭�� ���� �� �Ҵ��ϰ�,
//		1~10 ������ ������ �߻����� �迭�� �ʱ�ȭ ��
//		�迭 ��ü ���� �� �� �߿��� �ִ밪�� �ּҰ��� ����ϼ���.
//		[���� ȭ��]
//		�߻��� ���� : 5 3 2 7 4 8 6 10 9 10
//		�ִ밪 : 10
//		�ּҰ� : 2
		
		int[] arr = new int[10];
		int max = 0;
		int min = 11;
		System.out.print("�߻��� ���� : ");
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*10+1);
			System.out.print(arr[i]+" ");
			if(max<arr[i]) {
				max=arr[i];
			}
			if(min>arr[i]) {
				min=arr[i];
			}
		}
		System.out.printf("\n�ִ밪 : %d\n"
				+ "�ּҰ� : %d", max, min);
		
	}
	
	public void practice11() {
//		10���� ���� ������ �� �ִ� ������ �迭�� ���� �� �Ҵ��ϰ�
//		1~10 ������ ������ �߻����� �ߺ��� ���� ���� �迭�� �ʱ�ȭ�� �� ����ϼ���.
//		[���� ȭ��]
//		4 1 3 6 9 5 8 10 7 2 
		
		int[] arr = new int[10];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*10+1);
			for(int j=0; j<i; j++) {
				if(arr[j] == arr[i]) {
					i--;
					break;
				}
			}
		}
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}
	
	public void practice12() {
//		�ζ� ��ȣ �ڵ� ������ ���α׷��� �����.
//		(�ߺ� �� ���� ������������ �����Ͽ� ����ϼ���.)
//		[���� ȭ��]
//		3 4 15 17 28 40 
		
		int[] arr = new int[6];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*45+1);
			for(int j=0; j<i; j++) {
				if(arr[j] == arr[i]) {
					i--;
					break;
				}
			}
		}
		Arrays.sort(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}
	
	public void practice13() {
//		���ڿ��� �Է� �޾� ���ڿ��� � ���ڰ� ������ �迭�� �����ϰ�
//		������ ������ �Բ� ����ϼ���.
//		[���� ȭ��]
//		���ڿ� : application
//		���ڿ��� �ִ� ���� : a, p, l, i, c, t, o, n
//		���� ���� : 8
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���ڿ� : ");
		String str = sc.next();
		char[] ch = new char[str.length()];
		int count = 0;
		
		System.out.print("���ڿ��� �ִ� ���� : ");
		
		for(int i=0; i<ch.length; i++) {
			ch[i] = str.charAt(i);
			for(int j=0; j<i; j++) {
				if(ch[j] == ch[i]) {
					ch[i] = '@';
					count--;
					break;
				}
			}
			count++;
			if(ch[i] != '@') {
				if(i==ch.length-1) {
					System.out.print(ch[i]);
				}else {
					System.out.print(ch[i] + ", ");					
				}
			}

			
		}
		System.out.println("\n���� ���� : "+count);

		
	}
	
	
	public void practice14() {
//		����ڰ� �Է��� �迭�� ���̸�ŭ�� ���ڿ� �迭�� ���� �� �Ҵ��ϰ�
//		�迭�� �ε����� ���� �� ���� ����ڰ� �Է��Ͽ� �ʱ�ȭ �ϼ���.
//		��, ����ڿ��� �迭�� ���� �� ������ ����� �� ���� �� �Է��� ����,
//		�ø� ���� � �����͸� ���� ������ ��������.
//		����ڰ� �� �̻� �Է����� �ʰڴٰ� �ϸ� �迭 ��ü ���� ����ϼ���.
//		
//		[���� ȭ��]
//				�迭�� ũ�⸦ �Է��ϼ��� : 3
//				1��° ���ڿ� : �ڹ��� ����
//				2��° ���ڿ� : �˰���
//				3��° ���ڿ� : C���α׷���
//				�� ���� �Է��Ͻðڽ��ϱ�?(Y/N) : y
//				�� �Է��ϰ� ���� ���� : 2
//				4��° ���ڿ� : �ΰ�����
//				5��° ���ڿ� : �ڱ���
//				�� ���� �Է��Ͻðڽ��ϱ�?(Y/N) : y
//				�� �Է��ϰ� ���� ���� : 1
//				6��° ���ڿ� : ���ܾ�600
//				�� ���� �Է��Ͻðڽ��ϱ�?(Y/N) : n
//				[�ڹ��� ����, �˰���, C���α׷���, �ΰ�����, �ڱ���, ���ܾ�600]
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�迭�� ũ�⸦ �Է��ϼ��� : ");
		int size = sc.nextInt(); // 3
		sc.nextLine();  // next(), nextInt() ����� ��
						// �Է� ���� ���� �տ� \n�� �����ִ�
						// �׷��� ���� nextLine() �� ���� �տ� �����ִ� \n�� �о��
						// ��ĭ�� �о���� �һ�簡 �߻���
						//		
						// �ذ��� : next(), nextInt() ���� �ڿ� �ǹ̾��� nextLine()�� �� �� �ۼ��Ͽ�
						// �Է¹��ۿ� ���� \n�� ����
		int size2 = size;
		String[] arr = new String[size];
		char flag = 'y';
		for(int i=0; i<arr.length; i++) {
			System.out.print(i+"��° ���ڿ� : ");
			String str = sc.nextLine();
			arr[i] = str;
		}
		while(true) {
			System.out.print("�� ���� �Է��Ͻðڽ��ϱ�?(Y/N) : ");
			flag = sc.next().charAt(0);
			if(flag=='n' || flag=='N') {
				break;
			}
			if(!(flag=='y' || flag=='Y')) {
				System.out.print("�߸� �Է��ϼ̽��ϴ�\n");
				continue;
			}
			System.out.print("�� �Է��ϰ� ���� ���� : ");
			size += sc.nextInt();
			
			String[] arr2 = new String[size];
			for(int i=0; i<size2; i++) {
				arr2[i] = arr[i];
			}
			
			for(int i=size2; i<arr2.length; i++) {
				System.out.print(i+"��° ���ڿ� : ");
				String str = sc.nextLine();
				arr2[i] = str;
			}
			arr = Arrays.copyOf(arr2, arr2.length);
			size2 = size;
		}
		System.out.println(Arrays.toString(arr));
		
	}
}
