package hwjdi;

import hwjdi.base.BaseClass;
import hwjdi.entities.MetalsAndColors;
import org.testng.annotations.Test;
import static hwjdi.entities.User.*;
import static org.testng.Assert.assertEquals;

public class MetalsAndColorsJdiTest extends BaseClass {

    @Test(dataProviderClass = MetalsAndColorsDataProvider.class, dataProvider = "testData")
    public void jdiMetalsAndColorsTest(MetalsAndColors metalsAndColors) {

        JdiSite.openHomePage();
        JdiSite.jdiHomePage.login(ROMAN);
        JdiSite.jdiHomePage.userName.is().text(ROMAN.getFullName());

        JdiSite.openMetalsColorsPage();
        JdiSite.metalsAndColorsPage.setWebElements(metalsAndColors);

        assertEquals(JdiSite.metalsAndColorsPage.getResults(),
                metalsAndColors.toString());

        JdiSite.metalsAndColorsPage.logout();
    }
}
