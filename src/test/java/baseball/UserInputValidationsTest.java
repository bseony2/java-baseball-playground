package baseball;

import baseball.utils.UserInputValidations;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

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
        assertThat(UserInputValidations.duplicationValidate(UserInputValidations.convertInputToList(123))).isTrue();
        assertThat(UserInputValidations.duplicationValidate(UserInputValidations.convertInputToList(149))).isTrue();
        assertThat(UserInputValidations.duplicationValidate(UserInputValidations.convertInputToList(496))).isTrue();

        assertThatThrownBy(() -> UserInputValidations.duplicationValidate(UserInputValidations.convertInputToList(122)))
                .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("각 숫자는 중복되면 안됩니다.");
        assertThatThrownBy(() -> UserInputValidations.duplicationValidate(UserInputValidations.convertInputToList(151)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("각 숫자는 중복되면 안됩니다.");
        assertThatThrownBy(() -> UserInputValidations.duplicationValidate(UserInputValidations.convertInputToList(277)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("각 숫자는 중복되면 안됩니다.");
        assertThatThrownBy(() -> UserInputValidations.duplicationValidate(UserInputValidations.convertInputToList(881)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("각 숫자는 중복되면 안됩니다.");

    }

    @Test
    @DisplayName("3자리수 검증")
    void numberLengthTest() {
        assertThat(UserInputValidations.numberLength(UserInputValidations.convertInputToList(123))).isTrue();
        assertThat(UserInputValidations.numberLength(UserInputValidations.convertInputToList(666))).isTrue();

        assertThatThrownBy(() -> UserInputValidations.numberLength(UserInputValidations.convertInputToList(1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Balls의 크기는 3이어야 합니다.");
        assertThatThrownBy(() -> UserInputValidations.numberLength(UserInputValidations.convertInputToList(12)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Balls의 크기는 3이어야 합니다.");
        assertThatThrownBy(() -> UserInputValidations.numberLength(UserInputValidations.convertInputToList(1234)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Balls의 크기는 3이어야 합니다.");
    }

    @Test
    @DisplayName("유저 입력 테스트")
    void userInputValideTest() {
        assertThat(UserInputValidations.validateUserInput(UserInputValidations.convertInputToList(123))).isTrue();
        assertThat(UserInputValidations.validateUserInput(UserInputValidations.convertInputToList(792))).isTrue();

        assertThatThrownBy(() -> UserInputValidations.validateUserInput(UserInputValidations.convertInputToList(1243)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> UserInputValidations.validateUserInput(UserInputValidations.convertInputToList(12)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> UserInputValidations.validateUserInput(UserInputValidations.convertInputToList(902)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> UserInputValidations.validateUserInput(UserInputValidations.convertInputToList(223)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("유저 입력 리스트 변환 테스트")
    void convertInputToListTest() {
        List<Integer> testList = Arrays.asList(1, 2, 3);
        assertThat(compareList(UserInputValidations.convertInputToList(123), testList)).isTrue();
        assertThat(compareList(UserInputValidations.convertInputToList(321), testList)).isFalse();
        assertThat(compareList(UserInputValidations.convertInputToList(233), testList)).isFalse();
    }

    private boolean compareList(List<Integer> userInput, List<Integer> testList) {
        return convertListToInteger(userInput) - convertListToInteger(testList) == 0;
    }

    private int convertListToInteger(List<Integer> input) {
        return input.stream().reduce(0, (a,b) -> a*10+b);
    }

}
