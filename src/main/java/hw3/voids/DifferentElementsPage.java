package hw3.voids;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DifferentElementsPage extends HomePage {

    @FindBy(xpath = "//label[@class='label-checkbox' and contains(.,'Water')]")
    private WebElement waterCheckbox;

    @FindBy(xpath = "//label[@class='label-checkbox' and contains(., 'Wind')]")
    private WebElement windCheckbox;

    @FindBy(xpath = "//label[@class='label-radio' and contains(., 'Selen')]")
    private WebElement selenRadio;

    @FindBy(xpath = "//select[@class='uui-form-element' and contains(., 'Yellow')]")
    private WebElement dropdownYellow;

    public WebElement getWaterCheckbox() {
        return this.waterCheckbox;
    }

    public WebElement getWindCheckbox() {
        return this.windCheckbox;
    }

    public WebElement getSelenRadio() {
        return this.selenRadio;
    }

    public WebElement getDropdownYellow() {
        return this.dropdownYellow;
    }

    public void selectWaterCheckbox() {
        waterCheckbox.click();
    }

    public void selectWindCheckbox() {
        windCheckbox.click();
    }

    public void selectSelenRadio() {
        selenRadio.click();
    }

    public void selectDropdownYellow() {
        dropdownYellow.click();
    }

}
