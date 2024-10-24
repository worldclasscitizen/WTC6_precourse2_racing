package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.race.Car;
import racingcar.util.RacingMessage;

public class OutputView {
    public static void printResult() {
        System.out.println("\n" + RacingMessage.EXECUTION_RESULT_MESSAGE);
    }

    public static void printRaceStatus(List<Car> cars) {
        StringBuilder output = new StringBuilder();
        for (Car car : cars) {
            output.append(car.getCarName())
                    .append(" : ")
                    .append(generatePositionIndicator(car.getPosition()))
                    .append(System.lineSeparator());
        }
        /*
        for (Car car : cars) {
        output.append(car.getStatus())
              .append(System.lineSeparator());
        }
        */
        System.out.println(output);
    }

    private static String generatePositionIndicator(int position) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < position; i++) {
            result.append('-');
        }

        return result.toString();
    }

    public static void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));

        System.out.println(RacingMessage.FINAL_WINNER_MESSAGE + winnerNames);
    }
}