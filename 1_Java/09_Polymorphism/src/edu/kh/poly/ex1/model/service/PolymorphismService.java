package edu.kh.poly.ex1.model.service;

import edu.kh.poly.ex1.model.vo.Car;
import edu.kh.poly.ex1.model.vo.RollsRoyce;
import edu.kh.poly.ex1.model.vo.Spark;
import edu.kh.poly.ex1.model.vo.TeslaCar;

public class PolymorphismService {
	
	public void example1() {
		
		// ��ǻ�� ���� ��Ģ : ���� �ڷ��� ������ ������ �����ϴ�
		
		Car c = new Car(4, "�����ڵ�", "��������");
		// �θ� Ÿ�� �������� = �θ� Ÿ�� ��ü
		// -> ��ü�� ���������� Ÿ���� �����Ƿ� ���Կ��� ����!
		
		TeslaCar t = new TeslaCar(4, "�����ڵ�", "�������", 50000);
		// �ڽ� Ÿ�� �������� = �ڽ� Ÿ�� ��ü
		
		
		
		// ������(�� ĳ����) : �θ� Ÿ�� ���� ������ �ڽ� Ÿ�� ��ü�� ����
		
		Car c2 = new TeslaCar(6, "�����ڵ�", "�������", 100000);
		// �θ� Ÿ�� �������� = �ڽ� Ÿ�� ��ü
		// -> ���� ������ ��ü�� Ÿ���� ����ġ�ϳ� ���� ������ ������ ����
		
		// �� ��ü�� �ʵ� ���� ���
		System.out.println("c : " + c.toString());
		System.out.println("t : " + t.toString());
		System.out.println(c2.getWheel());
		System.out.println(c2.getHandle());
		System.out.println(c2.getEngine());
//		System.out.println(c2.getBatteryCapacity());
		// -> �θ�Ÿ���� ���� �����δ�
		//	  �ڽ� ��ü���� ����� ������ �� �����Ƿ� ���� �߻�
		System.out.println("c2 : " + c2.toString());
		
	}
	
	
	public void example2() {
		
		// ������ ��ĳ���� Ȱ��
		
		// 1) ��ü �迭
		// -> ���� �ٸ� �ڽ� Ÿ���� ��ü��
		//		�ϳ��� �θ� Ÿ�� ��ü �迭�� ��� �ٷ� �� �ִ�.
		TeslaCar tesla = new TeslaCar(4, "����", "�������", 5000);
		RollsRoyce royce = new RollsRoyce(4, "����", "��������", "����");
		Spark spark = new Spark(4, "����", "�ֹ��� ����", 0.5);
		
		// �� ��ü�� ���� ���� ���
		System.out.println( tesla.getEngine());
		System.out.println( royce.getEngine());
		System.out.println( spark.getEngine());
		
		// TeslaCar, RollsRoyce, Spark�� Car�� �ڽ��̶�� �������� �ִ�.
		// �θ� - �ڽ� ���迡��
		// �θ� ���� ������ �ڽ� ��ü�� �����ϴ� �������� ����ȴ�.
		
		Car[] arr = new Car[3]; // �θ� Ÿ�� ���� ���� �迭
								// �迭�� �� ��Ұ� Car Ÿ���� ���� ����
		
		// arr[0] = new TeslaCar();
		// �θ�			// �ڽ�
		
		arr[0] = tesla;
		// tesla == TeslaCar ��ü �ּҰ� �����
		
		arr[1] = royce; // RollsRoyce Ÿ�� ��ü ���� �ּ�
		// Car Ÿ�� ���� ����
		
		arr[2] = spark;
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i].getEngine());
		}
		
		
		System.out.println("-----------------------");
		
		// 2) ������ ��ĳ������ �Ű������� ����
		printEngine(tesla);
		printEngine(royce);
		printEngine(spark);
		
		// 3) �������� ��ĳ������ ����Ÿ��(��ȯ��)�� ����
		System.out.println(updateEngine(tesla).getEngine());
		
		
		Car c2 = createCar(1);
	}
	
	public Car updateEngine( Car c ) { // �Ű������� ���� Car�� ���� ���׷��̵�
		String newEngine = c.getEngine() + "(������)"; // �������(������)
		c.setEngine(newEngine);
		return c;
	}
	
	
	// ������ �ϳ� ���� �޾� 1�̸� teslaCar, 2�̸� RollsRoyce, 3�̸� Spark
	// ��ü�� �����Ͽ� ��ȯ
	public Car createCar(int num) {
		
		Car c = null;
		
		switch(num) {
		case 1 : c = new TeslaCar(); break; // ������(��ĳ����)
		case 2 : c = new RollsRoyce(); break;
		case 3 : c = new Spark(); break;
		}
		
		return c;
		
	}
	
	// �Ű����� ������ ����
	public void printEngine( Car c ) {
		System.out.println(c.getEngine());
	}
	
	// �Ű����� ������ ������
