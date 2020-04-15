package hw5.ex1;

import hw5.base.AllureScreenshotListener;
import hw5.base.BaseClass;
import hw5.steps.DifferentElementsPageSteps;
import hw5.steps.HomePageSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static hw3.enums.DifferentElements.*;
import static hw3.enums.DifferentElements.YELLOW;

@Listeners({AllureScreenshotListener.class})
public class Exercise2 extends BaseClass {

    private HomePageSteps homePageSteps;
    private DifferentElementsPageSteps differentElementsPageSteps;

    @BeforeMethod
    @Override
    public void setUp(){
        super.setUp();
        homePageSteps = new HomePageSteps();
        differentElementsPageSteps = new DifferentElementsPageSteps();
    }

    @Feature("Test for checking functionality of JDI site")
    @Story("Different Elements page test")
    @Test
    public void exerciseTwoTest() {

        // 1. Open test site by URL
        homePageSteps.open(properties.getProperty("URL"));

        // 2. Assert Browser title
        homePageSteps.shouldReturnPageTitle("Home Page");

        // 3. Perform login
        homePageSteps.login(properties.getProperty("username"), properties.getProperty("password"));

        // 4. Assert User name in the left-top side of screen that user is loggined
        homePageSteps.shouldReturnUsernameText("ROMAN IOVLEV");

        // 5. Open through the header menu Service -> Different Elements Page
        homePageSteps.clickServiceButton();
        homePageSteps.openDifferentElementsPage();

        // 6. Select checkboxes
        differentElementsPageSteps.selectCheckbox(WATER.getValue());
        differentElementsPageSteps.selectCheckbox(WIND.getValue());

        // 7. Select radio
        differentElementsPageSteps.selectRadioButton(SELEN.getValue());

        // 8. Select in dropdown
        differentElementsPageSteps.selectDropdown(YELLOW.getValue());

        // 9.1 Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox
        differentElementsPageSteps.shouldReturnSelectedCheckbox();
        differentElementsPageSteps.shouldReturnLogRowText(WATER.getValue(), "true");
        differentElementsPageSteps.shouldReturnLogRowText(WIND.getValue(), "true");

        // 9.2 Assert that for radio button there is a log row and value is corresponded to the status of radio button
        differentElementsPageSteps.shouldReturnSelectedRadioButton();
        differentElementsPageSteps.shouldReturnLogRowText(METAL.getValue(), SELEN.getValue());

        // 9.3 Assert that for dropdown there is a log row and value is corresponded to the selected value
        differentElementsPageSteps.shouldReturnSelectedDropdown();
        differentElementsPageSteps.shouldReturnLogRowText(COLORS.getValue(), YELLOW.getValue());
    }
}
