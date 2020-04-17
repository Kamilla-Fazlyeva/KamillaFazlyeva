package hwjdi.forms;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import hwjdi.entities.MetalsAndColors;

public class MetalsAndColorsForm extends Form<MetalsAndColors> {

    @Css("p.radio > label")
    private WebList summaryButtons;

    @Css("p.checkbox > label")
    private WebList elementsCheckboxes;

    @JDropdown(root = ".colors", value = ".selectpicker", list = "li", expand = ".caret")
    private Dropdown colors;

    @JDropdown(root = ".metals", value = ".selectpicker", list = "li", expand = ".caret")
    private Dropdown metals;

    @JDropdown(root = "#salad-dropdown", value = ".dropdown-menu", list = "li> a > label", expand = ".caret")
    private Dropdown vegetables;

    public void setValues(MetalsAndColors metalsAndColors) {
        for (int i : metalsAndColors.getSummary()) {
            summaryButtons.select(i);
        }
        elementsCheckboxes.select(metalsAndColors.getElements());
        colors.select(metalsAndColors.getColor());
        metals.select(metalsAndColors.getMetal());
        vegetables.select(metalsAndColors.getVegetables());
    }
}
