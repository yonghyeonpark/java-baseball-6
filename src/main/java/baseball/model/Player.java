package baseball.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {

    private static final String SIZE_ERROR_MESSAGE = "[ERROR] 세 자릿수를 입력해야 합니다.";
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 각 숫자의 범위는 1에서 9까지입니다.";
    private static final String DUPLICATION_ERROR_MESSAGE = "[ERROR] 각 숫자는 중복될 수 없습니다.";

    private List<Integer> player;

    public Player(List<Integer> player) {
        validateSize(player);
        validateRange(player);
        validateDuplication(player);
        this.player = player;
    }

    private void validateSize(List<Integer> player) {
        if (player.size() != 3) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    private void validateRange(List<Integer> player) {
        for (int number : player) {
            checkRange(number);
        }
    }

    private void checkRange(int number) {
        if (number < 1) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

    private void validateDuplication(List<Integer> player) {
        Set<Integer> duplicationCheck = new HashSet<>(player);
        if (player.size() != duplicationCheck.size()) {
            throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
        }
    }
}
