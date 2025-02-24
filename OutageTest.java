package edu.iastate.cs2280.hw1;

/**
 *  @author << Bavly Fayed >>
 *
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class OutageTest {
	
    Town t = new Town(4,4);
    outage o = new outage(t, 1, 2);

	@Test
	void test() {
		assertEquals(o.who(), State.OUTAGE);
	}


}
