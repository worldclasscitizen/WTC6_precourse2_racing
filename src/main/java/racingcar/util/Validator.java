package racingcar.util;

public class Validator {
    private static final int STOP_NUMBER_MIN = 0;

    private static final int STANDARD_NUMBER = 4;
    private static final int MOVE_NUMBER_MAX = 9;

    public static boolean validateGoStop(int randomNumber) {
        if(randomNumber < STANDARD_NUMBER) {
            return false; // 정지
        }
        return true; // 전진
    }
}
