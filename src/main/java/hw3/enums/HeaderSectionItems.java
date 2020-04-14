package hw3.enums;

public enum HeaderSectionItems {

    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_AND_COLORS("METALS & COLORS");

    final String text;

    HeaderSectionItems(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
