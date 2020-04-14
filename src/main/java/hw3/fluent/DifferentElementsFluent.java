package hw3.fluent;

import hw3.voids.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DifferentElementsFluent extends AbstractPage {

    @FindBy(css = ".label-checkbox")
    private List<WebElement> checkboxes;

    @FindBy(css = ".label-radio")
    private List<WebElement> radioButtons;

    @FindBy(css = "select[class='uui-form-element']")
    private WebElement dropdownSelect;

    @FindBy(css = ".logs > li")
    private List<WebElement> logRow;

    public DifferentElementsFluent(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public List<WebElement> getRadioButtons() {
        return radioButtons;
    }

    public DifferentElementsFluent selectWebElement(String text, List<WebElement> elements) {
        for (WebElement element : elements) {
            if (element.getText().equals(text)) {
                element.click();
            }
        }

        return this;
    }

    public DifferentElementsFluent selectDropdown(String colorText) {
        Select dropdown = new Select(dropdownSelect);
        dropdown.selectByVisibleText(colorText);

        return this;
    }

    public List<String> getLogRow() {
        return logRow.stream()
                .map(webElement -> webElement.getText().substring(9))
                .collect(Collectors.toList());
    }
}
