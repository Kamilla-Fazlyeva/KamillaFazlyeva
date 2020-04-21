package hwjdi.forms;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import hwjdi.entities.MetalsAndColors;
import static hwjdi.enums.Vegetables.VEGETABLES;

public class MetalsAndColorsForm extends Form<MetalsAndColors> {

    @XPath("//label[contains(., '%s')]")
    private RadioButtons summary;

    @Css("p.checkbox > label")
    private WebList elements;

    @JDropdown(root = ".colors", value = ".selectpicker", list = "li", expand = ".caret")
    private Dropdown colors;

    @JDropdown(root = ".metals", value = ".selectpicker", list = "li", expand = ".caret")
    private Dropdown metals;

    @JDropdown(root = "#salad-dropdown", value = ".dropdown-menu", list = "li> a > label", expand = ".caret")
    private Dropdown vegetables;

    @Css("#submit-button")
    private Button submit;

    public void setWebElements(MetalsAndColors metalsAndColors) {
        for (Integer element : metalsAndColors.getSummary()) {
            summary.select(String.valueOf(element));
        }

        for (String element : metalsAndColors.getElements()) {
            elements.select(element);
        }
        colors.select(metalsAndColors.getColor());
        metals.select(metalsAndColors.getMetals());

        vegetables.select(VEGETABLES.getValue());
        for (String element :  metalsAndColors.getVegetables()) {
            vegetables.select(element);
        }

        submit.click();
    }
}
