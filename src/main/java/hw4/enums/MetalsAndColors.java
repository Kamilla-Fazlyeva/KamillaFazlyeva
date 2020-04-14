package hw4.enums;

public enum MetalsAndColors {

    SUMMARY("Summary"),
    METALS("Metals"),
    COLORS("Colors"),
    ELEMENTS("Elements"),
    VEGETABLES("Vegetables");

    final String value;

    MetalsAndColors(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
