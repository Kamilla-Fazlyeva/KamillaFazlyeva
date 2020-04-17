package hwjdi;

import com.fasterxml.jackson.databind.ObjectMapper;
import hwjdi.entities.MetalsAndColors;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.HashMap;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static hwjdi.entities.User.*;

public class MetalsAndColorsJdiTest {

    protected MetalsAndColors metalsAndColors;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        initElements(JdiSite.class);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        killAllSeleniumDrivers();
    }

    @DataProvider
    public Object[] testData() {
        return getTestData();
    }

    public Object[] getTestData() {
        ObjectMapper objectMapper = new ObjectMapper();

        try(FileReader fileReader = new FileReader("src/test/resources/hwjdi/JDI_ex8_metalsColorsDataSet.json")) {
            return objectMapper.readValue(fileReader, HashMap.class).values().toArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Object[]{};
    }

    @Test(dataProvider = "testData")
    public void jdiLoginTest() {
        JdiSite.openHomePage();
        JdiSite.jdiHomePage.login(ROMAN);
        JdiSite.jdiHomePage.userName.is().text(ROMAN.getFullName());

        JdiSite.metalsAndColorsPage.open();
        JdiSite.metalsAndColorsPage.setValues(metalsAndColors);
    }
}
