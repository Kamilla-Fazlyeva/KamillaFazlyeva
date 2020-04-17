package hwjdi.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import hwjdi.entities.MetalsAndColors;
import hwjdi.forms.MetalsAndColorsForm;

public class MetalsAndColorsPage extends WebPage {

    @Css("#submit-button")
    private Button submit;

    @Css(".results li ")
    private WebList results;

    private MetalsAndColorsForm metalsAndColorsForm;

    public void setValues(MetalsAndColors metalsAndColors) {
        metalsAndColorsForm.setValues(metalsAndColors);
    }

    public void clickSubmit() {
        submit.click();
    }

    public WebList getResults() {
        return results;
    }
}
