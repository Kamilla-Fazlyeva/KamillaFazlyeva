package hw3.voids;

import hw3.composite.HeaderSection;
import hw3.composite.LeftSection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected HeaderSection headerSection;
    protected LeftSection leftSection;

    AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        headerSection = new HeaderSection(driver);
        leftSection = new LeftSection(driver);
    }

    public HeaderSection getHeaderSection() {
        return headerSection;
    }

    public LeftSection getLeftSection() {
        return leftSection;
    }
}
