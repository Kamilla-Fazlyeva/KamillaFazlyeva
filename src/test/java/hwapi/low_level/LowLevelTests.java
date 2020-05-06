package hwapi.low_level;

import hwapi.BaseClass;
import hwapi.service.URI;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static hwapi.enums.ErrorCode.*;
import static hwapi.enums.Lang.*;
import static hwapi.enums.TestData.TestDataRequest.*;
import static hwapi.enums.YandexSpellerConstants.*;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

public class LowLevelTests extends BaseClass {

    @Test
    public void checkTextStatusCode() {
        RestAssured
                .given(REQUEST_SPECIFICATION)
                .get(URI.CHECK_TEXT)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void checkCorrectText() {
        RestAssured
                .given(REQUEST_SPECIFICATION)
                .param(PARAM_TEXT, EN_WORD)
                .param(PARAM_LANG, EN.getValue())
                .log().everything()
                .get(URI.CHECK_TEXT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(is("[]"));
    }

    @Test
    public void checkIncorrectText() {
        RestAssured
                .given(REQUEST_SPECIFICATION)
                .param(PARAM_TEXT, RU_WRONG_WORD.getWrong())
                .param(PARAM_LANG, RU.getValue())
                .log().everything()
                .get(URI.CHECK_TEXT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("s[0]", hasItem(RU_WRONG_WORD.getCorrect()))
                .body("word[0]", is(RU_WRONG_WORD.getWrong()))
                .body("code[0]", is(ERROR_UNKNOWN_WORD.getValue()));
    }
}
