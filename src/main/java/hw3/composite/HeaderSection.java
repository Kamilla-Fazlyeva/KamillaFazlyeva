package hw3.composite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HeaderSection {

    @FindBy(css = ".m-l8 > li")
    private List<WebElement> headerItems;

    public List<WebElement> getHeaderItems() {
        return this.headerItems;
    }

    public List<String> getHeaderItemsTexts() {
        List<String> actualHeaderItemsTexts = new ArrayList<>();
        for (WebElement element : headerItems) {
            actualHeaderItemsTexts.add(element.getText());
        }

        return actualHeaderItemsTexts;
    }
}
