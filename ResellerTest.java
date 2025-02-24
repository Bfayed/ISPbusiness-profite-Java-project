package edu.iastate.cs2280.hw1;


/**
 *  @author << bavly Fayed >>
 *
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ResellerTest {
	Town t = new Town(4,4);
    Reseller r = new Reseller(t, 1, 2);
	@Test
	void test() {
		assertEquals(r.who(), State.RESELLER);
	}
	
}
