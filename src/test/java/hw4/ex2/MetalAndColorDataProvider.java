package hw4.ex2;

import hw4.builder.MetalAndColorData;
import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class MetalAndColorDataProvider {

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {MetalAndColorData.builder().setElements(Arrays.asList("Earth"))
                        .setColors("Yellow").setMetals("Gold").build()},

                {MetalAndColorData.builder().setSummary(Arrays.asList("3", "8"))
                        .setVegetables(Arrays.asList("Cucumber", "Tomato")).build()},

                {MetalAndColorData.builder().setSummary(Arrays.asList("3", "2"))
                        .setElements(Arrays.asList("Wind", "Fire", "Water"))
                        .setMetals("Bronze").setVegetables(Arrays.asList("Onion")).build()},

                {MetalAndColorData.builder().setSummary(Arrays.asList("6", "5"))
                        .setElements(Arrays.asList("Wind", "Fire","Water"))
                        .setColors("Green").setMetals("Selen")
                        .setVegetables(Arrays.asList("Cucumber", "Tomato", "Vegetables", "Onion")).build()},

                {MetalAndColorData.builder().setElements(Arrays.asList("Fire"))
                        .setColors("Blue")
                        .setVegetables(Arrays.asList("Cucumber", "Tomato", "Vegetables")).build()}
        };
    }
}
