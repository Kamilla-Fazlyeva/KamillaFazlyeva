package hwapi.functional_level;

import hwapi.BaseClass;
import hwapi.assertions.YandexSpellerAssertions;
import hwapi.builder.YandexSpellerRequest;
import hwapi.dto.SpellResult;
import hwapi.service.YandexSpellerService;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static hwapi.enums.Lang.*;
import static hwapi.enums.TestData.InvalidInputs.*;
import static hwapi.enums.TestData.TestDataRequest.*;
import static hwapi.enums.YandexSpellerConstants.*;
import static hwapi.service.URI.*;
import static org.hamcrest.Matchers.containsString;

public class YandexSpellerInvalidInputsTests extends BaseClass {

    @Test
    public void invalidLangTest() {
        RestAssured
                .given(REQUEST_SPECIFICATION)
                .param(PARAM_LANG, INVALID_LANG.getValue())
                .get(CHECK_TEXT)
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body(containsString("Invalid parameter 'lang'"));
    }

    @Test
    public void invalidOptionsTest() {
        YandexSpellerRequest request = YandexSpellerRequest.builder()
                .text(EN_WORD.getCorrect())
                .lang(EN.getValue())
                .options(INVALID_OPTIONS.getValue())
                .build();

        SpellResult[] result = new YandexSpellerService().getCheckText(request);
        new YandexSpellerAssertions(result)
                .assertEmptyResponse();
    }

    @Test
    public void textWithWrongLanguageTest() {
        YandexSpellerRequest request = YandexSpellerRequest.builder()
                .text(EN_WORD.getCorrect())
                .lang(RU.getValue())
                .build();

        SpellResult[] result = new YandexSpellerService().getCheckText(request);
        new YandexSpellerAssertions(result)
                .assertEmptyResponse();
    }

    @Test
    public void textWithSymbolsTest() {
        YandexSpellerRequest request = YandexSpellerRequest.builder()
                .text(INVALID_TEXT.getValue())
                .build();

        SpellResult[] result = new YandexSpellerService().getCheckText(request);
        new YandexSpellerAssertions(result)
                .assertEmptyResponse();
    }
}
