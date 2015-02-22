package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class QuantityTest {

    @Test
    public void threeFeetShouldEqualOneYard() {
        Quantity oneYard = Quantity.createQuantity(1, Units.YARDS);
        Quantity threeFeet = Quantity.createQuantity(3, Units.FEET);
        assertEquals(oneYard, threeFeet);
    }

    @Test
    public void oneMileShouldEqual1760Yard() {
        Quantity oneMile = Quantity.createQuantity(1, Units.MILES);
        Quantity oneMileInYards = Quantity.createQuantity(1760, Units.YARDS);
        assertEquals(oneMile, oneMileInYards);
    }

    @Test
    public void oneTablespoonShouldEqualThreeTeaspoons() {
        Quantity oneTablespoon = Quantity.createQuantity(1, Units.TBSP);
        Quantity threeTeaspoons = Quantity.createQuantity(3, Units.TSP);
        assertEquals(oneTablespoon, threeTeaspoons);
    }

    @Test
    public void oneOzShouldEqualTwoTablespoons() {
        Quantity oneOz = Quantity.createQuantity(1, Units.OZ);
        Quantity twoTablespoons = Quantity.createQuantity(2, Units.TBSP);
        assertEquals(oneOz, twoTablespoons);
    }

    @Test
    public void eightOzShouldEqualOneCup() {
        Quantity eightOz = Quantity.createQuantity(8, Units.OZ);
        Quantity oneCup = Quantity.createQuantity(1, Units.CUPS);
        assertEquals(eightOz, oneCup);
    }

    @Test
    public void oneInchShouldNotEqualOneTsp() {
        Quantity tsp = Quantity.createQuantity(1, Units.TSP);
        Quantity inch = Quantity.createQuantity(1, Units.INCHES);
        assertNotEquals(tsp, inch);
    }

    @Test
    public void twoInchesPlusTwoInchesShouldEqualFourInches() {
        assertEquals(Quantity.createQuantity(4, Units.INCHES),
                ((ArithmeticQuantity) Quantity.createQuantity(2, Units.INCHES)).add(Quantity.createQuantity(2, Units.INCHES)));
    }

    @Test
    public void twoTbspPlus1OzShouldEqual12Tsp() {
        assertEquals(Quantity.createQuantity(15, Units.TSP), ((ArithmeticQuantity) Quantity.createQuantity(3, Units.TBSP)).add(new ArithmeticQuantity(1, Units.OZ)));
    }

    @Test
    public void oneHundredCelsiusShouldEqual212F() {
        assertEquals(Quantity.createQuantity(212, Units.FAHRENHEIT), Quantity.createQuantity(100, Units.CELSIUS));
    }

    @Test(expected = RuntimeException.class)
    public void oneTspPlusOneInchShouldGiveAnException() {
        assertNotEquals(new ArithmeticQuantity(1, Units.CELSIUS), new ArithmeticQuantity(1, Units.TSP).add(new ArithmeticQuantity(1, Units.INCHES)));
    }
}