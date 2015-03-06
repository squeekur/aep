package edu.berkeley.aep;

import java.math.BigDecimal;

/**
 * Understands the likelihood of something happening
 */
public class Chance implements Bestable<Chance> {

    private final BigDecimal probability;
    private static final BigDecimal CERTAINTY = BigDecimal.ONE;

    public Chance(double probability) {
        this.probability = new BigDecimal(probability);
    }

    public Chance(BigDecimal probability) {
        this.probability = probability;
    }

    public Chance not() {
        return new Chance(CERTAINTY.subtract(probability));
    }

    public Chance and(Chance other) {
        return new Chance(probability.multiply(other.probability));
    }

    // DeMorgan's Law
    public Chance or(Chance other) {
        return not().and(other.not()).not();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (!(other instanceof Chance)) return false;
        return (probability.compareTo(((Chance) other).probability) == 0);
    }

    @Override
    public int hashCode() {
        return probability.hashCode();
    }

    @Override
    public String toString() {
        return "Chance: " + probability;
    }

    @Override
    public boolean betterThan(Chance other) {
        return probability.compareTo(other.probability) == 1;
    }
}
