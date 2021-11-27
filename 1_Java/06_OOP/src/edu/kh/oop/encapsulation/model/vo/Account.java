package edu.kh.oop.encapsulation.model.vo;

public class Account {
	
	// public : (������, �巯��) : ��𼭵��� �������� ���� �������� ��Ÿ��
	// private
	
	//�Ӽ�
	// public -> private �ٲ� (ĸ��ȭ)
	private String name; // �̸�
	private String accountNumber; // ���¹�ȣ
	private String password; // ��й�ȣ
	private int money; // ��
	private int bankCode; // ���� �ڵ�
	
	
	// ���
	public void deposit() { // �Ա� ���
		System.out.println("�Ա� ��� ����");
		
	}
	
	public void withdraw() { // ��� ���
		System.out.println("��� ��� ����");
		
	}
	// private���� ���� ������ ���ѵ� ��ü�� �Ӽ��κ���
	// ���������� ���� �� �� �ִ� ����� �ۼ�
	// --> �Ӽ����� ���� �����ϴ� ��� setter��
	//	   ���� �� �� �ְ� �ϴ� ��� getter�� �ۼ�
	
	
	// setter �ۼ� ���
	
	// public void set�Ӽ��� ( �Ӽ��ڷ��� �Ӽ��� ) {
	// 		this.�Ӽ��� = �Ӽ���;
	// }
	
	
	// name�� setter
	
	// public : �ܺο��� ���� ������ ����̶�� ��
	public void setName( String name ) {
						// String name -> �ܺηκ��� ���� ���� ���� ������ �Ű�ü
						// == �Ű� ����
						// -> �ܺη� ���� ���� ���� ����
						//	  �ش� ��� ���ο��� name�̶�� ���������� ���
		this.name = name;
		
		// this. : (����, �̰�, ���� ��ü)
	}
	
	// acountNumber�� setter
	public void setAccountNumber( String accountNumber ) {
		this.accountNumber = accountNumber;
	}
	
	// password�� setter
	public void setPassword( String password ) {
		this.password = password;
	}
	
	// money�� setter
	public void setMoney( int money ) {
		this.money = money;
	}
	
	// bankCode�� setter
	public void setBankCode( int bankCode ) {
		this.bankCode = bankCode;
	}

	
	// getter �ۼ���
	// public �Ӽ��ڷ��� get�Ӽ���() {
	//		return �Ӽ���;
	// }
	
	// name�� getter
	public String getName() {
			// String -> ȣ��� ������ �������� ���� �ڷ��� == ��ȯ��
		return name;
		
		// return : ȣ��� ������ ���ư��� == ��ȯ
		// return name;
		// -> ȣ��� ������ ���ư� �� name�Ӽ��� ����� ��("ȫ�浿")��
		//	  ������ ���ư���
	}
	
	// accounterNumber�� getter
	public String getAccountNumber() {
		return accountNumber;
	}
	
	// password�� getter
	public String getPassword() {
		return password;
	}
	
	// money�� getter
	public int getMoney() {
		return money;
	}
	
	// bankCode�� getter
	public int getBankCode() {
		return bankCode;
	}
	
	
	
}

