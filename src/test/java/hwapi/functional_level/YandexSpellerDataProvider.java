package hwapi.functional_level;

import org.testng.annotations.DataProvider;

import static hwapi.enums.Lang.*;
import static hwapi.enums.TestData.TestDataRequest.*;

public class YandexSpellerDataProvider {

    @DataProvider
    public Object[][] correctWord() {
        return new Object[][]{
                {EN_WORD.getCorrect(), EN.getValue()},
                {RU_WORD.getCorrect(), RU.getValue()},
        };
    }

    @DataProvider
    public Object[][] correctSentence() {
        return new Object[][]{
                {EN_SENTENCE.getCorrect(), EN.getValue()},
                {RU_SENTENCE.getCorrect(), RU.getValue()},
        };
    }

    @DataProvider
    public Object[][] incorrectWord() {
        return new Object[][]{
                {EN_WRONG_WORD.getWrong(), EN.getValue(), EN_WRONG_WORD.getCorrect()},
                {RU_WRONG_WORD.getWrong(), RU.getValue(), RU_WRONG_WORD.getCorrect()},
        };
    }

    @DataProvider
    public Object[][] incorrectSentence() {
        return new Object[][]{
                {EN_WRONG_SENTENCE.getWrong(), EN.getValue(), EN_WRONG_SENTENCE.getCorrect()},
                {RU_WRONG_SENTENCE.getWrong(), RU.getValue(), RU_WRONG_SENTENCE.getCorrect()}
        };
    }

    @DataProvider
    public Object[][] checkTextsCorrectData() {
        return new Object[][]{
                {EN_WORD.getCorrect(), EN_SENTENCE.getCorrect()},
                {RU_WORD.getCorrect(), RU_SENTENCE.getCorrect()}
        };
    }

    @DataProvider
    public Object[][] checkTextsIncorrectData() {
        return new Object[][]{
                {EN_WRONG_WORD.getWrong(), EN_WRONG_SENTENCE.getWrong()},
                {RU_WRONG_WORD.getWrong(), RU_WRONG_SENTENCE.getWrong()}
        };
    }
}
