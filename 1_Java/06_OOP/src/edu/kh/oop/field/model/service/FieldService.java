package edu.kh.oop.field.model.service;

import edu.kh.oop.field.model.vo.Korean;

public class FieldService {

	 
	public void exmaple1() {
		// ����� static �׽�Ʈ �ϱ�
		
		// �ѱ��� ��ü 2�� ����
		Korean k1 = new Korean();
		Korean k2 = new Korean();
		
		// �� ��ü�� �̸�, �ֹε�Ϲ�ȣ ����
		
		k1.setName("��ö��");
		k1.setId("990102-1234567");
		
		
		k2.setName("�迵��");
		k2.setId("990304-2345678");
		
		
		
		// �� ��ü�� �������ִ� �ʵ� ���� ���
		System.out.printf("%s / %s / %d\n", k1.getName(), k1.getId(), k1.getNationalCode());
		System.out.printf("%s / %s / %d\n", k2.getName(), k2.getId(), k2.getNationalCode());
		
		
		// ���� Korean ��ü�� 5õ������ �ִٰ� ����
		// �ѱ��� ���� �ڵ尡 82 -> 1 �� ����
		// �̹� ������� Korean��ü�� nationalCode ���� 1�� ����
		
		// k1.setNationalCode(1);
		// k2.setNationalCode(2);
		// .... �ʹ� ��ȿ���� --> static�� Ȱ������
		
		Korean.nationalCode = 1;
		// -> static���� ����Ǿ� ��� Korean ��ü��
		//	  nationalCode�� ����������
		//	  ���������ڰ� private�̸�
		//	  Korean.nationalCode�� static�� ���� ������ �� ����
		// --> �̷� ��� ĸ��ȭ ��Ģ�� �����ϰ� public���� �ۼ�
		
		System.out.printf("%s / %s / %d\n", k1.getName(), k1.getId(), k1.getNationalCode());
		System.out.printf("%s / %s / %d\n", k2.getName(), k2.getId(), k2.getNationalCode());
		
		
	}
}