//	public void printEngine( TeslaCar t) {
//		System.out.println(t.getEngine());
//	}
//	
//	public void printEngine( RollsRoyce r ) { // �����ε� ����
//		System.out.println(r.getEngine());
//	}
//	
//	public void printEngine( Spark s ) { // �����ε� ����
//		System.out.println(s.getEngine());
//	}
	
	
	
	public void example3() {
		
		// �ٿ� ĳ����
		
		Car c = new Spark();
		// c.getDiscountOffer();	-> �θ� Ÿ���� ���������δ� �θ� �κи� ���� ����
		
		((Spark)c).getDiscountOffer();
		// -> �θ� Ÿ�� ���������� �ڽ� Ÿ������ ����ȯ�Ͽ�
		//	  �ڽ� �κ��� ���� �����ϰ� ��. == �ٿ� ĳ����
		
		// ** instanceof ������
		
		// ex)	c	instanceof	Car
		//	  ��������			Ÿ��
		// -> �������� c�� �����ϰ� �ִ� ��ü�� Car Ÿ���ΰ�? ������ true �ƴϸ� false
		// == c�� �����ϰ� �ִ� ��ü�� Car ��ü�� ���ԵǾ� �ִ°�?
		// == c�� �����ϰ� �ִ� Spark ��ü�� Car ��ü�� ��� �����ΰ�?
		
		System.out.println(c instanceof Car);
		System.out.println(c instanceof Spark);
		
		
		Car[] carArr = { 
							new Car(8, "ū ���� �ڵ�", "v8 ���� ����"),
							new TeslaCar(4, "��� ���� �ڵ�", "���� ����", 50000),
							new RollsRoyce(6, "�ݺ��� �ڵ�", "���� ����", "����"),
							new Spark(4, "���׸� ���� �ڵ�", "���ָ� ����", 0.5)
						};
		// for���� �̿��Ͽ� �ϳ��� ����
		// 1) TeslaCar �ڷ����̸� -> ���͸� �뷮 ���
		// 2) RollsRoyce �ڷ����̸� -> ��� ���� ���
		// 3) Spark �ڷ����̸� -> ���� ���� ������ ���
		// 4) Car �ڷ����̸� -> toString()�� ���
		for(int i=0; i<carArr.length; i++) {
			// ���� �迭 ��Ұ� �����ϴ� ��ü�� Ÿ���� Ȯ��
			// -> �����Ǵ� ��� ��ü�� Car ��ü�� ��ӹް� �ֱ� ������
			//	  Car�� �˻��ϴ� ���ǹ��� �������� �ۼ�
			if (carArr[i] instanceof TeslaCar) {
				System.out.println(((TeslaCar)carArr[i]).getBatteryCapacity());
				
			} else if(carArr[i] instanceof RollsRoyce) {
				System.out.println(((RollsRoyce)carArr[i]).getUmbrellaColor());
				
			} else if(carArr[i] instanceof Spark) {
				System.out.println(((Spark)carArr[i]).getDiscountOffer());
				
			} else { // Car �ڷ����� ���
				System.out.println(carArr[i].toString());
				
			}
		}
		
	}
	
	// ��ĳ������ �̿��Ͽ� ���� �ڽ� ��ü��
	// �ϳ��� ��ü �迭�� �ٷ�ٰ�
	
	// �� �迭 ����� �ڷ����� ����
	// �ڷ����� �´� ������ ����� �����ϱ� ����
	
	// instanceof�� �ڷ����� �˻��ϰ�
	// �ٿ� ĳ�������� ����ȯ�Ͽ� ���� ��� ����
	
	
	
	public void example4() {
		// ���ε� : ���� ������ �޼ҵ� �ڵ�� �޼ҵ� ȣ��θ� �����ϴ� ��
		
		// ex) ex1(); // �޼ҵ� ȣ��
		//	-> public void ex1() { ... } // �޼ҵ� ����
		
		// 1. ���� ���ε�
		// - ���α׷� ���� �� ������ �ܰ迡��
		//	 �޼ҵ� �ڵ�� �޼ҵ� ȣ��θ� ����
		
		
		Car c = new Spark(4, "���� �ڵ�", "���ָ� ����", 0.5);
		// toString() : String - Car
		
		System.out.println(c.toString());
		// ���α׷� ���� �� c.toString()��
		// Car Ŭ������ �ִ� toString() �޼ҵ�� ����Ǿ� �ִ�.
		// == ���� ���ε�
		// ���� �� ��� ��� : 4 / ���� �ڵ� / ���ָ� ����
		
		// ���� ��� ���	: 4/ ���� �ڵ� / ���ָ� ���� / 0.5
		// -> Spark�� �������̵��� toString() ��ȯ��
		
		// -> ���α׷� ���� ��
		//	  ���� ���ε��� �޼ҵ尡 �ƴ�
		//	  ������ ����� ��ü Ÿ���� �������̵��� �޼ҵ�� ���ε�
		//	  == ���� ���ε�
		
	}
	
}
