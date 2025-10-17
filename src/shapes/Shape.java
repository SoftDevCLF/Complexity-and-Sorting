package shapes;
/**
 * The {@code Shape} abstract class defines the common structure and behavior
 * for all 3D geometric shapes. Each shape has a height, and
 * subclasses implement methods to calculate base area and volume.
 * 
 * <p>Implements {@link Comparable} to sort by height by default.
 * 
 * <p>Subclasses include specific geometric solids such as:
 * <ul>
 *   <li>{@link shapes.Cone}</li>
 *   <li>{@link shapes.Cylinder}</li>
 *   <li>{@link shapes.Pyramid}</li>
 *   <li>{@link shapes.Prism}</li>
 * </ul>
 * 
 * @see shapes.Prism
 * @see shapes.Cone
 * @see shapes.Cylinder
 * @see shapes.Pyramid
 * 
 * @version 1.0
 */
public abstract class Shape implements Comparable<Shape>
{
	private double height;

	/**Constructs a Shape object with specified attributes
	 * @param heigth as the height of the shape
	 */
	public Shape(double height) {
		super();
		this.height = height;
	}
	

	/**Return the height of the Shape
	 * @return the height the height
	 */
	public double getHeight() {
		return height;
	}

	/**Sets the height of the Shape to the specified value.
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * Calculates the volume of the shape.
	 *
	 * <p>This method must be implemented by all subclasses,
	 * as each shape has a different formula for volume calculation.
	 *
	 * @return the volume of the shape
	 */
	public abstract double calcVolume();
	
	/**
	 * Calculates the base area of the shape.
	 *
	 * <p>This method must be implemented by all subclasses,
	 * since each shape has its own unique base area formula.
	 *
	 * @return the base area of the shape
	 */
	public abstract double calcBaseArea();
	
	/**
	 * Compares this shape with another {@link Shape} by height.
	 *
	 * <p>This method defines the natural ordering of shapes.
	 * It returns:
	 * <ul>
	 *   <li>A positive value if this shape is taller than the other.</li>
	 *   <li>A negative value if this shape is shorter than the other.</li>
	 *   <li>Zero if both shapes have the same height.</li>
	 * </ul>
	 *
	 * @param s the {@code Shape} object to compare against
	 * @return a positive, negative, or zero integer 
	 */
	@Override
	public int compareTo( Shape s )
	{
		if( this.getHeight() > s.height )
		{
			return 1;
		}
		else if( this.getHeight() < s.height )
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
	
	/**
	 * Returns the string representation of this shape.
	 *
	 * <p>By default, this method returns the class name
	 * (e.g., {@code shapes.Cylinder}, {@code shapes.Pyramid}).
	 *
	 * @return the class name of this shape as a string
	 */
	@Override
    public String toString() 
    {
        return this.getClass().getName(); 
    }

}
