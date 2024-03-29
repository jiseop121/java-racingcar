package model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import model.domain.Cars;
import model.domain.RaceCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TestNumberGenerator;
import validation.ErrorMessage;
import view.InputParser;

class RaceOnceOperatorTest {

    private Cars cars;
    private final InputParser inputParser = new InputParser();
    private RaceOnceOperator raceOnceOperator;
    private static final RaceCount RACE_COUNT = new RaceCount(3);
    @BeforeEach
    void setCars(){
        cars = inputParser.initCarsFromCarNames("abc,qwer,hong");
        List<Integer> numberList = new ArrayList<>();
        numberList.add(2);
        numberList.add(3);
        numberList.add(4);
        numberList.add(5);
        numberList.add(1);
        numberList.add(7);
        numberList.add(5);
        numberList.add(1);
        numberList.add(7);
        raceOnceOperator = new RaceOnceOperator(new TestNumberGenerator(numberList));
    }

    @Test
    void RaceOnceOperator_정상_distance_누적(){
        raceOnceOperator.race(cars,RACE_COUNT);
        assertThat(getRaceDistanceValue(0)).isEqualTo(0);
        assertThat(getRaceDistanceValue(1)).isEqualTo(0);
        assertThat(getRaceDistanceValue(2)).isEqualTo(1);

        raceOnceOperator.race(cars,RACE_COUNT);
        assertThat(getRaceDistanceValue(0)).isEqualTo(1);
        assertThat(getRaceDistanceValue(1)).isEqualTo(0);
        assertThat(getRaceDistanceValue(2)).isEqualTo(2);
    }

    @Test
    void RaceOnceOperator_비정상_race_종료조건_충족후에도_race실행_예외출력(){
        //"hong"이 raceCount에 가장 먼저 도달한다.

        RaceAllOperator raceAllOperator = new RaceAllOperator(raceOnceOperator);

        raceAllOperator.raceAll(cars,RACE_COUNT);

        assertThatThrownBy(() -> raceOnceOperator.race(cars,RACE_COUNT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.RACE_ALREADY_OVER.getMessage());
    }

    private int getRaceDistanceValue(int index) {
        return cars.playCars().get(index).raceDistance().getValue();
    }
}