package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jhumble on 3/19/15.
 */
public class GolfTest {
    @Test
    public void groupOfOneShouldCreateOneTeeGroup() {
        Integer[] parties = new Integer[] { 1 };
        assertEquals(1, new GolfPartyAssigner(parties).assign());
    }

    @Test
    public void twoPartiesOfThreeShouldCreateTwoTeeGroups() {
        Integer[] parties = new Integer[] { 3, 3 };
        assertEquals(2, new GolfPartyAssigner(parties).assign());
    }

    @Test
    public void threePartiesOfThreeShouldCreateThreeTeeGroups() {
        Integer[] parties = new Integer[] { 3, 3, 3 };
        assertEquals(3, new GolfPartyAssigner(parties).assign());
    }

    @Test
    public void shouldCreateThreeTeeGroups() {
        Integer[] parties = new Integer[] { 3, 3, 3, 1};
        assertEquals(3, new GolfPartyAssigner(parties).assign());
    }

    @Test
    public void shouldCreateZeroTeeGroupsWithEmptyArrayOrNull() {
        Integer[] parties = new Integer[] {};
        assertEquals(0, new GolfPartyAssigner(parties).assign());
        assertEquals(0, new GolfPartyAssigner(null).assign());
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionIfTooManyPeopleInGroup() {
        Integer[] parties = new Integer[] { 6 };
        assertEquals(0, new GolfPartyAssigner(parties).assign());
    }
}
