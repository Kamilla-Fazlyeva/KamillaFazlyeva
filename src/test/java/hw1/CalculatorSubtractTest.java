package hw1;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSubtractTest extends BaseClass {

    @DataProvider
    public Object[][] subtractTwoNumbersDataProvider() {
        return new Object[][]{
                {10, - 2, 12},
                {5, 8, - 3},
                {6, 3, 3},
                {0, - 1, 1}
        };
    }

    @Test(dataProvider = "subtractTwoNumbersDataProvider", groups = {"Group1"})
    public void subtractTwoNumbersWithDataProvider(double a, double b, double expected) {
        double actual = calculator.sub(a, b);
        assertEquals(actual, expected);
    }

}
