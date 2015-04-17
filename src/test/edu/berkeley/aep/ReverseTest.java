package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseTest {

    @Test
    public void reverseASingleCharacter() {
        assertEquals("a", new Reverser("a").reverse());
    }

    @Test
    public void shouldReverseAString() {
        assertEquals("cba", new Reverser("abc").reverse());
    }

    @Test
    public void whatHappensIfIPassANullString() {
        assertEquals(null, new Reverser(null).reverse());
    }

    @Test
    public void whatHappensIfIPassAZeroLengthString() {
        assertEquals("", new Reverser("").reverse());
    }


}
