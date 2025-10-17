package utilities;

import shapes.Shape;
import java.util.*;

public class HeapSort
{
	//Sorts the array in descending order by height using a min-heap (Comparable) 
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
	
	// Builds min-heap based on height comparison
	private static void buildMinHeapComparable(Shape[] array, int n) 
	{
		for (int i = n / 2 - 1; i >= 0; i--)
		{
			siftDownComparable(array, i, n);
		}
	}
	
	// Moves a node down to maintain min-heap property for comparable 
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
	
	// Sorts the array in descending order using a Comparator volume or area
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

	// Builds a min-heap using the given Comparator
	private static void buildMinHeapComparator(Shape[] array, int n, Comparator<Shape> cmp) 
	{
		for (int i = n / 2 - 1; i >= 0; i--)
		{
			siftDownComparator(array, i, n, cmp);
		}
	}
	
	// Moves a node down to maintain the min-heap property (for Comparator)
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
	
	// Swaps two shapes in the array
	private static void swap(Shape[] a, int i, int j) 
	{
        Shape t = a[i]; a[i] = a[j]; a[j] = t;
    }
}

