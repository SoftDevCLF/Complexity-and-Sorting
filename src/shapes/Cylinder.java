package shapes;
/**
 * The {@code Cylinder} class represents a 3D cylinder shape.
 * 
 * <p>Extends the {@link Shape} class and provides methods
 * for calculating base area and volume.
 * 
 * <p>Formulas used:
 * <ul>
 *   <li>Base Area = π * radius²</li>
 *   <li>Volume = Base Area * height</li>/
 * </ul>
 * @version 1.0
 */
public class Cylinder extends Shape
{
	//Attributes
	private double radius;

	/**Constructs a Cylinder object with specified attributes
	 * @param height the height
	 * @param radius the radius
	 */
	public Cylinder(double height, double radius) {
		super(height);
		this.radius = radius;
	}
	
	/**Return the radius of the Cylinder
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}

	/**Sets the radius of the Cylinder to the specified value.
	 * @param radius the radius to set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	/**
	 * Calculates the volume of the Cylinder.
	 *
	 * <p>The formula for the volume of a cylinder is:
	 * <br>{@code V = baseArea * height}
	 * <br>where {@code baseArea = π * r²}.
	 *
	 * @return the volume of the cylinder
	 */
	@Override
	public double calcVolume() {
		return calcBaseArea() * getHeight();
	}

	/**
	 * Calculates the base area of the cylinder.
	 *
	 * <p>The formula for the base area of a cylinder is:
	 * <br>{@code A = π * r²}
	 * 
	 * @return the base area of the cylinder
	 */
	@Override
	public double calcBaseArea() {
		return Math.PI * Math.pow(getRadius(), 2);
	}

}
