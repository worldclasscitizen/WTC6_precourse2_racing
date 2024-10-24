package racingcar.race;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGame {
    private final Computer computer;

    public RacingGame() {
        this.computer = new Computer();
    }

    public void start() {
        initializeGame();
        race();
        announceWinners();
    }

    private void initializeGame() {
        List<Car> cars = InputView.readCarNames();
        int times = InputView.readAttemptTimes();
        computer.prepareGame(cars, times);
    }

    private void race() {
        OutputView.printResult();
        int totalRounds = computer.getTimes();

        for(int round = 0; round < totalRounds; round++) {
            computer.moveCars();
            OutputView.printRaceStatus(computer.getCars());
        }
    }

    private void announceWinners() {
        List<Car> winners = computer.determineWinners();
        OutputView.printWinners(winners);
    }
}