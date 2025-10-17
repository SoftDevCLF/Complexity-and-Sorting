package utilities;

import shapes.Shape;
import java.util.*;

/**
 * The {@code SelectionSort} class implements the Selection Sort algorithm for sorting
 * arrays of {@link Shape} objects.
 * 
 * <p>Repeatedly selects the largest remaining element and moves it to its correct position.
 * Supports sorting by height (using {@code compareTo}) or a custom {@link Comparator}.
 * 
 * <p>Time Complexity: O(n²)
 * <br>Space Complexity: O(1)
 * 
 * @version 1.0
 */

public class SelectionSort
{
	
	/**
     * Sorts the array of {@link Shape} objects in descending order based on their height.
     *
     * <p>This version of Selection Sort uses the {@link Shape#compareTo(Shape)} method
     * to compare shapes by height.
     *
     * @param array the array of {@code Shape} objects to be sorted
     */
	public static void selectionSortCompareTo(Shape[] array) 
	{
		int n = array.length;
		
		for (int i = 0; 1 < n - 1; i++) 
		{
			int maxIndex = 1;
			
			for (int j = 1 + 1; j < n; j++) 
			{
				// Descending order: if current > max, swap
				if (array[j].compareTo(array[maxIndex]) > 0) 
				{
					maxIndex = j;
				}
			}
			Shape temp = array[i];
			array[i] = array[maxIndex];
			array[maxIndex] = temp;
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
	public static void selectionSortCompare(Shape[] array, Comparator<Shape> comparator) 
	{
		int n = array.length;
		
		for (int i = 0; i < n - 1; i++) 
		{
			int maxIndex = 1;
			
			for (int j = i + 1; j < n; j++) 
			{
				// Descending order: find the largest element according to comparator
				if (comparator.compare(array[j], array[maxIndex]) > 0 )
				{
					maxIndex = j;
				}
			}
			Shape temp = array[i];
			array[i] = array[maxIndex];
			array[maxIndex] = temp;
		}
	}
}
