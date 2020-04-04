package hw3.ex2;

import hw3.base.BaseClass;
import hw3.ex1.HomePageAsserts;
import hw3.ex1.HomePageSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exercise2 extends BaseClass {

    private HomePageSteps homePageSteps;
    private HomePageAsserts homePageAsserts;
    private DifferentElementsPageSteps differentElementsPageSteps;
    private DifferentElementsAsserts differentElementsAsserts;

    @BeforeMethod
    @Override
    public void setUp(){
        super.setUp();
        homePageSteps = new HomePageSteps(driver);
        homePageAsserts = new HomePageAsserts(driver);
        differentElementsPageSteps = new DifferentElementsPageSteps(driver);
        differentElementsAsserts = new DifferentElementsAsserts(driver);
    }

    @Test
    public void exerciseTwoTest() {

        // 1. Open test site by URL
        homePageSteps.open();

        // 2. Assert Browser title
        homePageAsserts.shouldReturnPageTitle();

        // 3. Perform login
        homePageSteps.login(properties.getProperty("username"), properties.getProperty("password"));

        // 4. Assert User name in the left-top side of screen that user is loggined
        homePageAsserts.shouldReturnUsernameText();

        // 5. Open through the header menu Service -> Different Elements Page
        homePageSteps.clickServiceButton();
        homePageSteps.openDifferentElementsPage();

        // 6. Select checkboxes
        differentElementsPageSteps.selectCheckbox("Water");
        differentElementsPageSteps.selectCheckbox("Wind");

        // 7. Select radio
        differentElementsPageSteps.selectRadioButton("Selen");

        // 8. Select in dropdown
        differentElementsPageSteps.selectDropdown("Yellow");

        // 9.1 Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox
        differentElementsAsserts.shouldReturnSelectedCheckbox();
        differentElementsAsserts.shouldReturnLogRowText("Water: condition changed to true");

        // 9.2 Assert that for radio button there is a log row and value is corresponded to the status of radio button
        differentElementsAsserts.shouldReturnSelectedRadioButton();
        differentElementsAsserts.shouldReturnLogRowText("Wind: condition changed to true");

        // 9.3 Assert that for dropdown there is a log row and value is corresponded to the selected value
        differentElementsAsserts.shouldReturnSelectedDropdown();
        differentElementsAsserts.shouldReturnLogRowText("Colors: value changed to Yellow");
    }
}
