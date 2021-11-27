package edu.kh.oop.encapsulation.model.vo;

public class Book {
	// Ŭ������? 
	// -> ��ü�� Ư��(�Ӽ�, ���)�� ������ ��
	//	  ��ü�� ����� ���� ���赵
	
	
	// �Ӽ� == �� == ������
	private String title; // ����
	private String author; // ����
	private int price; // ����
	// private : ��ü �������� ���� ����
	
	// -> å�� �������ִ� ����� �κи��� �ۼ� == �߻�ȭ
	
	// -> �Ӽ��� private�� �߰��Ͽ� �ܺη� ������ ���� ������ ���� == ĸ��ȭ
	// * ĸ��ȭ�� ���� : ��ü�� �ջ��� ���� ����
	// * ĸ��ȭ�� �����ϴ� ��� �Ӽ��� ���� ������ �ȵǹǷ� ���� ���� ����� ����
	//	 --> ���� ���� ����(getter / setter)
	
	// ��� == ���� == ����
	public void knowlegeTransfer() { // ���� ���� ���
		
	}
	
	public void setTitle(String title) {
						// --> �Ű�����
						// ���� ���� ���� �����ϴ� �Ű�ü
		
		this.title = title;
		
		// this : ����, �̰�, ���� ��ü
		
		// ���� ��ü�� title �Ӽ��� private������
		// setTitle() �޼ҵ嵵 ���� ��ü�� �����Ƿ� ���� ����
	}
	
	public String getTitle() {
			// -> ���� ���� ���� �ڷ��� == ��ȯ��
			// * void : �������� ��ȯ���� ����
		return title;
		
		// return : ȣ���� ������ ���ư� == ��ȯ
		// return title; ȣ���� ������ ���ư� �� title �Ӽ����� ������ ���ư�
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
}
