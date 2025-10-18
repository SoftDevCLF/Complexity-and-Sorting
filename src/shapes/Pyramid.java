package shapes;

/**
 * The {@code Pyramid} class represents a 3D pyramid shape.
 * 
 * <p>
 * Extends the {@link Shape} class and provides methods for calculating base
 * area and volume.
 * 
 * <p>
 * Formulas used:
 * <ul>
 * 	<li>Base Area = side²</li>
 * 	<li>Volume = (1/3) * Base Area * height</li>/
 * </ul>
 * 
 * @version 1.0
 */
public class Pyramid extends Shape
{
	// Attributes
	private double side;

	/**
	 * Constructs a Pyramid object with specified attributes
	 * 
	 * @param height the Height
	 * @param side   the Side
	 */
	public Pyramid(double height, double side)
	{
		super(height);
		this.side = side;
	}

	/**
	 * Return the side of the Pyramid
	 * 
	 * @return the side
	 */
	public double getSide()
	{
		return side;
	}

	/**
	 * Sets the radius of the Pyramid to the specified value.
	 * 
	 * @param side the side to set
	 */
	public void setSide(double side)
	{
		this.side = side;
	}

	/**
	 * Calculates the volume of the pyramid.
	 *
	 * <p>
	 * Formula: <br>
	 * {@code V = (1/3) * baseArea * height}
	 *
	 * @return the volume of the pyramid
	 */
	@Override
	public double calcVolume()
	{
		return (1.0 / 3.0) * calcBaseArea() * getHeight();
	}

	/**
	 * Calculates the base area of the pyramid.
	 *
	 * <p>
	 * Formula: <br>
	 * {@code A = side²}
	 *
	 * @return the base area of the pyramid
	 */
	@Override
	public double calcBaseArea()
	{
		return Math.pow(getSide(), 2);
	}

}
