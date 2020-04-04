package hw4.base;

import hw4.pages.HomePage;
import hw4.pages.TableWithPages;
import org.openqa.selenium.WebDriver;

public abstract class AbstractBaseClass {

    protected HomePage homePage;
    protected TableWithPages tableWithPages;

    public AbstractBaseClass(WebDriver driver) {
        homePage = new HomePage(driver);
        tableWithPages = new TableWithPages(driver);
    }
}
