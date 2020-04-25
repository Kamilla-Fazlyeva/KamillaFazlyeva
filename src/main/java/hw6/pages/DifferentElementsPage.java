package hw6.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DifferentElementsPage extends AbstractPage {

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".label-checkbox")
    private List<WebElement> checkboxes;

    @FindBy(css = ".label-radio")
    private List<WebElement> radioButtons;

    @FindBy(xpath = "//select[@class='uui-form-element']")
    private WebElement dropdownSelect;

    @FindBy(css = ".logs > li")
    private List<WebElement> logRow;

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public List<WebElement> getRadioButtons() {
        return radioButtons;
    }

    public WebElement getDropdownSelect() {
        return dropdownSelect;
    }

    public void selectWebElement(List<WebElement> webElements, String webElementName) {
        for (WebElement element : webElements) {
            if (webElementName.contains(element.getText())) {
                element.click();
            }
        }
    }

    public void selectDropdown(String colorText) {
        Select dropdown = new Select(dropdownSelect);
        dropdown.selectByVisibleText(colorText);
    }

    public List<WebElement> getLogRow() {
        return logRow;
    }

}
