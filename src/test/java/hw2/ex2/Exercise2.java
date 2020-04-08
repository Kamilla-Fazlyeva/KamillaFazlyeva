package hw2.ex2;

import hw2.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Exercise2 extends BaseClass {

    @Test
    public void exerciseTwoTest() {

        // 1. Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Home Page";

        // 2. Assert Browser title
        assertEquals(actualTitle, expectedTitle);

        // 3. Perform login
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();

        WebElement loginUserName = driver.findElement(By.id("user-name"));

        // 4. Assert User name in the left-top side of screen that user is loggined
        assertEquals(loginUserName.getText(), "ROMAN IOVLEV");

        // 5. Open through the header menu Service -> Different Elements Page
        WebElement serviceButton = driver.findElement(By.className("dropdown-toggle"));
        serviceButton.click();

        WebElement differentElementsPage = driver.findElement(By
                .linkText("DIFFERENT ELEMENTS"));
        differentElementsPage.click();

        // 6. Select checkboxes
        WebElement waterCheckbox = driver.findElement(By
                .xpath("//label[@class='label-checkbox' and contains(.,'Water')]//input"));
        if (!waterCheckbox.isSelected()) {
            waterCheckbox.click();
        }
        WebElement windCheckbox = driver.findElement(By
                .xpath("//label[@class='label-checkbox' and contains(., 'Wind')]//input"));
        if (!windCheckbox.isSelected()) {
            windCheckbox.click();
        }

        // 7. Select radio
        WebElement selenRadio = driver.findElement(By
                .xpath("//label[@class='label-radio' and contains(., 'Selen')]//input"));
        if (!selenRadio.isSelected()) {
            selenRadio.click();
        }

        // 8. Select in dropdown
        WebElement dropdownYellow = driver.findElement(By
                .xpath("//select[@class='uui-form-element' and contains(., 'Yellow')]//input"));
        dropdownYellow.click();

        // 9.1 Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox
        assertTrue(waterCheckbox.isSelected());
        WebElement logWaterCheckbox = driver.findElement(By.xpath("//li[contains(., 'Water')]"));
        assertTrue(logWaterCheckbox.getText().contains("Water"));

        assertTrue(windCheckbox.isSelected());
        WebElement logWindCheckbox = driver.findElement(By.xpath("//li[contains(., 'Wind')]"));
        assertTrue(logWindCheckbox.getText().contains("Wind"));

        // 9.2 Assert that for radio button there is a log row and value is corresponded to the status of radio button
        assertTrue(selenRadio.isSelected());
        WebElement logSelenRadio = driver.findElement(By.xpath("//li[contains(., 'Selen')]"));
        assertTrue(logSelenRadio.getText().contains("Selen"));

        // 9.3 Assert that for dropdown there is a log row and value is corresponded to the selected value
        assertTrue(dropdownYellow.isSelected());
        WebElement logdropdownYellow = driver.findElement(By.xpath("//li[contains(., 'Yellow')]"));
        assertTrue(logdropdownYellow.getText().contains("Yellow"));

    }
}
