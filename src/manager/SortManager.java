package manager;

import java.io.*;
import java.util.*;
import shapes.*;
import utilities.*;

/**
 * The {@code SortManager} class serves as the central controller for managing
 * file input, shape creation, comparison logic, benchmarking and sorting operations.
 *
 * <h2>Command-Line Arguments</h2>
 * The class expects three arguments:
 * <ul>
 *   <li><b>-f</b><i>filename</i> → specifies the input file (e.g., <code>-fshapes2.txt</code>)</li>
 *   <li><b>-t</b><i>comparison type</i> → 'h' for height, 'a' for base area, 'v' for volume</li>
 *   <li><b>-s</b><i>sort type</i> → defines which sorting algorithm to use:
 *     <ul>
 *       <li><b>q</b> → Quick Sort</li>
 *       <li><b>m</b> → Merge Sort</li>
 *       <li><b>b</b> → Bubble Sort</li>
 *       <li><b>i</b> → Insertion Sort</li>
 *       <li><b>s</b> → Selection Sort</li>
 *       <li><b>z</b> → Heap Sort</li>
 *     </ul>
 *   </li>
 * </ul>
 * <h2>Responsibilities</h2>
 * <ul>
 *   <li>Parses command-line arguments and validates input</li>
 *   <li>Loads and constructs shape objects from a text file</li>
 *   <li>Chooses the appropriate {@link java.util.Comparator} or uses {@code compareTo()}</li>
 *   <li>Delegates sorting to the correct algorithm implementation in the {@code utilities} package</li>
 *   <li>Benchmarks sort performance and reports elapsed time</li>
 *   <li>Prints representative shape data (first, every 1000th, and last element)</li>
 * </ul>
 *
 * <h2>Example Usage</h2>
 * <pre>{@code
 * java -jar Sort.jar -fshapes1.txt -Tv -Sb 
 * }</pre>
 * This example sorts the shapes in <code>shapes1.txt</code> by volume using Bubble Sort.
 *
 * @see shapes.Shape
 * @see shapes.AreaCompare
 * @see shapes.VolumeCompare
 * @see utilities.BubbleSort
 * @see utilities.InsertionSort
 * @see utilities.MergeSort
 * @see utilities.QuickSort
 * @see utilities.SelectionSort
 * @see utilities.HeapSort
 *
 * @version 1.0
 */
public class SortManager
{
	private String filename;
	private String compareType;
	private String sortingType;
	private Comparator<Shape> comparator;
	private Shape[] shapes;

