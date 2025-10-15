package shapes;

public class Cylinder extends Shape
{
	private double radius;

	/**
	 * @param height
	 * @param radius
	 */
	public Cylinder(double height, double radius) {
		super(height);
		this.radius = radius;
	}
	


	/**
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}


	/**
	 * @param radius the radius to set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}



	@Override
	public double calcVolume() {
		return calcBaseArea() * getHeight();
	}

	@Override
	public double calcBaseArea() {
		return Math.PI * Math.pow(getRadius(), 2);
	}

}
