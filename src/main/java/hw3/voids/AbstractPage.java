package hw3.voids;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage extends AbstractPageComposite{

    protected AbstractPage(WebDriver driver) {
        super(driver);
    }
}
