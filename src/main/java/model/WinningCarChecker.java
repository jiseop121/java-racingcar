package model;

import static validation.ErrorMessage.WINNING_CAR_NAMES_EMPTY;

import java.util.ArrayList;
import java.util.List;
import model.domain.Car;
import model.domain.CarName;
import model.domain.Cars;
import model.domain.RaceCount;
import model.domain.WinningCarNames;
import validation.RaceValidator;

public class WinningCarChecker {

    public WinningCarNames generateWinningCarNames(Cars cars,RaceCount raceCount){
        List<CarName> carNameList = generateCarNameList(cars, raceCount.value());
        RaceValidator.validateCarNames(carNameList);
        return new WinningCarNames(carNameList);
    }

    private static List<CarName> generateCarNameList(Cars cars, int longestDistance) {
        List<CarName> carNameList = new ArrayList<>();
        cars.playCars().forEach(
                car -> {
                    stackCarName(longestDistance, carNameList, car);
                }
        );
        return carNameList;
    }

    private static void stackCarName(int longestDistance, List<CarName> carNameList, Car car) {
        if(isEqualLongestDistance(longestDistance, car)){
            carNameList.add(car.carName());
        }
    }

    private static boolean isEqualLongestDistance(int longestDistance, Car car) {
        return longestDistance == car.raceDistance().getValue();
    }
}
