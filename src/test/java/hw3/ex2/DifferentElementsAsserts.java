package hw3.ex2;

import hw3.base.BaseClass;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DifferentElementsAsserts extends BaseClass {

    public void shouldReturnWaterCheckbox() {
        assertFalse(differentElementsPage.getWaterCheckbox().isSelected());
    }

    public void shouldReturnWindCheckbox() {
        assertFalse(differentElementsPage.getWindCheckbox().isSelected());
    }

    public void shouldReturnSelenRadio() {
        assertFalse(differentElementsPage.getSelenRadio().isSelected());
    }

    public void shouldReturnDropdownYellow() {
        assertFalse(differentElementsPage.getDropdownYellow().isSelected());
    }

    public void shouldReturnWaterCheckboxText() {
        assertTrue(differentElementsPage.getWaterCheckbox().getText().contains("Water"));
    }

    public void shouldReturnWindCheckboxText() {
        assertTrue(differentElementsPage.getWindCheckbox().getText().contains("Wind"));
    }

    public void shouldReturnSelenRadioText() {
        assertTrue(differentElementsPage.getSelenRadio().getText().contains("Selen"));
    }

    public void shouldReturnDropdownYellowText() {
        assertTrue(differentElementsPage.getDropdownYellow().getText().contains("Yellow"));
    }
}
