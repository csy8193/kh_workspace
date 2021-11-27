package edu.kh.oop.method.service;


// ���� ��ɸ��� ��Ƶ� Ŭ����
public class ApplicationSet {
	
	// ���� ��ȯ �޼ҵ�
	public int squared(int num) {
		// ���� ���� ���� ������ ����
		
		return num * num;
	}
	
	
	
	
	// �迭 ���� �� �ʱ�ȭ �޼ҵ�
	public int[] createArray(int size) {
		
		// �迭 ����
		int[] arr = new int[size];
		
		// ������� 1���� 1�� �����ϴ� ������ �ʱ�ȭ
		for(int i=0; i<arr.length; i++) {
			arr[i] = i+1;
		}
		
		// ������ int[]�� ����
		return arr;
	}
	
	
	// ���� �迭�� ���� �޾�
	// �� ��ҿ� ����� ���� �� �����ϱ�
	public int arraySum(int[] arr) {
		int sum = 0;
		for(int i=0; i < arr.length; i++) {
			sum += arr[i];
		}
		
		return sum;
	}
	
	
}
