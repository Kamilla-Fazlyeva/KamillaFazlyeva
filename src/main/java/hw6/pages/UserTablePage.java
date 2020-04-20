package hw6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class UserTablePage extends AbstractPage {

    @FindBy(tagName = "select")
    private List<WebElement> numberTypeDropdowns;

    @FindBy(css = "tr > td:nth-child(1)")
    private List<WebElement> numberType;

    @FindBy(css = "select > option")
    private List<WebElement> options;

    @FindBy(css = "tr > td > a")
    private List<WebElement> usernames;

    @FindBy(css = ".user-descr > span")
    private List<WebElement> description;

    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(css = ".logs > li")
    private List<WebElement> logs;

    public UserTablePage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getNumberType() {
        return numberType;
    }

    public List<WebElement> getNumberTypeDropdowns() {
        return numberTypeDropdowns;
    }

    public List<WebElement> getUsernames() {
        return usernames;
    }

    public List<WebElement> getDescription() {
        return description;
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public String getWebElementText(List<WebElement> webElements, Integer number) {
        return webElements.get(number).getText();
    }

    public String getTypeOptions() {
        return options.get(0).getText() + "\n" + options.get(1).getText() + "\n" + options.get(2).getText();
    }

    public void setCheckbox(String user) {
        driver.findElement(By.xpath("//td[contains(., '" + user + "')]/..//input")).click();
    }

    public List<String> getLogRow() {
        return logs.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
