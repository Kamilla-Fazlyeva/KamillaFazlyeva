package hw5.steps;

import hw5.base.AbstractBaseClass;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;

public class DifferentElementsPageSteps extends AbstractBaseClass {

    public DifferentElementsPageSteps() {
        super();
    }

    @Step("I select checkbox '{0}'")
    public void selectCheckbox(String checkboxName) {
        differentElementsPage.selectCheckbox(checkboxName);
    }

    @Step("I select radiobutton '{0}'")
    public void selectRadioButton(String radioButtonName) {
        differentElementsPage.selectRadioButton(radioButtonName);
    }

    @Step("I select dropdown '{0}'")
    public void selectDropdown(String colorText) {
        differentElementsPage.selectDropdown(colorText);
    }

    @Step("Selected checkbox should be displayed")
    public void shouldReturnSelectedCheckbox() {
        differentElementsPage.getCheckboxes().forEach(element -> assertTrue(element.isDisplayed()));
    }

    @Step("Selected radiobutton should be displayed")
    public void shouldReturnSelectedRadioButton() {
        differentElementsPage.getRadioButtons().forEach(element -> assertTrue(element.isDisplayed()));
    }

    @Step("Selected dropdown should be displayed")
    public void shouldReturnSelectedDropdown() {
        assertTrue(differentElementsPage.getDropdownSelect().isDisplayed());
    }

    @Step("Results on the log row should be displayed '{0}'")
    public void shouldReturnLogRowText(String elementName, String logRowText) {
        for (WebElement element : differentElementsPage.getLogRow()) {
            if(element.getText().contains(elementName)) {
                assertTrue(element.getText().contains(logRowText));
            }
        }
    }
}
