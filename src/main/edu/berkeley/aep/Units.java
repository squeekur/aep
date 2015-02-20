package edu.berkeley.aep;

// Understands how to convert between different units
public class Units {

    private final int inBaseUnits;
    private final int offset;
    private final UnitType unitType;

    public Units(int inBaseUnits, int offset, UnitType unitType) {
        this.inBaseUnits = inBaseUnits;
        this.offset = offset;
        this.unitType = unitType;
    }

    public int convertTo(int size, Units otherUnits) {
        return (size + offset) * this.inBaseUnits / otherUnits.inBaseUnits - otherUnits.offset;
    }

    private enum UnitType { DISTANCE, VOLUME, TEMPERATURE }

    public static final Units INCHES = new Units(1, UnitType.DISTANCE);
    public static final Units FEET = new Units(12, UnitType.DISTANCE);
    public static final Units YARDS = new Units(36, UnitType.DISTANCE);
    public static final Units MILES = new Units(36 * 1760, UnitType.DISTANCE);
    public static final Units TSP = new Units(1, UnitType.VOLUME);
    public static final Units TBSP = new Units(3, UnitType.VOLUME);
    public static final Units OZ = new Units(6, UnitType.VOLUME);
    public static final Units CUPS = new Units(48, UnitType.VOLUME);
    public static final Units CELSIUS = new Units(9, 0, UnitType.TEMPERATURE);
    public static final Units FAHRENHEIT = new Units(5, -32, UnitType.TEMPERATURE);

    public Units(int inBaseUnits, UnitType unitType) {
        this(inBaseUnits, 0, unitType);
    }



    public int toBaseUnits(int size) {
        return size * inBaseUnits;
    }

    public boolean convertsTo(Units other) {
        return unitType == other.unitType;
    }
}
