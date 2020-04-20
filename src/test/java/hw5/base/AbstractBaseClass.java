package hw5.base;

import hw3.voids.DifferentElementsPage;
import hw3.voids.HomePage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractBaseClass {

    protected WebDriver driver;

    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;

    public AbstractBaseClass() {
        driver = WebDriverSingleton.INSTANCE.getDriver();
        homePage = new HomePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
    }
}