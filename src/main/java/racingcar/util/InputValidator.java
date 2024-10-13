package racingcar.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.race.Car;

public class InputValidator {
    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    public static void validateCarName(String carName) {
        validateNameLength(carName);
    }

    public static void validateIsNotDuplicate(List<Car> cars) {
        List<String> names = new ArrayList<>();
        for (Car car : cars) {
            if (names.contains(car.getCarName())) {
                throw new IllegalArgumentException("[ERROR] 중복된 자동차 이름이 있습니다.");
            }
            names.add(car.getCarName());
        }
    }

    private static void validateNameLength(String userInput) {
        if(!(userInput.length() >= MIN_CAR_NAME_LENGTH && userInput.length() <= MAX_CAR_NAME_LENGTH)) {
            throw new IllegalArgumentException("[ERROR]" + " 자동차의 이름은 1~5자여야 합니다.");
        }
    }
    public static void validateIsIntRange(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR]" + " 입력 횟수가 int 타입의 범위를 넘습니다.");
        }
    }


    public static int validateIsNatureNumber(String userInput) {
        int number = Integer.parseInt(userInput);
        if(number <= 0) {
            throw new IllegalArgumentException("반복 횟수는 자연수여야 합니다.");
        }
        return number;
    }
}