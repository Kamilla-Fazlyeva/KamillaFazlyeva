package hw4.enums;

public enum VegetableItems {

    CUCUMBER("Cucumber"),
    TOMATO("Tomato"),
    VEGETABLES("Vegetables"),
    ONION("Onion");

    final String value;

    VegetableItems(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
