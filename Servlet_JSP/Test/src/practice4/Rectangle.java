package practice4;

public class Rectangle extends Shape implements Resizable{
	
	public boolean isSquare() {
		return true;
	}
	
	protected double getArea() {
		return 0;
	}
	
	public void resize() {}

}
