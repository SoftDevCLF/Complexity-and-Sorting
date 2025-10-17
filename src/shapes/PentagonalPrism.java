package shapes;
/**
 * The {@code PentagonalPrism} class represents a prism with
 * a regular pentagonal base.
 *
 * <p>Formulas used:
 * <ul>
 *   <li>Base Area: {@code A = (5/4) * side² * tan(54)}</li>
 *   <li>Volume: {@code V = baseArea * height}</li>
 * </ul>
 *
 * @see shapes.Prism
 * @see shapes.Shape
 * 
 * @version 1.0
 */
public class PentagonalPrism extends Prism
{

	/**Constructs a PentagonalPrism object with specified attributes
	 * @param height
	 * @param side
	 */
	public PentagonalPrism(double height, double side) {
		super(height, side);
	}


/**
 * Calculates the base area of the pentagonal prism.
 *
 * <p>Formula:
 * <br>{@code A = (5/4) * side² * tan(54)}
 *
 * @return the base area of the pentagonal prism
 */
	@Override
	public double calcBaseArea() {
		return (5 * Math.pow(getSide(), 2) * Math.tan(Math.toRadians(54)))/4;
	}
}
