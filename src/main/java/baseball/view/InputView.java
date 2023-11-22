package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.util.Convert;
import java.util.List;

public class InputView {

    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_GAME_DECISION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public List<Integer> readPlayerNumber() {
        System.out.print(INPUT_MESSAGE);
        int integer = Convert.stringToInteger(readLine());
        return Convert.integerToList(integer);
    }

    private int readGameDecision() {
        System.out.println(INPUT_GAME_DECISION_MESSAGE);
        return Convert.stringToInteger(readLine());
    }
}
