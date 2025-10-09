package shapes;

public class Pyramid extends Shape
{
	private double side;

	/**
	 * @param height
	 * @param side
	 */
	public Pyramid(double height, double side) {
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

	@Override
	public double calcVolume() {
		return (1/3) * calcBaseArea() *getHeight();
	}

	@Override
	public double calcBaseArea() {
		return Math.pow(getSide(), 2); 
	}
	

}
