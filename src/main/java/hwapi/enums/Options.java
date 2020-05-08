package hwapi.enums;

public enum Options {

    IGNORE_DIGITS(2),
    IGNORE_URLS(4),
    FIND_REPEAT_WORDS(8),
    IGNORE_CAPITALIZATION(512);

    private Integer value;

    Options(Integer value) {
        this.value = value;
    }

    public String getValue() {
        return String.valueOf(value);
    }

    public String sumOptions(Options... options) {
        Integer sum = 0;
        for (Options o : options) {
            sum += o.value;
        }
        return String.valueOf(sum);
    }

}
