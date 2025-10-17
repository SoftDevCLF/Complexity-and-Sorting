package utilities;
import shapes.Shape;
import java.util.*;

/**
 * The {@code MergeSort} class implements the Merge Sort algorithm for sorting
 * arrays of {@link Shape} objects.
 * 
 * <p>Merge Sort is a divide-and-conquer algorithm that recursively divides
 * the array into two halves, sorts each half, and then merges the sorted halves
 * back together to produce the final sorted array.
 * 
 * <p>Supports sorting by height (using {@code compareTo}) or a custom
 * {@link Comparator} for area or volume.
 * 
 * <p>Time Complexity: O(n log n)
 * <br>Space Complexity: O(n)
 * 
 * @version 1.0
 */
public class MergeSort
{
	/**
     * Merges two subarrays of {@link Shape} objects using {@link Shape#compareTo(Shape)}.
     *
     * <p>This method merges two sorted halves of the array into a single sorted
     * section in descending order by height.
     *
     * @param array the array of {@code Shape} objects to be merged
     * @param left the starting index of the first subarray
     * @param mid the ending index of the first subarray
     * @param right the ending index of the second subarray
     */

	public static void mergeCompareTo(Shape[] array, int left, int mid, int right) 
	{
		//Finding sizes of two sub arrays to be merged
		int n1 = mid - left + 1;
		int n2 = right - mid;
		
		//Creating two temporary arrays
		Shape Left[] = new Shape[n1];
		Shape Right[] = new Shape[n2];
		
		//Copy data into to temporary arrays
		for (int i = 0; i < n1; ++i)
		{
			Left[i] = array[left + i];
		}
		for (int j = 0; j < n2; ++j)
		{
			Right[j] = array[mid + 1 + j];
		}
		
		//Merge the temporary arrays
		int i = 0, j = 0, k = left;
		
		//Initial index of merged sub array
		while (i < n1 && j < n2) 
		{
			//flipped comparison signs for descending
			if(Left[i].compareTo(Right[j]) >= 0)
			{
				array[k] = Left[i];
				i++;
			}
			else {
				array[k] = Right[j];
				j++;
			}
			k++;
		}
		//Copy remaining elements of L[] then of [R]
		while (i < n1) {
			array[k] = Left[i];
			i++;
			k++;
		}
		while (j < n2) {
			array[k] = Right[j];
			j++;
			k++;
		}
	}
	
	/**
     * Recursively sorts the array of {@link Shape} objects in descending order by height
     * using the {@link Shape#compareTo(Shape)} method.
     *
     * @param array the array of {@code Shape} objects to be sorted
     * @param left the starting index of the array section to sort
     * @param right the ending index of the array section to sort
     */
	public static void mergeSortCompareTo(Shape[] array, int left, int right)
	{
		if (left < right)
		{
			int mid = ((left + right) / 2);
			mergeSortCompareTo(array, left, mid);
			mergeSortCompareTo(array, mid + 1, right);
			mergeCompareTo(array, left, mid, right);
		}
	}
	
	/**
     * Merges two subarrays of {@link Shape} objects using a custom {@link Comparator}.
     *
     * <p>This method merges two sorted halves of the array into a single sorted
     * section in descending order based on area or volume.
     *
     * @param array the array of {@code Shape} objects to be merged
     * @param left the starting index of the first subarray
     * @param mid the ending index of the first subarray
     * @param right the ending index of the second subarray
     * @param comparator the {@link Comparator} used to define the sort order
     */
	public static void mergeCompare(Shape[] array, int left, int mid, int right, Comparator<Shape> comparator) 
	{
		//Finding sizes of two sub arrays to be merged
		int n1 = mid - left + 1;
		int n2 = right - mid;
			
		//Creating two temporary arrays
		Shape Left[] = new Shape[n1];
		Shape Right[] = new Shape[n2];
			
		//Copy data into to temporary arrays
		for (int i = 0; i < n1; ++i)
		{
			Left[i] = array[left + i];
		}
		for (int j = 0; j < n2; ++j)
		{
			Right[j] = array[mid + 1 + j];
		}
			
		//Merge the temporary arrays
		int i = 0, j = 0, k = left;
			
		//Initial index of merged sub array 
		while (i < n1 && j < n2) 
		{
			if(comparator.compare(Left[i], Right[j]) >= 0)
			{
				array[k] = Left[i];
				i++;
			}
			else 
			{
				array[k] = Right[j];
				j++;
			}
			k++;
		}
		//Copy remaining elements of L[] then of [R]
		while (i < n1) 
		{
			array[k] = Left[i];
			i++;
			k++;
		}
		while (j < n2) 
		{
			array[k] = Right[j];
			j++;
			k++;
		}
		}
		
	/**
     * Recursively sorts the array of {@link Shape} objects in descending order
     * using a custom {@link Comparator}.
     *
     * <p>This version allows sorting based on different shape attributes, such as
     * base area or volume.
     *
     * @param array the array of {@code Shape} objects to be sorted
     * @param left the starting index of the array section to sort
     * @param right the ending index of the array section to sort
     * @param comparator the {@link Comparator} used to define the sort order
     */
		public static void mergeSortCompare(Shape[] array, int left, int right, Comparator<Shape> comparator)
		{
			if (left < right)
			{
				int mid = (left + right) / 2;
				mergeSortCompare(array, left, mid, comparator);
				mergeSortCompare(array, mid + 1, right, comparator);
				mergeCompare(array, left, mid, right, comparator);	
			}
		}	
	}