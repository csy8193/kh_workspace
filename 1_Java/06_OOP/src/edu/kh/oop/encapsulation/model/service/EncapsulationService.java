package edu.kh.oop.encapsulation.model.service;

import edu.kh.oop.encapsulation.model.vo.Account;
import edu.kh.oop.encapsulation.model.vo.Book;

public class EncapsulationService {
	
	public void example1() {
		
		// Acount ��ü�� �ϳ� �����Ͽ� �̸� �����ϴ� ���� ac�� �ּ� ����
		Account ac = new Account();
		
		// ĸ��ȭ�� ������� �ʾ��� ���
//		ac.name = "�ֽ¿�";
//		ac.accountNumber = "123-123456-10";
//		ac.password = "1111";
//		ac.bankCode = 10;
//		ac.money = 1000000; // 100����
//		
//		
//		System.out.println(ac.money);
//		System.out.println(ac.password);
//		ac.money -= 1000000; // �鸸�� ���
		
		// -> �ܺ��� �߸��� ������� ���� ��ü�� �ջ�
		
		
		// *** ĸ��ȭ ���� �� ��ü�� �Ӽ��� �������� ������ �Ұ�������.
		//     -> (���� �ڵ忡�� ���� �߻��ϴ� ����)
		
		// setter�� �̿��� �� �����ϱ�
		ac.setName("ȫ�浿");
		// Account ��ü�� ��� �� setName�� �Ű������� "ȫ�浿" ���� ����
		ac.setAccountNumber("123-1234-1234");
		ac.setPassword("1111");
		ac.setMoney(1000000);
		ac.setBankCode(10);
		
		
		// getter�� �̿��Ͽ� ���� ���� ����ϱ�
		System.out.println(ac.getName());
		System.out.println(ac.getAccountNumber());
		System.out.println(ac.getPassword());
		System.out.println(ac.getMoney());
		System.out.println(ac.getBankCode());
		
		
		
	}
	
	
	public void example2() {
		
		// Book ��ü�� �����Ͽ� �̸� �����ϴ� ���� book1�� �ּҸ� ����
		
		// * �ڹٿ��� ��ü��?
		// new �����ڸ� ���� Heap ������ ������ ��
		// -> ��ü�� ����� ���ؼ� ���赵(Ŭ����)�� �ʿ�
		
		Book book1 = new Book();
		
		// book1�� �� ���� �� ���
		
		book1.setTitle("�����");
		book1.setAuthor("�����㺣��");
		book1.setPrice(8000);
		
		System.out.println("���� : "+ book1.getTitle());
		System.out.println("���� : "+ book1.getAuthor());
		System.out.println("���� : "+ book1.getPrice());
		
		
	}
}
