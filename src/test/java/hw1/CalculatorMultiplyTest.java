package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorMultiplyTest {

    private Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @DataProvider
    public Object[][] multiplyTwoNumbersDataProvider() {
        return new Object[][]{
                {10, -2, -20},
                {5, 8, 40},
                {6, 3, 18},
                {0, -1, - 0.0}
        };
    }

    @Test(dataProvider = "multiplyTwoNumbersDataProvider", groups = {"Group2"})
    public void multiplyTwoNumbersWithDataProvider(double a, double b, double expected) {
        double actual = calculator.mult(a, b);
        assertEquals(actual, expected);
    }

    @AfterMethod
    public void tearDown() {
        calculator = null;
    }

}
