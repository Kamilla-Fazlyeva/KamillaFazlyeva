package hwapi.enums;

public enum ErrorCode {

    ERROR_UNKNOWN_WORD(1),
    ERROR_REPEAT_WORD(2),
    ERROR_CAPITALIZATION(3),
    ERROR_TOO_MANY_ERRORS(4);

    private Integer value;

    ErrorCode(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
