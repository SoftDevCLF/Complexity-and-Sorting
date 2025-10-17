package shapes;

import java.util.Comparator;
/**
 * The {@code AreaCompare} class implements {@link Comparator} to compare
 * {@link Shape} objects by their base area.
 * 
 * <p>This comparator returns:
 * <ul>
 *   <li>A positive value if the first shape has a larger base area.</li>
 *   <li>A negative value if the first shape has a smaller base area.</li>
 *   <li>Zero if both shapes have the same base area.</li>
 * </ul>
 * 
 * @version 1.0
 */
public class AreaCompare implements Comparator<Shape> {

	@Override
	public int compare(Shape shape1, Shape shape2) {
		if (shape1.calcBaseArea() > shape2.calcBaseArea()) {
			return 1;
		}else if (shape1.calcBaseArea() < shape2.calcBaseArea()) {
			return -1;
		}else {
			return 0;
		}
		
	}
}
