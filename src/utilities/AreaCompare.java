package utilities;

import java.util.Comparator;

import shapes.Shape;

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
