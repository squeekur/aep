package edu.berkeley.aep;

// Understands how to convert between different units
public class Units {

    public static final Units INCHES = new Units(1, UnitType.DISTANCE, "Inches");
    public static final Units FEET = new Units(12, UnitType.DISTANCE, "Feet");
    public static final Units YARDS = new Units(36, UnitType.DISTANCE, "Yards");
    public static final Units MILES = new Units(36 * 1760, UnitType.DISTANCE, "Miles");
    public static final Units TSP = new Units(1, UnitType.VOLUME, "Tsp");
    public static final Units TBSP = new Units(3, UnitType.VOLUME, "Tbsp");
    public static final Units OZ = new Units(6, UnitType.VOLUME, "Oz");
    public static final Units CUPS = new Units(48, UnitType.VOLUME, "Cups");
    public static final Units CELSIUS = new Units(9, 0, UnitType.TEMPERATURE, "Celsius");
    public static final Units FAHRENHEIT = new Units(5, -32, UnitType.TEMPERATURE, "Fahrenheit");

    private final int inBaseUnits;
    private final int offset;
    private final UnitType unitType;
    private final String name;

    private enum UnitType { DISTANCE(true), VOLUME(true), TEMPERATURE(false);
        private final boolean isArithmetic;
        UnitType(boolean isArithmetic) {
            this.isArithmetic = isArithmetic;
        }
    }

    public Units(int inBaseUnits, int offset, UnitType unitType, String name) {
        this.inBaseUnits = inBaseUnits;
        this.offset = offset;
        this.unitType = unitType;
        this.name = name;
    }

    public Units(int inBaseUnits, UnitType unitType, String name) {
        this(inBaseUnits, 0, unitType, name);
    }

    public boolean convertsTo(Units other) {
        return unitType == other.unitType;
    }

    public int convertTo(int size, Units otherUnits) {
        return (size + offset) * this.inBaseUnits / otherUnits.inBaseUnits - otherUnits.offset;
    }

    public boolean isArithmetic() {
        return unitType.isArithmetic;
    }

    @Override
    public String toString() {
        return name;
    }
}
