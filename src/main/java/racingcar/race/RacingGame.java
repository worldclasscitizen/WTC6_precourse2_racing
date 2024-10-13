package racingcar.race;

import java.util.List;
import racingcar.view.InputReader;
import racingcar.view.OutputWriter;

public class RacingGame {
    private final Computer computer;
    private GameState gameState;

    public RacingGame() {
        this.computer = new Computer();
    }

    public void start() {
        run();
    }

    public void run() {
        setGame();
        playGame();
        endGame();
    }

    private void setGame() {
        gameState = GameState.PLAY;
    }

    private void playGame() {
        computer.inputCarNames();
        computer.inputTimes();

        OutputWriter.printResult();
        race();
    }

    private void race() {
        for(int i = 0; i < computer.getTimes(); i++) {
            computer.moveCarWithRandomNumber();
            OutputWriter.printRacing(computer);
        }
    }

    private void endGame() {
        computer.findWinners();
        OutputWriter.printWinners(computer);
    }
}
