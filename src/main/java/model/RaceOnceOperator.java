package model;

import java.util.List;
import model.domain.Car;
import model.domain.Cars;
import model.domain.RaceCount;
import validation.ErrorMessage;

public class RaceOnceOperator {

    private final NumberGenerator numberGenerator;
    private final RaceCount raceCount;

    private static final int FORWARD_STANDARD_NUMBER = 4;

    public RaceOnceOperator(NumberGenerator numberGenerator, RaceCount raceCount) {
        this.numberGenerator = numberGenerator;
        this.raceCount = raceCount;
    }

    public void race(Cars cars){
        validateRaceOnce(cars);
        cars.playCars().forEach(
                car -> {
                    doForwardOrStop(car);
                }
        );
    }

    private void validateRaceOnce(Cars cars) {
        if(isEnd(cars)){
            throw new IllegalArgumentException(ErrorMessage.RACE_ALREADY_OVER.getMessage());
        }
    }

    public boolean isEnd(Cars cars){
        for (Car car : cars.playCars()) {
            if(isReachEndDistance(car)){
                return true;
            }
        }
        return false;
    }

    private boolean isReachEndDistance(Car car) {
        return raceCount.value() <= car.raceDistance().getValue();
    }

    private void doForwardOrStop(Car car) {
        int randomNumber = numberGenerator.getRandomNumber();
        if(possibleForward(randomNumber)){
            car.raceDistance().plus();
        }
    }

    private static boolean possibleForward(int randomNumber) {
        return randomNumber >= FORWARD_STANDARD_NUMBER;
    }
}
