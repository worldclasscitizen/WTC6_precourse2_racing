package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.race.Car;

public class Parser {
    public static List<Car> parseInput(String input) {
        String[] names = input.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }
}
