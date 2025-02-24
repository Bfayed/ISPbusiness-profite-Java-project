package edu.iastate.cs2280.hw1;

public class Reseller extends TownCell{

	public Reseller(Town p, int r, int c) {
		super(p, r, c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public State who() {
		return State.RESELLER;
	}

	@Override
	public TownCell next(Town tNew) {
		
		int[] nCensus = new int[5];
		
		census(nCensus);
		 	
        if (nCensus[CASUAL] <= 3 || nCensus[EMPTY] >= 3) {
			return new Empty(tNew, row, col);
		}
		else {
			return new Reseller(tNew, row, col);
		}
	}

}
