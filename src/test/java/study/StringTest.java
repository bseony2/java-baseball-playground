package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@Nested
@DisplayName("문자열 테스트")
public class StringTest {
    @Test
    @DisplayName("replace 테스트")
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("split 테스트")
    void splitTest() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");

        result = "1,".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("substring 테스트")
    void substringTest() {
        String target = "(1,2)";
        String result = target.substring(1, target.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 테스트")
    void charAtTest() {
        String target = "abc";
        assertThat(target.charAt(0)).isEqualTo('a');
        assertThat(target.charAt(1)).isEqualTo('b');
        assertThat(target.charAt(2)).isEqualTo('c');

        int index = 3;
        //target.charAt(index);
        assertThatThrownBy(() -> {
            target.charAt(index);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("range: %d", index);

    }
}
