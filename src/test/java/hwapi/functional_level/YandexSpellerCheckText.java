package hwapi.functional_level;

import hwapi.assertions.YandexSpellerAssertions;
import hwapi.builder.YandexSpellerRequest;
import hwapi.dto.SpellResult;
import hwapi.service.YandexSpellerService;
import org.testng.annotations.Test;

public class YandexSpellerCheckText {

    @Test(dataProviderClass = YandexSpellerDataProvider.class, dataProvider = "correctWord")
    public void checkCorrectWordTest(String text, String lang) {
        YandexSpellerRequest request = YandexSpellerRequest.builder()
                .text(text)
                .lang(lang)
                .build();

        SpellResult[] result = new YandexSpellerService().getCheckText(request);
        new YandexSpellerAssertions(result)
                .assertEmptyResponse();
    }

    @Test(dataProviderClass = YandexSpellerDataProvider.class, dataProvider = "incorrectWord")
    public void checkIncorrectWordTest(String text, String lang, String expected) {
        YandexSpellerRequest request = YandexSpellerRequest.builder()
                .text(text)
                .lang(lang)
                .build();

        SpellResult[] result = new YandexSpellerService().getCheckText(request);
        new YandexSpellerAssertions(result)
                .assertNotEmptyResponse()
                .assertInitialWord(text)
                .assertSuggestions(expected);
    }

    @Test(dataProviderClass = YandexSpellerDataProvider.class, dataProvider = "correctSentence")
    public void checkCorrectSentenceTest(String text, String lang) {
        YandexSpellerRequest request = YandexSpellerRequest.builder()
                .text(text)
                .lang(lang)
                .build();

        SpellResult[] result = new YandexSpellerService().getCheckText(request);
        new YandexSpellerAssertions(result)
                .assertEmptyResponse();
    }

    @Test(dataProviderClass = YandexSpellerDataProvider.class, dataProvider = "incorrectSentence")
    public void checkIncorrectSentenceTest(String text, String lang, String expected) {
        YandexSpellerRequest request = YandexSpellerRequest.builder()
                .text(text)
                .lang(lang)
                .build();

        SpellResult[] result = new YandexSpellerService().getCheckText(request);
        new YandexSpellerAssertions(result)
                .assertNotEmptyResponse()
                .assertSuggestions(expected);
    }
}
