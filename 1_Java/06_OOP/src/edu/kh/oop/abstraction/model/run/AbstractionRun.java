package edu.kh.oop.abstraction.model.run;

import edu.kh.oop.abstraction.model.service.AbstractionService;

public class AbstractionRun {
	
	public static void main(String[] args) {
		
		AbstractionService service = new AbstractionService();
									// new -> ��ü���� -> �ϼ�ǰ -> ��ɼ���O
		
		service.example1();
	}
}
