package baseball.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BaseballServiceTest {

    private BaseballService baseballService;
    private List<Integer> computer;

    @BeforeEach
    void setUp() {
        baseballService = new BaseballService();
        computer = List.of(1, 2, 3);
    }

    @DisplayName("결과가 1볼인 케이스")
    @Test
    void resultIsOneBall() {
        List<Integer> player = List.of(3, 4, 5);

        baseballService.compareNumber(computer, player);

        assertThat(baseballService.getResult()).isEqualTo("1볼 ");
    }

    @DisplayName("결과가 2볼인 케이스")
    @Test
    void resultIsTwoBall() {
        List<Integer> player = List.of(2, 1, 5);

        baseballService.compareNumber(computer, player);

        assertThat(baseballService.getResult()).isEqualTo("2볼 ");
    }

    @DisplayName("결과가 3볼인 케이스")
    @Test
    void resultIsThreeBall() {
        List<Integer> player = List.of(2, 3, 1);

        baseballService.compareNumber(computer, player);

        assertThat(baseballService.getResult()).isEqualTo("3볼 ");
    }

    @DisplayName("결과가 1스트라이크인 케이스")
    @Test
    void resultIsOneStrike() {
        List<Integer> player = List.of(1, 4, 5);

        baseballService.compareNumber(computer, player);

        assertThat(baseballService.getResult()).isEqualTo("1스트라이크");
    }

    @DisplayName("결과가 2스트라이크인 케이스")
    @Test
    void resultIsTwoStrike() {
        List<Integer> player = List.of(1, 2, 4);

        baseballService.compareNumber(computer, player);

        assertThat(baseballService.getResult()).isEqualTo("2스트라이크");
    }

    @DisplayName("결과가 3스트라이크인 케이스")
    @Test
    void resultIsThreeStrike() {
        List<Integer> player = List.of(1, 2, 3);

        baseballService.compareNumber(computer, player);

        assertThat(baseballService.getResult()).isEqualTo("3스트라이크");
    }

    @DisplayName("결과가 1볼 1스트라이크인 케이스")
    @Test
    void resultIsOneBallOneStrike() {
        List<Integer> player = List.of(1, 3, 4);

        baseballService.compareNumber(computer, player);

        assertThat(baseballService.getResult()).isEqualTo("1볼 1스트라이크");
    }

    @DisplayName("결과가 2볼 1스트라이크인 케이스")
    @Test
    void resultIsTwoBallOneStrike() {
        List<Integer> player = List.of(3, 2, 1);

        baseballService.compareNumber(computer, player);

        assertThat(baseballService.getResult()).isEqualTo("2볼 1스트라이크");
    }

    @DisplayName("결과가 낫싱인 케이스")
    @Test
    void resultIsNothing() {
        List<Integer> player = List.of(4, 5, 6);

        baseballService.compareNumber(computer, player);

        assertThat(baseballService.getResult()).isEqualTo("낫싱");
    }

    @DisplayName("게임 결과가 3스트라이크면 승리이다.")
    @ParameterizedTest
    @CsvSource({"1,2,3,true", "1,2,5,false"})
    void judgeIsWin(int num1, int num2, int num3, boolean expected) {
        List<Integer> player = List.of(num1, num2, num3);
        baseballService.compareNumber(computer, player);

        boolean isWin = baseballService.isWin();

        assertThat(isWin).isEqualTo(expected);
    }

    @DisplayName("게임 진행 여부에 대해 1 또는 2를 입력하지 않으면 예외가 발생한다.")
    @Test
    void should_ThrowException_When_InvalidGameDecision() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> baseballService.shouldGameContinue(3))
                .withMessageContaining("[ERROR]");
    }
}
