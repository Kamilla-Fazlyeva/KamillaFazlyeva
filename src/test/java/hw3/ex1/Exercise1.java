package hw3.ex1;

import hw3.base.BaseClass;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class Exercise1 extends BaseClass {

    private HomePageSteps homePageSteps;
    private HomePageAsserts homePageAsserts;

    @BeforeMethod
    public void setUp(){
        super.setUp();
        homePageSteps = new HomePageSteps(driver);
        homePageAsserts = new HomePageAsserts(driver);
    }

    @Test
    public void exerciseOneTest() {
        SoftAssert sa = new SoftAssert();

        // 1. Open test site by URL
        homePageSteps.open();

        // 2. Assert Browser title
        homePageAsserts.shouldReturnPageTitle();

        // 3. Perform login
        homePageSteps.login(properties.getProperty("username"), properties.getProperty("password"));

        // 4. Assert Username is loggined
        homePageAsserts.shouldReturnUsernameText();

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        homePageAsserts.shouldReturnHeaderSectionItems();
        homePageAsserts.shouldReturnHeaderSectionItemsTexts();

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        homePageAsserts.shouldReturnImagesIndexPage();

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePageAsserts.shouldReturnIconTexts();

        // 8. Assert that there is the iframe with “Frame Button” exist
        homePageAsserts.shouldReturnFrame();

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        homePageSteps.switchToFrame();
        homePageAsserts.shouldReturnFrameButton();

        // 10. Switch to original window back
        homePageSteps.switchToOriginalPage();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        homePageAsserts.shouldReturnLeftSectionItems();
        homePageAsserts.shouldReturnLeftSectionItemsTexts();

        homePageAsserts.softAssertAll();

    }

}
