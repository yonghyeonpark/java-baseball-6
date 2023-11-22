package baseball.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {

    private static final int CORRECT_SIZE = 3;
    private static final int RANGE_STANDARD = 1;
    private static final String SIZE_ERROR_MESSAGE = "[ERROR] 세 자릿수를 입력해야 합니다.";
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 각 숫자의 범위는 1에서 9까지입니다.";
    private static final String DUPLICATION_ERROR_MESSAGE = "[ERROR] 각 숫자는 중복될 수 없습니다.";

    private final List<Integer> player;

    public Player(List<Integer> player) {
        validateSize(player);
        validateRange(player);
        validateDuplication(player);
        this.player = player;
    }

    private void validateSize(List<Integer> player) {
        if (player.size() != CORRECT_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    private void validateRange(List<Integer> player) {
        for (int number : player) {
            checkRange(number);
        }
    }

    private void checkRange(int number) {
        if (number < RANGE_STANDARD) {
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