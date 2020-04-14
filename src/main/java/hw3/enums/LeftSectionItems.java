package hw3.enums;

public enum LeftSectionItems {

    HOME("Home"),
    CONTACT_FORM("Contact form"),
    SERVICE("Service"),
    METALS_AND_COLORS("Metals & Colors"),
    ELEMENTS_PACKS("Elements packs");

    private String itemText;

    LeftSectionItems(String itemText) {
        this.itemText = itemText;
    }

    public String getItemText() {
        return itemText;
    }
}
