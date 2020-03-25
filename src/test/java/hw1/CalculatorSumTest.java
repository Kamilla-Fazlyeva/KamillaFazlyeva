package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSumTest {

    private Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

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

    @AfterMethod
    public void tearDown() {
        calculator = null;
    }
}
