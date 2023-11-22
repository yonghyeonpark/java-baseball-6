package baseball.service;

import baseball.model.Score;
import java.util.List;

public class BaseballService {

    private static final String GAME_DECISION_ERROR_MESSAGE = "[ERROR] 1 또는 2만 입력할 수 있습니다. (게임을 새로 시작하려면 1, 종료하려면 2)";

    private final Score score;

    public BaseballService() {
        this.score = new Score();
    }

    public void compareNumber(List<Integer> computer, List<Integer> player) {
        for (int index = 0; index < 3; index++) {
            checkIsBallOrStrike(computer, player, index);
        }
    }

    private void checkIsBallOrStrike(List<Integer> computer, List<Integer> player, int index) {
        if (computer.contains(player.get(index))) {
            if (computer.get(index) != player.get(index)) {
                score.addBall();
            }
            if (computer.get(index) == player.get(index)) {
                score.addStrike();
            }
        }
    }

    public String getResult() {
        return score.toString();
    }

    public void scoreInitialize() {
        score.initialize();
    }

    public boolean isWin() {
        if (score.toString().equals("3스트라이크")) {
            return true;
        }
        return false;
    }

    public boolean shouldGameContinue(int gameDecision) {
        validate(gameDecision);
        if (gameDecision == 1) {
            return true;
        }
        return false;
    }

    private void validate(int gameDecision) {
        if (gameDecision != 1 && gameDecision != 2) {
            throw new IllegalArgumentException(GAME_DECISION_ERROR_MESSAGE);
        }
    }
}
