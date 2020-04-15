package hw3.enums;

public enum DifferentElements {

    WIND("Wind"),
    WATER("Water"),
    SELEN("Selen"),
    YELLOW("Yellow"),
    METAL("metal"),
    COLORS("Colors");

    final String value;

    DifferentElements(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
