package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.race.Car;
import racingcar.util.InputValidator;
import racingcar.util.Parser;
import racingcar.util.Validator;

public class InputReader {
    public static List<Car> readCarNames() {
        List<Car> validCars = new ArrayList<>();

        while (validCars.isEmpty()) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                String userInput = Console.readLine();

                List<Car> cars = Parser.parseInput(userInput);
                InputValidator.validateIsNotDuplicate(cars);

                for (Car car : cars) {
                    InputValidator.validateCarName(car.getCarName());
                    validCars.add(car);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 시도해주세요.");
            }
        }
        return validCars;
    }

    public static int readMoveTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
        String userInput = Console.readLine();

        InputValidator.validateIsIntRange(userInput);
        int howManytimes = InputValidator.validateIsNatureNumber(userInput);

        return howManytimes;
    }
}
