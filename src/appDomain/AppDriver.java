package appDomain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import shapes.Cone;
import shapes.Cylinder;
import shapes.OctagonalPrism;
import shapes.PentagonalPrism;
import shapes.Pyramid;
import shapes.Shape;
import shapes.SquarePrism;
import shapes.TriangularPrism;

/**
 * <p>
 * This application driver code is designed to be used as a basis for the
 * Complexity and Sorting assignment that will be developed in the CPRG304 F2025
 * class at SAIT. The implementors of this applications will be required to add
 * all the correct functionality.
 * </p>
 */
public class AppDriver {
	/**
	 * The main method is the entry point of the application.
	 * 
	 * @param args The input to control the execution of the application.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ****parsing command line arguments***
		// Here I'm pointing how many arguments the program accepts
		// 3 because -ffile_name -tv -sb
		if (args.length < 3) {
			System.out.println("Not enough arguments.");
			return;
		}
		
		//Start the variables		
        String filename = null;
        String comparisonType = null;
        String sortingType = null;
        
        //Start from the first argument (index 0),
        //keep going until you’ve checked all of them,
        //and move one by one through the array.
        //order insensitive
        for (int i = 0; i < args.length; i++) {
        	//case insensitive
        	if (args[i].startsWith("-f") || args[i].startsWith("-F")) {
                //the filename will be the substring of the argument
        		filename = args[i].substring(2);
            } else if (args[i].startsWith("-t") || args[i].startsWith("-T")) {
                comparisonType = args[i].substring(2);
            } else if (args[i].startsWith("-s") || args[i].startsWith("-S")) {
                sortingType = args[i].substring(2);
            }
        }

        if (filename == null || comparisonType == null ||sortingType == null  )  {
            System.out.println("Missing arguments.");
            return;
        }
        
		File file = new File(filename);
		// TODO Auto-generated method stub

		// refer to demo00 BasicFileIO.java for a simple example on how to
		// read data from a text file
		try {
			Scanner readFile = new Scanner(file);
			int numOfShapes = Integer.parseInt(readFile.nextLine().trim());
			Shape[] shapes = new Shape[numOfShapes];
			int index = 0;
			while (readFile.hasNext()) {
				String line = readFile.nextLine();
				String[] fields = line.split(" ");
				String name = fields[0];
				double height = Double.parseDouble(fields[1]);
				switch (name) {
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

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		// refer to demo01 Test.java for an example on how to parse command
		// line arguments and benchmarking tests

		// refer to demo02 Student.java for comparable implementation, and
		// NameCompare.java or GradeCompare for comparator implementations

		// refer to demo02 KittySort.java on how to use a custom sorting
		// algorithm on a list of comparables to sort using either the
		// natural order (comparable) or other orders (comparators)

	}

}
