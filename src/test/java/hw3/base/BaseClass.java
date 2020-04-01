package hw3.base;

import hw3.composite.HeaderSection;
import hw3.composite.LeftSection;
import hw3.ex1.HomePageSoftAsserts;
import hw3.ex1.HomePageSteps;
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
    protected DifferentElementsPage differentElementsPage;
    protected HeaderSection headerSection;
    protected LeftSection leftSection;
    protected HomePageSteps homePageSteps;
    protected HomePageSoftAsserts homePageSoftAsserts;

    public BaseClass() {

    }

    public BaseClass(WebDriver driver) {
        driver = new ChromeDriver();
        this.homePage = new HomePage();
        this.differentElementsPage = new DifferentElementsPage();
        this.homePageSteps = new HomePageSteps(driver);
        this.homePageSoftAsserts = new HomePageSoftAsserts(driver);
        this.headerSection = new HeaderSection();
        this.leftSection = new LeftSection();
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
