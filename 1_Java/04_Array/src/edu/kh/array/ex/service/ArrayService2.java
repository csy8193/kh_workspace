package edu.kh.array.ex.service;

import java.util.Arrays;

public class ArrayService2 {
	
	// �迭 ����
	// - ���� ���� : �����ϴ� �迭�� ���� �ּҸ��� ����
	// -> ��ü�� �Ű�����, ��ȯ�� ���� �� ���
	
	// - ���� ���� : ���� �迭�� ������ �ڷ���, �����ϰų� �� ū ũ��
	//			   ������ �����͸� ������ ���ο� �迭�� ����� ��
	// -> ���� ������ ����, ������ �Ȱ��� �迭�� �ʿ��� ��
	
	public void example1() {
		// ���� ���� ����
		
		int[] arr = {1,2,3,4,5};
		
		// ���� ���� ����
		int[] copyArr = arr;
		// arr, copyArr�� ������ �ּҿ� �ִ� int[]�� ����
		
		System.out.println("���� ��");
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(copyArr));
		// -> ���簡 �Ǿ����� Ȯ��
		
		// ������ �迭�� 0��° ��Ҹ� ����
		copyArr[0] = 999;
		
		System.out.println("���� ��");
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(copyArr));
		// ���� ���� -> arr, copyArr�� ���� �迭�� ����
		// -> arr, copyArr �� �� 0�� �ε��� ���� �����
	}
	
	public void example2() {
		
		// ���� ���� ����
		
		int[] arr = {1,2,3,4,5};
		
		// ���� ���� ����
		
		// 1) ���縦 ���� ���ο� �迭 ���� �� �Ҵ�
		int[] copyArr = new int[arr.length];
						// -> ���� �迭�� ���� ũ���� ���ο� �迭 �Ҵ�
		
		// 2) ���� �迭�� ������ ����� �迭�� �ʱ�ȭ�ϱ�
		
		// 2-1) for���� �̿��� ���� ����
//		for(int i=0; i<arr.length; i++) {
//			copyArr[i] = arr[i];
//		}
		
		// 2-2) System.arraycopy(�����迭, ���� ���� ���� �ε���, ����迭, ����迭�� ���� ���� �ε���, �������);
		
		System.arraycopy(arr, 0, copyArr, 0, arr.length);
		// ���� �迭 arr���� 0�� �ε������� 5���� �����͸�
		// ���� �迭 copyArr�� 0�� �ε������� ���ʴ�� ����
		
		System.out.println("���� ��");
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(copyArr));
		
		
		copyArr[0] = 999;
		
		System.out.println("���� ��");
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(copyArr));
		
	}
	
	// ����
	
	public void example3() {
		// �迭 ��� �ߺ� �˻�
		
		
		int[] arr = {4, 2, 3, 4, 1, 4};
		
		// 0�� index���� �ϳ��� �������� �ϳ��� ��
		// �� ���� ������ ���� for
		for(int i=0; i< arr.length-1; i++) {
			
			// �� ����� �����ϴ� for��
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i] == arr[j]) {
							//�� ���
					System.out.println(arr[i] + " �ߺ�");
					break;
				}
			}
		}
	}
	
	public void example4() {
		
		// ������ �߻����� �ߺ��Ǵ� ���� �ִ��� Ȯ��
		// ���� 1. ������ ���� ���� 0 ~ 20
		// ���� 2. ���� ���� ���� : 4��
		// Math.random()
		// -> 0.0�̻� 1.0�̸��� ������ �߻���Ű�� �޼ҵ�(���)
		
		int[] arr = new int[4];
		
		// �迭 ��ҿ� 0~20 ���� ������ ����
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*21);
		}
		System.out.println(Arrays.toString(arr));
		
		
		// �ߺ� �˻� �ڵ�
		for(int standard = 0; standard < arr.length-1; standard++) {
			
			for(int target = standard + 1; target < arr.length; target++) {
				
				if(arr[standard] == arr[target]) {
					System.out.println(arr[standard] + " �ߺ�");
				}
			}
		}
	}
	
	
	// �ζ� ��ȣ ������
	// ����1) 1 ~ 45 ���� ����
	// ����2) 6��
	// ����3) �ߺ� X
	// + �߰����� : �������� ����
	public void lottoNumberConstructor() {
		
		int[] lotto = new int[6];
		
		for(int i=0; i<lotto.length; i++) {
			int ran = (int)(Math.random()*45+1);
			
			lotto[i] = ran;
			
			// ���� ������ ���� ran��
			// lotto �迭�� �����ϴ� ���� ������ �����
			for(int x=0; x<i; x++) { // �ռ� ����� ������ �����ϱ� ���� for��
				
				// �ռ� ����� ������, ���� ������ ������ ���� ���
				// == �ߺ��� �߻��ߴ�.
				// == i���� �������� �������� �ʰ� ������ �ٽ� �����ߵȴ�
				// -> ��� : i���� ������Ű�� ������ �ȴ�
				if(lotto[x] == ran) {
					i--; // �ߺ��� �߻��� ��� ���ڸ����� �ٽ� ���� �߻�
					break;
				}
			}	
		}
		
		// Arrays.sort(�迭��)
		// -> �迭 �� ������ �������� ������ ����
		Arrays.sort(lotto);
		System.out.println(Arrays.toString(lotto));
	}
	
	////////////////////////////////////////////////////
	
	
	// String, String[]
	public void example5() {
		String str1 = "Apple";
		String str2 = "Banana";
		
		String[] arr = new String[3];
		arr[0] = "Hello";
		arr[1] = "�ȳ�";
		arr[2] = "Hi";
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
