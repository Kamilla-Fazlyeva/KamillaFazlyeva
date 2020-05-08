package hwapi.functional_level;

import hwapi.assertions.YandexSpellerAssertions;
import hwapi.builder.YandexSpellerRequest;
import hwapi.dto.SpellResult;
import hwapi.service.YandexSpellerService;
import org.testng.annotations.Test;

import static hwapi.enums.ErrorCode.*;
import static hwapi.enums.Lang.EN;
import static hwapi.enums.Lang.RU;
import static hwapi.enums.Options.FIND_REPEAT_WORDS;
import static hwapi.enums.TestData.TestDataWithErrors.*;

public class YandexSpellerErrorCodeTests {

    @Test
    public void checkUnknownWordError() {
        YandexSpellerRequest request = YandexSpellerRequest.builder()
                .text(DATA_UNKNOWN_WORD.getValue())
                .lang(EN.getValue())
                .build();
        SpellResult[] result = new YandexSpellerService().getCheckText(request);
        new YandexSpellerAssertions(result).assertErrorCode(ERROR_UNKNOWN_WORD.getValue());
    }

    // The test is failed, the response body is empty.
    // It works correctly only if the protocol in the domain URL is http.
    @Test
    public void checkRepeatWordError() {
        YandexSpellerRequest request = YandexSpellerRequest.builder()
                .text(DATA_FIND_REPEAT_WORD.getValue())
                .options(FIND_REPEAT_WORDS.getValue())
                .lang(RU.getValue())
                .build();
        SpellResult[] result = new YandexSpellerService().getCheckText(request);
        new YandexSpellerAssertions(result).assertErrorCode(ERROR_REPEAT_WORD.getValue());
    }

    // The test is failed, the response body is empty.
    // It works correctly only if the protocol in the domain URL is http.
    @Test
    public void checkCapitalizationError() {
        YandexSpellerRequest request = YandexSpellerRequest.builder()
                .text(DATA_CAPITALIZATION.getValue())
                .lang(EN.getValue())
                .build();
        SpellResult[] result = new YandexSpellerService().getCheckText(request);
        new YandexSpellerAssertions(result).assertErrorCode(ERROR_CAPITALIZATION.getValue());
    }

    @Test
    public void checkTooManyErrorsCode() {
        YandexSpellerRequest request = YandexSpellerRequest.builder()
                .text(DATA_WITH_ERRORS.getValue())
                .build();

        SpellResult[] result = new YandexSpellerService().getCheckText(request);
        new YandexSpellerAssertions(result)
                .assertNotEmptyResponse()
                .assertErrorCode(ERROR_TOO_MANY_ERRORS.getValue());
    }
}
