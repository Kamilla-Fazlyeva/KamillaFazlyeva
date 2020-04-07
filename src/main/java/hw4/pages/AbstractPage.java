package hw4.pages;

import hw4.composite.HeaderSection;
import hw4.utils.SummarySum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected HeaderSection headerSection;
    protected Properties properties;
    protected SummarySum summarySum;

    AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        headerSection = new HeaderSection(driver);
        summarySum = new SummarySum();

        properties = new Properties();
        try(InputStream input = new FileInputStream("src/main/resources/hw4/config.properties")) {
            properties.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HeaderSection getHeaderSection() {
        return headerSection;
    }

    public SummarySum getSummarySum() {
        return summarySum;
    }
}
