package baseball.service;

import baseball.model.Score;
import java.util.List;

public class BaseballService {

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
            score.addStrike();
        }
    }

    public String getResult() {
        return score.toString();
    }

    public void scoreInitialize() {
        score.initialize();
    }
}
