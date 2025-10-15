package utilities;
import shapes.Shape;
import java.util.*;

/**
 * Utilities.java
 *
 * @author temi
 * @version 4.36
 * 
 * Class Definition: This class implements two different Quicksort methods one using compareTo() and one using compare()
 * The implementation starts with two different partition methods, a swap method is added for the positioning of the integers 
 * then lastly two quick sort function implementations are at the end one using the compareTo and one using the compare. 
 * All methods are required in order to do a quicksort functionality.
 */

public class QuickSort
{
	//Partition Method for compareTo()
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
	
	//Partition Method using compare()
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
	
	//Swap function
	public static void swap(Shape[] array, int i, int j)
	{
		Shape temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	
	
	//Quicksort function implementation compareTo()
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
	
	//Quicksort function implementation compare()
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
