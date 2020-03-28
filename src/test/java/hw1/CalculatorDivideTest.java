package hw1;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorDivideTest extends BaseClass{

    @DataProvider
    public Object[][] divideTwoNumbersDataProvider() {
        return new Object[][]{
                {10, - 2, - 5},
                {32, 8, 4},
                {6, 3, 2},
                {1, 0, Double.POSITIVE_INFINITY}
        };
    }

    @Test(dataProvider = "divideTwoNumbersDataProvider", groups = {"Group2"})
    public void divideTwoNumbersWithDataProvider(double a, double b, double expected) {
        double actual = calculator.div(a, b);
        assertEquals(actual, expected);
    }

}
