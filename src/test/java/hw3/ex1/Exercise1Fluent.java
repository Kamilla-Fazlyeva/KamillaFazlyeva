package hw3.ex1;

import hw3.enums.HeaderSectionItems;
import hw3.enums.IconTexts;
import hw3.enums.LeftSectionItems;
import hw3.fluent.HomePageFluent;
import hw5.base.BaseClass;
import org.testng.annotations.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise1Fluent extends BaseClass {

    @Test
    public void exerciseOneFluent() {

        HomePageFluent homePageFluent = new HomePageFluent(driver);

        driver.get(properties.getProperty("URL"));

        assertEquals(driver.getTitle(), "Home Page");

        homePageFluent.clickUserIcon()
                .setUsername(properties.getProperty("username"))
                .setPassword(properties.getProperty("password"))
                .clickLoginButton();

        assertEquals(homePageFluent.getUserNameText(), "ROMAN IOVLEV");

        homePageFluent.getHeaderItems().forEach(webElement -> assertTrue(webElement.isDisplayed()));

        assertEquals(homePageFluent.getHeaderItemsTexts(),
                Stream.of(HeaderSectionItems.values())
                        .map(HeaderSectionItems::getText)
                        .collect(Collectors.toList()));

        homePageFluent.getImagesIndexPage().forEach(webElement -> assertTrue(webElement.isDisplayed()));

        assertEquals(homePageFluent.getIconText(),
                Stream.of(IconTexts.values())
                        .map(IconTexts::getText)
                        .collect(Collectors.toList()));

        assertTrue(homePageFluent.getFrame().isDisplayed());
        homePageFluent.switchToFrame();
        assertTrue(homePageFluent.getFrameButton().isDisplayed());

        homePageFluent.switchToOriginalPage();

        homePageFluent.getLeftSectionItems().forEach(webElement -> assertTrue(webElement.isDisplayed()));
        assertEquals(homePageFluent.getLeftSectionItemsTexts(),
                Stream.of(LeftSectionItems.values())
                        .map(LeftSectionItems::getItemText)
                        .collect(Collectors.toList()));

    }
}
