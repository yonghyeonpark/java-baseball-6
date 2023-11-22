package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConvertTest {

    @DisplayName("문자열을 숫자로 변환한다.")
    @Test
    void stringToInteger() {
        String input = "3";

        int convertedInteger = Convert.stringToInteger(input);

        assertThat(convertedInteger).isEqualTo(3);
    }

    @DisplayName("변환 과정에서 입력값이 올바르지 않을 때 발생하는 예외를 잡아 고의로 IllegalArgumentException을 발생시킨다.")
    @Test
    void should_ThrowIllegalArgumentException_When_InvalidInput() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Convert.stringToInteger("a"))
                .withMessageContaining("[ERROR]");
    }

    @DisplayName("정수를 리스트로 변환한다.")
    @Test
    void integerToList() {
        int integer = 123;

        List<Integer> digits = Convert.integerToList(integer);

        assertThat(digits.size()).isEqualTo(3);
        assertThat(digits.get(0)).isEqualTo(1);
        assertThat(digits.get(1)).isEqualTo(2);
        assertThat(digits.get(2)).isEqualTo(3);
    }
}
