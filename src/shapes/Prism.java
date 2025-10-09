package shapes;

public abstract class Prism extends Shape {

	private double side;
	

	/**
	 * @param height
	 * @param side
	 */
	public Prism(double height, double side) {
		super(height);
		this.side = side;
	}
	
	/**
	 * @return the side
	 */
	public double getSide() {
		return side;
	}
	/**
	 * @param side the side to set
	 */
	public void setSide(double side) {
		this.side = side;
	}
	
	public double calcVolume() {
	    return calcBaseArea() * getHeight();
	}
	
}
