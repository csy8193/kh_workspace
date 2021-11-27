package edu.kh.poly.ex2.model.vo;

// ������, �����, �⸰, ���, ȣ����, ����ī, �ڳ���, ��, ����
// ��, �Ź�, ����, ���, ���ű�
public abstract class Animal {
	
	// �߻� Ŭ���� (abstract class)
	// 1. �߻� �޼ҵ带 �����ϰ� �ִ� �̿ϼ��� Ŭ����
	
	// 2. �̿ϼ��� �κ��� ��� ��ü�� �����Ǽ��� �ȵǴ� Ŭ����
	
	
	// �ʵ�
	private String type; // ��
	private String eatType; // �ļ� (�ʽ�, ����, ���)
	
	
	// ������ : ��ü ���� ���
	// * �߻� Ŭ������ �������� ��ü ������ �Ұ��� ������
	//	 ��� ���� �ڽ� ��ü ���ο� ������ �� �����Ƿ� ������ �ۼ� ����
	//	 ( �ڽ� ������ �ڵ� ���� super() �����ڸ� ���� )

	public Animal() {
		super();
	}
	
	public Animal(String type, String eatType) {
		super();
		this.type = type;
		this.eatType = eatType;
	}
	

	
	// ���
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	public String getEatType() {
		return eatType;
	}
	public void setEatType(String eatType) {
		this.eatType = eatType;
	}
	
	
	// �����̶�� ��� ������ �ִ� ���������
	// �������� �����ϴ� ����� �ٸ� ���
	public abstract void hunt(); // �̿ϼ� �޼ҵ�
	
	
	
}
