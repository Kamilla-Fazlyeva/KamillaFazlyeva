package hw3.ex2;

import hw3.base.BaseClass;
import hw3.enums.LogRowTexts;
import hw3.fluent.DifferentElementsFluent;
import hw3.fluent.HomePageFluent;
import org.testng.annotations.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static hw3.enums.DifferentElements.*;
import static org.testng.Assert.assertEquals;

public class Exercise2Fluent extends BaseClass {

    @Test
    public void exerciseTwoFluent() {

        HomePageFluent homePageFluent = new HomePageFluent(driver);
        DifferentElementsFluent differentElementsFluent = new DifferentElementsFluent(driver);
        driver.get(properties.getProperty("URL"));

        assertEquals(driver.getTitle(), "Home Page");

        homePageFluent.clickUserIcon()
                .setUsername(properties.getProperty("username"))
                .setPassword(properties.getProperty("password"))
                .clickLoginButton();

        assertEquals(homePageFluent.getUserNameText(), "ROMAN IOVLEV");

        homePageFluent.clickServiceButton()
                .clickDifferentElementsPage()
                .selectWebElement(WATER.getValue(), differentElementsFluent.getCheckboxes())
                .selectWebElement(WIND.getValue(), differentElementsFluent.getCheckboxes())
                .selectWebElement(SELEN.getValue(), differentElementsFluent.getRadioButtons())
                .selectDropdown(YELLOW.getValue());

        System.out.println(differentElementsFluent.getLogRow());
        assertEquals(differentElementsFluent.getLogRow(),
                Stream.of(LogRowTexts.values())
                        .map(LogRowTexts::getLogText)
                        .collect(Collectors.toList()));
    }
}
