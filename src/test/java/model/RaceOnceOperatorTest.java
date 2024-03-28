package model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import model.domain.Cars;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TestNumberGenerator;
import view.InputParser;

class RaceOnceOperatorTest {

    private Cars cars;
    private final InputParser inputParser = new InputParser();
    private List<Integer> numberList;
    private RaceOnceOperator raceOnceOperator;
    @BeforeEach
    void setCars(){
        cars = inputParser.initCarsFromCarNames("abc,qwer,hong");
        numberList = new ArrayList<>();
        numberList.add(2);
        numberList.add(3);
        numberList.add(4);
        numberList.add(5);
        numberList.add(1);
        numberList.add(7);
        raceOnceOperator = new RaceOnceOperator(new TestNumberGenerator(numberList));
    }

    @Test
    void RaceOnceOperator_정상(){
        raceOnceOperator.race(cars);
        assertThat(getRaceDistanceValue(0)).isEqualTo(0);
        assertThat(getRaceDistanceValue(1)).isEqualTo(0);
        assertThat(getRaceDistanceValue(2)).isEqualTo(1);

        raceOnceOperator.race(cars);
        assertThat(getRaceDistanceValue(0)).isEqualTo(1);
        assertThat(getRaceDistanceValue(1)).isEqualTo(0);
        assertThat(getRaceDistanceValue(2)).isEqualTo(2);
    }

    private int getRaceDistanceValue(int index) {
        return cars.playCars().get(index).raceDistance().getValue();
    }
}