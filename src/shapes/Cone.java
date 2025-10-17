package shapes;
/**
 * The {@code Cone} class represents a 3D cylinder shape.
 * 
 * <p>Extends the {@link Shape} class and provides methods
 * for calculating base area and volume.
 * 
 * <p>Formulas used:
 * <ul>
 *   <li>Base Area = π * radius²</li>
 *   <li>Volume = 1/3 * Base Area * height</li>/
 * </ul>
 * @version 1.0
 */
public class Cone extends Shape
{
	//Attributes
	private double radius;

	/**Constructs a Cone object with specified attributes
	 * @param height the Height
	 * @param radius the Radius
	 */
	public Cone(double height, double radius) {
		super(height);
		this.radius = radius;
	}

	/**Return the radius of the Cone
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}

	/**Sets the radius of the Cone to the specified value.
	 * @param radius the radius to set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	/**
	 * Calculates the volume of the cone.
	 *
	 * <p>The formula for the volume of a cone is:
	 * <br>{@code V = (1/3) * baseArea * height}
	 * <br>where {@code baseArea = π * r²}.
	 *
	 * @return the volume of the cone
	 */
	@Override
	public double calcVolume() {
		return (1.0/3.0) * calcBaseArea() * getHeight();
	}

	/**
	 * Calculates the base area of the cone.
	 *
	 * <p>The formula for the base area of a cone is:
	 * <br>{@code A = π * r²}
	 * 
	 * @return the base area of the cone
	 */
	@Override
	public double calcBaseArea() {
		return Math.PI * Math.pow(getRadius(), 2);
	}

}
