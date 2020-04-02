package hw3.base;

import hw3.voids.DifferentElementsPage;
import hw3.voids.HomePage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractBaseClass {

    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;

    public AbstractBaseClass(WebDriver driver) {
        this.homePage = new HomePage(driver);
        this.differentElementsPage = new DifferentElementsPage(driver);
    }
}
