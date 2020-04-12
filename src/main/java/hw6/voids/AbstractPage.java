package hw6.voids;

import hw6.composite.HeaderSection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected HeaderSection headerSection;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        headerSection = new HeaderSection(driver);
    }

    public HeaderSection getHeaderSection() {
        return headerSection;
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
