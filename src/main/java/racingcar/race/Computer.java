package racingcar.race;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

import racingcar.util.InputValidator;
import racingcar.util.Validator;

public class Computer {
    private final int MIN_RANDOM_NUMBER_RANGE = 0;
    private final int MAX_RANDOM_NUMBER_RANGE = 9;
    private List<Car> cars;
    private int times;

    public Computer() {
        this.cars = new ArrayList<>();
    }

    public Computer(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTimes() {
        return times;
    }

    /* 사용자로부터 자동차 이름과 경주 횟수를 입력받는 메서드 */
    public void prepareGame(List<Car> cars, int times) {
        this.cars = new ArrayList<>(cars);
        this.times = times;

        validateInputs();
    }

    private void validateInputs() {
        InputValidator.validateCarName(cars);
        InputValidator.validateAttemptTimes(times);
    }

    public void moveCars() {
        cars.forEach(car -> {
            if(shouldMove()) {
                car.movePosition();
            }
        });
    }

    public List<Car> determineWinners() {
        Validator.IsNotEmptyCarList(cars);

        int maxPosition = findMaxPosition();

        return selectWinners(maxPosition);
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException("[ERROR] position 값을 찾을 수 없습니다."));
    }

    private List<Car> selectWinners(int maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    private boolean shouldMove() {
        int randomNumber = pickRandomNumber();
        return Validator.goOrStop(randomNumber);
    }

    private int pickRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER_RANGE, MAX_RANDOM_NUMBER_RANGE);
    }
}