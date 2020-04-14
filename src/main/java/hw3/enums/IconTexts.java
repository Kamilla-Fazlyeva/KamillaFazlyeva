package hw3.enums;

public enum IconTexts {

    FIRST_ICON("To include good practices and ideas from successful EPAM project"),
    SECOND_ICON("To be flexible and customizable"),
    THIRD_ICON("To be multiplatform"),
    FOURTH_ICON("Already have good base (about 20 internal and some external projects), wish to get more…");

    final String iconText;

    IconTexts(String text) {
        this.iconText = text;
    }

    public String getText() {
        return iconText;
    }
}
