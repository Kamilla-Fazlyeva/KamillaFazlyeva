package hw3.voids;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AbstractPage {

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

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void login(final String username, final String password) {
        userIcon.click();
        userNameTextField.sendKeys(username);
        passwordTextField.sendKeys(password);
        loginButton.click();
    }

    public String getUserNameText() {
        return userNameText.getText();
    }

    public String getTitle() {
        return driver.getTitle();
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

    public void switchToFrame() {
        driver.switchTo().frame(iframe);
    }

    public WebElement  getFrameButton() {
        return this.frameButton;
    }

    public void switchToOriginalPage() {
        driver.switchTo().defaultContent();
    }

}
