package racingcar.util;

import java.util.ArrayList;
import java.util.List;
import racingcar.race.Car;

public class Parser {
    public static List<Car> convertInputToCars(String input) {
        String[] names = input.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

    public static int parseToInteger(String userInput) {
        try {
            return Integer.parseInt(userInput.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT_ERROR_MESSAGE.getMessage());
        }
    }
}