package hw4.enums;

public enum ColorItems {

    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    final String value;

    ColorItems(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
