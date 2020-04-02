package hw3.composite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class LeftSection {

    protected WebDriver driver;

    public LeftSection(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = ".sidebar-menu")
    private List<WebElement> leftSectionItems;

    public List<WebElement> getLeftSectionItems() {
        return this.leftSectionItems;
    }

    public List<String> getLeftSectionItemsTexts() {
        List<String> actualLeftSectionItems = new ArrayList<>();
        for (WebElement element : leftSectionItems) {
            actualLeftSectionItems.add(element.getText());
        }

        return actualLeftSectionItems;
    }
}
