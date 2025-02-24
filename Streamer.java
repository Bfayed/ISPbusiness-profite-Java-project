package edu.iastate.cs2280.hw1;

public class Streamer extends TownCell {

	public Streamer(Town p, int r, int c) {
		super(p, r, c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public State who() {

		return State.STREAMER;
	}

	@Override
	public TownCell next(Town tNew) {

		int[] nCensus = new int[5];

		census(nCensus);

		if (nCensus[OUTAGE] + nCensus[EMPTY] <= 1) {
			return new Reseller(tNew, row, col);
		} else if (nCensus[RESELLER] > 0) {
			return new outage(tNew, row, col);
		} else if (nCensus[OUTAGE] > 0) {
			return new Empty(tNew, row, col);
		} else {
			return new Streamer(tNew, row, col);
		}
	}

}