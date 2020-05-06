package hwapi.assertions;

import hwapi.dto.SpellResult;

import static org.assertj.core.api.Assertions.assertThat;

public class YandexSpellerAssertions {

    private SpellResult[] result;
    private SpellResult[][] results;

    public YandexSpellerAssertions(SpellResult[] result) {
        this.result = result;
    }

    public YandexSpellerAssertions(SpellResult[][] results) {
        this.results = results;
    }

    public YandexSpellerAssertions assertErrorCode(Integer code) {
        assertThat(result[0].getCode()).isEqualTo(code);
        return this;
    }

    public YandexSpellerAssertions assertSuggestions(String expected) {
        assertThat(result[0].getS().get(0)).isEqualTo(expected);
        return this;
    }

    public YandexSpellerAssertions assertInitialWord(String word) {
        assertThat(this.result[0].getWord()).isEqualTo(word);
        return this;
    }

    public void assertEmptyResponse() {
        assertThat(result).isEmpty();
    }

    public YandexSpellerAssertions assertNotEmptyResponse() {
        assertThat(result).isNotEmpty();
        return this;
    }

    public void assertEmptyBodyResponse() {
        assertThat(results[0]).isEmpty();
    }

    public YandexSpellerAssertions assertNotEmptyBodyResponse() {
        assertThat(results[0]).isNotEmpty();
        return this;
    }
}
