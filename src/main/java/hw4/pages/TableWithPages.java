package hw4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TableWithPages extends AbstractPage {

    public TableWithPages(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//option[1]")
    private WebElement defaultValue;

    @FindBy(xpath = "//option[2]")
    private WebElement selectedValue;

    @FindBy(xpath = "//li[contains(text(), 'new value=10')]")
    private WebElement logRowSelectedValue;

    @FindBy(xpath = "//li[contains(text(), 'junit')]")
    private WebElement logRowSearchJunit;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchField;

    public WebElement getDefaultValue() {
        return this.defaultValue;
    }

    public WebElement getSelectedValue() {
        return this.selectedValue;
    }

    public WebElement getLogRowSelectedValue() {
        return logRowSelectedValue;
    }

    public WebElement getLogRowSearchJunit() {
        return logRowSearchJunit;
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public void typeSearchField(String search) {
        searchField.sendKeys(search);
    }
}
