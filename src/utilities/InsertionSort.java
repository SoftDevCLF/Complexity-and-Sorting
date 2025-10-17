package utilities;

import shapes.Shape;
import java.util.*;

public class InsertionSort
{
	// uses compareTo in height
    public static void insertionSortCompareTo(Shape[] array) 
    {
        for (int i = 1; i < array.length; i++) 
        {
            Shape key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j].compareTo(key) < 0) 
            {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    // uses compareTo in area and volume
    public static void insertionSortCompare(Shape[] array, Comparator<Shape> comparator) 
    {
        for (int i = 1; i < array.length; i++) 
        {
            Shape key = array[i];
            int j = i - 1;

            while (j >= 0 && comparator.compare(array[j], key) < 0) 
            {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}