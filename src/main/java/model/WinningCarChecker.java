package model;

import static validation.ErrorMessage.WINNING_CAR_NAMES_EMPTY;

import java.util.ArrayList;
import java.util.List;
import model.domain.Car;
import model.domain.CarName;
import model.domain.Cars;
import model.domain.RaceCount;
import model.domain.WinningCarNames;

public class WinningCarChecker {

    private final RaceCount raceCount;

    public WinningCarChecker(RaceCount raceCount) {
        this.raceCount = raceCount;
    }

    public WinningCarNames generateWinningCarNames(Cars cars){
        List<CarName> carNameList = generateCarNameList(cars, raceCount.value());
        validateCarNames(carNameList);
        return new WinningCarNames(carNameList);
    }

    private static void validateCarNames(List<CarName> carNameList) {
        checkIsCarNamesEmpty(carNameList);
    }

    private static void checkIsCarNamesEmpty(List<CarName> carNameList) {
        if(carNameList.isEmpty()){
            throw new IllegalArgumentException(WINNING_CAR_NAMES_EMPTY.getMessage());
        }
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
