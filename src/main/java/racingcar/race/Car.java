package racingcar.race;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Objects;
import racingcar.util.Validator;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getCarName() { return name; }

    public int getPosition() {
        return position;
    }
    /*
    public String getStatus() {
        return name + " : " + "-".repeat(position);
    }
    */
    public void movePosition() {
        position += 1;
    }
}