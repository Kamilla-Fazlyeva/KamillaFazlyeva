package hw6.steps;

import hw6.voids.HomePage;
import hw6.driver.WebDriverSingleton;
import io.cucumber.java.en.Given;

public class ModalStep extends AbstractBaseStep {

    @Given("I open JDI GitHub site")
    public void iOpenJDISite() {
        WebDriverSingleton.INSTANCE.createdDriver("chrome");
        homePage = new HomePage(WebDriverSingleton.INSTANCE.getDriver());
        homePage.open();
    }
}
