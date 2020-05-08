package hwapi.enums;

public enum Lang {

    RU("ru"),
    EN("en"),
    UK("uk");

    private String value;

    Lang(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
