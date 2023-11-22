package baseball.util;

public class Convert {

    private static final String CONVERT_ERROR_MESSAGE = "[ERROR] 숫자만 입력하셔야 합니다.";

    public static int stringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CONVERT_ERROR_MESSAGE);
        }
    }
}
