package hw4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TableWithPages extends AbstractPage {

    public TableWithPages(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "table-with-pages_length")
    private WebElement tableEntries;

    @FindBy(xpath = "//option[1]")
    private WebElement defaultValue;

    @FindBy(css = ".info-panel-body-log")
    private WebElement logRow;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchField;

    @FindBy(xpath = "//tr//td[2]")
    private List<WebElement> tableRows;

    public WebElement getDefaultValue() {
        return defaultValue;
    }

    public String getLogRowText() {
        return logRow.getText();
    }

    public void selectTableEntries(String entry) {
        Select dropdown = new Select(tableEntries);
        dropdown.selectByVisibleText(entry);
    }

    public void typeSearchField(String search) {
        searchField.sendKeys(search);
    }

    public List<WebElement> getTableRows() {
        return tableRows;
    }
}
