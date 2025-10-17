package shapes;

/**
 * The {@code TriangularPrism} class represents a prism with
 * an equilateral triangle as its base.
 *
 * <p>Formula used:
 * <ul>
 *   <li>Base Area: {@code A = (√3 / 4) * side²}</li>
 *   <li>Volume: {@code V = baseArea * height}</li>
 * </ul>
 *
 * @see shapes.Prism
 * @see shapes.Shape
 * 
 * @version 1.0
 */
public class TriangularPrism extends Prism
{

	/**Constructs a TriangularPrism object with specified attributes
	 * @param height the height
	 * @param side the Side
	 */
	public TriangularPrism(double height, double side) {
		super(height, side);
	}

	/**
	 * Calculates the base area of the triangular prism.
	 *
	 * <p>Formula:
	 * <br>{@code A = (√3 / 4) * side²}
	 *
	 * @return the base area of the triangular prism
	 */
	@Override
	public double calcBaseArea() {
		return (Math.pow(getSide(), 2) * Math.sqrt(3))/4;
	}

}
