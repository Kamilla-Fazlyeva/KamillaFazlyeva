package hw2.ex2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class Exercise2 {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void exerciseOneTest() {

        // 1. Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Home Page";

        // 2. Assert Browser title
        assertEquals(actualTitle, expectedTitle);

        // 3. Perform login
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.cssSelector("#name")).sendKeys("Roman");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();

        WebElement loginUserName = driver.findElement(By.id("user-name"));

        // 4. Assert User name in the left-top side of screen that user is loggined
        assertEquals(loginUserName.getText(), "ROMAN IOVLEV");

        // 5. Open through the header menu Service -> Different Elements Page
        WebElement serviceButton = driver.findElement(By.className("dropdown-toggle"));
        serviceButton.click();

        WebElement differentElementsPage = driver.findElement(By
                .xpath("//a[contains(text(), 'Different elements')]"));
        differentElementsPage.click();

        // 6. Select checkboxes
        WebElement waterCheckbox = driver.findElement(By
                .xpath("//label[@class='label-checkbox' and contains(.,'Water')]"));
        if (!waterCheckbox.isSelected()) {
            waterCheckbox.click();
        }
        WebElement windCheckbox = driver.findElement(By
                .xpath("//label[@class='label-checkbox' and contains(., 'Wind')]"));
        if (!windCheckbox.isSelected()) {
            windCheckbox.click();
        }

        // 7. Select radio
        WebElement selenRadio = driver.findElement(By
                .xpath("//label[@class='label-radio' and contains(., 'Selen')]"));
        if (!selenRadio.isSelected()) {
            selenRadio.click();
        }

        // 8. Select in dropdown
        WebElement dropdownYellow = driver.findElement(By
                .xpath("//select[@class='uui-form-element' and contains(., 'Yellow')]"));
        dropdownYellow.click();

        // 9.1 Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox
        assertTrue(waterCheckbox.getText().contains("Water"));
        assertFalse(waterCheckbox.isSelected());

        assertTrue(windCheckbox.getText().contains("Wind"));
        assertFalse(windCheckbox.isSelected());

        // 9.2 Assert that for radio button there is a log row and value is corresponded to the status of radio button
        assertTrue(selenRadio.getText().contains("Selen"));
        assertFalse(selenRadio.isSelected());

        // 9.3 Assert that for dropdown there is a log row and value is corresponded to the selected value
        assertTrue(dropdownYellow.getText().contains("Yellow"));
        assertFalse(dropdownYellow.isSelected());

    }

    // 10. Close Browser
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
