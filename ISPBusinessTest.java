package edu.iastate.cs2280.hw1;

/**
 *  @author << Bavly fayed >>
 *
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ISPBusinessTest {

	Town t = new Town(4,4);
	@Test
	void test() {
		t.randomInit(10);
        assertEquals(ISPBusiness.getProfit(t),1);
	}

}

