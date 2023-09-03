package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    private Set<Integer> numbers;
    private int[] numberArr = new int[]{1, 1, 2, 3};

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        for(int i : numberArr) {
            numbers.add(i);
        }
    }

    @Test
    @DisplayName("size Test")
    void sizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers.size()).isNotEqualTo(numberArr.length);
    }

    @DisplayName("contains Test")
    @ParameterizedTest()
    @ValueSource(ints = {1, 1, 2, 3})
    void containsTest(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("continas Test 2")
    @ParameterizedTest()
    @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"}, delimiterString = ":")
    void containsTest2(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

}
