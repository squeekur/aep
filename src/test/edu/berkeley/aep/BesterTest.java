package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BesterTest {
    @Test
    public void oneYardShouldBeBiggestQuantity() {
        assertEquals(Quantity.create(1, Units.YARDS),
                Bester.sort((ArithmeticQuantity) Quantity.create(13, Units.INCHES), (ArithmeticQuantity) Quantity.create(1, Units.YARDS)));
    }

    @Test
    public void oneHalfShouldBeBiggestProbability() {
        assertEquals(new Chance(0.5),
                Bester.sort(new Chance(0.25), new Chance(0.5)));
    }

}
