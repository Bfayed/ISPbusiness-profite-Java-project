package edu.iastate.cs2280.hw1;
/**
 *  @author << Bavly Fayed >>
 *
 */

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
public class TownCellTest {
    @Test
    void testCensus() {
        Town test = new Town(3,3);
        test.grid[0][0] = new Casual(test, 0, 0);
        test.grid[0][1] = new Streamer(test, 0, 1);
        test.grid[0][2] = new outage(test, 0, 2);
        test.grid[1][0] = new Empty(test, 1, 0);
        test.grid[1][1] = new Reseller(test, 1, 1);
        test.grid[1][2] = new Casual(test, 1, 2);
        test.grid[2][0] = new Empty(test, 2, 0);
        test.grid[2][1] = new Reseller(test, 2, 1);
        test.grid[2][2] = new Casual(test, 2, 2);

        test.grid[1][1].census(TownCell.nCensus);
        boolean c = (TownCell.nCensus[TownCell.CASUAL] == 3);
        boolean s = (TownCell.nCensus[TownCell.STREAMER] == 1);
        boolean o = (TownCell.nCensus[TownCell.OUTAGE] == 1);
        boolean e = (TownCell.nCensus[TownCell.EMPTY] == 2);
        boolean r = (TownCell.nCensus[TownCell.RESELLER] == 1);

        assertEquals(true, c && s && o && e && r);
    }
}