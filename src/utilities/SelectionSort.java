package utilities;

import shapes.Shape;
import java.util.*;

public class SelectionSort
{
	
	// Sorts the array in descending order by height
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
	
	// Sorts the array in descending order using area or volume 
	public static void selectionSortCompare(Shape[] array, Comparator<Shape> comparator) 
	{
		int n = array.length;
		
		for (int i = 0; i < n - 1; i++) 
		{
			int maxIndex = 1;
			
			for (int j = i + 1; j < n; j++) 
			{
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
