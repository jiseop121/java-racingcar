package model;

import model.domain.Car;
import model.domain.Cars;
import model.domain.RaceCount;
import validation.RaceValidator;

public class RaceOnceOperator {

    private static final int FORWARD_STANDARD_NUMBER = 4;

    private final NumberGenerator numberGenerator;

    public RaceOnceOperator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void race(Cars cars,RaceCount raceCount){
        RaceValidator.validateRaceOnce(cars,raceCount);
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

    protected StringBuilder generateRaceOnceStatus(Cars cars) {
        StringBuilder sb= new StringBuilder();
        for(Car car : cars.playCars()){
            sb.append(car.carName().value());
            sb.append(" : ");
            sb.append(car.raceDistance().getImageWithBars());
            sb.append("\n");
        }
        sb.append("\n");
        return sb;
    }
}
