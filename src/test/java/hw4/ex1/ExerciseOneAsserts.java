package hw4.ex1;

import hw4.base.AbstractBaseClass;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ExerciseOneAsserts extends AbstractBaseClass {

    public ExerciseOneAsserts(WebDriver driver) {
        super(driver);
    }

    public void shouldReturnUsernameText() {
        assertEquals(homePage.getUserNameText(), "ROMAN IOVLEV");
    }

    public void shouldReturnPageTitle() {
        assertEquals(homePage.getTitle(), "Home Page");
    }

    public void shouldReturnDefaultValue() {
        assertEquals(tableWithPages.getDefaultValue().getText(), "5");
    }

    public void shouldReturnAmountOfEntries() {
        assertTrue(tableWithPages.getLogRowSelectedValue().getText().contains("new value=10"));
    }

    public void shouldReturnTrueIfTableContainsSearchValue() {
        assertTrue(tableWithPages.getLogRowSearchJunit().getText().contains("junit"));
    }

}
