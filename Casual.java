package edu.iastate.cs2280.hw1;

public class Casual extends TownCell {

	public Casual(Town p, int r, int c) {
		super(p, r, c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public State who() {

		return State.CASUAL;
	}

	@Override
	public TownCell next(Town tNew) {
		int[] nCensus = new int[5];

		census(nCensus);

		if (nCensus[OUTAGE] + nCensus[EMPTY] <= 1) {
			return new Reseller(tNew, row, col);
		} else if (nCensus[RESELLER] > 0) {
			return new outage(tNew, row, col);
		} else if (nCensus[STREAMER] > 0 || nCensus[CASUAL] >= 5) {
			return new Streamer(tNew, row, col);
		} else {
			return new Casual(tNew, row, col);
		}

	}

}
