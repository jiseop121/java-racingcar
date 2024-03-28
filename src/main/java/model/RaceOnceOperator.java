package model;

import model.domain.Car;
import model.domain.Cars;

public class RaceOnceOperator {

    private final NumberGenerator numberGenerator;
    private static final int FORWARD_STANDARD_NUMBER= 4;

    public RaceOnceOperator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void race(Cars cars){
        cars.playCars().forEach(
                car -> {
                    doForwardOrStop(car);
                }
        );
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
