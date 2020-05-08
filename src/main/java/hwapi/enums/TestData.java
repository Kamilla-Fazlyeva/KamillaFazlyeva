package hwapi.enums;

public class TestData {

    public enum TestDataWithOptions {

        DATA_IGNORE_DIGITS("тек123ст"),
        DATA_IGNORE_URL("text@yandex.ru"),
        DATA_REPEAT_WORD("text text"),
        DATA_IGNORE_CAPITAL("москва");

        private String value;

        TestDataWithOptions(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum TestDataWithErrors {

        DATA_UNKNOWN_WORD("kiten"),
        DATA_FIND_REPEAT_WORD("кот кот"),
        DATA_CAPITALIZATION("tEXT"),
        DATA_WITH_ERRORS("αβγ");

        private String value;

        TestDataWithErrors(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum TestDataRequest {

        RU_WORD("кошка", "кошка"),
        EN_WORD("cat", "cat"),
        RU_WRONG_WORD("катенок", "котенок"),
        EN_WRONG_WORD("kiten", "kitten"),
        RU_SENTENCE("Это правильное предложение", "Это правильное предложение"),
        EN_SENTENCE("There are no mistakes", "There are no mistakes"),
        RU_WRONG_SENTENCE("Предложение с ашипками", "ошибками"),
        EN_WRONG_SENTENCE("The cat is sleping and purring", "sleeping");

        private String correct;
        private String wrong;

        TestDataRequest(String wrong, String correct) {
            this.correct = correct;
            this.wrong = wrong;
        }

        public String getCorrect() {
            return correct;
        }
        public String getWrong() {
            return wrong;
        }
    }

    public enum InvalidInputs {

        INVALID_LANG("123"),
        INVALID_OPTIONS("123"),
        INVALID_TEXT("te^$x#t");

        private String value;

        InvalidInputs(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
