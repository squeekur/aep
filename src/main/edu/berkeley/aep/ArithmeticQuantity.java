package edu.berkeley.aep;

import java.io.Serializable;

// Understands an amount in a given arithmetic unit
class ArithmeticQuantity extends Quantity {

    protected ArithmeticQuantity(int size, Units units) {
        super(size, units);
    }

    public Quantity add(Quantity quantity) {
        if (!quantity.units.convertsTo(units)) {
            throw new RuntimeException("Cannot add " + quantity.units + " to " + units);
        }
        return new ArithmeticQuantity(quantity.convertTo(units).size + size, units);
    }
}
