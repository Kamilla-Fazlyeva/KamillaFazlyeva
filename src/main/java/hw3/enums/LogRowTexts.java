package hw3.enums;

public enum LogRowTexts {

    COLORS("Colors: value changed to Yellow"),
    METAL("metal: value changed to Selen"),
    WIND("Wind: condition changed to true"),
    WATER("Water: condition changed to true");

    final String logText;

    LogRowTexts(String logText) {
        this.logText = logText;
    }

    public String getLogText() {
        return logText;
    }
}
