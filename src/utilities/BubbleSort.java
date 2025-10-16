package utilities;

import shapes.Shape;
import java.util.*;

public class BubbleSort
{
	// uses compareTo in height
	public static void bubbleSortCompareTo(Shape[] array)
    {
        for (int i = 0; i < array.length - 1; i++)
        {
            for (int j = 0; j < array.length - i - 1; j++)
            {
                if (array[j].compareTo(array[j + 1]) < 0)
                {
                    Shape temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // uses compareTo in area and volume
	public static void bubbleSortCompare(Shape[] array, Comparator<Shape> comparator)
    {
        for (int i = 0; i < array.length - 1; i++)
        {
            for (int j = 0; j < array.length - i - 1; j++)
            {
                if (comparator.compare(array[j], array[j + 1]) < 0)
                {
                    Shape temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
		}
	}
}