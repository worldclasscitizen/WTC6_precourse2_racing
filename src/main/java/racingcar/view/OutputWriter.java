package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import racingcar.race.Car;
import racingcar.race.Computer;

public class OutputWriter {
    private static StringBuilder result;
    private static List<Car> cars;

    public static void printResult() {
        System.out.println("실행 결과");
    }

    public static void printRacing(Computer computer) {
        cars = new ArrayList<>(computer.getCars());
        cars.forEach(car -> {
            System.out.println(car.getCarName() + " : " + printDash(car));
        });
        System.out.println();
    }

    private static String printDash(Car car) {
        result = new StringBuilder();
        int position = car.getPosition();

        for (int i = 0; i < position; i++) {
            result.append('-');
        }

        return result.toString();
    }

    public static void printWinners(Computer computer) {
        List<Car> winners = new ArrayList<>(computer.getWinners());
        String winnerNames = winners.stream()
                .map(Car::getCarName)
                .reduce((name1, name2) -> name1 + ", " + name2)
                .orElse("");

        System.out.println("최종 우승자 : " + winnerNames);
    }
}
