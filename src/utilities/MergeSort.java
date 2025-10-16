package utilities;
import shapes.Shape;
import java.util.*;

/**
 * Utilities.java
 *
 * @author temi
 * @version 4.36
 * 
 * Class Definition: This class implements two different Merge methods one using compareTo() and one using compare()
 * The implementation works by recursively diving the input array into two halves, then sorts the two halves,  
 * and then merges them back together to obtain the sorted array. It divide, conquers, and merges.
 * All methods are required in order to the merge functionality.
 */

public class MergeSort
{
	//Merge two sub arrays of Shapes[] with compareTo() array
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
	
	//Using compareTo() to compare both shapes by height
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
	
	//Merge two sub arrays of Shapes[] with compare() array
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
		
		//using compare() to compare both shapes by volume or area
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
