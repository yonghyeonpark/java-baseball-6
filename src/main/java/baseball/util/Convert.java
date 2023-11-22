package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class Convert {

    private static final int POSITIVE_CONDITION = 0;
    private static final int INITIAL_INDEX = 0;
    private static final int BASE_TEN = 10;
    private static final String CONVERT_ERROR_MESSAGE = "[ERROR] 숫자만 입력하셔야 합니다.";

    public static int stringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CONVERT_ERROR_MESSAGE);
        }
    }

    public static List<Integer> integerToList(int number) {
        List<Integer> digits = new ArrayList<>();
        while (number > POSITIVE_CONDITION) {
            digits.add(INITIAL_INDEX, number % BASE_TEN);
            number /= BASE_TEN;
        }
        return digits;
    }
}
