package edu.kh.oop.constructor.model.vo;

public class User {
	
	
	/* Ŭ���� ����
	 * 
	 * public class Ŭ������ {
	 * 	
	 * 		�ʵ�
	 * 
	 * 		������
	 * 
	 * 		�޼ҵ�
	 * 
	 * }
	 * */
	
	// �ʵ�
	// ĸ��ȭ ��Ģ�� ���ؼ� �⺻������ private
	private String userId; // ����� ID
	private String userPassword; // ����� ��й�ȣ
	private String userName; // ����� �̸�
	private int userAge; // ����� ����
	private char userGender; // ����� ����
	
	
	// ������
	
	/* - new �����ڸ� ���� ��ü ���� �� 
	 *   ������ ��ü�� �ʵ� ���� �ʱ�ȭ�ϰ�, ������ ����� �����ϴ� ���� ����.
	 * 
	 * - ������ �ۼ� ��Ģ
	 * 1) �������� �̸��� �ݵ�� Ŭ������� ���ƾ� �Ѵ�
	 * 2) �����ڴ� ��ȯ���� �������� �ʴ´�.
	 * 3) �����ڰ� �ϳ��� �����ϴ� ���
	 * 	  �����Ϸ��� ���ؼ� �⺻ �����ڰ� �ڵ� �߰����� ����.
	 * 	  -> �Ű� ���� �ִ� ������ �ۼ� ��
	 * 		 �⺻ �����ڸ� �ݵ�� ����� �ִ� ���� ����.
	 * 
	 * 
	 * */
	
	// �⺻ ������
	// [����������] Ŭ������() { ... }
	public User() {
		// ��ü ���� �� ����� �ڵ� �ۼ�
		
		System.out.println("�⺻ �����ڿ� ���ؼ� User ��ü�� �����Ǿ����ϴ�.");
	}
	// -> �����ڰ� �ϳ��� �ۼ����� ���� ���
	//	  ����� ��ü�� ������ �� ���� ������
	//	  �����Ϸ��� �ڵ����� �⺻ �����ڸ� �߰� ���� !
	
	// �Ű����� �ִ� ������
	// - ��ü ���� �� �Ű������� ���� ���� ���� �̿��ؼ�
	//	 ��ü�� �ʵ带 �ʱ�ȭ �ϴ� �뵵�� ������
	// -> ��ü�� ���� ���ڸ��� �ʵ忡 ���� �� ����.
	
	public User(String userId, String userPassword,
			String userName, int userAge, char userGender) {
		// �Ű������� 5�� == ���� �޴� ���� 5��
		
//		this.userId = userId;
//		this.userPassword = userPassword;
		this(userId, userPassword); // this ������
		// -> ���� Ŭ���� ���ο� �ۼ��� �ٸ� �����ڸ� ȣ���� �� ���
		// -> �ߺ� ���Ÿ� ���� �ڵ� ���� ���� ȿ���� ���� ���
		// (���ǻ���) �ݵ�� ������ ù ��° �ٿ� �ۼ��ؾ���.
		
		this.userName = userName;
		this.userAge = userAge;
		this.userGender = userGender;
	}
	
	// ������ �����ε� -> 1) �Ű������� ������ �ٸ��� ����
	public User(String userId, String userPassword) {
		this.userId = userId;
		this.userPassword = userPassword;
	}
	
	// ������ �����ε� -> 2) �Ű������� ������ ������ Ÿ���� �ٸ��� ����
	public User(String userId, int userAge) {
		this.userId = userId;
		this.userAge = userAge;
	}
	
	// ������ �����ε� -> 3) �Ű������� ����, Ÿ���� ������ ������ �ٸ��� ����
	public User(int userAge, String userId) {
		this.userId = userId;
		this.userAge = userAge;
	}
	
	// �����ε� �� ���ǻ��� - ������
//	public User(int userAge, String userName) {
//		this.userName = userName;
//		this.userAge = userAge;
//	}
	
	// �޼ҵ�
	// getter / setter
	public String getUserId() {
		// ���� ��ü�� �ʵ忡 �ִ� userId�� ��ȯ
		return userId;
	}
	
	public void setUserId(String userId) {
		// �Ű������� ���� ���� userId�� ���� ��ü�� �ʵ忡 �ִ� userId�� ����
		this.userId = userId;
	}
	
	public String getUserPassword() {
		return userPassword;
		
	}
	
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
		
	}
	
	public String getUserName() {
		return userName;
		
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
		
	}
	
	public int getUserAge() {
		return userAge;
		
	}
	
	public void setUserAge(int userAge) {
		this.userAge = userAge;
		
	}
	
	public char getUserGender() {
		return userGender;
		
	}
	
	public void setUserGender(char userGender) {
		this.userGender = userGender;
		
	}
	
	
	
	
	
	
}
