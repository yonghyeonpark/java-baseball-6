package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ScoreTest {

    private Score score;

    @BeforeEach
    void setUp() {
        score = new Score();
    }

    @DisplayName("볼을 추가한다.")
    @Test
    void addBall() {
        score.addBall();

        assertThat(score.toString()).isEqualTo("1볼 ");
    }

    @DisplayName("스트라이크를 추가한다.")
    @Test
    void addStrike() {
        score.addStrike();

        assertThat(score.toString()).isEqualTo("1스트라이크");
    }

    @DisplayName("스코어를 초기화한다.")
    @Test
    void initialize() {
        score.addBall();
        score.addStrike();
        score.initialize();

        assertThat(score.toString()).isEqualTo("낫싱");
    }
}
