package shapes;

import java.util.Comparator;

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
