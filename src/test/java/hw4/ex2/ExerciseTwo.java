package hw4.ex2;

import hw4.base.BaseClass;
import hw4.builder.MetalAndColorData;
import hw4.pages.HomePage;
import hw4.pages.MetalAndColorPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ExerciseTwo extends BaseClass {

    private HomePage homePage;
    private MetalAndColorPage metalAndColorPage;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        metalAndColorPage = new MetalAndColorPage(driver);
    }

    @Test(dataProviderClass = MetalAndColorDataProvider.class, dataProvider = "testData")
    public void exerciseTwoTest(MetalAndColorData metalAndColorData) {

        // 1. Open test site by URL
        homePage.open();

        // 2. Perform login
        homePage.login(properties.getProperty("username"), properties.getProperty("password"));
        assertEquals(homePage.getUserNameText(), "ROMAN IOVLEV");

        // 3. Click on the link on the Header section
        homePage.getHeaderSection().getMetalAndColorPage().click();

        // 4. Fill form on the page
        if (metalAndColorData.getSummary() != null) {
            metalAndColorPage.selectSummaryRadioButtons(metalAndColorData.getSummary());
        }

        if (metalAndColorData.getElements() != null) {
            metalAndColorPage.selectElementsCheckbox(metalAndColorData.getElements());
        }

        if (metalAndColorData.getColors() != null) {
            metalAndColorPage.clickColorDropdown();
            metalAndColorPage.selectColorDropdown(metalAndColorData.getColors());
        }

        if (metalAndColorData.getMetals() != null) {
            metalAndColorPage.clickMetalDropdown();
            metalAndColorPage.selectMetalDropdown(metalAndColorData.getMetals());
        }


        if (metalAndColorData.getVegetables() != null) {
            metalAndColorPage.clickVegetablesDropdown();
            metalAndColorPage.uncheckVegetables();
            metalAndColorPage.selectVegetablesCheckbox(metalAndColorData.getVegetables());

        }

        // 5. Click “Submit” button
        metalAndColorPage.clickSubmitButton();

        // 6. Check Results block output on the right-side
        for (WebElement element : metalAndColorPage.getResults()) {

            if (metalAndColorData.getSummary() != null && metalAndColorPage.getResults().contains("Summary")) {
                assertTrue(metalAndColorPage.getResults().contains(metalAndColorData.getSummary()));
            }

            if (metalAndColorData.getElements() != null && metalAndColorPage.getResults().contains("Elements")) {
                assertTrue(metalAndColorPage.getResults().contains(metalAndColorData.getElements()));
            }

            if (metalAndColorData.getColors() != null && metalAndColorPage.getResults().contains("Colors")) {
                assertTrue(metalAndColorPage.getResults().contains(metalAndColorData.getColors()));
            }

            if (metalAndColorData.getMetals() != null && metalAndColorPage.getResults().contains("Metals")) {
                assertTrue(metalAndColorPage.getResults().contains(metalAndColorData.getMetals()));
            }

            if (metalAndColorData.getVegetables() != null && metalAndColorPage.getResults().contains("Vegetables")) {
                assertTrue(metalAndColorPage.getResults().contains(metalAndColorData.getVegetables()));
            }

        }
    }
}
