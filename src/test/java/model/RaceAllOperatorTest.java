package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import model.domain.Cars;
import model.domain.RaceCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TestNumberGenerator;
import view.InputParser;

class RaceAllOperatorTest {

    private Cars cars;
    private final InputParser inputParser = new InputParser();
    private RaceAllOperator raceAllOperator;
    private static final RaceCount RACE_COUNT = new RaceCount(3);
    @BeforeEach
    void setCars(){
        cars = inputParser.initCarsFromCarNames("kokod,kuku,cucu");
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
        raceAllOperator = new RaceAllOperator(
                new RaceOnceOperator(new TestNumberGenerator(numberList))
        );
    }

    @Test
    void raceAll_정상(){
        String raceAllResultMessage = raceAllOperator.raceAll(cars, RACE_COUNT);

        assertThat(getRaceDistanceValue(0)).isEqualTo(2);
        assertThat(getRaceDistanceValue(1)).isEqualTo(0);
        assertThat(getRaceDistanceValue(2)).isEqualTo(3);

        assertThat(raceAllResultMessage).containsIgnoringWhitespaces(
                """
                kokod :
                kuku :
                cucu : -
                """
        );

        assertThat(raceAllResultMessage).containsIgnoringWhitespaces(
                """
                kokod : -
                kuku :
                cucu : --
                """
        );

        assertThat(raceAllResultMessage).containsIgnoringWhitespaces(
                """
                kokod : --
                kuku :
                cucu : ---
                """
        );
    }

    private int getRaceDistanceValue(int index) {
        return cars.playCars().get(index).raceDistance().getValue();
    }
}