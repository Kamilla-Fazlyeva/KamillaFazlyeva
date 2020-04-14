package hw3.fluent;

import hw3.voids.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HomePageFluent extends AbstractPage {

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement userNameTextField;

    @FindBy(id = "password")
    private WebElement passwordTextField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement userNameText;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> imagesIndexPage;

    @FindBy(className = "benefit-txt")
    private List<WebElement> iconTexts;

    @FindBy(id = "frame")
    private WebElement iframe;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    @FindBy(css = ".m-l8 > li")
    private List<WebElement> headerItems;

    @FindBy(className = "dropdown-toggle")
    private WebElement serviceButton;

    @FindBy(linkText = "DIFFERENT ELEMENTS")
    private WebElement differentElementsPage;

    @FindBy(css = ".sidebar-menu > li")
    private List<WebElement> leftSectionItems;

    public HomePageFluent(WebDriver driver) {
        super(driver);
    }

    public HomePageFluent clickUserIcon() {
        userIcon.click();
        return this;
    }

    public HomePageFluent setUsername(final String username) {
        userNameTextField.sendKeys(username);
        return this;
    }

    public HomePageFluent setPassword(final String password) {
        passwordTextField.sendKeys(password);
        return this;
    }

    public HomePageFluent clickLoginButton() {
        loginButton.click();
        return this;
    }

    public String getUserNameText() {
        return userNameText.getText();
    }

    public List<WebElement> getHeaderItems() {
        return this.headerItems;
    }

    public List<String> getHeaderItemsTexts() {
        return headerItems.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<WebElement> getImagesIndexPage() {
        return this.imagesIndexPage;
    }

    public List<String> getIconText() {
        List<String> iconItemsTexts = new ArrayList<>();
        for (WebElement element : iconTexts) {
            iconItemsTexts.add(element.getText().replaceAll("\n", " "));
        }
        return iconItemsTexts;
    }

    public WebElement getFrame() {
        return this.iframe;
    }

    public HomePageFluent switchToFrame() {
        driver.switchTo().frame(iframe);
        return this;
    }

    public WebElement  getFrameButton() {
        return this.frameButton;
    }

    public HomePageFluent switchToOriginalPage() {
        driver.switchTo().defaultContent();
        return this;
    }

    public HomePageFluent clickServiceButton() {
        serviceButton.click();
        return this;
    }

    public DifferentElementsFluent clickDifferentElementsPage() {
        differentElementsPage.click();
        return new DifferentElementsFluent(driver);
    }

    public List<WebElement> getLeftSectionItems() {
        return leftSectionItems;
    }

    public List<String> getLeftSectionItemsTexts() {
        return leftSectionItems.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
