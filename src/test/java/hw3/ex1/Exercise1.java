package hw3.ex1;

import hw3.base.BaseClass;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class Exercise1 extends BaseClass {

    @BeforeMethod
    public void setUp(){
        super.setUp();
    }

    @Test
    public void exerciseOneTest() {
        SoftAssert sa = new SoftAssert();

        // 1. Open test site by URL
        homePageSteps.open();

        // 2. Assert Browser title
        homePageSoftAsserts.shouldReturnPageTitle();

        // 3. Perform login
        homePageSteps.login("" , "");

        // 4. Assert Username is loggined
        homePageSoftAsserts.shouldReturnUsernameText();

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        homePageSoftAsserts.shouldReturnHeaderSectionItems();
        homePageSoftAsserts.shouldReturnHeaderSectionItemsTexts();

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        homePageSoftAsserts.shouldReturnImagesIndexPage();

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePageSoftAsserts.shouldReturnIconTexts();

        // 8. Assert that there is the iframe with “Frame Button” exist
        homePageSoftAsserts.shouldReturnFrame();

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        homePageSteps.switchToFrame();
        homePageSoftAsserts.shouldReturnFrameButton();

        // 10. Switch to original window back
        homePageSteps.switchToOriginalPage();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        homePageSoftAsserts.shouldReturnLeftSectionItems();
        homePageSoftAsserts.shouldReturnLeftSectionItemsTexts();

        homePageSoftAsserts.softAssertAll();

    }

}
