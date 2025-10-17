package shapes;

/**
 * The {@code Prism} class is an abstract subclass of {@link Shape}
 * that represents a generic three-dimensional prism.
 *
 * <p>This class provides shared properties and behaviors common
 * to all prisms, such as:
 * <ul>
 *   <li>{@code height} — inherited from {@link Shape}</li>
 *   <li>{@code edgeLength} — length of one side of the polygonal base</li>
 *   <li>{@code calcVolume()} — implemented here as
 *       {@code baseArea * height}, since this formula applies to all prisms</li>
 * </ul>
 *
 * <p>Subclasses must implement {@link #calcBaseArea()} to define
 * the correct formula for their specific polygonal base.
 *
 * @see Shape
 * @see TriangularPrism
 * @see SquarePrism
 * @see PentagonalPrism
 * @see OctagonalPrism
 * 
 * @version 1.0
 */
public abstract class Prism extends Shape {

	//Attributes
	private double side;
	

	/**Constructs a Prism object with specified attributes
	 * @param height the Height
	 * @param side the Side A
	 */
	public Prism(double height, double side) {
		super(height);
		this.side = side;
	}
	
	/**Return the side of the Prism
	 * @return the side
	 */
	public double getSide() {
		return side;
	}
	/**Sets the side of the Prism to the specified value.
	 * @param side the side to set
	 */
	public void setSide(double side) {
		this.side = side;
	}
	
	/**
	 * Calculates the volume of the prism.
	 *
	 * <p>The volume of any prism is the product of its base area and height:
	 * <br>{@code V = baseArea * height}
	 *
	 * <p>Since this formula is the same for all prism types, this method
	 * is implemented here and reused by all concrete subclasses.
	 *
	 * @return the volume of the prism
	 */
	public double calcVolume() {
	    return calcBaseArea() * getHeight();
	}
	
}
