

package edu.iastate.cs2280.hw1;

/**
 *  @author << Bavly Fayed >>
 *
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

	class CasualTest {
	    Town t = new Town(4,4);
	    Casual c = new Casual(t, 1, 2);
	    
		@Test
		void test() {
			assertEquals(c.who(), State.CASUAL);
		}

	}
