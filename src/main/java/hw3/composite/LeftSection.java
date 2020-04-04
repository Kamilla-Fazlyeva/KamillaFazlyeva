package hw3.composite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class LeftSection extends AbstractPageComposite {

    public LeftSection(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".sidebar-menu > li")
    private List<WebElement> leftSectionItems;

    public List<WebElement> getLeftSectionItems() {
        return leftSectionItems;
    }

    public List<String> getLeftSectionItemsTexts() {
        return leftSectionItems.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
