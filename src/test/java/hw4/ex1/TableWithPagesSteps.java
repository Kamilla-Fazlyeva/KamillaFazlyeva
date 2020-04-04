package hw4.ex1;

import hw4.base.AbstractBaseClass;
import org.openqa.selenium.WebDriver;

public class TableWithPagesSteps extends AbstractBaseClass {

    public TableWithPagesSteps(WebDriver driver) {
        super(driver);
    }

    public void selectValue() {
        tableWithPages.getSelectedValue().click();
    }

    public void typeSearchField(String search) {
        tableWithPages.typeSearchField(search);
    }
}
