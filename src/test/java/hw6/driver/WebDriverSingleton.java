package hw6.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public enum WebDriverSingleton {

    INSTANCE;

    private WebDriver driver;

    public void createdDriver(String browserName) {
        if ("CHROME".equalsIgnoreCase(browserName)) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        }
    }


    public WebDriver getDriver() {
        return driver;
    }

}
