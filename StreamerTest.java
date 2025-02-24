package edu.iastate.cs2280.hw1;


/**
 *  @author <<Pola Tawfik>>
 *
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StreamerTest {
    Town t = new Town(4,4);
    Streamer s = new Streamer(t, 1, 2);

	@Test
	void test() {
		assertEquals(s.who(), State.STREAMER);
	}
}
