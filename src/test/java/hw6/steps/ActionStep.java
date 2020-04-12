package hw6.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class ActionStep extends AbstractBaseStep{

    @When("I login as user {string} with password {string} on the Home page")
    public void iLoginAsUserOnHomePage(String userName, String password) {
        homePage.login(userName, password);
    }

    @When("I click on {string} button in Header")
    public void iClickServiceButtonOnHeaderMenu(String headerItem) {
        homePage.getHeaderSection().clickHeaderItem(headerItem);
    }

    @When("I click on {string} button in Service dropdown")
    public void iClickUserTableButton(String dropdownMenuItem) {
        homePage.getHeaderSection().clickDropdownMenuItem(dropdownMenuItem);
    }

    @And("I click {string} checkbox")
    public void iClickCheckbox(String checkboxName) {
        differentElementsPage.selectCheckbox(checkboxName);
    }

    @And("I click {string} radiobutton")
    public void iClickRadioButton(String radioButtonName) {
        differentElementsPage.selectRadioButton(radioButtonName);
    }

    @And("I select {string} dropdown")
    public void iClickDropdown(String dropdownName) {
        differentElementsPage.selectDropdown(dropdownName);
    }

    @When("I select 'vip' checkbox for {string}")
    public void iSelectVipCheckboxForSergey(String name) {
        userTablePage.setCheckbox(name);
    }

}
