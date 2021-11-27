package edu.kh.poly.ex1.model.vo;

public class TeslaCar extends Car{
	
	private int batteryCapacity; // ���͸� �뷮
	
	public TeslaCar() {
		super();
	}

	public TeslaCar( int wheel, String handle, String engine, int batteryCapacity) {
		
		// this.wheel // ��� ���� �θ��� private ����� ���� ���� �Ұ�
		super(wheel, handle, engine);
		this.batteryCapacity = batteryCapacity;
	}

	public int getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}
	
	@Override
	public String toString() {
		return super.toString() + " / " + batteryCapacity;
	}
	
	
}
