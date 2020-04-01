package hw3.ex2;

import hw3.base.BaseClass;
import org.openqa.selenium.WebDriver;

public class DifferentElementsPageSteps extends BaseClass {

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
