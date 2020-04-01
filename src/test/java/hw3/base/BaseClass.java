package hw3.base;

import hw3.composite.HeaderSection;
import hw3.composite.LeftSection;
import hw3.voids.DifferentElementsPage;
import hw3.voids.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    protected WebDriver driver;

    protected HomePage homePage;

    protected HeaderSection headerSection;

    protected LeftSection leftSection;

    protected DifferentElementsPage differentElementsPage;

    public BaseClass() {

    }

    public BaseClass(WebDriver driver) {
        driver = new ChromeDriver();
        this.homePage = new HomePage();
    }

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }

    // 12. Close Browser
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
