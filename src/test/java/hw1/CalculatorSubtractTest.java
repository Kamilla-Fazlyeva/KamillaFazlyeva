package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSubtractTest {

    private Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

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


    @AfterMethod
    public void tearDown() {
        calculator = null;
    }

}
