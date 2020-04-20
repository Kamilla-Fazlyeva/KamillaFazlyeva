package hw2.ex1;

import hw2.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise1 extends BaseClass {

    @Test
    public void exerciseOneTest() {
        SoftAssert sa = new SoftAssert();

        // 1. Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Home Page";

        // 2. Assert Browser title
        sa.assertEquals(actualTitle, expectedTitle);

        // 3. Perform login
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();

        WebElement loginUserName = driver.findElement(By.id("user-name"));

        // 4. Assert Username is loggined
        sa.assertEquals(loginUserName.getText(), "ROMAN IOVLEV");

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts

        List<WebElement> headerItems = driver.findElements(By
                .cssSelector(".m-l8 > li"));
        List<String> expectedHeaderItemsTexts = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        List<String> actualHeaderItemsTexts = new ArrayList<>();
        for (WebElement element : headerItems) {
            actualHeaderItemsTexts.add(element.getText());
        }

        for (WebElement element : headerItems) {
            sa.assertTrue(element.isDisplayed());
        }
        sa.assertEquals(actualHeaderItemsTexts, expectedHeaderItemsTexts);

        // 6. Assert that there are 4 images on the Index Page and they are displayed

        List<WebElement> images = driver.findElements(By.cssSelector(".benefit-icon"));

        for (WebElement element : images) {
            sa.assertTrue(element.isDisplayed());
        }

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text

        List<WebElement> iconTexts = driver.findElements(By.className("benefit-txt"));
        List<String> expectedIconTexts = Arrays.asList("To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project",
                "To be flexible and\n" +
                        "customizable", "To be multiplatform",
                "Already have good hw5.base\n"+
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…");
        List<String> actualIconTexts = new ArrayList<>();

        for (WebElement element : iconTexts) {
            actualIconTexts.add(element.getText());
        }

        for (WebElement element : iconTexts) {
            sa.assertTrue(element.isDisplayed());
        }

        sa.assertEquals(actualIconTexts, expectedIconTexts);

        // 8, 9, 10 hw5.steps

        WebElement iframe = driver.findElement(By.id("frame"));

        // 8. Assert that there is the iframe with “Frame Button” exist
        sa.assertTrue(iframe.isDisplayed());

        driver.switchTo().frame(iframe);
        WebElement frameButton = driver.findElement(By.id("frame-button"));

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        sa.assertTrue(frameButton.isDisplayed());

        // 10. Switch to original window back
        driver.switchTo().defaultContent();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text

        List<WebElement> leftSectionItems = driver.findElements(By.cssSelector(".sidebar-menu > li"));
        List<String> expectedLeftSectionItems = Arrays.asList("Home", "Contact form", "Service",
                "Metals & Colors", "Elements packs");
        List<String> actualLeftSectionItems = new ArrayList<>();
        for (WebElement element : leftSectionItems) {
            actualLeftSectionItems.add(element.getText());
        }

        for (WebElement element : leftSectionItems) {
            sa.assertTrue(element.isDisplayed());
        }

        sa.assertEquals(actualLeftSectionItems, expectedLeftSectionItems);

        sa.assertAll();
    }

}