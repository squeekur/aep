package edu.berkeley.aep;

public interface Bestable<T> {
    public boolean betterThan(T other);
}
