package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.util.Convert;
import java.util.List;

public class InputView {

    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public List<Integer> readPlayerNumber() {
        System.out.print(INPUT_MESSAGE);
        int integer = Convert.stringToInteger(readLine());
        return Convert.integerToList(integer);
    }
}
