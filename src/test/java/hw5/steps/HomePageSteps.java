package hw5.steps;

import hw5.base.AbstractBaseClass;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

public class HomePageSteps extends AbstractBaseClass {

    SoftAssert sa = new SoftAssert();

    public HomePageSteps() {
        super();
    }

    @Step("I open JDI site}")
    public void open() {
        homePage.open();
    }

    @Step("Page title should be '{0}'")
    public void shouldReturnPageTitle(String expectedTitle) {
        sa.assertEquals(homePage.getTitle(), expectedTitle);
    }

    @Step("I login as '{0}' and password '{1}'")
    public void login(final String username, final String password) {
        homePage.login(username, password);
    }

    @Step("Username should be '{0}'")
    public void shouldReturnUsernameText(String expectedUsername) {
        sa.assertEquals(homePage.getUserNameText(), expectedUsername);
    }

    @Step("Header sections items should be displayed")
    public void shouldReturnHeaderSectionItems() {
        for (WebElement element : homePage.getHeaderSection().getHeaderItems()) {
            sa.assertTrue(element.isDisplayed());
        }
    }

    @Step("Texts should be displayed on the header section")
    public void shouldReturnHeaderSectionItemsTexts() {
        List<String> expectedHeaderItemsTexts = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        sa.assertEquals(homePage.getHeaderSection().getHeaderItemsTexts(), expectedHeaderItemsTexts);
    }

    @Step("Icons on the home page should be displayed")
    public void shouldReturnImagesIndexPage() {
        for (WebElement element : homePage.getImagesIndexPage()) {
            sa.assertTrue(element.isDisplayed());
        }
    }

    @Step("Texts should be displayed under the icons")
    public void shouldReturnIconTexts() {
        List<String> expectedIconTexts = Arrays.asList("To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project",
                "To be flexible and\n" +
                        "customizable", "To be multiplatform",
                "Already have good base\n"+
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…");
        sa.assertEquals(homePage.getIconText(), expectedIconTexts);
    }

    @Step("Frame should be displayed on the page")
    public void shouldReturnFrame() {
        sa.assertTrue(homePage.getFrame().isDisplayed());
    }

    @Step("I switch to frame")
    public void switchToFrame() {
        homePage.switchToFrame();
    }

    @Step("Frame button should be displayed")
    public void shouldReturnFrameButton() {
        sa.assertTrue(homePage.getFrameButton().isDisplayed());
    }

    @Step("I switch back to the home page")
    public void switchToOriginalPage() {
        homePage.switchToOriginalPage();
    }

    @Step("Left Section items should be displayed")
    public void shouldReturnLeftSectionItems() {
        for (WebElement element : homePage.getLeftSection().getLeftSectionItems()) {
            sa.assertTrue(element.isDisplayed());
        }
    }

    @Step("Texts should be displayed on the left section")
    public void shouldReturnLeftSectionItemsTexts() {
        List<String> expectedLeftSectionItems = Arrays.asList("Home", "Contact form", "Service",
                "Metals & Colors", "Elements packs");
        sa.assertEquals(homePage.getLeftSection().getLeftSectionItemsTexts(), expectedLeftSectionItems);
    }

    @Step("I click Service button")
    public void clickServiceButton() {
        homePage.getHeaderSection().getServiceButton().click();
    }

    @Step("I open Different Elements page")
    public void openDifferentElementsPage() {
        homePage.getHeaderSection().getDifferentElementsPage().click();
    }

    public void softAssertAll() {
        sa.assertAll();
    }
}
