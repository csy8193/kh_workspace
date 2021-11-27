package edu.kh.oarr.ex.model.service;

import java.util.Scanner;

import edu.kh.oarr.ex.model.vo.Book;

public class BookService {
	
	public void example1() {
		
		// Book ��ü �迭 ���� �� �Ҵ�
		Book[] books = new Book[3];
						// Book ���� ���� 3��
		
		// Book ��ü �迭 ��� �ʱ�ȭ
		books[0] = new Book("�����", "�����㺣��", 8000);
		books[1] = new Book("�ڹ�������", "���� ��", 30000);
		books[2] = new Book("�ﱹ��", "�̹���", 100000);
		
		// for���� �̿��Ͽ� Book ��ü�迭 ��� ���� ��� ���
		for(int i=0; i<books.length; i++) {
			System.out.println( books[i].information() );
		}
		
		// books �迭�� ��� ��
		// ������ "�ڹ�������"�� Book ��ü�� ����(price)�� ���
		
		for(int i=0; i < books.length; i++) {
			
			// books[i] ��Ұ� �����ϴ� Book ��ü�� ������ "�ڹ�������"�� ���
			if( books[i].getTitle().equals("�ڹ�������") ) {
				System.out.println("�ڹ������� ���� : " + books[i].getPrice());
			}
		}
	}
	
	public void example2() {
		
		// �⺻ �ڷ��� 1���� �迭 ���� �� �ʱ�ȭ
		int[] arr = {1, 2, 3};
		
		// ��ü �迭 ����� ���ÿ� �ʱ�ȭ
		Book[] books = { 
							new Book("�׸����θ���ȭ", "���콺", 10000),
							new Book("�����", "�����㺣��", 8000),
							new Book("�ڹ�������", "���� ��", 30000),
						};
		// Book[] ��ü �迭 ���� ��
		// 3ĭ �Ҵ� + Book ��ü ���� �� �ʱ�ȭ
		
		
		// books�� �����ϴ� å�� ���� �� ���ϱ�
		int sum=0;
		
		for(int i=0; i<books.length; i++) {
			sum += books[i].getPrice();
		}
		
		System.out.println(sum);
		
	}
	
	public void example3() {
		
		// Book ��ü 3���� ������ �� �ִ� �迭�� ���� �� �Ҵ��ϰ�
		// å 3���� ������ �Է� �޾� Book ��ü �迭�� ������� ����,
		// + ������ ���� ��� å, ���� ������ å�� ������ ���
		
		Book[] books = new Book[3]; // Book ��ü �迭 ���� �� �Ҵ�
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=1; i<books.length; i++) {
			System.out.print(i + "��° å ���� : ");
			String title = sc.nextLine();
			
			System.out.print(i + "��° ���� : ");
			String author = sc.nextLine();
			
			System.out.print(i + "��° å ���� : ");
			int price = sc.nextInt();
			sc.nextLine(); // �Է� ���ۿ� �����ִ� ���๮�� ����
			
			// �Է� ���� ���� �̿��� Book ��ü ������
			// books �迭�� ������� ����
			books[i] = new Book(title, author, price);
			
			System.out.println( books[i].information() );
		}
		
		//// ���� ��
		
		
		// ���� ������ ū/���� ���� ���� å�� �ε����� ������ ����
		int maxIndex = 0;
		int minIndex = 0;
		
		for(int i=0; i <books.length; i++) {
			
			// ���� �ε����� ������ maxIndex�� ���ݺ��� �������
			if(books[i].getPrice() > books[maxIndex].getPrice()) {
					maxIndex = i; // �ִ밪�� ��Ÿ���� maxIndex ����
			}
			
			// ���� �ε����� ������ minIndex�� ���ݺ��� �������
			else if(books[i].getPrice() < books[minIndex].getPrice()) {
				minIndex = i; // �ּҰ��� ��Ÿ���� minIndex ����
			}
			
		}
		
		System.out.println("���� ��� å : " + books[maxIndex].information());
		System.out.println("���� �� å : " + books[minIndex].information());
	}
}
