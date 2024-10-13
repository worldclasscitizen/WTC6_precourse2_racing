package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.race.Car;
import racingcar.race.Computer;
import racingcar.race.RacingGame;

public class RacingTest {
    @DisplayName("자동차가 1회 움직이면 위치는 1이다.")
    @Test
    void moveSuccessTest() {
        // given : 한 개의 Car 객체를 생성
        Car car = new Car("car");

        // when : car 의 position 을 증가시킴
        car.movePosition();

        // then : car 의 position 이 1 인지 확인
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차가 움직이지 않으면 위치는 0이다.")
    @Test
    void moveFailTest() {
        // given : 한 개의 Car 객체를 생성
        Car car = new Car("car");

        // when : 없음

        // then : car 의 position 이 0 인지 확인
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("우승자가 1명이면 우승자 목록에도 1명만 있다.")
    @Test
    void singleWinnerTest() {
        // given: 세 개의 Car 객체를 생성하고 리스트에 저장
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        // when: car1 의 position 을 증가시킴
        car1.movePosition();

        // Computer 클래스의 static 필드에 cars 리스트를 직접 할당
        // Computer.cars 필드가 private 이라서 어떻게 고칠지 생각해봐야 함. 테스트할 때만 public 바꿔보니 되긴 함
        // Computer.cars = cars;

        // 그리고 findWinners 메서드 호출
        List<Car> winnersList = Computer.findWinners();

        // then: 우승자가 1명인지 확인하고, 그 우승자가 car1 인지 확인
        assertEquals(1, winnersList.size(), "우승자는 1명이어야 한다.");
        assertEquals(car1, winnersList.get(0), "우승자는 car1이어야 한다.");
    }

    @DisplayName("우승자가 2명이면 우승자 목록에도 2명이 있다.")
    @Test
    void multipleWinnersTest() {
        // given: 세 개의 Car 객체를 생성하고 리스트에 저장
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        // when: car1, car2 의 position 을 증가시킴
        car1.movePosition();
        car2.movePosition();

        Computer.cars = cars;

        // 그리고 findWinners 메서드 호출
        List<Car> winnersList = Computer.findWinners();

        // then: 우승자가 2명인지 확인하고, 그 우승자가 car1, car2 인지 확인
        assertEquals(2, winnersList.size(), "우승자는 2명이어야 한다.");
        assertTrue(winnersList.contains(car1), "우승자 목록에 car1이 포함되어야 한다.");
        assertTrue(winnersList.contains(car2), "우승자 목록에 car2가 포함되어야 한다.");
    }
}
