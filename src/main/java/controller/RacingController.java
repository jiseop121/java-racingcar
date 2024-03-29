package controller;

import model.RaceAllOperator;
import model.WinningCarChecker;
import model.domain.Cars;
import model.domain.RaceCount;
import model.domain.WinningCarNames;

public class RacingController {

    private final RaceAllOperator raceAllOperator;
    private final WinningCarChecker winningCarChecker;

    public RacingController(RaceAllOperator raceAllOperator, WinningCarChecker winningCarChecker) {
        this.raceAllOperator = raceAllOperator;
        this.winningCarChecker = winningCarChecker;
    }

    public String runAllRace(Cars cars, RaceCount raceCount){
        return raceAllOperator.raceAll(cars,raceCount);
    }

    public WinningCarNames pickWinningCarNames(Cars cars,RaceCount raceCount){
        return winningCarChecker.generateWinningCarNames(cars,raceCount);
    }


}
