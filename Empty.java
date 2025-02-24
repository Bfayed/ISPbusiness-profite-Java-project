package edu.iastate.cs2280.hw1;

public class Empty extends TownCell{

	public Empty(Town p, int r, int c) {
			super(p, r, c);
			// TODO Auto-generated constructor stub
		}

		@Override
		public State who() {

			return State.EMPTY;
		}

		@Override
		public TownCell next(Town tNew) {
			int [] ncensus = new int[5];
			census(ncensus);
			if(ncensus[OUTAGE] + ncensus[EMPTY] <= 1 ) {
				Reseller r = new Reseller (tNew , row , col);
				return r;
			}
			return new Casual (tNew , row , col);
		}
		
		
	}