	public SortManager(String[] args)
	{
		// Parsing arguments
		// check if there is enough arguments
		if (args.length < 3)
		{
			System.out.println("Not enough arguments.");
			return;
		}

		// Loop to assign arguments to variables
		for (int i = 0; i < args.length; i++)
		{
			// case insensitive
			if (args[i].startsWith("-f") || args[i].startsWith("-F"))
			{
				// the filename will be the substring of the argument
				filename = args[i].substring(2);
				//Deleting the quotes
				if (filename.startsWith("\"") && filename.endsWith("\""))
				{
					filename  = filename.substring(1,filename.length() -1);
				}
			} else if (args[i].startsWith("-t") || args[i].startsWith("-T"))
			{
				compareType = args[i].substring(2);
			} else if (args[i].startsWith("-s") || args[i].startsWith("-S"))
			{
				sortingType = args[i].substring(2);
			}
		}

		// If there are missing arguments
		if (filename == null || compareType == null || sortingType == null)
		{
			System.out.println("Missing arguments.");
			return;
		}

		// read the shape's file
		File file = new File(filename);
		//if the file has not absolute path or relative path and is just the name
		if (!file.isAbsolute()&& !filename.contains(File.separator))
		{
			//create a relative path appending res
			file = new File ("res" + File.separator + filename);
		}
		
		try
		{
			Scanner readFile = new Scanner(file);
			int numOfShapes = Integer.parseInt(readFile.nextLine().trim());
			shapes = new Shape[numOfShapes];
			int index = 0; 
			while (readFile.hasNext())
			{
				String line = readFile.nextLine();
				String[] fields = line.split(" ");
				String name = fields[0];
				double height = Double.parseDouble(fields[1]);
				switch (name)
				{
				case "Cone":
					double radius = Double.parseDouble(fields[2]);
					shapes[index++] = new Cone(height, radius);
					break;
				case "Cylinder":
					radius = Double.parseDouble(fields[2]);
					shapes[index++] = new Cylinder(height, radius);
					break;
				case "Pyramid":
					double side = Double.parseDouble(fields[2]);
					shapes[index++] = new Pyramid(height, side);
					break;
				case "SquarePrism":
					side = Double.parseDouble(fields[2]);
					shapes[index++] = new SquarePrism(height, side);
					break;
				case "TriangularPrism":
					side = Double.parseDouble(fields[2]);
					shapes[index++] = new TriangularPrism(height, side);
					break;
				case "PentagonalPrism":
					side = Double.parseDouble(fields[2]);
					shapes[index++] = new PentagonalPrism(height, side);
					break;
				case "OctagonalPrism":
					side = Double.parseDouble(fields[2]);
					shapes[index++] = new OctagonalPrism(height, side);
					break;
				}
			}

			readFile.close();

		} catch (FileNotFoundException e)
		{

			e.printStackTrace();
		}
		
		//Determine compare Type and the measurement type (Area, Volume, or Height)
		String measurementType = "";
		switch (compareType.toLowerCase())
		{
		case "h":
			measurementType = "Height:";
			comparator = null;
			break;
		case "a":
			measurementType = "Area:";
			comparator = new AreaCompare();
			break;
		case "v":
			measurementType = "Volume:";
			comparator = new VolumeCompare();
			break;
		default:
			throw new IllegalArgumentException("Invalid comparison type");
		}
		
		//Measure sort time (benchmarking) start
		long startTime = System.currentTimeMillis();
		String sortName = "";
		
		//Choose and perform the sort type
		switch (sortingType.toLowerCase())
		{
		case "q":
			sortName = "Quick Sort";
			if (comparator == null)
			{
				QuickSort.quickSortCompareTo(shapes, 0, shapes.length - 1);
			}
			else
			{
				QuickSort.quickSortCompare(shapes, comparator, 0, shapes.length - 1);
			}
			break;
		case "m":
			sortName = "Merge Sort";
			if (comparator == null)
			{
				MergeSort.mergeSortCompareTo(shapes, 0, shapes.length - 1);
			}
			else 
			{
				MergeSort.mergeSortCompare(shapes, 0, shapes.length - 1, comparator);
			}
		case "b":
			sortName = "Bubble Sort";
	        if (comparator == null)
	        {
	            BubbleSort.bubbleSortCompareTo(shapes);
	        }
	        else
	        {
	            BubbleSort.bubbleSortCompare(shapes, comparator);
	        }
	        break;
		case "i":
			sortName = "Insertion Sort";
	        if (comparator == null)
	        {
	            InsertionSort.insertionSortCompareTo(shapes);
	        }
	        else
	        {
	            InsertionSort.insertionSortCompare(shapes, comparator);
	        }
	        break;
		case "s":
			sortName = "Selection Sort";
			if (comparator == null)
			{
				SelectionSort.selectionSortCompareTo(shapes);
			}
			else
			{
				SelectionSort.selectionSortCompare(shapes, comparator);
			}
			break;
		case "z":
			sortName = "Heap Sort";
			if (comparator == null)
			{
				HeapSort.heapSortCompareTo(shapes);
			}
			else
			{
				HeapSort.heapSortCompare(shapes, comparator);
			}
			break;

	    default:
	        throw new IllegalArgumentException("Invalid sorting type: " + sortingType);
		}
		
		long endTime = System.currentTimeMillis(); //measure ends
		long totalDuration = (endTime - startTime); //Average run time
		
		//Printing
		//Print the first element
		if (shapes.length > 0)
		{
			Shape s = shapes[0];
			double value = 0;
			switch (compareType.toLowerCase())
			{
				case "h": 
					value = s.getHeight();
					break;
				case "a":
					value = s.calcBaseArea();
					break;
				case "v":
					value = s.calcVolume();
					break;
			}
			
			// Use of printf to format the output: printf(format,args)
			// %-18s : left-justified label
			// %25s  : right-justified shape name
			// %5s   : gap between columns
			// %s    : measurement type label (s is a placeholder)
			// %.15E  : measurement value in scientific notation, 15 digits allowed with capital E
		    System.out.printf("%-18s %25s%5s%s %.15E%n",
                    "First element is:", s, "", measurementType, value);
		}		
		
		// Print every 1000th element
		for (int i = 999; i < shapes.length; i += 1000) 
		{ 
			Shape s = shapes[i];
			double value = 0;
			switch (compareType.toLowerCase())
			{
				case "h": 
					value = s.getHeight();
					break;
				case "a":
					value = s.calcBaseArea();
					break;
				case "v":
					value = s.calcVolume();
					break;
			}
		    System.out.printf("%-18s %25s%5s%s %.15E%n",
                    (i + 1) + "-th element:", s, "", measurementType, value);
		}
		
		//Print the last element
		Shape lastShape = shapes[shapes.length - 1];
		double lastValue = 0;
		switch (compareType.toLowerCase())
		{
			case "h": 
				lastValue = lastShape.getHeight();
				break;
			case "a":
				lastValue = lastShape.calcBaseArea();
				break;
			case "v":
				lastValue = lastShape.calcVolume();
				break;
		}
		
		System.out.printf("%-18s %25s%5s%s %.15E%n",
                "Last element is:", lastShape, "", measurementType, lastValue);
		
		
		//Print the type of sort and runtime in milliseconds 
		System.out.println(sortName + " run time was: " + totalDuration + " milliseconds");
		}
}

