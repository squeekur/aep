package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleTest {

    @Test
    public void twoByTwoRectangleShouldHaveAreaFourAndPerimeterEight() {
        Rectangle rectangle = new Rectangle(2, 2);
        assertEquals(4, rectangle.area());
        assertEquals(8, rectangle.perimeter());
    }

    @Test
    public void oneByOneRectangleShouldHaveAreaOneAndPerimeterFour() {
        Rectangle rectangle = new Rectangle(1, 1);
        assertEquals(1, rectangle.area());
        assertEquals(4, rectangle.perimeter());
    }

}