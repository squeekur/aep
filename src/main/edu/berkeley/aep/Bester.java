package edu.berkeley.aep;

// Understands how to sort objects of type Bestable
public abstract class Bester {
    public static Bestable sort(Bestable... quantities) {
        Bestable champion = quantities[0];
        for (Bestable challenger : quantities) {
            if (challenger.betterThan(champion)) {
                champion = challenger;
            }
        }
        return champion;
    }
}
