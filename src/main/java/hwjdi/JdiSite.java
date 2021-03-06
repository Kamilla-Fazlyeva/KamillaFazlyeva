package hwjdi;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hwjdi.pages.JdiHomePage;
import hwjdi.pages.MetalsAndColorsPage;

@JSite("http://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    @Url("/index.html")
    public static JdiHomePage jdiHomePage;

    @Url("/metals-colors.html")
    public static MetalsAndColorsPage metalsAndColorsPage;

    public static void openHomePage() {
        jdiHomePage.open();
    }

    public static void openMetalsColorsPage() {
        metalsAndColorsPage.open();
    }
}
