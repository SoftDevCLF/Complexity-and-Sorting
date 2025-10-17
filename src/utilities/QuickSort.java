package utilities;
import shapes.Shape;
import java.util.*;

/**
 * The {@code QuickSort} class implements the Quick Sort algorithm for sorting
 * arrays of {@link Shape} objects.
 * 
 * <p>Quick Sort partitions the array around a pivot element and recursively sorts
 * the subarrays on each side. Supports sorting by height (using {@code compareTo})
 * or by a custom {@link Comparator} for area or volume.
 * 
 * <p>Time Complexity: O(n log n) average, O(n²) worst case
 * <br>Space Complexity: O(log n)
 * 
 * @version 1.0
 */

public class QuickSort
{
	/**
     * Partitions the array by height using {@link Shape#compareTo(Shape)}.
     *
     * @param array the array of shapes
     * @param low starting index
     * @param high ending index
     * @return the pivot index
     */
	public static int partitionCompareTo(Shape[] array, int low, int high)
	{
		//Choose the pivot
		Shape pivot = array[high];
		int index = low - 1;
		
		for (int j = low; j <= high - 1; j++)
		{
			//Larger methods moved to the left, in order for Shape array to descend
			if (array[j].compareTo(pivot) > 0) 
			{
				index++;
				swap(array, index, j);
			}
		}
		//Return pivot to original position
		swap(array, index + 1, high);
		return index + 1;
	}
	
	/**
     * Partitions the array using a custom {@link Comparator}.
     *
     * @param array the array of shapes
     * @param comparator the comparator for sorting
     * @param low starting index
     * @param high ending index
     * @return the pivot index
     */
	public static int partitionCompare(Shape[] array, Comparator<Shape> comparator, int low, int high)
	{
		//Choose the pivot
		Shape pivot = array[high];
		int index = low - 1;
		
		for (int j = low; j <= high - 1; j++)
		{
			//Larger methods moved to the left, in order for Shape array to descend
			if (comparator.compare(array[j], pivot) > 0)
			{
				index++;
				swap(array, index, j);
			}
		}
		//Return pivot to original position
		swap(array, index + 1, high);
		return index + 1;
	}
	
	/**
     * Swaps two elements in the array.
     *
     * @param array the array of shapes
     * @param i first index
     * @param j second index
     */
	public static void swap(Shape[] array, int i, int j)
	{
		Shape temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	/**
     * Sorts the array by height in descending order.
     *
     * @param array the array of shapes
     * @param low starting index
     * @param high ending index
     */
	public static void quickSortCompareTo(Shape[] array, int low, int high)
	{
		if (low < high)
		{
			//pi partition return index of pivot
			int pi = partitionCompareTo(array, low, high);
			
			//recursion
			quickSortCompareTo(array, low, pi - 1);
			quickSortCompareTo(array, pi + 1, high);
		}
	}
	
	/**
     * Sorts the array using a custom {@link Comparator}.
     *
     * @param array the array of shapes
     * @param comparator the comparator for sorting
     * @param low starting index
     * @param high ending index
     */
	public static void quickSortCompare(Shape[] array, Comparator<Shape> comparator, int low, int high)
	{
		if (low < high)
		{
			//pi partition return index of pivot
			int pi = partitionCompare(array, comparator, low, high);
			
			//recursion
			quickSortCompare(array, comparator, low, pi - 1);
			quickSortCompare(array, comparator, pi + 1, high);
		}
	}
}
