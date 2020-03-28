package hw1;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSumTest extends BaseClass {

    @DataProvider
    public Object[][] sumTwoNumbersDataProvider() {
        return new Object[][]{
                {10, -2, 8},
                {5, 8, 13},
                {6, 3, 9},
                {0, -1, -1}
        };
    }

    @Test(dataProvider = "sumTwoNumbersDataProvider", groups = {"Group1"})
    public void sumTwoNumbersWithDataProvider(double a, double b, double expected) {
        double actual = calculator.sum(a, b);
        assertEquals(actual, expected);
    }
}
