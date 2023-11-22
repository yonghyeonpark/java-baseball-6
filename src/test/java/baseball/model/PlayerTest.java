package baseball.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @DisplayName("플레이어의 숫자가 3자리가 아니면 예외가 발생한다.")
    @Nested
    class PlayerSizeTest {

        @DisplayName("플레이어의 숫자가 2자리이면 예외가 발생한다.")
        @Test
        void should_ThrowException_When_PlayerSizeIsTwo() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Player(List.of(1, 2)))
                    .withMessageContaining("[ERROR]");
        }

        @DisplayName("플레이어의 숫자가 4자리이면 예외가 발생한다.")
        @Test
        void should_ThrowException_When_PlayerSizeIsFour() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Player(List.of(1, 2, 3, 4)))
                    .withMessageContaining("[ERROR]");
        }
    }

    @DisplayName("플레이어의 숫자가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void should_ThrowException_When_InvalidPlayerRange() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Player(List.of(1, 2, 0)))
                .withMessageContaining("[ERROR]");
    }

    @DisplayName("플레이어의 숫자가 중복되면 예외가 발생한다.")
    @Test
    void should_ThrowException_When_PlayerDuplicate() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Player(List.of(1, 2, 2)))
                .withMessageContaining("[ERROR]");
    }
}
