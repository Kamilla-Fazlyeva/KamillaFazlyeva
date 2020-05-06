package hwapi.functional_level;

import hwapi.assertions.YandexSpellerAssertions;
import hwapi.builder.YandexSpellerRequest;
import hwapi.dto.SpellResult;
import hwapi.service.YandexSpellerService;
import org.testng.annotations.Test;

import static hwapi.enums.Lang.*;
import static hwapi.enums.Options.*;
import static hwapi.enums.TestData.TestDataWithOptions.*;

public class YandexSpellerOptionsTests {

    @Test
    public void checkIgnoreDigitsOption() {
        YandexSpellerRequest request = YandexSpellerRequest.builder()
                .text(DATA_IGNORE_DIGITS.getValue())
                .lang(EN.getValue())
                .options(IGNORE_DIGITS.getValue())
                .build();
        SpellResult[] result = new YandexSpellerService().getCheckText(request);
        new YandexSpellerAssertions(result).assertEmptyResponse();
    }

    @Test
    public void checkIgnoreURL() {
        YandexSpellerRequest request = YandexSpellerRequest.builder()
                .text(DATA_IGNORE_URL.getValue())
                .lang(EN.getValue())
                .options(IGNORE_URLS.getValue())
                .build();
        SpellResult[] result = new YandexSpellerService().getCheckText(request);
        new YandexSpellerAssertions(result).assertEmptyResponse();
    }

    // The test is failed, the response body is empty.
    // It works correctly only if the protocol in the domain URL is http.
    @Test
    public void checkFindRepeatWord() {
        YandexSpellerRequest request = YandexSpellerRequest.builder()
                .text(DATA_REPEAT_WORD.getValue())
                .lang(EN.getValue())
                .options(FIND_REPEAT_WORDS.getValue())
                .build();
        SpellResult[] result = new YandexSpellerService().getCheckText(request);
        new YandexSpellerAssertions(result).assertNotEmptyResponse();
    }

    @Test
    public void checkIgnoreCapitalization() {
        YandexSpellerRequest request = YandexSpellerRequest.builder()
                .text(DATA_IGNORE_CAPITAL.getValue())
                .lang(RU.getValue())
                .options(IGNORE_CAPITALIZATION.getValue())
                .build();
        SpellResult[] result = new YandexSpellerService().getCheckText(request);
        new YandexSpellerAssertions(result).assertEmptyResponse();
    }
}
