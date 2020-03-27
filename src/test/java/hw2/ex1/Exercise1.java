package hw2.ex1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Exercise1 {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void browserTitleTest() {
        SoftAssert sa = new SoftAssert();

        // 1. Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Home Page";

        // 2. Assert Browser title
        sa.assertEquals(actualTitle, expectedTitle);
        sa.assertAll();
    }

    @Test
    public void userLoginTest() {
        SoftAssert sa = new SoftAssert();

        // 3. Perform login
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.cssSelector("#name")).sendKeys("Roman");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();

        WebElement loginUserName = new WebDriverWait(driver,5)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));

        // 4. Assert Username is loggined
        sa.assertEquals(loginUserName.getText(), "ROMAN IOVLEV");
        sa.assertAll();
    }

    //5. Assert that there are 4 items on the header section are displayed and they have proper texts
    @Test
    public void headerSectionItemsTest() {
        SoftAssert sa = new SoftAssert();

        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        List<WebElement> headerItems = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By
                        .xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']/li")));
        List<String> expectedHeaderItemsTexts = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        List<String> actualHeaderItemsTexts = new ArrayList<>();
        for (WebElement element : headerItems) {
            actualHeaderItemsTexts.add(element.getText());
        }

        for (WebElement element : headerItems) {
            sa.assertTrue(element.isDisplayed());
        }
        sa.assertEquals(actualHeaderItemsTexts, expectedHeaderItemsTexts);

        sa.assertAll();
    }

    // 6. Assert that there are 4 images on the Index Page and they are displayed
    @Test
    public void indexPageImagesTest() {
        SoftAssert sa = new SoftAssert();

        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        List<WebElement> images = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='benefit-icon']/span")));

        for (WebElement element : images) {
            sa.assertTrue(element.isDisplayed());
        }

        sa.assertAll();
    }

    // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
    @Test
    public void textUnderIconsTest() {
        SoftAssert sa = new SoftAssert();

        driver.get("https://jdi-testing.github.io/jdi-light/index.html");

        List<WebElement> iconTexts = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("benefit-txt")));
        List<String> expectedIconTexts = Arrays.asList("To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project",
                "To be flexible and\n" +
                        "customizable", "To be multiplatform",
                "Already have good base\n" +
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
        sa.assertAll();
    }

    // 8, 9, 10 steps
    @Test
    public void iframeExistsTest() {
        SoftAssert sa = new SoftAssert();

        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        WebElement iframe = new WebDriverWait(driver,5)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("frame")));

        // 8. Assert that there is the iframe with “Frame Button” exist
        sa.assertTrue(iframe.isDisplayed());

        driver.switchTo().frame(iframe);
        WebElement frameButton = new WebDriverWait(driver,5)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("frame-button")));

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        sa.assertTrue(frameButton.isDisplayed());

        // 10. Switch to original window back
        driver.switchTo().defaultContent();

        sa.assertAll();

    }

    // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
    @Test
    public void leftSectionMenuTest() {
        SoftAssert sa = new SoftAssert();

        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        List<WebElement> leftSectionItems = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@class='sidebar-menu']/li")));
        List<String> actualLeftSectionItems = Arrays.asList("Home", "Contact form", "Service",
                "Metals & Colors", "Elements packs");
        List<String> expectedLeftSectionItems = new ArrayList<>();
        for (WebElement element : leftSectionItems) {
            expectedLeftSectionItems.add(element.getText());
        }

        for (WebElement element : leftSectionItems) {
            sa.assertTrue(element.isDisplayed());
        }

        sa.assertEquals(actualLeftSectionItems, expectedLeftSectionItems);
        sa.assertAll();

    }

    // 12. Close Browser
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
