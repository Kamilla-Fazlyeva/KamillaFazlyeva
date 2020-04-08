package hw3.voids;

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

    public void selectCheckbox(String checkboxName) {
       for (WebElement element : checkboxes) {
           if (element.getText().equals(checkboxName)) {
               element.click();
           }
       }
    }

    public void selectRadioButton(String radioButtonName) {
        for (WebElement element : radioButtons) {
            if (element.getText().equals(radioButtonName)) {
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
