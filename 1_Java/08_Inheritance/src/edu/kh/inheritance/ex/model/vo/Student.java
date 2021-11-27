package edu.kh.inheritance.ex.model.vo;

// final Ŭ���� : ��� �Ұ��� Ŭ����
public final class Student extends Person{
			// �������� �ڽ�	// �����ִ� �θ�
	
	// * extends ��� Ű���带 ����ϴ� ����?!
	// - "Ȯ���ϴ�" ��� �ǹ̷�
	//	 �ڽ��� �θ��� ���(�ʵ�, �޼���)�� ���� �����Ƿν�
	//	 �ڽ��� �����ԵǴ� ����� ���� �þ��(Ȯ��) ����
	
	// �ʵ�
	// private String name;
	// private int age;
	// private String nationality;
	// Person Ŭ������ �ߺ��Ǵ� �ʵ�, �޼��带 �����޾� ����� ����
	
	private int grade; // �г�
	private int classRoom; // ��
	
	
	// ������
	public Student() { 
		super(); // �ڽ� ��ü ���� �θ� ��ü��
	} // �⺻ ������
	
	// �Ű����� �ִ� ������
	// Student�� �������ִ� �ʵ� : grade, classRoom
	//						   name, age, nationality
	
	public Student(int grade, int classRoom, String name, int age, String nationality) {
		// ��� 2) super() ������ ���
		
		// * super() ������
		// - �ڽ� ������ ���� ù �ٿ� �ۼ������ϸ�
		//	 �ڽ� ��ü ���� �� ������ �θ� �κ��� �����ϴµ� ���Ǵ� ������
		//   (����) �ڽ� ��ü �κ��� �������� �θ� �κ��� ���� �����ȴ�.
		// super(); // �θ� �⺻ ������ ȣ��
		
		// �θ� �Ű����� �ִ� ������
		super(name, age, nationality);
		// �ڵ� ���뼺 ����, �ڵ���� ����
		
		
		
		this.grade = grade;
		this.classRoom = classRoom;
		
		// this.name // -> ��� ���� �θ��� �ʵ尡 private�̸� ���� ���� �Ұ�
		// ��� 1) �θ� �ʵ� ���� ���� ����� setter �̿�
		// setName(name);
		// setAge(age);
		// setNationality(nationality);
		
	}


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	public int getClassRoom() {
		return classRoom;
	}


	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}
	
	
	// �ڽ� ��ü�� �������ִ� ��� �ʵ� ������ ���ڿ��� ��ȯ�ϴ� �޼ҵ�
	public String information() {
		// �̸� / ���� / ���� / �г� / ��
		
//		return getName() + " / " + getAge() + " / " + getNationality() + 
//				" / " + grade + " / " + classRoom;
		
//		return information() + 
//				" / " + grade + " / " + classRoom;
		
		// information() �̶�� �ۼ��ϰ� �Ǹ�
		// -> �̰� �θ�? �ڽ�? ������ ������ Ȯ���� ���е��� �ʾ�
		//	  �ڽ��� �޼ҵ�� �Ǵ��Ͽ� ȣ����.
		//		-> ���� �޼ҵ尡 ȣ��Ǵ� ���� (���ȣ��)�� ������ �ݺ��Ǿ�
		//		   �޼ҵ尡 ���̴� �޸� ���� Stack�� ���� �帧
		//		   (StackOverflow)
		
		return super.information() + 
				" / " + grade + " / " + classRoom;
	}
	
	
	// Object�� toString() ��ӹ޾� �������̵��� Person��
	// ��� ���� Student���� toString()�� �� �������̵� �ϱ�
	@Override
	public String toString() {
		return super.toString() + " / " + grade + " / " + classRoom;
	}
	
	
	// final �޼��� �������̵� �Ұ� Ȯ��
//	@Override
//	public void breath() {
//			// -> Person ��ü�� final �޼���� �������̵� �Ұ�
//	}
	
	@Override // 
	public String overridingTest() {
		
		return "Student���� �������̵� �Ǿ���";
	}
	
	
	// �޼��� �����ε�
	public int sum(int num1, int num2) {
		int sum = num1 + num2;
		return sum;
	}
	
	public double sum(double num1, double num2) {
		double sum = num1 + num2;
		return sum;
	}
	
}
