package edu.berkeley.aep;

//Understands how to reverse a string
public class Reverser {
    private final String toReverse;

    public Reverser(String toReverse) {
        this.toReverse = toReverse;
    }

    public String reverse() {
        if (toReverse == null || toReverse.length() < 2)
            return toReverse;
        return new Reverser(toReverse.substring(1)).reverse() + toReverse.charAt(0);
    }
}
