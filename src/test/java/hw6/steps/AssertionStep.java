package hw6.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

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
    public void userTableShouldContainValues(DataTable dataTable) {
        List<Map<String, String>> values = dataTable.asMaps(String.class, String.class);
        for (int i = 0; i < 6; i++) {
            if (userTablePage.getNumberTypeText(i).equals(values.get(i).get("Number"))) {
                assertEquals(userTablePage.getUsernameText(i), values.get(i).get("User"));
                assertEquals(userTablePage.getDescriptionText(i).replaceAll("\n", " "),
                        values.get(i).get("Description"));
            }
        }
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
