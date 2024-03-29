package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static validation.ErrorMessage.WINNING_CAR_NAMES_EMPTY;

import java.util.ArrayList;
import java.util.List;
import model.domain.Cars;
import model.domain.RaceCount;
import model.domain.WinningCarNames;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TestNumberGenerator;
import view.InputParser;

class WinningCarCheckerTest {

    private WinningCarChecker winningCarChecker;
    private Cars testCars;
    private RaceOnceOperator raceOnceOperator;
    private final InputParser inputParser = new InputParser();

    @BeforeEach
    void initData(){
        winningCarChecker = new WinningCarChecker(new RaceCount(3));
        testCars = inputParser.initCarsFromCarNames("abc,qwer,hong");

        setTestRace();
    }

    private void runTestRace() {
        while(!raceOnceOperator.isEnd(testCars)){
            raceOnceOperator.race(testCars);
        }
    }

    private void setTestRace() {
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
        raceOnceOperator = new RaceOnceOperator(new TestNumberGenerator(numberList), new RaceCount(3));
    }

    @Test
    void WinningCarChecker_결과정상(){
        runTestRace();

        //abc : 2, qwer : 1, hong : 3

        WinningCarNames winningCarNames = winningCarChecker.generateWinningCarNames(testCars);
        assertThat(winningCarNames.carNames())
                .contains(testCars.playCars().get(2).carName());
    }

    @Test
    void WinningCarChecker_비정상_Empty_일때_예외출력(){
        raceOnceOperator.race(testCars);
        raceOnceOperator.race(testCars);

        assertThatThrownBy(() -> winningCarChecker.generateWinningCarNames(testCars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WINNING_CAR_NAMES_EMPTY.getMessage());
    }
}