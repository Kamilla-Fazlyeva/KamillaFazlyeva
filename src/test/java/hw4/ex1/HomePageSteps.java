package hw4.ex1;

import hw4.base.AbstractBaseClass;
import org.openqa.selenium.WebDriver;

public class HomePageSteps extends AbstractBaseClass {

    public HomePageSteps(WebDriver driver) {
        super(driver);
    }

    public void open() {
        homePage.open();
    }

    public void login(final String username, final String password) {
        homePage.login(username, password);
    }

    public void clickServiceButton() {
        homePage.getHeaderSection().getServiceButton().click();
    }

    public void openTableWithPages() {
        homePage.getHeaderSection().getTableWithPages().click();
    }
}
