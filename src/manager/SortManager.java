package manager;

import java.io.*;
import java.util.*;
import shapes.*;
import utilities.BubbleSort;
import utilities.QuickSort;

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
		// check there is enough arguments
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
		
		//Determine compare Type
		switch (compareType.toLowerCase())
		{
		case "h":
			comparator = null;
			break;
		case "a":
			comparator = new AreaCompare();
			break;
		case "v":
			comparator = new VolumeCompare();
			break;
		default:
			throw new IllegalArgumentException("Invalid comparison type");
		}
				
		switch (sortingType.toLowerCase())
		{
		case "b":
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
			if (comparator == null)
			{
				QuickSort.quickSortCompareTo(shapes, 0, shapes.length - 1);
			}
			else
			{
				QuickSort.quickSortCompare(shapes, comparator, 0, shapes.length - 1);
			}
			break;

		default:
			throw new IllegalArgumentException("Invalid sorting type");
		}
	}
}
