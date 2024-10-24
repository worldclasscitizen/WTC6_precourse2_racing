package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.race.Car;

public class InputValidator {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    /* 사용자로부터 입력받은 자동차 이름의 중복과 길이를 검증하는 메서드 */
    public static void validateCarName(List<Car> cars) {
        Set<String> carNames = new HashSet<>();

        for (Car car : cars) {
            String carName = car.getCarName();

            if (!carNames.add(carName)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME_ERROR_MESSAGE.getMessage());
            }

            validateCarNameLength(carName);

            carNames.add(carName);
        }
    }

    private static void validateCarNameLength(String carName) {
        if(carName.isEmpty() || carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_LENGTH_ERROR_MESSAGE.getMessage());
        }
    }

    public static void validateAttemptTimes(int times) {
        if(times <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NATURAL_NUMBER_ERROR_MESSAGE.getMessage());
        }
    }
}