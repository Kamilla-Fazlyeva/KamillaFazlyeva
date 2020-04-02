package hw3.composite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HeaderSection {

    protected WebDriver driver;

    public HeaderSection(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = ".m-l8 > li")
    private List<WebElement> headerItems;

    @FindBy(className = "dropdown-toggle")
    private WebElement serviceButton;

    @FindBy(linkText = "DIFFERENT ELEMENTS")
    private WebElement differentElementsPage;

    public List<WebElement> getHeaderItems() {
        return this.headerItems;
    }

    public List<String> getHeaderItemsTexts() {
        List<String> actualHeaderItemsTexts = new ArrayList<>();
        for (WebElement element : headerItems) {
            actualHeaderItemsTexts.add(element.getText());
        }

        return actualHeaderItemsTexts;
    }

    public WebElement getServiceButton() {
        return this.serviceButton;
    }

    public WebElement getDifferentElementsPage() {
        return this.differentElementsPage;
    }
}
