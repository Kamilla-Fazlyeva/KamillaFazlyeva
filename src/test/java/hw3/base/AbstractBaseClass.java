package hw3.base;

import hw3.composite.HeaderSection;
import hw3.composite.LeftSection;
import hw3.ex1.HomePageAsserts;
import hw3.ex1.HomePageSteps;
import hw3.ex2.DifferentElementsAsserts;
import hw3.ex2.DifferentElementsPageSteps;
import hw3.voids.DifferentElementsPage;
import hw3.voids.HomePage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractBaseClass {

    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;
    protected HeaderSection headerSection;
    protected LeftSection leftSection;
    protected HomePageSteps homePageSteps;
    protected HomePageAsserts homePageAsserts;
    protected DifferentElementsPageSteps differentElementsPageSteps;
    protected DifferentElementsAsserts differentElementsAsserts;

    public AbstractBaseClass(WebDriver driver) {
        this.homePage = new HomePage(driver);
        this.differentElementsPage = new DifferentElementsPage(driver);
        this.homePageSteps = new HomePageSteps(driver);
        this.homePageAsserts = new HomePageAsserts(driver);
        this.headerSection = new HeaderSection(driver);
        this.leftSection = new LeftSection(driver);
        this.differentElementsAsserts = new DifferentElementsAsserts(driver);
        this.differentElementsPageSteps = new DifferentElementsPageSteps(driver);
    }
}
