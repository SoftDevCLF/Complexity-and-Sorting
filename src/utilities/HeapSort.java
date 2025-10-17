package utilities;

import shapes.Shape;
import java.util.*;

/**
 * The {@code HeapSort} class implements the Heap Sort algorithm for sorting
 * arrays of {@link Shape} objects.
 * 
 * <p>Builds a heap from the input and repeatedly extracts the largest element
 * to sort in descending order. Supports sorting by height (using {@code compareTo})
 * or by a custom {@link Comparator} (area or volume).
 * 
 * <p>Time Complexity: O(n log n)
 * <br>Space Complexity: O(1)
 * 
 * @version 1.0
 */


public class HeapSort
{
	/**
     * Sorts an array of {@link Shape} objects in descending order by height
     * using a min-heap built from their natural ordering ({@link Shape#compareTo(Shape)}).
     *
     * @param array the array of {@code Shape} objects to be sorted
     */ 
	public static void heapSortCompareTo(Shape[] array) 
	{
		int n = array.length;
		
		// Build the initial min-heap
		buildMinHeapComparable(array, n);
		
		// Move smallest to the end one by one
		for (int end = n - 1; end > 0; end--)
		{
			swap(array, 0, end);
			siftDownComparable(array, 0, end);
		}
	}
	
	/**
     * Builds a min-heap based on height comparison using {@link Shape#compareTo(Shape)}.
     *
     * @param array the array of {@code Shape} objects
     * @param n the number of elements in the heap
     */
	private static void buildMinHeapComparable(Shape[] array, int n) 
	{
		for (int i = n / 2 - 1; i >= 0; i--)
		{
			siftDownComparable(array, i, n);
		}
	}
	
	/**
     * Maintains the min-heap property for {@link Shape} objects compared by height.
     *
     * @param array the array representing the heap
     * @param i the index of the current node
     * @param n the size of the heap
     */ 
	private static void siftDownComparable(Shape[] array, int i, int n) 
	{
        while (true) 
        {
            int left = 2 * i + 1, right = left + 1, smallest = i;
            
            // Compare children with the current smallest
            if (left  < n && array[left].compareTo(array[smallest])  < 0) smallest = left;
            if (right < n && array[right].compareTo(array[smallest]) < 0) smallest = right;
            
            // Stops if the heap property is already correct
            if (smallest == i) break;
            
            swap(array, i, smallest);
            i = smallest;
        }
    }
	
	/**
     * Sorts an array of {@link Shape} objects in descending order using a custom {@link Comparator}.
     *
     * <p>Allows sorting by other attributes such as base area or volume.
     *
     * @param array the array of {@code Shape} objects to be sorted
     * @param cmp the {@link Comparator} defining the sort order
     */
	public static void heapSortCompare(Shape[] array, Comparator<Shape> cmp) 
	{
		int n = array.length;
		
		// Build the initial min-heap using Comparator
		buildMinHeapComparator(array, n, cmp);
		
		// Move the smallest element to the end one by one
		for (int end = n - 1; end > 0; end--) 
		{
			swap(array, 0, end);
			siftDownComparator(array, 0, end, cmp);
		}
	}

	/**
     * Builds a min-heap using a custom {@link Comparator}.
     *
     * @param array the array of {@code Shape} objects
     * @param n the number of elements in the heap
     * @param cmp the {@link Comparator} used for ordering
     */
	private static void buildMinHeapComparator(Shape[] array, int n, Comparator<Shape> cmp) 
	{
		for (int i = n / 2 - 1; i >= 0; i--)
		{
			siftDownComparator(array, i, n, cmp);
		}
	}
	
	/**
     * Maintains the min-heap property using a custom {@link Comparator}.
     *
     * @param a the array representing the heap
     * @param i the index of the current node
     * @param n the size of the heap
     * @param cmp the {@link Comparator} used for comparison
     */
	private static void siftDownComparator(Shape[] a, int i, int n, Comparator<Shape> cmp) 
	{
        while (true) 
        {
            int left = 2 * i + 1, right = left + 1, smallest = i;
            
            // Compare children with the current smallest using Comparator
            if (left  < n && cmp.compare(a[left],  a[smallest]) < 0) smallest = left;
            if (right < n && cmp.compare(a[right], a[smallest]) < 0) smallest = right;
            
            if (smallest == i) break;
            
            swap(a, i, smallest);
            i = smallest;
        }
    }
	
	/**
     * Swaps two {@link Shape} elements in the array.
     *
     * @param a the array of shapes
     * @param i the index of the first element
     * @param j the index of the second element
     */
	private static void swap(Shape[] a, int i, int j) 
	{
        Shape t = a[i]; a[i] = a[j]; a[j] = t;
    }
}

