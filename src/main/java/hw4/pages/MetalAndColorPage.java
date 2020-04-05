package hw4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MetalAndColorPage extends AbstractPage {

    public MetalAndColorPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "p.radio > label")
    private List<WebElement> summaryRadioButtons;

    @FindBy(css = "p.checkbox > label")
    private List<WebElement> elementsCheckboxes;

    @FindBy(css = "button[title='Colors']")
    private WebElement colorDropdown;

    @FindBy(xpath = "//button[@title='Metals']//span[2]")
    private WebElement metalDropdown;

    @FindBy(xpath = "//ul[@class='dropdown-menu inner selectpicker']//li")
    private List<WebElement> colorAndMetalOptions;

    @FindBy(xpath = "//button[@class='btn btn-default dropdown-toggle']")
    private WebElement vegetablesDropdown;

    @FindBy(css = ".dropdown-menu > li > a > label")
    private List<WebElement> vegetableCheckboxes;

    @FindBy(css = "#submit-button")
    private WebElement submitButton;

    @FindBy(xpath = "//ul[@class='panel-body-list results']//li")
    private List<WebElement> results;

    public void selectSummaryRadioButtons(List<String> summaryRadioButtonName) {
        for (WebElement element : summaryRadioButtons) {
            if (summaryRadioButtonName.contains(element.getText())) {
                element.click();
            }
        }
    }

    public void selectElementsCheckbox(List<String> elementsName) {
        for (WebElement element : elementsCheckboxes) {
            if (elementsName.contains(element.getText())) {
                element.click();
            }
        }
    }

    public void clickColorDropdown() {
        colorDropdown.click();
    }

    public void selectColorDropdown(String colorText) {
        for (WebElement element : colorAndMetalOptions) {
            if (element.getText().equals(colorText)) {
                element.click();
            }
        }
    }

    public void clickMetalDropdown() {
        metalDropdown.click();
    }

    public void selectMetalDropdown(String metalText) {
        for (WebElement element : colorAndMetalOptions) {
            if (element.getText().equals(metalText)) {
                element.click();
            }
        }
    }

    public void clickVegetablesDropdown() {
        vegetablesDropdown.click();
    }

    public void selectVegetablesCheckbox(List<String> vegetablesText) {
        for (WebElement element : vegetableCheckboxes) {
            if (vegetablesText.contains(element.getText())) {
                element.click();
            }
        }
    }

    public void uncheckVegetables() {
        for (WebElement element : vegetableCheckboxes) {
            if (element.getText().contains("Vegetables")) {
                element.click();
            }
        }
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public List<WebElement> getResults() {
        return results;
    }
}
