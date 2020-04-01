package hw3.ex2;

import hw3.base.BaseClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exercise2 extends BaseClass {

    @BeforeMethod
    public void setUp(){
        super.setUp();
    }

    @Test
    public void exerciseTwoTest() {

        // 1. Open test site by URL
        homePageSteps.open();

        // 2. Assert Browser title
        homePageSoftAsserts.shouldReturnPageTitle();

        // 3. Perform login
        homePageSteps.login("" , "");

        // 4. Assert User name in the left-top side of screen that user is loggined
        homePageSoftAsserts.shouldReturnUsernameText();

        // 5. Open through the header menu Service -> Different Elements Page
        homePageSteps.clickServiceButton();
        homePageSteps.openDifferentElementsPage();

        // 6. Select checkboxes
        differentElementsPageSteps.clickWaterCheckbox();
        differentElementsPageSteps.clickWindCheckbox();

        // 7. Select radio
        differentElementsPageSteps.clickSelenRadioCheckbox();

        // 8. Select in dropdown
        differentElementsPageSteps.clickDropdownYellow();

        // 9.1 Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox
        differentElementsAsserts.shouldReturnWaterCheckbox();
        differentElementsAsserts.shouldReturnWaterCheckboxText();

        differentElementsAsserts.shouldReturnWindCheckbox();
        differentElementsAsserts.shouldReturnWindCheckboxText();

        // 9.2 Assert that for radio button there is a log row and value is corresponded to the status of radio button
        differentElementsAsserts.shouldReturnSelenRadio();
        differentElementsAsserts.shouldReturnSelenRadioText();

        // 9.3 Assert that for dropdown there is a log row and value is corresponded to the selected value
        differentElementsAsserts.shouldReturnDropdownYellow();
        differentElementsAsserts.shouldReturnDropdownYellowText();
    }
}
