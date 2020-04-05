package hw4.ex1;

import hw4.base.BaseClass;
import hw4.pages.HomePage;
import hw4.pages.TableWithPages;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ExerciseOne extends BaseClass {

    private HomePage homePage;
    private TableWithPages tableWithPages;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        tableWithPages = new TableWithPages(driver);
    }

    @Test
    public void exerciseOneTest() {

        // 1. Open test site by URL
        homePage.open();

        // 2. Assert Browser title
        assertEquals(homePage.getTitle(), "Home Page");

        // 3. Perform login
        homePage.login(properties.getProperty("username"), properties.getProperty("password"));

        // 4. Assert User name in the left-top side of screen that user is loggined
        assertEquals(homePage.getUserNameText(), "ROMAN IOVLEV");

        // 5. Open through the header menu Service -> Table with pages
        homePage.getHeaderSection().getServiceButton().click();
        homePage.getHeaderSection().getTableWithPages().click();

        // 6. Check that default value for “Show entries” dropdown is 5
        assertEquals(tableWithPages.getDefaultValue().getText(), "5");

        // 7. Select new value for the entries in the dropdown list
        tableWithPages.selectTableEntries("10");

        // 8. Assert that in the table displayed corrected amount of entries
        assertTrue(tableWithPages.getLogRowText().contains("new value=10"));

        // 9. Type in “Search” text field
        tableWithPages.typeSearchField(properties.getProperty("search"));

        // 10. Assert the table contains only records with Search field value
        for (WebElement element : tableWithPages.getTableRows()) {
            System.out.println(element.getText());
            assertTrue(element.getText().contains(properties.getProperty("search")));
        }
    }
}
