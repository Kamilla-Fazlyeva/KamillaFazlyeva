package hw3.ex2;

import hw3.base.AbstractBaseClass;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DifferentElementsAsserts extends AbstractBaseClass {

    public DifferentElementsAsserts(WebDriver driver) {
        super(driver);
    }

    public void shouldReturnSelectedCheckbox() {
        differentElementsPage.getCheckboxes().forEach(element -> assertTrue(element.isSelected()));
    }

    public void shouldReturnSelectedRadioButton() {
        differentElementsPage.getRadioButtons().forEach(element -> assertTrue(element.isSelected()));
    }

    public void shouldReturnSelectedDropdown() {
        assertTrue(differentElementsPage.getDropdownSelect().isSelected());
    }

    public void shouldReturnLogRowText(String logRowText) {
        assertTrue(differentElementsPage.getLogRowText().contains(logRowText));
    }
}
