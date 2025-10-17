package utilities;

import shapes.Shape;
import java.util.*;

/**
 * The {@code InsertionSort} class implements the Insertion Sort algorithm for sorting
 * arrays of {@link Shape} objects.
 * 
 * <p>Insertion Sort builds the sorted portion of the array one element at a time by
 * inserting each new element into its correct position. Supports sorting by height
 * (using {@code compareTo}) or a custom {@link Comparator} for area or volume.
 * 
 * <p>Time Complexity: O(n²)
 * <br>Space Complexity: O(1)
 * 
 * @version 1.0
 */



public class InsertionSort
{
	/**
     * Sorts the array of {@link Shape} objects in descending order based on their height.
     *
     * <p>This version of Insertion Sort uses the {@link Shape#compareTo(Shape)} method
     * to compare shapes by height.
     *
     * @param array the array of {@code Shape} objects to be sorted
     */
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

    /**
     * Sorts the array of {@link Shape} objects in descending order using a custom {@link Comparator}.
     *
     * <p>This method allows sorting based on other attributes, such as base area or volume.
     *
     * @param array the array of {@code Shape} objects to be sorted
     * @param comparator the {@link Comparator} used to define the sort order
     */
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