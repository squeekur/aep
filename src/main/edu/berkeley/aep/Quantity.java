package edu.berkeley.aep;

// Understands an amount in a given scaled unit
public class Quantity implements Bestable<Quantity> {
    protected final int size;
    protected final Units units;

    public static Quantity create(int size, Units units) {
        if (units.isArithmetic()) {
            return new ArithmeticQuantity(size, units);
        }
        return new Quantity(size, units);
    }

    protected Quantity(int size, Units units) {
        this.size = size;
        this.units = units;
    }

    protected Quantity convertTo(Units otherUnits) {
        return new Quantity(units.convertTo(size, otherUnits), units);
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
        if (!units.convertsTo(other.units)) return false;
        return size == other.convertTo(units).size;
    }

    @Override
    public boolean betterThan(Quantity other) {
        return size > (other.convertTo(units)).size;
    }

}
