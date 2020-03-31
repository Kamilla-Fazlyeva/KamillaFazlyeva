package hw3.composite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class LeftSection {

    @FindBy(css = ".sidebar-menu")
    private List<WebElement> leftSectionItems;

    public List<String> getLeftSectionItems() {
        List<String> expectedLeftSectionItems = new ArrayList<>();
        for (WebElement eleemnt : leftSectionItems) {
            expectedLeftSectionItems
        }
    }
}
