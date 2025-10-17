package shapes;

/**
 * The {@code SquarePrism} class represents a prism with
 * a square base.
 *
 * <p>Formula used:
 * <ul>
 *   <li>Base Area: {@code A = side²}</li>
 *   <li>Volume: {@code V = baseArea * height}</li>
 * </ul>
 *
 * @see shapes.Prism
 * @see shapes.Shape
 * 
 * @version 1.0
 */
public class SquarePrism extends Prism
{

	/**Constructs a SquarePrism object with specified attributes
	 * @param height the height
	 * @param side the side
	 */
	public SquarePrism(double height, double side) {
		super(height, side);
	}

	/**
	 * Calculates the base area of the square prism.
	 *
	 * <p>Formula:
	 * <br>{@code A = side²}
	 *
	 * @return the base area of the square prism
	 */
	@Override
	public double calcBaseArea() {
		return Math.pow(getSide(), 2);
	}


}
