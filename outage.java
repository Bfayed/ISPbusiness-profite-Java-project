package edu.iastate.cs2280.hw1;

public class outage extends TownCell {

	public outage(Town p, int r, int c) {
		super(p, r, c);
	}

	@Override
	public State who() {
		return State.OUTAGE;
	}

	@Override
	public TownCell next(Town tNew) {
		int [] ncensus = new int [5];
		census(ncensus);
		if(ncensus[CASUAL]>=5) {
			Streamer s = new Streamer(tNew , row , col);
			return s;
		}
		return new Empty( tNew , row , col );
		
	}
}