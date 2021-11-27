package edu.kh.oarr.ex.model.vo;

// getter / setter �ڵ� �ϼ�

// alt (+ shift) + s -> r

public class Book {

	// �ʵ�
	private String title; 	// ����
	private String author;	// ����
	private int price;		// ����
	
	
	// ������
	public Book() { } // �⺻ ������
	
	//�Ű����� �ִ� ������
	public Book(String title, String author, int price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String information() {
		// ��ü�� ������ �ִ� �ʵ� ���� ��ȯ �޼ҵ�
		return title + " / " + author + " / " + price;
			// ����� / �����㺣�� / 8000
	}
	
}
