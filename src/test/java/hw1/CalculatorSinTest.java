package hw1;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import static java.lang.Math.*;
import static org.testng.Assert.assertEquals;

public class CalculatorSinTest extends BaseClass {

    @DataProvider
    public Object[][] sinInDegreesDataProvider() {
        return new Object[][]{
                {30, 0.5},
                {60, 0.9},
                {0, 0},
                {360, 0}
        };
    }

    @Test(dataProvider = "sinInDegreesDataProvider")
    public void sinInDegreesWithDataProvider(double a, double expected) {
        double inRadians = toRadians(a);
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("#.#", symbols);
        double actual = Double.valueOf(df.format(calculator.sin(inRadians)));
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] sinInRadiansDataProvider() {
        return new Object[][]{
                {PI/2, 1},
                {PI/4, 0.7},
                {0, 0},
                {- PI, 0},
                {PI/10, 0.3}
        };
    }

    @Test(dataProvider = "sinInRadiansDataProvider")
    public void sinInRadiansDataProvider(double a, double expected) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("#.#", symbols);
        double actual = Double.valueOf(df.format(calculator.sin(a)));
        assertEquals(actual, expected);
    }

    @Test
    public void shouldReturnNaNIfInputIsNaN() {
        double actual = calculator.sin(Double.NaN);
        double expected = Double.NaN;
        assertEquals(actual, expected);
    }
}
