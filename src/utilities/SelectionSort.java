package utilities;

import shapes.Shape;
import java.util.*;

public class SelectionSort
{
	
	// Compare using height
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
}
