package edu.berkeley.aep;

// Understands an amount in a given unit
public class Quantity {

    private final int size;
    private final Units units;

    public Quantity(int size, Units units) {
        this.size = size;
        this.units = units;
    }

    @Override
    public int hashCode() {
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Quantity)) return false;
        Quantity other = (Quantity) obj;
        return equals(other);
    }

    private boolean equals(Quantity other) {
        return units.convertsTo(other.units) && units.toBaseUnits(size) == other.units.toBaseUnits(other.size);
    }
}
