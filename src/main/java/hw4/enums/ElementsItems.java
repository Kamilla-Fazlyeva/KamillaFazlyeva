package hw4.enums;

public enum ElementsItems {

    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    final String value;

    ElementsItems(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
