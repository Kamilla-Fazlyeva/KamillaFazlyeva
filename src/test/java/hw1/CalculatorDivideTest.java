package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorDivideTest {

    private Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

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

    @AfterMethod
    public void tearDown() {
        calculator = null;
    }

}
