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

    public void movePosition() {
        position += 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
