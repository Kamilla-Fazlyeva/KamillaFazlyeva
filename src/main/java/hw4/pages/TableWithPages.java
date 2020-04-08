package hw4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TableWithPages extends AbstractPage {

    @FindBy(name = "table-with-pages_length")
    private WebElement tableEntries;

    @FindBy(css = ".info-panel-body-log")
    private WebElement logRow;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchField;

    @FindBy(css = "tbody > tr")
    private List<WebElement> tableRows;

    public TableWithPages(WebDriver driver) {
        super(driver);
    }

    public String getLogRowText() {
        return logRow.getText();
    }

    public String getTableEntriesText() {
        Select defaultValue = new Select(tableEntries);
        return defaultValue.getFirstSelectedOption().getText();
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
