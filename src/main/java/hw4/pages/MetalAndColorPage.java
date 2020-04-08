package hw4.pages;

import hw4.utils.SummarySum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MetalAndColorPage extends AbstractPage {

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

    private SummarySum summarySum;

    public MetalAndColorPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getSummaryRadioButtons() {
        return summaryRadioButtons;
    }

    public List<WebElement> getElementsCheckboxes() {
        return elementsCheckboxes;
    }

    public List<WebElement> getColorAndMetalOptions() {
        return colorAndMetalOptions;
    }

    public List<WebElement> getVegetableCheckboxes() {
        return vegetableCheckboxes;
    }

    public WebElement getColorDropdown() {
        return colorDropdown;
    }

    public WebElement getMetalDropdown() {
        return metalDropdown;
    }

    public WebElement getVegetablesDropdown() {
        return vegetablesDropdown;
    }

    public void selectWebElement(List<WebElement> webElements, List<String> webElementName) {
        for (WebElement element : webElements) {
            if (webElementName.contains(element.getText())) {
                element.click();
            }
        }
    }

    public void uncheckVegetables() {
        for (WebElement element : vegetableCheckboxes) {
            if (element.getText().contains(properties.getProperty("default"))) {
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
