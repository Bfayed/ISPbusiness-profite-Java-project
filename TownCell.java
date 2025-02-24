package edu.iastate.cs2280.hw1;

/**
 * 
 * @author <<Bavly Fayed>> Also provide appropriate comments for this
 *         class
 *
 */
public abstract class TownCell {

	protected Town plain;  // The town (grid) in which this cell resides.
	protected int row;     // The row position of this cell in the town grid.
	protected int col;     // The column position of this cell in the town grid.

	// Constants representing the different possible cell types.
	protected static final int RESELLER = 0;
	protected static final int EMPTY = 1;
	protected static final int CASUAL = 2;
	protected static final int OUTAGE = 3;
	protected static final int STREAMER = 4;

	public static final int NUM_CELL_TYPE = 5;


	public static final int[] nCensus = new int[NUM_CELL_TYPE];

	public TownCell(Town p, int r, int c) {
		plain = p;
		row = r;
		col = c;
	}

	/**
	 * Checks all neigborhood cell types in the neighborhood. Refer to homework pdf
	 * for neighbor definitions (all adjacent neighbors excluding the center cell).
	 * Use who() method to get who is present in the neighborhood
	 * 
	 * @param counts of all customers
	 */
	public void census(int nCensus[]) {
		// zero the counts of all customers
		nCensus[RESELLER] = 0; 
		nCensus[EMPTY] = 0; 
		nCensus[CASUAL] = 0; 
		nCensus[OUTAGE] = 0; 
		nCensus[STREAMER] = 0;
		
	
		
		

		// Loop through the neighboring cells (in a 3x3 grid surrounding the current cell).
		for(int r = -1; r <= 1; r++) {
		    for(int c = -1; c <= 1; c++) {
		    	// Check if the neighbor cell is within bounds and is not the center cell itself
		        if((row + r >= 0 && row + r < plain.getLength()) && (col + c >= 0 && col + c < plain.getWidth()) && !(r == 0 && c == 0)) {
		        	// Increment the count for the respective cell type.
		            if(plain.grid[row + r][col + c].who() == State.CASUAL) {
		                nCensus[CASUAL]++;
		            }
		            if(plain.grid[row + r][col + c].who() == State.STREAMER) {
		                nCensus[STREAMER]++;
		            }
		            if(plain.grid[row + r][col + c].who() == State.RESELLER) {
		                nCensus[RESELLER]++;
		            }
		            if(plain.grid[row + r][col + c].who() == State.OUTAGE) {
		                nCensus[OUTAGE]++;
		            }
		            if(plain.grid[row + r][col + c].who() == State.EMPTY) {
		                nCensus[EMPTY]++;
		            }
		        }
		    }
		}

	}
	/**
	 * Gets the identity of the cell.
	 * 
	 * @return State
	 */
	public abstract State who();

	/**
	 * Determines the cell type in the next cycle.
	 * 
	 * @param tNew: town of the next cycle
	 * @return TownCell
	 */
	public abstract TownCell next(Town tNew);
}
