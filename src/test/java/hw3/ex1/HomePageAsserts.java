package hw3.ex1;

import hw3.base.AbstractBaseClass;
import hw3.enums.HeaderSectionItems;
import hw3.enums.IconTexts;
import hw3.enums.LeftSectionItems;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        for (WebElement element : homePage.getHeaderSection().getHeaderItems()) {
            sa.assertTrue(element.isDisplayed());
        }
    }

    public void shouldReturnHeaderSectionItemsTexts() {
        List<String> expectedHeaderItemsTexts = Stream.of(HeaderSectionItems.values())
                .map(HeaderSectionItems::getText)
                .collect(Collectors.toList());
        sa.assertEquals(homePage.getHeaderSection().getHeaderItemsTexts(), expectedHeaderItemsTexts);
    }

    public void shouldReturnImagesIndexPage() {
        for (WebElement element : homePage.getImagesIndexPage()) {
            sa.assertTrue(element.isDisplayed());
        }
    }

    public void shouldReturnIconTexts() {
        List<String> expectedIconTexts = Stream.of(IconTexts.values())
                .map(IconTexts::getText)
                .collect(Collectors.toList());
        sa.assertEquals(homePage.getIconText(), expectedIconTexts);
    }

    public void shouldReturnFrame() {
        sa.assertTrue(homePage.getFrame().isDisplayed());
    }

    public void shouldReturnFrameButton() {
        sa.assertTrue(homePage.getFrameButton().isDisplayed());
    }

    public void shouldReturnLeftSectionItems() {
        for (WebElement element : homePage.getLeftSection().getLeftSectionItems()) {
            sa.assertTrue(element.isDisplayed());
        }
    }

    public void shouldReturnLeftSectionItemsTexts() {
        List<String> expectedLeftSectionItems = Stream.of(LeftSectionItems.values())
                .map(LeftSectionItems::getItemText)
                .collect(Collectors.toList());
        sa.assertEquals(homePage.getLeftSection().getLeftSectionItemsTexts(), expectedLeftSectionItems);
    }

    public void softAssertAll() {
        sa.assertAll();
    }

}
