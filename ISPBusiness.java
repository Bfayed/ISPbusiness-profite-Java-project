package edu.iastate.cs2280.hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author <<BAVLY FAYED>>
 *
 *         The ISPBusiness class performs simulation over a grid plain with
 *         cells occupied by different TownCell types.
 *
 */
public class ISPBusiness {

	/**
	 * Returns a new Town object with updated grid value for next billing cycle.
	 * 
	 * @param tOld: old/current Town object.
	 * @return: New town object.
	 */
	public static Town updatePlain(Town tOld) {
	    Town tNew = new Town(tOld.getLength(), tOld.getWidth());
	    for (int x = 0; x < tOld.getLength(); x++) {
	        for (int y = 0; y < tOld.getWidth(); y++) {
	            if (tOld.grid[x][y] != null) {
	                tNew.grid[x][y] = tOld.grid[x][y].next(tNew);
	            } else {
	                System.err.println("Null cell at (" + x + ", " + y + "). Defaulting to Empty.");
	                tNew.grid[x][y] = new Empty(tNew, x, y); // Default to Empty if the cell is null
	            }
	        }
	    }
	    return tNew;
	}

	/**
	 * Returns the profit for the current state in the town grid.
	 * 
	 * @param town
	 * @return
	 */
	public static int getProfit(Town town) {
	    int C = 0;
	    for (int x = 0; x < town.getLength(); x++) {
	        for (int y = 0; y < town.getWidth(); y++) {
	            if (town.grid[x][y] != null && town.grid[x][y].who() == State.CASUAL) {
	                C++;
	            }
	        }
	    }
	    return C;
	}

	/**
	 * Main method. Interact with the user and ask if user wants to specify elements
	 * of grid via an input file (option: 1) or wants to generate it randomly
	 * (option: 2).
	 * <p>
	 * Depending on the user choice, create the Town object using respective
	 * constructor and if user choice is to populate it randomly, then populate the
	 * grid here.
	 * <p>
	 * Finally: For 12 billing cycle calculate the profit and update town object
	 * (for each cycle). Print the final profit in terms of %. You should print the
	 * profit percentage with two digits after the decimal point: Example if profit
	 * is 35.5600004, your output should be:
	 * <p>
	 * 35.56%
	 * <p>
	 * Note that this method does not throw any exception, so you need to handle all
	 * the exceptions in it.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		int InputAnswer;

		Scanner scnr = new Scanner(System.in);
		System.out.println(" (type 1 or 2): 1: from a file. 2 is random");

		InputAnswer = scnr.nextInt();

		if (InputAnswer == 1) {
			String filePath = "";
			double profit = 0.0;
			try {
				System.out.println("Enter file path:");
				scnr.nextLine();
				filePath = scnr.nextLine();

				Town t = new Town(filePath);
				


				for (int month = 0; month < 12; month++) {
					//System.out.println(t.toString());
					profit += (getProfit(t) / ((double) t.getWidth() * (double) t.getLength())) * 100;
					t = updatePlain(t);
				}
				profit = profit / 12;
				System.out.printf("%.2f%c", profit, '%');

			} catch (FileNotFoundException e) {
				System.out.println("Invalid file path: " + e.toString());
			}
		}
		if (InputAnswer == 2) {

			int seed;
			int row;
			int col;
			System.out.println("Provide rows, cols and seed integer separated by spaces:");
			row = scnr.nextInt();
			col = scnr.nextInt();
			seed = scnr.nextInt();
			Town t = new Town(row, col);

			t.randomInit(seed);

			double profit = 0.0;

			for (int month = 0; month < 12; month++) {
				profit += (getProfit(t) / ((double) t.getWidth() * (double) t.getLength())) * 100;
				t = updatePlain(t);
			}
			profit = profit / 12;
	System.out.printf("%.2f%c", profit, '%');
		}
	}
}