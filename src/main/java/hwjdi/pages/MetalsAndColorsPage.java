package hwjdi.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import hwjdi.entities.MetalsAndColors;
import hwjdi.forms.MetalsAndColorsForm;

public class MetalsAndColorsPage extends WebPage {

    @Css(".results")
    private UIElement results;

    @Css("#user-name")
    private Button userButton;

    @Css(".logout")
    private Button logoutButton;

    private MetalsAndColorsForm metalsAndColorsForm;

    public void setWebElements(MetalsAndColors metalsAndColors) {
        metalsAndColorsForm.setWebElements(metalsAndColors);
    }

    public String getResults() {
        return results.getText();
    }

    public void logout() {
        userButton.click();
        logoutButton.click();
    }
}
