package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class QuantityTest {

    @Test
    public void threeFeetShouldEqualOneYard() {
        Quantity oneYard = new Quantity(1, Units.YARDS);
        Quantity threeFeet = new Quantity(3, Units.FEET);
        assertEquals(oneYard, threeFeet);
    }

    @Test
    public void oneMileShouldEqual1760Yard() {
        Quantity oneMile = new Quantity(1, Units.MILES);
        Quantity oneMileInYards = new Quantity(1760, Units.YARDS);
        assertEquals(oneMile, oneMileInYards);
    }

    @Test
    public void oneTablespoonShouldEqualThreeTeaspoons() {
        Quantity oneTablespoon = new Quantity(1, Units.TBSP);
        Quantity threeTeaspoons = new Quantity(3, Units.TSP);
        assertEquals(oneTablespoon, threeTeaspoons);
    }

    @Test
    public void oneOzShouldEqualTwoTablespoons() {
        Quantity oneOz = new Quantity(1, Units.OZ);
        Quantity twoTablespoons = new Quantity(2, Units.TBSP);
        assertEquals(oneOz, twoTablespoons);
    }

    @Test
    public void eightOzShouldEqualOneCup() {
        Quantity eightOz = new Quantity(8, Units.OZ);
        Quantity oneCup = new Quantity(1, Units.CUPS);
        assertEquals(eightOz, oneCup);
    }

    @Test
    public void oneInchShouldNotEqualOneTsp() {
        Quantity tsp = new Quantity(1, Units.TSP);
        Quantity inch = new Quantity(1, Units.INCHES);
        assertNotEquals(tsp, inch);
    }

    @Test
    public void twoInchesPlusTwoInchesShouldEqualFourInches() {
        assertEquals(new Quantity(4, Units.INCHES), new Quantity(2, Units.INCHES).add(new Quantity(2, Units.INCHES)));
    }

    @Test
    public void twoTbspPlus1OzShouldEqual12Tsp() {
        assertEquals(new Quantity(15, Units.TSP), new Quantity(3, Units.TBSP).add(new Quantity(1, Units.OZ)));
    }

    @Test
    public void oneHundredCelsiusShouldEqual212F() {
        assertEquals(new Quantity(212, Units.FAHRENHEIT), new Quantity(100, Units.CELSIUS));
    }

    @Test(expected = RuntimeException.class)
    public void oneTspPlusOneInchShouldGiveAnException() {
        assertNotEquals(new Quantity(1, Units.CELSIUS), new Quantity(1, Units.TSP).add(new Quantity(1, Units.INCHES)));
    }
}