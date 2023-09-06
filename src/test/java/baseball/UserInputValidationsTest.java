package baseball;

import baseball.utils.UserInputValidations;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;


public class UserInputValidationsTest {

    @ParameterizedTest
    @CsvSource(value = {"0:false", "1:true", "2:true", "3:true", "4:true", "5:true", "6:true", "7:true", "8:true", "9:true", "10:false",}, delimiterString = ":")
    @DisplayName("각 자리수(1 이상 9 이하) 검증")
    void unitSizeTest(int value, boolean expected) {
        assertThat(UserInputValidations.unitSizeValidate(value)).isEqualTo(expected);
    }

    @Test
    @DisplayName("값 중복 검증")
    void numberDuplicationTest() {
        assertThat(UserInputValidations.duplicationValidate(123)).isTrue();
        assertThat(UserInputValidations.duplicationValidate(149)).isTrue();
        assertThat(UserInputValidations.duplicationValidate(122)).isFalse();
        assertThat(UserInputValidations.duplicationValidate(151)).isFalse();
        assertThat(UserInputValidations.duplicationValidate(277)).isFalse();
        assertThat(UserInputValidations.duplicationValidate(881)).isFalse();
        assertThat(UserInputValidations.duplicationValidate(496)).isTrue();
    }

    @Test
    @DisplayName("3자리수 검증")
    void numberLengthTest() {
        assertThat(UserInputValidations.numberLength(123)).isTrue();
        assertThat(UserInputValidations.numberLength(666)).isTrue();
        assertThat(UserInputValidations.numberLength(1)).isFalse();
        assertThat(UserInputValidations.numberLength(12)).isFalse();
        assertThat(UserInputValidations.numberLength(1234)).isFalse();
    }

}
