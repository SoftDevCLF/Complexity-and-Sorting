package shapes;

import java.util.Comparator;

/**
 * The {@code VolumeCompare} class implements {@link Comparator} to compare
 * {@link Shape} objects by their volume.
 * 
 * <p>This comparator returns:
 * <ul>
 *   <li>A positive value if the first shape has a larger volume.</li>
 *   <li>A negative value if the first shape has a smaller volume.</li>
 *   <li>Zero if both shapes have the same volume.</li>
 * </ul>
 * 
 * Used to sort shapes by their calculated volume.

 * @version 1.0
 */
public class VolumeCompare implements Comparator<Shape> {
	
	@Override
	public int compare(Shape shape1, Shape shape2) {
		if (shape1.calcVolume() > shape2.calcVolume()) {
			return 1;
		}else if (shape1.calcVolume() < shape2.calcVolume()) {
			return -1;
		}else {
			return 0;
		}
		
	}

}
