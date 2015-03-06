package edu.berkeley.aep;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ChanceTest {

    @Test
    public void shouldUnderstandNotBeEqualToAnother() {
        Chance coinToss = new Chance(0.5);
        Chance dieThrow = new Chance(1/6);
        assertEquals(coinToss, coinToss);
        assertFalse(dieThrow.equals(coinToss));
    }

    @Test
    public void twoChancesWithTheSameProbabilityShouldBeEqual() {
        Chance coinToss = new Chance(0.5);
        assertEquals(new Chance(0.5), coinToss);
        assertFalse(coinToss.equals(null));
        assertFalse(coinToss.equals(new Object()));
        assertFalse(coinToss.equals(new Chance(0.75)));
    }

    @Test
    public void shouldHaveAHashCode() {
        Map<Chance, String> map = new HashMap<Chance, String>();
        map.put(new Chance(0.5), "Coin Toss");
        assertEquals("Coin Toss", map.get(new Chance(0.5)));
    }

    @Test
    public void notShouldReturnComplementOfProbability() {
        Chance coinToss = new Chance(0.5);
        assertEquals(new Chance(0.5), coinToss.not());
        assertEquals(new Chance(0), new Chance(1).not());
    }

    @Test
    public void shouldAndTwoProbabilities() {
        Chance coinToss = new Chance(new BigDecimal(4).divide(BigDecimal.TEN));
        assertEquals(new Chance(new BigDecimal(16).divide(new BigDecimal(100))), coinToss.and(coinToss));
        assertEquals(new Chance(0), new Chance(0).and(coinToss));
    }

    @Test
    public void shouldOrTwoProbabilities() {
        Chance coinToss = new Chance(0.5);
        assertEquals(new Chance(0.75), coinToss.or(coinToss));
        assertEquals(new Chance(1), new Chance(1).or(coinToss));
    }

    @Test
    public void probabilityOfHalfShouldBeGreaterThanProbabilityOfQuarter() {
        assertTrue(new Chance(0.5).betterThan(new Chance(0.25)));
    }
}
