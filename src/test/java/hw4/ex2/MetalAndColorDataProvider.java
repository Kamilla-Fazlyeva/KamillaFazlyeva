package hw4.ex2;

import hw4.builder.MetalAndColorData;
import org.testng.annotations.DataProvider;

import java.util.Arrays;

import static hw4.enums.ColorItems.*;
import static hw4.enums.ElementsItems.*;
import static hw4.enums.MetalItems.*;
import static hw4.enums.SummaryItems.*;
import static hw4.enums.VegetableItems.*;

public class MetalAndColorDataProvider {

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {MetalAndColorData.builder().setElements(Arrays.asList(EARTH.getValue()))
                        .setColors(Arrays.asList(YELLOW.getValue()))
                        .setMetals(Arrays.asList(GOLD.getValue())).build()},

                {MetalAndColorData.builder().setSummary(Arrays.asList(THREE.getValue(), EIGHT.getValue()))
                        .setVegetables(Arrays.asList(CUCUMBER.getValue(), TOMATO.getValue())).build()},

                {MetalAndColorData.builder().setSummary(Arrays.asList(THREE.getValue(), TWO.getValue()))
                        .setElements(Arrays.asList(WATER.getValue(), WIND.getValue(), FIRE.getValue()))
                        .setMetals(Arrays.asList(BRONZE.getValue()))
                        .setVegetables(Arrays.asList(ONION.getValue())).build()},

                {MetalAndColorData.builder().setSummary(Arrays.asList(SIX.getValue(), FIVE.getValue()))
                        .setElements(Arrays.asList(WATER.getValue()))
                        .setColors(Arrays.asList(GREEN.getValue())).setMetals(Arrays.asList(SELEN.getValue()))
                        .setVegetables(Arrays.asList(CUCUMBER.getValue(), TOMATO.getValue(),
                                VEGETABLES.getValue(), ONION.getValue())).build()},

                {MetalAndColorData.builder().setElements(Arrays.asList(FIRE.getValue()))
                        .setColors(Arrays.asList(BLUE.getValue()))
                        .setVegetables(Arrays.asList(CUCUMBER.getValue(), TOMATO.getValue(),
                        VEGETABLES.getValue())).build()}
        };
    }


}
