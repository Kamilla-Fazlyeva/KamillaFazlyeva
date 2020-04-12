package hw6.steps;

import hw6.voids.DifferentElementsPage;
import hw6.voids.HomePage;
import hw6.driver.WebDriverSingleton;
import hw6.voids.UserTablePage;

public abstract class AbstractBaseStep {

    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;

    public AbstractBaseStep() {
        homePage = new HomePage(WebDriverSingleton.INSTANCE.getDriver());
        differentElementsPage = new DifferentElementsPage(WebDriverSingleton.INSTANCE.getDriver());
        userTablePage = new UserTablePage(WebDriverSingleton.INSTANCE.getDriver());
    }

}
