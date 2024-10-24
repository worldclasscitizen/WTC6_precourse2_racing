package racingcar.util;

import racingcar.race.Car;

import java.util.List;

public class Validator {
    private static final int STANDARD_NUMBER = 4;

    public static boolean goOrStop(int randomNumber) {
        return randomNumber >= STANDARD_NUMBER;
    }

    public static void IsNotEmptyCarList(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalStateException(ErrorMessage.CAR_LIST_EMPTY_ERROR_MESSAGE.getMessage());
        }
    }
}