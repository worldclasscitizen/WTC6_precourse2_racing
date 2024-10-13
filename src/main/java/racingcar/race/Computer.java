package racingcar.race;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.util.Validator;
import racingcar.view.InputReader;

public class Computer {
    private static int randomNumber;
    private static final int MIN_GAME_NUMBER_RANGE = 0;
    private static final int MAX_GAME_NUMBER_RANGE = 9;
    public static List<Car> cars;
    public static List<Car> winners;
    private static int times;


    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        return winners;
    }

    public int getTimes() {
        return times;
    }

    public static void inputCarNames() {
        cars = new ArrayList<>(InputReader.readCarNames());
    }

    public static void inputTimes() {
        times = InputReader.readMoveTimes();
    }

    public static void moveCarWithRandomNumber() {
        cars.forEach(car -> {
            if(getRandomNumber()) {
                car.movePosition();
            }
        });
    }

    public static List<Car> findWinners() {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalStateException("[ERROR] 자동차 목록이 비어 있습니다.");
        }

        winners = new ArrayList<>();

        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException("[ERROR] position 값을 찾을 수 없습니다."));

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }

        return winners;
    }

    public static boolean getRandomNumber() {
        randomNumber = pickRandomNumber();
        return Validator.validateGoStop(randomNumber);
    }

    private static int pickRandomNumber() {
        return Randoms.pickNumberInRange(MIN_GAME_NUMBER_RANGE, MAX_GAME_NUMBER_RANGE);
    }

}
