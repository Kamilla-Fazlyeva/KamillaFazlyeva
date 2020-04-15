package hw5.ex1;

import hw3.enums.HeaderSectionItems;
import hw3.enums.IconTexts;
import hw5.base.AllureScreenshotListener;
import hw5.base.BaseClass;
import hw5.steps.HomePageSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Listeners({AllureScreenshotListener.class})
public class Exercise1 extends BaseClass {

    private HomePageSteps homePageSteps;

    @BeforeMethod
    @Override
    public void setUp(){
        super.setUp();
        homePageSteps = new HomePageSteps();
    }

    @Feature("Test for checking functionality of JDI site")
    @Story("Home page test")
    @Test
    public void exerciseOneTest() {
        SoftAssert sa = new SoftAssert();

        // 1. Open test site by URL
        homePageSteps.open(properties.getProperty("URL"));

        // 2. Assert Browser title
        homePageSteps.shouldReturnPageTitle("Home Page");

        // 3. Perform login
        homePageSteps.login(properties.getProperty("username"), properties.getProperty("password"));

        // 4. Assert Username is loggined
        homePageSteps.shouldReturnUsernameText("ROMAN IOVLEV");

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        homePageSteps.shouldReturnHeaderSectionItems();
        homePageSteps.shouldReturnHeaderSectionItemsTexts(Stream.of(HeaderSectionItems.values())
                .map(HeaderSectionItems::getText)
                .collect(Collectors.toList()));

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        homePageSteps.shouldReturnImagesIndexPage();

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePageSteps.shouldReturnIconTexts(Stream.of(IconTexts.values())
                .map(IconTexts::getText)
                .collect(Collectors.toList()));

        // 8. Assert that there is the iframe with “Frame Button” exist
        homePageSteps.shouldReturnFrame();

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        homePageSteps.switchToFrame();
        homePageSteps.shouldReturnFrameButton();

        // 10. Switch to original window back
        homePageSteps.switchToOriginalPage();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        homePageSteps.shouldReturnLeftSectionItems();
        homePageSteps.shouldReturnLeftSectionItemsTexts();

        homePageSteps.softAssertAll();

    }
}
