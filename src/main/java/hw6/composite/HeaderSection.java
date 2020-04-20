package hw6.composite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderSection extends AbstractPageComposite {

    public HeaderSection(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".m-l8 > li > a")
    private List<WebElement> headerItems;

    @FindBy(css = ".dropdown-menu > li > a")
    private List<WebElement> dropdownMenuItems;

    public void clickHeaderItem(String headerItemText) {
        for (WebElement element : headerItems) {
            if (headerItemText.equals(element.getText())) {
                element.click();
            }
        }
    }

    public void clickDropdownMenuItem(String dropdownMenuItemText) {
        for (WebElement element : dropdownMenuItems) {
            if (dropdownMenuItemText.equals(element.getText())) {
                element.click();
                break;
            }
        }
    }
}
