package hw3.ex2;

import hw3.base.AbstractBaseClass;
import org.openqa.selenium.WebDriver;

public class DifferentElementsPageSteps extends AbstractBaseClass {

    public DifferentElementsPageSteps(WebDriver driver) {
        super(driver);
    }

    public void clickWaterCheckbox() {
        differentElementsPage.selectWaterCheckbox();
    }

    public void clickWindCheckbox() {
        differentElementsPage.selectWindCheckbox();
    }

    public void clickSelenRadioCheckbox() {
        differentElementsPage.selectSelenRadio();
    }

    public void clickDropdownYellow() {
        differentElementsPage.selectDropdownYellow();
    }
}
