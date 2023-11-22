package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.util.Convert;

public class InputView {

    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public int readPlayerNumber() {
        System.out.print(INPUT_MESSAGE);
        return Convert.stringToInteger(readLine());
    }
}
