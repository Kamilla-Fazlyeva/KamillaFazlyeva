package hwapi.functional_level;

import hwapi.assertions.YandexSpellerAssertions;
import hwapi.dto.SpellResult;
import hwapi.service.YandexSpellerService;
import org.testng.annotations.Test;

public class YandexSpellerCheckTexts {

    @Test(dataProviderClass = YandexSpellerDataProvider.class, dataProvider = "checkTextsCorrectData")
    public void checkCorrectTextsTest(String firstText, String secondText) {
        SpellResult[][] results = new YandexSpellerService()
                .getCheckTexts(new String[]{firstText, secondText});

        new YandexSpellerAssertions(results)
                .assertEmptyBodyResponse();
    }

    @Test(dataProviderClass = YandexSpellerDataProvider.class, dataProvider = "checkTextsIncorrectData")
    public void checkIncorrectTextsTest(String firstText, String secondText) {
        SpellResult[][] results = new YandexSpellerService()
                .getCheckTexts(new String[]{firstText, secondText});

        new YandexSpellerAssertions(results)
                .assertNotEmptyBodyResponse();
    }
}
