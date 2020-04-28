package hwjdi.enums;

public enum Vegetables {

    VEGETABLES("Vegetables");

    final String value;

    Vegetables(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
