package hw3.composite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.stream.Collectors;

public class HeaderSection extends AbstractPageComposite {

    public HeaderSection(WebDriver driver) {
        super(driver);
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
        return headerItems.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public WebElement getServiceButton() {
        return this.serviceButton;
    }

    public WebElement getDifferentElementsPage() {
        return this.differentElementsPage;
    }
}
