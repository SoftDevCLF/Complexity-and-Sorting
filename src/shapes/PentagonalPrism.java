package shapes;

public class PentagonalPrism extends Prism
{

	/**
	 * @param height
	 * @param side
	 */
	public PentagonalPrism(double height, double side) {
		super(height, side);
	}

	@Override
	public double calcBaseArea() {
		return (5 * Math.pow(getSide(), 2) * Math.tan(Math.toRadians(54)))/4;
	}
}
