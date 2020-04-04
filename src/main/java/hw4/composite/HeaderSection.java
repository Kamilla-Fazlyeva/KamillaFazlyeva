package hw4.composite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HeaderSection {

    protected WebDriver driver;

    public HeaderSection(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".m-l8 > li")
    private List<WebElement> headerItems;

    @FindBy(className = "dropdown-toggle")
    private WebElement serviceButton;

    @FindBy(linkText = "TABLE WITH PAGES")
    private WebElement tableWithPages;

    public List<WebElement> getHeaderItems() {
        return this.headerItems;
    }

    public WebElement getServiceButton() {
        return this.serviceButton;
    }

    public WebElement getTableWithPages() {
        return this.tableWithPages;
    }
}
