package edu.kh.collection.model.service;

import edu.kh.collection.model.vo.Student;

public class ArrayService {
	/* �迭
	 * - �� ���� �ڷ����� ���� ���� ���� ���� �ٷ�� ��.
	 * - �� �� ������ ũ�⸦ ������ �� ���� 
	 * 
	 * */
	
	// Student ��ü �迭
	private Student[] stdList = new Student[3];
								// Student ��ü ���� ���� 3�� ����
	
	private int index = 0; // add() �޼ҵ� ȣ�� �� �߰��� index�� �����ϴ� ����
	
	// �Ű������� ���� ���� Student ��ü �ּҸ� stdList�� ������� �߰�
	public boolean add(Student std) {
		
		// �迭 ���� ���� �ڵ� �߰�
		// == ���ο� �� ū �迭�� �����  ���� ���� ��
		//	  stdList�� ���� ����
		
		// �迭�� �� á�� �� ���̸� 2�� ����
		if(index == stdList.length) {
			
			// 1) �ι� ū �迭 ����
			Student[] newList = new Student[stdList.length*2];
			
			// 2) ���� ����(������ ��ü�� ���� == ����)
			System.arraycopy(stdList, 0, newList, 0, stdList.length);
			
			// 3) ���� ����(�ּҸ� ����)
			stdList = newList; // stdList ���� ������ ������ �迭�� ����
		}
		
		stdList[index] = std;
		index++;
		
		return true;
	}
	
	// stdList�� ����� ��ü ������ ��� ��ȯ
	@Override
	public String toString() {
		
		String str = "";
		
		for(int i=0; i<index; i++) {
			str += stdList[i] + ", ";
			// ȫ�浿 / 15 / 2, �迵�� / 12 / 5,
		}
		
		return str;
	}
	
	
	
}
