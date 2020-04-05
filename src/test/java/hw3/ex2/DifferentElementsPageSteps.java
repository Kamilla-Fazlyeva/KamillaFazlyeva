package hw3.ex2;

import hw3.base.AbstractBaseClass;
import org.openqa.selenium.WebDriver;

public class DifferentElementsPageSteps extends AbstractBaseClass {

    public DifferentElementsPageSteps(WebDriver driver) {
        super(driver);
    }

    public void selectCheckbox(String checkboxName) {
        differentElementsPage.selectCheckbox(checkboxName);
    }

    public void selectRadioButton(String radioButtonName) {
        differentElementsPage.selectRadioButton(radioButtonName);
    }

    public void selectDropdown(String colorText) {
        differentElementsPage.selectDropdown(colorText);
    }
}
