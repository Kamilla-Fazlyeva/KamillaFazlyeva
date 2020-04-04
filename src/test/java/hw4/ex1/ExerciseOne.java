package hw4.ex1;

import hw4.base.BaseClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExerciseOne extends BaseClass {

    private HomePageSteps homePageSteps;
    private TableWithPagesSteps tableWithPagesSteps;
    private ExerciseOneAsserts exerciseOneAsserts;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        homePageSteps = new HomePageSteps(driver);
        tableWithPagesSteps = new TableWithPagesSteps(driver);
        exerciseOneAsserts = new ExerciseOneAsserts(driver);
    }

    @Test
    public void exerciseOneTest() {

        homePageSteps.open();

        exerciseOneAsserts.shouldReturnPageTitle();

        homePageSteps.login(properties.getProperty("username"), properties.getProperty("password"));

        exerciseOneAsserts.shouldReturnUsernameText();

        homePageSteps.clickServiceButton();
        homePageSteps.openTableWithPages();

        exerciseOneAsserts.shouldReturnDefaultValue();
        tableWithPagesSteps.selectValue();

        exerciseOneAsserts.shouldReturnAmountOfEntries();

        tableWithPagesSteps.typeSearchField(properties.getProperty("search"));
        exerciseOneAsserts.shouldReturnTrueIfTableContainsSearchValue();
    }
}
