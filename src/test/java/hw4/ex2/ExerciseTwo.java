package hw4.ex2;

import hw4.base.BaseClass;
import hw4.builder.MetalAndColorData;
import hw4.pages.HomePage;
import hw4.pages.MetalAndColorPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static hw4.enums.MetalsAndColors.*;
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
            metalAndColorPage.selectWebElement(metalAndColorPage
                    .getSummaryRadioButtons(), metalAndColorData.getSummary());
        }

        if (metalAndColorData.getElements() != null) {
            metalAndColorPage.selectWebElement(metalAndColorPage
                    .getElementsCheckboxes(), metalAndColorData.getElements(
            ));
        }

        if (metalAndColorData.getColors() != null) {
            metalAndColorPage.getColorDropdown().click();
            metalAndColorPage.selectWebElement(metalAndColorPage
                    .getColorAndMetalOptions(), metalAndColorData.getColors());
        }

        if (metalAndColorData.getMetals() != null) {
            metalAndColorPage.getMetalDropdown().click();
            metalAndColorPage.selectWebElement(metalAndColorPage
                    .getColorAndMetalOptions(), metalAndColorData.getMetals());
        }


        if (metalAndColorData.getVegetables() != null) {
            metalAndColorPage.getVegetablesDropdown().click();
            metalAndColorPage.uncheckVegetables();
            metalAndColorPage.selectWebElement(metalAndColorPage
                    .getVegetableCheckboxes(), metalAndColorData.getVegetables());

        }

        // 5. Click “Submit” button
        metalAndColorPage.clickSubmitButton();

        // 6. Check Results block output on the right-side
        for (WebElement result : metalAndColorPage.getResults()) {

            if (metalAndColorData.getSummary() != null && result.getText().contains(SUMMARY.getValue())) {
                assertTrue(result.getText().contains(metalAndColorPage.getSummarySum().summarySum(metalAndColorData.getSummary())));
            }

            if (metalAndColorData.getElements() != null && result.getText().contains(ELEMENTS.getValue())) {
                assertTrue(result.getText().contains(String.join(", ", metalAndColorData.getElements())));
            }

            if (metalAndColorData.getColors() != null && result.getText().contains(COLORS.getValue())) {
                assertTrue(result.getText().contains(String.join(", ", metalAndColorData.getColors())));
            }

            if (metalAndColorData.getMetals() != null && result.getText().contains(METALS.getValue())) {
                assertTrue(result.getText().contains(String.join(",", metalAndColorData.getMetals())));
            }

            if (metalAndColorData.getVegetables() != null && result.getText().contains(VEGETABLES.getValue())) {
                assertTrue(result.getText().contains(String.join(", ", metalAndColorData.getVegetables())));
            }
        }
    }
}
