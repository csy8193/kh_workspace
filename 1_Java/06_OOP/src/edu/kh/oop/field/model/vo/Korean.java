package edu.kh.oop.field.model.vo;

public class Korean {
	
	
	private String name;
	private String id; // �ֹε�Ϲ�ȣ
	// private int nationalCode = 82;
	public static int nationalCode = 82; // static ����� �߰�
	// -> ���α׷��� ���� ���ڸ��� static ������ �޸𸮰� �Ҵ��.
	
	// public final static String Language = "�ѱ�";
	public static final String Language = "�ѱ�";
	// -> ����Ǵ� ��� ex) PI
	
	
	// ***** static ���� �ۼ��� �ڵ��
	// ���α׷� ���� �� static ������ �ڵ����� �߰��ȴ�.
	
	// JVM�� Static ���� == ���� �޸� ���� == ���� �޸� ����
	
	
	 
	/* *** �ʵ� ����ȭ
	 * 1) ��� ���� == �ν��Ͻ� ���� (static x)
	 * - private String name;
	 * 
	 * (����) Ŭ���� ���ο� �ۼ��Ǵ� �ʵ�, �޼ҵ带 ��Ʋ�� "���"
	 * 		 ��, static ����
	 * 
	 * - ���� : new �����ڸ� ���� Heap ������ ��ü(�ν��Ͻ�)�� ������ ��
	 * - �Ҹ� : ��ü�� �Ҹ�� �� ���� �Ҹ�
	 * 			-> ��ü �Ҹ� ���� : ��� ���� �������� �������� ���� �� GC�� �Ҹ� ��Ŵ
	 * 
	 * 2) Ŭ���� ���� == static ���� (static o)
	 * - public static int nationalCode;
	 * 
	 * - ���� : ���α׷� ���� �� Static ������ ������.
	 * - �Ҹ� : ���α׷� ���� �� �ڵ� �Ҹ��
	 * 
	 * */
	
	
	
	
	
	
	
	
	
	
	// ���
	public void setName(String name) {
						// �Ű�����
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setNationalCode(int nationalCode) {
		this.nationalCode = nationalCode;
	}
	
	public int getNationalCode() {
		return nationalCode;
	}
}
