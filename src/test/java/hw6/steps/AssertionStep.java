package hw6.steps;

import hw6.entities.UserTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertionStep extends AbstractBaseStep {

    @Then("username should be {string} on the Home page")
    public void usernameShouldBeOnTheHomePage(String expectedUserName) {
        assertEquals(homePage.getUserNameText(), expectedUserName);
    }

    @Then("title {string} should be displayed on the Home page")
    public void titleShouldBeOnTheHomePage(String expectedTitle) {
        assertEquals(homePage.getTitle(), expectedTitle);
    }

    @Then("Checkboxes should be displayed on Different elements page")
    public void checkboxesShouldBeDisplayedOnDifferentElementsPage() {
        differentElementsPage.getCheckboxes().forEach(webElement -> assertTrue(webElement.isDisplayed()));
    }

    @And("radiobuttons should be displayed on Different elements page")
    public void radioButtonsShouldBeDisplayedOnDifferentElementsPage() {
        differentElementsPage.getRadioButtons().forEach(webElement -> assertTrue(webElement.isDisplayed()));
    }

    @And("dropdown should be displayed on Different elements page")
    public void dropdownShouldBeDisplayedOnDifferentElementsPage() {
        assertTrue(differentElementsPage.getDropdownSelect().isDisplayed());
    }

    @Then("Log row should contain element name {string} and its value changed to {string}")
    public void shouldReturnLogRowText(String elementName, String logRowText) {
        for (WebElement element : differentElementsPage.getLogRow()) {
            if(element.getText().contains(elementName)) {
                assertTrue(element.getText().contains(logRowText));
            }
        }
    }

    @Then("{string} page should be opened")
    public void userTablePageShouldBeDisplayed(String pageTitle) {
        assertEquals(userTablePage.getTitle(), pageTitle);
    }

    @And("6 Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void dropdownsShouldBeDisplayedOnUsersTablePage() {
        userTablePage.getNumberTypeDropdowns().forEach(webElement -> assertTrue(webElement.isDisplayed()));
    }

    @And("6 Usernames should be displayed on Users Table on User Table Page")
    public void usernamesShouldBeDisplayedOnUsersTablePage() {
        userTablePage.getUsernames().forEach(webElement -> assertTrue(webElement.isDisplayed()));
    }

    @And("6 Description texts under images should be displayed on Users Table on User Table Page")
    public void descriptionTextsShouldBeDisplayedOnUsersTablePage() {
        userTablePage.getDescription().forEach(webElement -> assertTrue(webElement.isDisplayed()));
    }

    @And("6 checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxesShouldBeDisplayedOnUsersTablePage() {
        userTablePage.getCheckboxes().forEach(webElement -> assertTrue(webElement.isDisplayed()));
    }

    @And("User table should contain following values:")
    public void userTableShouldContainValues(List<UserTable> userTable) {
        for (int i = 0; i < userTable.size(); i++) {
            assertEquals(userTablePage.getWebElementText(userTablePage.getNumberType(), i),
                    userTable.get(i).getNumber());
            assertEquals(userTablePage.getWebElementText(userTablePage.getUsernames(), i),
                    userTable.get(i).getUser());
            assertEquals(userTablePage.getWebElementText(userTablePage
                    .getDescription(), i).replaceAll("\n", " "),
                    userTable.get(i).getDescription());
        }
    }

    @DataTableType
    public UserTable userTable(Map<String, String> user) {
        return new UserTable(user.get("Number"), user.get("User"), user.get("Description"));
    }

    @And("droplist should contain values in column Type for user Roman")
    public void droplistShouldContainValuesForUser(List<String> droplist) {
        assertEquals(userTablePage.getTypeOptions(),
                droplist.get(1) + "\n" + droplist.get(2) + "\n" + droplist.get(3));
    }

    @Then("1 log row has {string} text in log section")
    public void logRowShouldHasProperText(String logText) {
        userTablePage.getLogRow().forEach(log -> assertTrue(log.contains(logText)));
    }
}
