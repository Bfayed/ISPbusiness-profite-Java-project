package edu.iastate.cs2280.hw1;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author <<BAVLY FAYED>>
 *
 */
public class Town {
	private int length, width; // Row and col (first and second indices)
	public TownCell[][] grid;

	/**
	 * Constructor to be used when user wants to generate grid randomly, with the
	 * given seed. This constructor does not populate each cell of the grid (but
	 * should assign a 2D array to it).
	 * 
	 * @param length
	 * @param width
	 */
	public Town(int length, int width) {
		grid = new TownCell[length][width];
		this.length = length;
		this.width = width;
	}

	/**
	 * Constructor to be used when user wants to populate grid based on a file.
	 * Please see that it simple throws FileNotFoundException exception instead of
	 * catching it. Ensure that you close any resources (like file or scanner) which
	 * is opened in this function.
	 * 
	 * @param inputFileName
	 * @throws FileNotFoundException
	 */
	public Town(String inputFileName) throws FileNotFoundException {
		File file = new File(inputFileName);

		Scanner scnr = new Scanner(file);
		length = scnr.nextInt();
		width = scnr.nextInt();
		grid = new TownCell[length][width];

		if (scnr.hasNextLine()) {

			scnr.nextLine();

			for (int x = 0; x < length; x++) {

				for (int y = 0; y < width; y++) {

					String s = scnr.next();

					if ("C".equals(s)) {
						grid[x][y] = new Casual(this, x, y);
					} else if ("S".equals(s)) {
						grid[x][y] = new Streamer(this, x, y);
					} else if ("R".equals(s)) {
						grid[x][y] = new Reseller(this, x, y);
					} else if ("E".equals(s)) {
						grid[x][y] = new Empty(this, x, y);
					} else if ("O".equals(s)) {
						grid[x][y] = new outage(this, x, y);
					}
				}

				if (scnr.hasNextLine()) {
					scnr.nextLine();
				}

			}
		}
		scnr.close();
	}

	/**
	 * Returns width of the grid.
	 * 
	 * @return
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Returns length of the grid.
	 * 
	 * @return
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Initialize the grid by randomly assigning cell with one of the following
	 * class object: Casual, Empty, Outage, Reseller OR Streamer
	 */
	public void randomInit(int seed) {
		Random rand = new Random(seed);

		for (int x = 0; x < length; x++) {
			for (int y = 0; y < width; y++) {
				int randval = rand.nextInt(5);
				if (randval == TownCell.CASUAL) {
					grid[x][y] = new Casual(this, x, y);
				} else if (randval == TownCell.STREAMER) {
					grid[x][y] = new Streamer(this, x, y);
				} else if (randval == TownCell.RESELLER) {
					grid[x][y] = new Reseller(this, x, y);
				} else if (randval == TownCell.OUTAGE) {
					grid[x][y] = new outage(this, x, y);
				} else if (randval == TownCell.EMPTY) {
					grid[x][y] = new Empty(this, x, y);
				}
			}
		}
	}

	/**
	 * Output the town grid. For each square, output the first letter of the cell
	 * type. Each letter should be separated either by a single space or a tab. And
	 * each row should be in a new line. There should not be any extra line between
	 * the rows.
	 */
	@Override
	public String toString() {
	    StringBuilder s = new StringBuilder();
	    for (int x = 0; x < length; x++) {
	        for (int y = 0; y < width; y++) {
	            if (grid[x][y] != null) {
	                s.append(grid[x][y].who().toString().charAt(0)).append(" ");
	            } else {
	                s.append("N "); // 'N' could represent a null cell or provide a better placeholder
	            }
	        }
	        s.append("\n");
	    }
	    return s.toString();
	}
}