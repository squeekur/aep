package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class QuantityTest {

    @Test
    public void threeFeetShouldEqualOneYard() {
        Quantity oneYard = Quantity.create(1, Units.YARDS);
        Quantity threeFeet = Quantity.create(3, Units.FEET);
        assertEquals(oneYard, threeFeet);
    }

    @Test
    public void oneMileShouldEqual1760Yard() {
        Quantity oneMile = Quantity.create(1, Units.MILES);
        Quantity oneMileInYards = Quantity.create(1760, Units.YARDS);
        assertEquals(oneMile, oneMileInYards);
    }

    @Test
    public void oneTablespoonShouldEqualThreeTeaspoons() {
        Quantity oneTablespoon = Quantity.create(1, Units.TBSP);
        Quantity threeTeaspoons = Quantity.create(3, Units.TSP);
        assertEquals(oneTablespoon, threeTeaspoons);
    }

    @Test
    public void oneOzShouldEqualTwoTablespoons() {
        Quantity oneOz = Quantity.create(1, Units.OZ);
        Quantity twoTablespoons = Quantity.create(2, Units.TBSP);
        assertEquals(oneOz, twoTablespoons);
    }

    @Test
    public void eightOzShouldEqualOneCup() {
        Quantity eightOz = Quantity.create(8, Units.OZ);
        Quantity oneCup = Quantity.create(1, Units.CUPS);
        assertEquals(eightOz, oneCup);
    }

    @Test
    public void oneInchShouldNotEqualOneTsp() {
        Quantity tsp = Quantity.create(1, Units.TSP);
        Quantity inch = Quantity.create(1, Units.INCHES);
        assertNotEquals(tsp, inch);
    }

    @Test
    public void twoInchesPlusTwoInchesShouldEqualFourInches() {
        assertEquals(Quantity.create(4, Units.INCHES),
                ((ArithmeticQuantity) Quantity.create(2, Units.INCHES)).add(Quantity.create(2, Units.INCHES)));
    }

    @Test
    public void twoTbspPlus1OzShouldEqual12Tsp() {
        assertEquals(Quantity.create(15, Units.TSP), ((ArithmeticQuantity) Quantity.create(3, Units.TBSP)).add(new ArithmeticQuantity(1, Units.OZ)));
    }

    @Test
    public void oneHundredCelsiusShouldEqual212F() {
        assertEquals(Quantity.create(212, Units.FAHRENHEIT), Quantity.create(100, Units.CELSIUS));
    }

    @Test(expected = RuntimeException.class)
    public void oneTspPlusOneInchShouldGiveAnException() {
        assertNotEquals(new ArithmeticQuantity(1, Units.CELSIUS), new ArithmeticQuantity(1, Units.TSP).add(new ArithmeticQuantity(1, Units.INCHES)));
    }
    
//    @Test
//    public void thirteenInchesShouldBeBetterThanOneFoot() {
//        assertTrue(Quantity.create(13, Units.INCHES).betterThan(Quantity.create(1, Units.FEET)));
//    }
}