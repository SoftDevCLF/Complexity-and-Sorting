package shapes;


public abstract class Shape implements Comparable<Shape>
{
	private double height;

	/**
	 * @param heigth
	 */
	public Shape(double height) {
		super();
		this.height = height;
	}
	

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	public abstract double calcVolume();
	public abstract double calcBaseArea();
	
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

}
