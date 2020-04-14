package hw4.enums;

public enum SummaryItems {

    ONE("1"),
    TWO("2"),
    THREE("3"),
    FIVE("5"),
    SIX("6"),
    EIGHT("8");

    final String value;

    SummaryItems(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Integer getIntValue() {
        return Integer.parseInt(value);
    }
}
