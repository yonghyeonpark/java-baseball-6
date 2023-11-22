package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumberGenerator {

    private static final int CORRECT_SIZE = 3;
    private static final int RANGE_MIN = 1;
    private static final int RANGE_MAX = 9;

    public List<Integer> generateComputer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < CORRECT_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(RANGE_MIN, RANGE_MAX);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
