package hw3.voids;

import hw3.composite.HeaderSection;
import hw3.composite.LeftSection;
import org.apache.http.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {

    protected WebDriver driver;
    protected HeaderSection headerSection;
    protected LeftSection leftSection;
    protected DifferentElementsPage differentElementsPage;

    AbstractPage() {

    }

    AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HeaderSection getHeaderSection() {
        return this.headerSection;
    }

    public LeftSection getLeftSection() {
        return this.leftSection;
    }
}
