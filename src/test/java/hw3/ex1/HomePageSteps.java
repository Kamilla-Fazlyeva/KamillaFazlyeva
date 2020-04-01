package hw3.ex1;


import hw3.base.BaseClass;
import org.openqa.selenium.WebDriver;

public class HomePageSteps extends BaseClass {

    public HomePageSteps(WebDriver driver) {
        super(driver);
    }

    public void open() {
        homePage.open();
    }

    public void login(final String username, final String password) {
        homePage.login(username, password);
    }

    public void switchToFrame() {
        homePage.switchToFrame();
    }

    public void switchToOriginalPage() {
        homePage.switchToOriginalPage();
    }

    public void clickServiceButton() {
        homePage.getHeaderSection().getServiceButton().click();
    }

    public void openDifferentElementsPage() {
        homePage.getHeaderSection().getDifferentElementsPage().click();
    }
}
