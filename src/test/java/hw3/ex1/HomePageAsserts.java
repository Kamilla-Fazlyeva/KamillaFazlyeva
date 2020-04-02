package hw3.ex1;

import hw3.base.AbstractBaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class HomePageAsserts extends AbstractBaseClass {

    public HomePageAsserts(WebDriver driver) {
        super(driver);
    }

    SoftAssert sa = new SoftAssert();

    public void shouldReturnUsernameText() {
        sa.assertEquals(homePage.getUserNameText(), "ROMAN IOVLEV");
    }

    public void shouldReturnPageTitle() {
        sa.assertEquals(homePage.getTitle(), "Home Page");
    }

    public void shouldReturnHeaderSectionItems() {
        for (WebElement element : headerSection.getHeaderItems()) {
            sa.assertTrue(element.isDisplayed());
        }
    }

    public void shouldReturnHeaderSectionItemsTexts() {
        List<String> expectedHeaderItemsTexts = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        for (WebElement element : headerSection.getHeaderItems()) {
            sa.assertEquals(element.getText(), expectedHeaderItemsTexts);
        }
    }

    public void shouldReturnImagesIndexPage() {
        for (WebElement element : homePage.getImagesIndexPage()) {
            sa.assertTrue(element.isDisplayed());
        }
    }

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

    public void shouldReturnFrame() {
        sa.assertTrue(homePage.getFrame().isDisplayed());
    }

    public void shouldReturnFrameButton() {
        sa.assertTrue(homePage.getFrameButton().isDisplayed());
    }

    public void shouldReturnLeftSectionItems() {
        for (WebElement element : leftSection.getLeftSectionItems()) {
            sa.assertTrue(element.isDisplayed());
        }
    }

    public void shouldReturnLeftSectionItemsTexts() {
        List<String> expectedLeftSectionItems = Arrays.asList("Home", "Contact form", "Service",
                "Metals & Colors", "Elements packs");
        for (WebElement element : leftSection.getLeftSectionItems()) {
            sa.assertEquals(element.getText(), expectedLeftSectionItems);
        }
    }

    public void softAssertAll() {
        sa.assertAll();
    }

}
