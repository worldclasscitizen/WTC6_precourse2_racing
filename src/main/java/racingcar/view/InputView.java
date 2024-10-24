package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.race.Car;
import racingcar.util.Parser;
import racingcar.util.RacingMessage;

public class InputView {
    public static List<Car> readCarNames() {
        System.out.println(RacingMessage.INPUT_CAR_NAME_MESSAGE);
        String userInput = Console.readLine().trim();

        return Parser.convertInputToCars(userInput);
    }

    public static int readAttemptTimes() {
        System.out.println(RacingMessage.INPUT_TIMES_MESSAGE);
        String userInput = Console.readLine().trim();

        return Parser.parseToInteger(userInput);
    }
}