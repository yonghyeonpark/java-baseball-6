package baseball.model;

import java.util.HashMap;
import java.util.Map;

public class Score {

    private static final int INITIAL_VALUE = 0;
    private static final int INCREMENTAL_VALUE = 1;
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String SPACE = " ";

    private final Map<String, Integer> score;

    public Score() {
        this.score = new HashMap<>();
        setUp();
    }

    private void setUp() {
        score.put(BALL, INITIAL_VALUE);
        score.put(STRIKE, INITIAL_VALUE);
    }

    public void addBall() {
        score.put(BALL, score.get(BALL) + INCREMENTAL_VALUE);
    }

    public void addStrike() {
        score.put(STRIKE, score.get(STRIKE) + INCREMENTAL_VALUE);
    }

    public void initialize() {
        score.clear();
        setUp();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        checkBallCount(stringBuilder);
        checkStrikeCount(stringBuilder);
        checkIsNothing(stringBuilder);
        return stringBuilder.toString();
    }

    private void checkBallCount(StringBuilder stringBuilder) {
        Integer ballCount = score.get(BALL);
        if (ballCount != INITIAL_VALUE) {
            stringBuilder.append(ballCount)
                    .append(BALL)
                    .append(SPACE);
        }
    }

    private void checkStrikeCount(StringBuilder stringBuilder) {
        Integer strikeCount = score.get(STRIKE);
        if (strikeCount != INITIAL_VALUE) {
            stringBuilder.append(strikeCount)
                    .append(STRIKE);
        }
    }

    private void checkIsNothing(StringBuilder stringBuilder) {
        Integer ballCount = score.get(BALL);
        Integer strikeCount = score.get(STRIKE);
        if (ballCount == INITIAL_VALUE && strikeCount == INITIAL_VALUE) {
            stringBuilder.append(NOTHING);
        }
    }
}
