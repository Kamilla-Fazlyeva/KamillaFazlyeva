package hw3.voids;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class AbstractPage extends AbstractPageComposite{

    private static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";

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

    protected AbstractPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(URL);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getUserName() {
        return userNameText.getText();
    }

    public void switchToFrame() {
        driver.switchTo().frame(iframe);
    }

    public void switchToOriginalPage() {
        driver.switchTo().defaultContent();
    }

}
