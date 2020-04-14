package hw4.enums;

public enum MetalItems {

    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    final String value;

    MetalItems(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
