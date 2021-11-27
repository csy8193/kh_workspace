package edu.kh.inheritance.ex.model.vo;
	
// java.lang ��Ű���� �����Ϸ��� �ڵ����� import�ϴ� ������ �߰��Ͽ�
// String, Object ���� Ŭ������ �ٷ� ��� �����ϰ���

// MVC model 2 ����
// -> �����ϴ� ���ҿ� ���� Ŭ������ Model, View, Controller�� ������ �����ϴ� ����

// model : ����Ͻ� ����
//			-> ������ ����, ������ ����, ������ ���̽� ���� ����

// VO(Value Object) : 
public class Person extends Object{ 
					// Ŭ������ ���� ��� ������ ������ ���
					// �����Ϸ��� ���ؼ� �ڵ����� extends Object ������ �߰��ȴ�
	
	// �ʵ�
	private String name; // �̸�
	private int age; // ����
	private String nationality; // ����
	
	// ������ : ��ü ���� + ��ü ������ �ʵ� �ʱ�ȭ + Ư�� ��� ����
	public Person() { } // �⺻ ������
	
	// ** �����ڸ� �ϳ��� �ۼ����� ���� ���
	// -> �����Ϸ��� �ڵ����� �⺻ �����ڸ� �߰�����
	
	// �Ű����� �ִ� ������
	public Person(String name, int age, String nationality) {
		this.name = name;
		this.age = age;
		this.nationality = nationality;
		
		// this �������� : ��ü ���� �� ���ο� ���� �����Ǹ�, ��ü�� ���� �ּҸ� ����
		// �����ε� : �ϳ��� �޼�������� ���� ����� �����ϴ� ��
		//		-> ���� ���� : 1) �Ű������� ����		2) Ÿ��		3) ����
	}
	
	// ��� (method)
	// VO Ŭ������ getter / setter + �ʵ� ������ �� ���� ����ϴ� �뵵�� �޼���
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	// �ʵ� ������ �ѹ��� ����ϴ� �뵵�� �޼���
	public String information() {
		return name + " / " + age + " / " + nationality;
	}
	
	
	// �������̵� : �ڽ� Ŭ������ �θ�� ���� ��� ���� �޼��带 ������(���ۼ�) �ϴ� ��.
	
	// ���� ����
	// 1) �޼ҵ���� �����ؾ��Ѵ�.
	// 2) �Ű������� ����, Ÿ��, ������ ��� �����ؾ� �Ѵ�.
	// 3) ��ȯ��(����Ÿ��)�� �����ؾ� �Ѵ�.
	// 4) �θ��� private �޼ҵ�� ������ �Ұ��ؼ� �������̵� �� �� ����.
	// 5) ���� �������� ������ ���ų� �� �о�� �Ѵ�.
	// 6) ���� ó���� ������ ���ų� �� ��ü���̾�� �Ѵ�.
	
	// Object.toString() �������̵�
	// -> Object�� ��� ��ü�� ������ ����� �߻�ȭ�Ͽ� ��Ƶ� Ŭ����
	// -> toString() : ��ü�� ��� �ʵ� ������ ���ڿ��� ��ȯ�ϴ� �뵵�� �޼���
	
	// Object�� toString() �޼ҵ� : Ŭ������ + @ + 16���� �ؽ��ڵ�
	// -> ��� ������ ���� �����Ƿ� ��� ���� �ڽ��� ������!
	
	@Override // Override ������̼� : �ش� �޼���� �������̵� �Ǿ��ٸ� �����Ϸ����� �˷��ִ� ����
	public String toString() {
		// ���� �ڵ� ������
		return name + " / " + age + " / " + nationality;
	}
	
	// Person ��ü���� ��� + ��� �Ǿ �������̵� �Ұ�
	// -> final �޼���
	// ��� ���� ������ �� �̻� �������̵� ���� ����.
	// -> ���� �ɼ� �ִ� ������ �޼���
	public final void breath() {
		System.out.println("����� �ڳ� ������ ȣ���� �ؾ� �Ѵ�");
	}
	
	
	public String overridingTest() {
		return "Person Ŭ������ �ۼ��� �������̵� �׽�Ʈ �޼���";
	}
}
