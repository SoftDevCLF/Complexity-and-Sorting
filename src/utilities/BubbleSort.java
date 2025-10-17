package utilities;

import shapes.Shape;
import java.util.*;

/**
 * The {@code BubbleSort} class implements the Bubble Sort algorithm for sorting
 * arrays of {@link Shape} objects.
 * 
 * <p>Bubble Sort repeatedly compares adjacent elements and swaps them if they
 * are out of order, causing larger elements to "bubble" toward the end of the array.
 * Supports sorting by height (using {@code compareTo}) or a custom {@link Comparator}
 * for area or volume.
 * 
 * <p>Time Complexity: O(n²)
 * <br>Space Complexity: O(1)
 * 
 * @version 1.0
 */


public class BubbleSort
{
	/**
     * Sorts the array of {@link Shape} objects in descending order based on their height.
     *
     * <p>This version of Bubble Sort uses the {@link Shape#compareTo(Shape)} method
     * to compare shapes by height.
     *
     * @param array the array of {@code Shape} objects to be sorted
     */
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

	/**
     * Sorts the array of {@link Shape} objects in descending order using a custom {@link Comparator}.
     *
     * <p>This method allows sorting based on other attributes, such as base area or volume.
     *
     * @param array the array of {@code Shape} objects to be sorted
     * @param comparator the {@link Comparator} used to define the sort order
     */
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