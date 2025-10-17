package manager;

import java.io.*;
import java.util.*;
import shapes.*;
import utilities.*;

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
				System.out.println("Filename after stripping quotes: " + filename);
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
		
		//Measure sort time (benchmarking)
		long startTime = System.currentTimeMillis();
		String sortName = "";
		
		//Choose and perform the sort type
		switch (sortingType.toLowerCase())
		{
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
		case "s":
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
			throw new IllegalArgumentException("Invalid sorting type");
		}
		
		long endTime = System.currentTimeMillis();
		long totalDuration = (endTime - startTime); //Average run time
		
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
			System.out.println("First element is:\t " + shapes[0] + "\t\t" + measurementType + value);
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
		    System.out.println((i + 1) + "-th element:\t " + shapes[i] + "\t\t" + measurementType + value);
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
		
		System.out.println("Last element is:\t " + shapes[shapes.length - 1] + "\t\t" + measurementType + lastValue);
		
		
		//Print the type of sort and runtime in milliseconds 
		System.out.println("\n" + sortName + " run time was: " + totalDuration + " milliseconds");
		
		}
}

