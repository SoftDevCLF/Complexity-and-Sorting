package shapes;

/**
 * The {@code OctagonalPrism} class represents a prism with a regular octagonal
 * base.
 *
 * <p>
 * Formulas used:
 * <ul>
 * 	<li>Base Area: {@code A = 2 * (1 + √2) * side²}</li>
 * 	<li>Volume: {@code V = baseArea * height}</li>
 * </ul>
 *
 * @see shapes.Prism
 * @see shapes.Shape
 * 
 * @version 1.0
 */
public class OctagonalPrism extends Prism
{

	/**
	 * Constructs a TriangularPrism object with specified attributes
	 * 
	 * @param height the height
	 * @param side   the Side
	 */
	public OctagonalPrism(double height, double side)
	{
		super(height, side);
	}

	/**
	 * Calculates the base area of the octagonal prism.
	 *
	 * <p>
	 * Formula: <br>
	 * {@code A = 2 * (1 + √2) * side²}
	 *
	 * @return the base area of the octagonal prism
	 */
	@Override
	public double calcBaseArea()
	{
		return 2 * (1 + Math.sqrt(2)) * Math.pow(getSide(), 2);
	}
}
