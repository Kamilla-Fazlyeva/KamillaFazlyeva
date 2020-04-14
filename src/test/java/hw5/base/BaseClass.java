package hw5.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class BaseClass {

    protected Properties properties;

    protected WebDriver driver;

    @BeforeSuite
    public void suiteSetUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        WebDriverSingleton.INSTANCE.createDriver("chrome");
        driver = WebDriverSingleton.INSTANCE.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        properties = new Properties();
        try(InputStream input = new FileInputStream("src/main/resources/hw3/config.properties")) {
            properties.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 12. Close Browser
    @AfterMethod
    public void tearDown() {
        WebDriverSingleton.INSTANCE.getDriver().quit();
    }
}
